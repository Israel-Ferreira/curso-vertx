package io.codekaffee.vertx.course.vertx_starter.verticles;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;

public class VerticleN extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    System.out.println("Start Verticle " + VerticleN.class.getName() + " On Thread " + Thread.currentThread().getName() + " With Config " + config());
    startPromise.complete();
  }

  @Override
  public void stop(Promise<Void> stopPromise) throws Exception {
    System.out.println("Stop Verticle " + VerticleN.class.getName());
    stopPromise.complete();
  }
}
