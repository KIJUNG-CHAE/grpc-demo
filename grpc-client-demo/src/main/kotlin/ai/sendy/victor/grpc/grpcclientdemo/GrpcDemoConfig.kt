package ai.sendy.victor.grpc.grpcclientdemo

import helloworld.HelloRequest
import helloworld.MyServiceGrpc.*
import net.devh.boot.grpc.client.inject.GrpcClient
import net.devh.boot.grpc.client.inject.GrpcClientBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service


//@Configuration
//@GrpcClientBean(
//    clazz = MyServiceBlockingStub::class,
//    beanName = "blockingStub",
//    client = GrpcClient("myService")
//)
//class GrpcDemoConfig {
//
//    @Bean
//    fun foobarService(@Autowired blockingStub: MyServiceBlockingStub): FoobarService {
//        return FoobarService(blockingStub)
//    }
//}
//
//@Service
//class FoobarService (
//    private val blockingStub: MyServiceBlockingStub
//) {
//
//    fun receiveGreeting(name: String?): String {
//        val request = HelloRequest.newBuilder()
//            .setName(name)
//            .build()
//        return blockingStub.sayHello(request).getMessage()
//    }
//}