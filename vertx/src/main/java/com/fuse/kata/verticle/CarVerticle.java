package com.fuse.kata.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.shareddata.impl.AsynchronousCounter;

public class CarVerticle extends AbstractVerticle {
    private final AsynchronousCounter counter;

    public CarVerticle(Vertx vertx) {
        counter = new AsynchronousCounter((VertxInternal) vertx);
    }

    @Override
    public void start(Future<Void> fut) {
        System.out.println("START car verticle...");

        vertx.createHttpServer()
                .requestHandler(r -> counter.incrementAndGet(ar -> r.response().end("Hello World! Counter " + ar.result())))
                .listen(8080, result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(result.cause());
                    }
                });

        System.out.println("STARTED car verticle...");
    }
}