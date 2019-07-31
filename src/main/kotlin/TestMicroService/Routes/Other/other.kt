package TestMicroService.Routes.Other
import TestMicroService.App
import org.apache.log4j.LogManager
import TestMicroService.DAO.Other.OtherDao;
import spark.Spark.*;
private val logger = LogManager.getLogger(App::class.java)
private val otherDao = OtherDao()

fun setup() {
    path("/sessions") {
        before("") { request, response ->
            logger.info("catch the request before the processing is done")
        }
        get("") { request, response ->
            logger.info("generating a new session")

            val test = "new session here"

            test
        }
        post("") { request, response ->
            otherDao.create()
            throw IllegalAccessException("403 not allowed from this ip: ${request.ip()}")
        }
        put("") {request, response ->
            otherDao.update()
            throw Exception("General Error")
        }
        after("") { request, response ->
            logger.info("catch the request after the processing is done")
        }
    }
}