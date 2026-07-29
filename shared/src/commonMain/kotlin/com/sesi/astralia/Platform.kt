package com.sesi.astralia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform