import kotlinx.coroutines.*

fun main() = runBlocking {
    val service = UserService()

    coroutineScope {
        launch(Dispatchers.IO) {
            delay(10_000)

            println("[${Thread.currentThread().name}] One")

            service.successfulUsersResponse()
        }
        launch(Dispatchers.IO) {
            println("[${Thread.currentThread().name}] Two")

            service.successfulUsersResponse()
        }
    }

    println("[${Thread.currentThread().name}] Done!")
}