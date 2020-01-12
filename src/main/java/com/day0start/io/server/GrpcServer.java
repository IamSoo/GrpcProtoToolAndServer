package com.day0start.io.server;

import com.day0start.io.service.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    private static final int SERVER_PORT = 9090;

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(SERVER_PORT)
                .addService(new UserService())
                .build();

        server.start();
        System.out.println(String.format("Server started at port {} ", SERVER_PORT));
        server.awaitTermination();
    }
}
