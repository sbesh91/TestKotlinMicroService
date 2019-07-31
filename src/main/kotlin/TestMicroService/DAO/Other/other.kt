package TestMicroService.DAO.Other

import TestMicroService.App
import org.apache.log4j.LogManager

private val logger = LogManager.getLogger(App::class.java)


object OtherDao {

    fun create() {
        logger.info("creating in other dao")
    }

    fun update() {
        logger.info("updating in other dao")
    }

}