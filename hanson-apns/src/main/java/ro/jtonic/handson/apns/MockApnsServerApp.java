package ro.jtonic.handson.apns;

import com.eatthepath.pushy.apns.ApnsPushNotification;
import com.eatthepath.pushy.apns.server.AcceptAllPushNotificationHandlerFactory;
import com.eatthepath.pushy.apns.server.MockApnsServer;
import com.eatthepath.pushy.apns.server.MockApnsServerBuilder;
import com.eatthepath.pushy.apns.server.ParsingMockApnsServerListenerAdapter;
import com.eatthepath.pushy.apns.server.RejectionReason;
import io.netty.channel.nio.NioEventLoopGroup;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockApnsServerApp {

  public static final Logger LOGGER = LoggerFactory.getLogger("mock-apns-server");

  private static final NioEventLoopGroup SERVER_EVENT_LOOP_GROUP = new NioEventLoopGroup(2);

  protected static final String SERVER_CERTIFICATES_FILENAME = "/certs/server-certs.pem";
  protected static final String SERVER_KEY_FILENAME = "/certs/server-key.pem";
  protected static final String CA_CERTIFICATE_FILENAME = "/certs/ca.pem";

  public static void main(String[] args) throws Exception {
    final MockApnsServer apnsServer = new MockApnsServerBuilder()
        .setServerCredentials(
            MockApnsServerApp.class.getResourceAsStream(SERVER_CERTIFICATES_FILENAME),
            MockApnsServerApp.class
                .getResourceAsStream(SERVER_KEY_FILENAME), null)
        .setTrustedClientCertificateChain(
            MockApnsServerApp.class.getResourceAsStream(CA_CERTIFICATE_FILENAME))
        .setEventLoopGroup(SERVER_EVENT_LOOP_GROUP)
        .setHandlerFactory(new AcceptAllPushNotificationHandlerFactory())
        .setListener(new TestMockApnsServerListener())
        .build();

    apnsServer.start(8081);

    LOGGER.info("Mock apns server started on port 8081.");
  }

  private static class TestMockApnsServerListener extends ParsingMockApnsServerListenerAdapter {

    private final AtomicInteger acceptedNotifications = new AtomicInteger(0);
    private final AtomicInteger rejectedNotifications = new AtomicInteger(0);

    private ApnsPushNotification mostRecentPushNotification;
    private RejectionReason mostRecentRejectionReason;
    private Instant mostRecentDeviceTokenExpiration;

    @Override
    public void handlePushNotificationAccepted(final ApnsPushNotification pushNotification) {

      LOGGER.info("Accepted push notification payload: {}", pushNotification.getPayload());

      this.mostRecentPushNotification = pushNotification;
      this.mostRecentRejectionReason = null;
      this.mostRecentDeviceTokenExpiration = null;

      this.acceptedNotifications.incrementAndGet();

      synchronized (this.acceptedNotifications) {
        this.acceptedNotifications.notifyAll();
      }
    }

    @Override
    public void handlePushNotificationRejected(final ApnsPushNotification pushNotification, final RejectionReason rejectionReason, final Instant deviceTokenExpirationTimestamp) {

      LOGGER.info("Rejected push notification payload: {}", pushNotification.getPayload());

      this.mostRecentPushNotification = pushNotification;
      this.mostRecentRejectionReason = rejectionReason;
      this.mostRecentDeviceTokenExpiration = deviceTokenExpirationTimestamp;

      this.rejectedNotifications.incrementAndGet();

      synchronized (this.rejectedNotifications) {
        this.rejectedNotifications.notifyAll();
      }
    }
  }
}
