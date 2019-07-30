package TestMicroService.Routes.Other
import spark.Spark.*;

fun setup() {
    path("/sessions") {
        before("") { request, response ->
            println("catch the request before the processing is done")
        }
        get("") { request, response ->
            println("generating a new session")

            val test = "new session here"

            test
        }
        post("") { request, response ->
            throw IllegalAccessException("403 not allowed from this ip: ${request.ip()}")
        }
        put("") {request, response ->
            throw Exception("General Error")
        }
        after("") { request, response ->
            println("catch the request after the processing is done")
        }
    }
}