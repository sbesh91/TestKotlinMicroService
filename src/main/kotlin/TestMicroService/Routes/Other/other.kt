package TestMicroService.Routes.Other
import spark.Spark.*;

fun setup() {

    path("/api/sessions") {
        before("") { request, response ->
            println("catch the request before the processing is done")
        }
        get("") { request, response ->
            println("generating a new session")

            return@get "new session here"
        }
        after("") { request, response ->
            println("catch the request after the processing is done")
        }
    }
}