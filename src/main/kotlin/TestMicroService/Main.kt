package TestMicroService
import TestMicroService.Routes.Some.setup as some
import TestMicroService.Routes.Other.setup as other
import TestMicroService.Routes.ErrorHandlers.setup as errorHandlers
import spark.Spark.*
import org.apache.log4j.LogManager
import org.apache.log4j.PropertyConfigurator

object App {

    private val logger = LogManager.getLogger(App::class.java)

    @JvmStatic
    fun main(args: Array<String>) {
        PropertyConfigurator.configure("log4j.properties")

        logger.info("booting application.")

        threadPool(8, 2, 30000)
        port(8080)

        path("/api/v2") {
            some()
            other()
            errorHandlers()
        }

        awaitInitialization()
        logger.info("Application finished booting!")
    }
}

fun main(args: Array<String>) {
    App.main(args)
}
