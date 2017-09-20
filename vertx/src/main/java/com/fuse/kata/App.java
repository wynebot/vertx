package com.fuse.kata;

import com.fuse.kata.verticle.CarVerticle;
import io.vertx.core.Vertx;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new CarVerticle(vertx));
    }
}

