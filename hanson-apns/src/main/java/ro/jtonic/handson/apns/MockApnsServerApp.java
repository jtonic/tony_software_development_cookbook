package ro.jtonic.handson.apns;

import com.eatthepath.pushy.apns.ApnsPushNotification;
import com.eatthepath.pushy.apns.server.AcceptAllPushNotificationHandlerFactory;
import com.eatthepath.pushy.apns.server.MockApnsServer;
import com.eatthepath.pushy.apns.server.MockApnsServerBuilder;
import com.eatthepath.pushy.apns.server.ParsingMockApnsServerListenerAdapter;
import com.eatthepath.pushy.apns.server.RejectionReason;
import io.netty.channel.nio.NioEventLoopGroup;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockApnsServerApp {

  public static final Logger LOGGER = LoggerFactory.getLogger("mock-apns-server");

  private static final NioEventLoopGroup SERVER_EVENT_LOOP_GROUP = new NioEventLoopGroup(2);

  protected static final String SERVER_CERTIFICATES_FILENAME = "/certs/ca/server-certs.pem";
  protected static final String SERVER_KEY_FILENAME = "/certs/ca/server-key.pem";
  protected static final String CA_CERTIFICATE_FILENAME = "/certs/ca/ca.pem";
  public static final int PORT = 8443;

  public static void main(String[] args) throws Exception {
    final MockApnsServer apnsServer = new MockApnsServerBuilder()
        .setTrustedClientCertificateChain(
            MockApnsServerApp.class.getResourceAsStream(CA_CERTIFICATE_FILENAME))
        .setServerCredentials(
            MockApnsServerApp.class.getResourceAsStream(SERVER_CERTIFICATES_FILENAME),
            MockApnsServerApp.class
                .getResourceAsStream(SERVER_KEY_FILENAME), null)
        .setEventLoopGroup(SERVER_EVENT_LOOP_GROUP)
        .setHandlerFactory(new AcceptAllPushNotificationHandlerFactory())
        .setListener(new TestMockApnsServerListener())
        .build();

    apnsServer.start(PORT);

    LOGGER.info("Mock apns server started on port {}", PORT);
  }

  private static class TestMockApnsServerListener extends ParsingMockApnsServerListenerAdapter {

    @Override
    public void handlePushNotificationAccepted(final ApnsPushNotification pushNotification) {
      LOGGER.info("Accepted push notification payload: {}", pushNotification.getPayload());
    }

    @Override
    public void handlePushNotificationRejected(final ApnsPushNotification pushNotification,
                                               final RejectionReason rejectionReason,
                                               final Instant deviceTokenExpirationTimestamp) {
      LOGGER.info("Rejected push notification payload: {}", pushNotification.getPayload());
    }
  }
}
