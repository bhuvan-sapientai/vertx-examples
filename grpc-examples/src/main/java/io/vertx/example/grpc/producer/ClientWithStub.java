package io.vertx.example.grpc.producer;

import io.vertx.core.Future;
import io.vertx.core.VerticleBase;
import io.vertx.core.net.SocketAddress;
import io.vertx.example.grpc.Messages;
import io.vertx.example.grpc.VertxProducerServiceGrpcClient;
import io.vertx.grpc.client.GrpcClient;
import io.vertx.launcher.application.VertxApplication;

/*
 * @author <a href="mailto:plopes@redhat.com">Paulo Lopes</a>
 */
public class ClientWithStub extends VerticleBase {

  public static void main(String[] args) {
    VertxApplication.main(new String[]{ClientWithStub.class.getName()});
  }

  private GrpcClient client;

  @Override
  public Future<?> start() {

    // Create the channel
    GrpcClient client = GrpcClient.client(vertx);

    // Get a stub to use for interacting with the remote service
    VertxProducerServiceGrpcClient stub = new VertxProducerServiceGrpcClient(client, SocketAddress.inetSocketAddress(8080, "localhost"));

    // Call the remote service
    return stub.streamingInputCall(writeStream -> {
      for (int i = 0; i < 10; i++) {
        writeStream.write(Messages.StreamingInputCallRequest.newBuilder().build());
      }
      writeStream.end();
    }).onSuccess(res -> System.out.println("Server replied OK"));
  }
}
