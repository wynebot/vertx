package com.fuse.kata.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class CarVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> fut) {
        System.out.println("Starting car verticle...");
        /*vertx.executeBlocking(future -> vertx
                .createHttpServer()
                .requestHandler(r -> {
                    r.response().end("<h1>Hello from my first " +
                            "Vert.x 3 application</h1>");
                })
                .listen(8080, result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(result.cause());
                    }
                }), res -> System.out.println("done!"));*/
        vertx
                .createHttpServer()
                .requestHandler(r -> {
                    r.response().end("<h1>Hello from my first " +
                            "Vert.x 3 application</h1>");
                })
                .listen(8080, result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(result.cause());
                    }
                });

    }
}