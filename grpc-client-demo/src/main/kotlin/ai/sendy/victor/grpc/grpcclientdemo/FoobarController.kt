package ai.sendy.victor.grpc.grpcclientdemo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FoobarController(
    private val foobarService: FoobarService,
) {

    @GetMapping("/grpc-message-test")
    fun sendGrpcData(@RequestParam name: String):ResponseEntity<String> {
        val responseString = foobarService.receiveGreeting(name)
        return ResponseEntity.ok(responseString)

    }
}
