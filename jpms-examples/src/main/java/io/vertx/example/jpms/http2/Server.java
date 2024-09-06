package io.vertx.example.jpms.http2;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.JksOptions;

public class Server extends AbstractVerticle {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new Server())
      .onFailure(Throwable::printStackTrace);
  }

  @Override
  public void start(Promise<Void> startFuture) {
    HttpServer server = vertx.createHttpServer(
      new HttpServerOptions()
        .setUseAlpn(true)
        .setKeyCertOptions(new JksOptions().setPath("server-keystore.jks").setPassword("wibble"))
        .setSsl(true)
    );
    server.requestHandler(req -> {
        req.response().end(new JsonObject()
          .put("http", req.version())
          .put("message", "Hello World")
          .toString());
      }).listen(8443)
      .<Void>mapEmpty()
      .onComplete(startFuture);
  }
}
