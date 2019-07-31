package TestMicroService.Routes.ErrorHandlers
import TestMicroService.App
import org.apache.log4j.LogManager
import spark.Spark.*;
private val logger = LogManager.getLogger(App::class.java)

val errorRoutes = {
    exception(IllegalAccessException::class.java) { exception, request, response ->
        logger.error(exception.message)
        response.status(403)
        response.body(exception.message)
    }

    internalServerError { request, response ->
        val message = "Internal server error at: ${request.url()}"
        logger.error(message)
        response.status(500)
        message
    }

    notFound { request, response ->
        val message = "Request url not found: ${request.url()}"
        logger.info(message)
        message
    }
}