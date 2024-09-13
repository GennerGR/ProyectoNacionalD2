package com.gnr.proyectod2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform