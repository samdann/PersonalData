package com.blackchain.com.blackchain.drivers.http

import com.blackchain.com.blackchain.application.PersonalDataScrapperHub

object HubBuilders {

    fun buildPersonalDataScrapperHub(): PersonalDataScrapperHub {
        return PersonalDataScrapperHub()
    }
}