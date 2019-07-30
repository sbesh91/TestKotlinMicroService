package TestMicroService.Routes.Some
import spark.Spark.*;

fun setup() {
    path("/manifests") {
        before("") { request, response ->
            println("catch the request before the processing is done")
        }
        get("") { request, response ->
            println("generating a new manifest")

            "new manifest here"
        }
        after("") { request, response ->
            println("catch the request after the processing is done")
        }
    }
}