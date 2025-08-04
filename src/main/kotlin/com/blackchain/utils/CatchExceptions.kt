package com.blackchain.com.blackchain.utils

import org.http4k.core.Filter

fun convertExceptionsTo500() = Filter { next ->

    { request ->
        try {
            next(request)
        } catch (e: Throwable) {
            e.stackTrace.toList().map { println(it) }
            next(request)
        }
    }
}