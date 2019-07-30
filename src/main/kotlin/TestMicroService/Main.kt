package TestMicroService
import TestMicroService.Routes.Some.setup as some
import TestMicroService.Routes.Other.setup as other
import spark.Spark.*

fun main(args: Array<String>) {
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
}

