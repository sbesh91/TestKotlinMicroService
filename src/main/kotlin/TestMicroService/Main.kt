package TestMicroService
import TestMicroService.Routes.ErrorHandlers.errorRoutes
import TestMicroService.Routes.Other.otherRoutes
import TestMicroService.Routes.Some.someRoutes
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
            someRoutes
            otherRoutes
            errorRoutes
        }

        awaitInitialization()
        // todo fire the beacon to assert that booting has finished
        logger.info("Application finished booting!")
    }
}

fun main(args: Array<String>) {
    App.main(args)
}
