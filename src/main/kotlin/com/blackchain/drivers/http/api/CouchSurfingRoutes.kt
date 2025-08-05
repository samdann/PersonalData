package com.blackchain.com.blackchain.drivers.http.api

import com.blackchain.com.blackchain.application.PersonalDataScrapperHub
import org.http4k.contract.PreFlightExtraction
import org.http4k.contract.Tag
import org.http4k.contract.meta
import org.http4k.contract.security.Security
import org.http4k.core.Body
import org.http4k.core.ContentType
import org.http4k.core.Method
import org.http4k.core.Status
import org.http4k.core.Status.Companion.OK
import org.http4k.lens.MultipartFormFile
import org.http4k.lens.Validator
import org.http4k.lens.multipartForm

private val uploadFile = MultipartFormFile.required("document")
private val uploadMasterDataBodyLens = Body.multipartForm(Validator.Strict, uploadFile).toLens()

fun importCouchSurfingData(hub: PersonalDataScrapperHub) =
    "/api/v1/couch-surfing/import-data" meta {
        summary = "Import all data from Couch surfing"
        description = "Import all data from Couch surfing"
        security = Security.None
        tags += Tag("Couch Surfing")
        produces += ContentType.MULTIPART_FORM_DATA
        preFlightExtraction = PreFlightExtraction.IgnoreBody


        receiving(uploadMasterDataBodyLens)
        returning(OK)
        returning(Status.BAD_REQUEST)
        returning(Status.INTERNAL_SERVER_ERROR)
    } bindContract Method.POST to { req ->
        val content = uploadFile(uploadMasterDataBodyLens(req))
        hub.importCouchSurfingData(content.content)
    }