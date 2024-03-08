package ai.sendy.victor.grpc.grpcserverdemo

import helloworld.HelloReply
import helloworld.HelloRequest
import helloworld.MyServiceGrpc
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService

@GrpcService
class MyServiceImpl : MyServiceGrpc.MyServiceImplBase() {
    override fun sayHello(request: HelloRequest, responseObserver: StreamObserver<HelloReply?>) {
        val reply: HelloReply = HelloReply.newBuilder()
            .setMessage("안녕하세요, " + request.name + "님! 좋은 아침입니다. ^^")
            .build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}