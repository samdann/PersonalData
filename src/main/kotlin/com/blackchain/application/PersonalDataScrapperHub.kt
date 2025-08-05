package com.blackchain.com.blackchain.application

import com.blackchain.com.blackchain.adapters.couchsurfing.domain.MessagesWrapper
import org.http4k.core.Response
import org.http4k.core.Status
import org.http4k.format.Jackson
import java.io.InputStream


class PersonalDataScrapperHub {

    fun importCouchSurfingData(content: InputStream): Response {
        val jsonString = content.bufferedReader().use { it.readText() }
        val messagesWrapper = Jackson.asA(jsonString, MessagesWrapper::class)
        println(messagesWrapper)
        return Response(Status.OK).body("Hello")
    }
}

