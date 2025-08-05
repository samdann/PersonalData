package com.blackchain.com.blackchain.drivers.http

import com.blackchain.com.blackchain.drivers.http.api.importCouchSurfingData
import org.http4k.contract.ContractRoutingHttpHandler
import org.http4k.contract.contract
import org.http4k.contract.openapi.ApiInfo
import org.http4k.contract.openapi.v3.OpenApi3

fun createContractHandler(descriptionPath: String): ContractRoutingHttpHandler {

    val personalDataScrapperHub = HubBuilders.buildPersonalDataScrapperHub()
    // Define a contract, and render an OpenApi 3 spec at the given path
    return contract {

        routes += importCouchSurfingData(personalDataScrapperHub)
        renderer = OpenApi3(
            ApiInfo("Hello Server - Developer UI", "99.3.4")
        )
        this.descriptionPath = descriptionPath
    }
}
