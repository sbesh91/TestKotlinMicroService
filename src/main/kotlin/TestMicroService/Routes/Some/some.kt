package TestMicroService.Routes.Some
import TestMicroService.App
import TestMicroService.DAO.Some.SomeDao
import org.apache.log4j.LogManager
import spark.Spark.*;
private val logger = LogManager.getLogger(App::class.java)
private val someDao = SomeDao();


fun setup() {
    path("/manifests") {
        before("") { request, response ->
            logger.info("catch the request before the processing is done")
        }
        get("") { request, response ->
            logger.info("generating a new manifest")

            "new manifest here"
        }
        post("") { request, response ->
            someDao.create()
            "creating new manifest"
        }
        put("") { request, response ->
            someDao.update()
            "updating manifest"
        }
        after("") { request, response ->
            logger.info("catch the request after the processing is done")
        }
    }
}