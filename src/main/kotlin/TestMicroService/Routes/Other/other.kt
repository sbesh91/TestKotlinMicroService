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
        after("") { request, response ->
            println("catch the request after the processing is done")
        }
    }
}