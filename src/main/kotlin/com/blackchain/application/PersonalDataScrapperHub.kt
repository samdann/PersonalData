package com.blackchain.com.blackchain.application

import org.http4k.core.Response
import org.http4k.core.Status
import java.io.InputStream

class PersonalDataScrapperHub {

    fun importCouchSurfingData(content: InputStream): Response {
        return Response(Status.OK).body("Hello")
    }
}