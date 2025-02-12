package io.vertx.example.reactivex.eventbus.zipreplies;

import io.reactivex.Single;
import io.vertx.launcher.application.VertxApplication;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.eventbus.EventBus;
import io.vertx.reactivex.core.eventbus.Message;

/*
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class Sender extends AbstractVerticle {

  public static void main(String[] args) {
    VertxApplication.main(new String[]{Sender.class.getName(), "-cluster"});
  }

  @Override
  public void start() throws Exception {

    EventBus eb = vertx.eventBus();

    vertx.setPeriodic(1000, v -> {

      // Send two messages expecting replies
      Single<Message<Integer>> reply1 = eb.rxRequest("heatsensor1", "ping");
      Single<Message<Integer>> reply2 = eb.rxRequest("heatsensor2", "ping");

      // Zip responses to receive both at the same time
      Single<int[]> reply = reply1.zipWith(reply2, (msg1, msg2) -> new int[]{msg1.body(), msg2.body()});

      reply.subscribe(heats -> {

        // Print highest temp
        if (heats[0] > heats[1]) {
          System.out.println("heat sensor 1 is highest " + heats[0]);
        } else {
          System.out.println("heat sensor 2 is highest " + heats[1]);
        }

      }, err -> {

        System.out.println("Reply error:");
        err.printStackTrace();
      });
    });
  }
}
