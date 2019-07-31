package TestMicroService.DAO.Some

import TestMicroService.App
import org.apache.log4j.LogManager

private val logger = LogManager.getLogger(App::class.java)


class SomeDao {

    fun create() {
        logger.info("creating in some dao")
    }

    fun update() {
        logger.info("updating in some dao")
    }

}