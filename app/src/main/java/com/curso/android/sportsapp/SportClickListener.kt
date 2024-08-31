package com.curso.android.sportsapp

import android.view.View

interface SportClickListener {
    fun onCLick(v: View, pos: Int)
}