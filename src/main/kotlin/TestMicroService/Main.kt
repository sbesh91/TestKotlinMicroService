package TestMicroService
import TestMicroService.Routes.ErrorHandlers.errorRoutes
import TestMicroService.Routes.Other.otherRoutes
import TestMicroService.Routes.Some.someRoutes
import spark.Spark.*
import org.apache.log4j.LogManager
import org.apache.log4j.PropertyConfigurator
import redis.clients.jedis.*

object App {

    private val logger = LogManager.getLogger(App::class.java)
    // todo make redis retry the connection
    // todo enable jedis connection pooling
    private val redis: Jedis = {
        Jedis("http://localhost:6379")
    } ()

    // todo setup jesque here
    @JvmStatic
    fun main(args: Array<String>) {
        PropertyConfigurator.configure("log4j.properties")

        logger.info("booting application.")

        App.redis.set("hello", "Hi Dave!")

        logger.info("Testing Redis Connection: ${App.redis.get("hello")}")

        threadPool(8, 2, 30000)
        port(8080)

        path("/api/v2") {
            someRoutes()
            otherRoutes()
            errorRoutes()
        }

//        val r = khttp.get("http://google.com")
//        logger.info("Raw HTTP response from google.com: ${r.text}")

        awaitInitialization()
        // todo fire the beacon to assert that booting has finished
        logger.info("Application finished booting!")
    }
}

fun main(args: Array<String>) {
    App.main(args)
}
