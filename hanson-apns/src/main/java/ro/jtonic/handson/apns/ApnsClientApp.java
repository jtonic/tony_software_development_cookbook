package ro.jtonic.handson.apns;

import static ro.jtonic.handson.apns.MockApnsServerApp.CA_CERTIFICATE_FILENAME;

import com.eatthepath.pushy.apns.ApnsClient;
import com.eatthepath.pushy.apns.ApnsClientBuilder;
import com.eatthepath.pushy.apns.PushNotificationResponse;
import com.eatthepath.pushy.apns.util.ApnsPayloadBuilder;
import com.eatthepath.pushy.apns.util.SimpleApnsPayloadBuilder;
import com.eatthepath.pushy.apns.util.SimpleApnsPushNotification;
import io.netty.channel.nio.NioEventLoopGroup;
import java.util.Random;
import java.util.UUID;

public class ApnsClientApp {

  private static final String HOST = "localhost";
  private static final int PORT = 8081;
  private static final NioEventLoopGroup CLIENT_EVENT_LOOP_GROUP = new NioEventLoopGroup(2);
  private static final String CLIENT_CERTIFICATES_FILENAME = "certs/multiple-keys.p12";
  private static final String CLIENT_PWD = "pushy-test";
  private static final String TOPIC = "com.relayrides.pushy";

  protected static final int TOKEN_LENGTH = 32; // bytes
  private static final String DEVICE_TOKEN = generateRandomDeviceToken();
  private static final String PAYLOAD = generateRandomPayload();

  public static void main(String[] args) throws Exception {

    final ApnsClient client = new ApnsClientBuilder()
        .setApnsServer(HOST, PORT)
        .setTrustedServerCertificateChain(
            ApnsClientApp.class.getResourceAsStream(CA_CERTIFICATE_FILENAME))
        .setClientCredentials(ApnsClientApp.class.getResourceAsStream(CLIENT_CERTIFICATES_FILENAME),
            CLIENT_PWD)
        .setEventLoopGroup(CLIENT_EVENT_LOOP_GROUP)
        .setMetricsListener(null)
        .build();

    final SimpleApnsPushNotification pushNotification = new SimpleApnsPushNotification(DEVICE_TOKEN, TOPIC, PAYLOAD);

    final PushNotificationResponse<SimpleApnsPushNotification> response =
        client.sendNotification(pushNotification).get();

    assert(response.isAccepted());
  }

  protected static String generateRandomDeviceToken() {
    final byte[] tokenBytes = new byte[TOKEN_LENGTH];
    new Random().nextBytes(tokenBytes);

    final StringBuilder builder = new StringBuilder(TOKEN_LENGTH * 2);

    for (final byte b : tokenBytes) {
      builder.append(String.format("%02x", b));
    }

    return builder.toString();
  }

  protected static String generateRandomPayload() {
    final ApnsPayloadBuilder payloadBuilder = new SimpleApnsPayloadBuilder();
    payloadBuilder.setAlertBody(UUID.randomUUID().toString());

    return payloadBuilder.build();
  }
}
