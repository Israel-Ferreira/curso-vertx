package io.codekaffee.vertx.course.vertx_starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;

import java.util.UUID;

public class VerticleA extends AbstractVerticle {
  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    System.out.println("Start " + getClass().getName());
    vertx.deployVerticle(new VerticleAA(), whenDeployed -> {
      System.out.println("Deployed Verticle: " + VerticleAA.class);
      vertx.undeploy(whenDeployed.result());
    });

    vertx.deployVerticle(
      VerticleN.class.getName(),
      new DeploymentOptions()
        .setInstances(4)
        .setConfig(
          new JsonObject()
            .put("id", UUID.randomUUID().toString())
            .put("name", VerticleN.class.getSimpleName())
        )

    );

    startPromise.complete();
  }
}
