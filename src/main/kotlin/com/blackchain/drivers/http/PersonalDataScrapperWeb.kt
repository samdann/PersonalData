package com.blackchain.com.blackchain.drivers.http

import org.http4k.contract.ui.swaggerUiLite
import org.http4k.routing.RoutingHttpHandler

class PersonalDataScrapperWeb {

    fun routes(): RoutingHttpHandler = org.http4k.routing.routes(
        // bind the API and OpenApi description off of root
        createContractHandler("/openapi.json"),

        // bind Swagger UI to the root path
        swaggerUiLite {
            url = "/openapi.json"
            pageTitle = "Hello Server - Swagger UI"
            persistAuthorization = true
        }
    )
}