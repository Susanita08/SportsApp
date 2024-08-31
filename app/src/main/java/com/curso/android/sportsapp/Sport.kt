package com.curso.android.sportsapp

class Sport(sportName: String, sportImage: Int) {
    private val _sportName: String = sportName
    private val _sportImage: Int = sportImage

    fun getSportName(): String {
        return _sportName
    }

    fun getSportImage(): Int {
        return _sportImage
    }
}