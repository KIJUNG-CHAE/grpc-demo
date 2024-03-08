package ai.sendy.victor.grpc.grpcserverdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrpcServerDemoApplication

fun main(args: Array<String>) {
	runApplication<GrpcServerDemoApplication>(*args)
}
