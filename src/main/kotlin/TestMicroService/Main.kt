package TestMicroService
import TestMicroService.Routes.Some.setup as some
import TestMicroService.Routes.Other.setup as other
import spark.Spark.*

fun main(args: Array<String>) {
    port(8080)
    some()
    other()
}

