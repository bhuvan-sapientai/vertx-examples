package io.vertx.example.rxjava3.web.client.unmarshalling;

import io.reactivex.rxjava3.core.Single;
import io.vertx.launcher.application.VertxApplication;
import io.vertx.rxjava3.core.AbstractVerticle;
import io.vertx.rxjava3.ext.web.client.HttpResponse;
import io.vertx.rxjava3.ext.web.client.WebClient;
import io.vertx.rxjava3.ext.web.codec.BodyCodec;

/*
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class Client extends AbstractVerticle {

  public static void main(String[] args) {
    VertxApplication.main(new String[]{Client.class.getName()});
  }

  // Unmarshalled response from server
  static class Data {

    public String message;

  }

  @Override
  public void start() throws Exception {

    WebClient client = WebClient.create(vertx);
    Single<HttpResponse<Data>> request = client.get(8080, "localhost", "/")
      .as(BodyCodec.json(Data.class))
      .rxSend();

    // Fire the request
    request.subscribe(resp -> System.out.println("Server content " + resp.body().message));

    // Again
    request.subscribe(resp -> System.out.println("Server content " + resp.body().message));

    // And again
    request.subscribe(resp -> System.out.println("Server content " + resp.body().message));
  }
}
