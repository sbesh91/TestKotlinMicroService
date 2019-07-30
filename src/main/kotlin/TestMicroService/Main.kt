package TestMicroService
import TestMicroService.Routes.Some.setup as some
import TestMicroService.Routes.Other.setup as other
import spark.Spark.*
import org.apache.log4j.LogManager
import org.apache.log4j.PropertyConfigurator

object App {

    private val logger = LogManager.getLogger(App::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        PropertyConfigurator.configure("log4j.properties")

        logger.info("booting application.")

        threadPool(8)
        port(8080)

        path("/api/v2") {
            some()
            other()

            exception(IllegalAccessException::class.java) { exception, request, response ->
                println("Printing Exception Message --- ${exception.message}")

                response.status(403)
                response.body(exception.message)
            }

            internalServerError { request, response ->
                val message = "Internal server error at: ${request.url()}"
                println(message)
                response.status(500)
                message
            }

            notFound { request, response ->
                val message = "Request url not found: ${request.url()}"
                println(message)

                message
            }
        }

        awaitInitialization()
        logger.info("Application finished booting!")
    }
}

fun main(args: Array<String>) {
    App.main(args)
}
