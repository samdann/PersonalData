package com.blackchain.com.blackchain.launchers

import com.blackchain.com.blackchain.drivers.http.PersonalDataScrapperWeb
import com.blackchain.com.blackchain.utils.convertExceptionsTo500
import org.http4k.core.then
import org.http4k.filter.CorsPolicy
import org.http4k.filter.ServerFilters
import org.http4k.filter.ServerFilters.Cors.invoke
import org.http4k.server.Jetty
import org.http4k.server.asServer

class PersonalDataScrapperWebServer {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val allowCors = ServerFilters.Cors(CorsPolicy.UnsafeGlobalPermissive)
            val server = allowCors
                .then(convertExceptionsTo500())
                .then(PersonalDataScrapperWeb().routes())
                .asServer(Jetty(8081))
            server.start()
            println("Server has been started at http://localhost:${server.port()}")
        }
    }
}