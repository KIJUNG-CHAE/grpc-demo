package ai.sendy.victor.grpc.grpcclientdemo

import helloworld.HelloRequest
import helloworld.MyServiceGrpc
import net.devh.boot.grpc.client.inject.GrpcClient
import org.springframework.stereotype.Service


@Service
class FoobarService {

    @GrpcClient("hello")
    lateinit var myServiceStub: MyServiceGrpc.MyServiceBlockingStub

//    @GrpcClient("hello")
//    private val myServiceStub: MyServiceGrpc.MyServiceBlockingStub? = null

    fun receiveGreeting(name: String?): String {
        val request: HelloRequest = HelloRequest.newBuilder()
            .setName(name)
            .build()
        return myServiceStub.sayHello(request).message
    }
}