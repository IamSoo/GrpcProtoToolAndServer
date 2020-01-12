package com.day0start.io.service;

import com.day0start.io.grpc.Message;
import com.day0start.io.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {

    @Override
    public void hello(Message.request request, StreamObserver<Message.response> responseObserver) {
        System.out.println("Hitting UserService");
        String userName = request.getUsername();
        Message.response.Builder resp = Message.response.newBuilder();
        resp.setReply( "Hello " + userName + " welcome!!!");
        responseObserver.onNext(resp.build());
        responseObserver.onCompleted();
    }
}
