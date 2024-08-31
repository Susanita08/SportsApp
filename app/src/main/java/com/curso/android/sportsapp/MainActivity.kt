package com.curso.android.sportsapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), SportClickListener {
    private val sportList : ArrayList<Sport> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)



        sportList.add(Sport("Soccer", R.drawable.football))
        sportList.add(Sport("Basketball", R.drawable.basketball))
        sportList.add(Sport("Volleyball", R.drawable.volley))
        sportList.add(Sport("Tennis", R.drawable.tennis))
        sportList.add(Sport("PinPong", R.drawable.ping))

        val myAdapter = CustomAdapter(sportList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter

        myAdapter.setClickListener(this)

    }

    override fun onCLick(v: View, pos: Int) {
        Toast.makeText(this, "You Choose: ${sportList[pos].getSportName()}", Toast.LENGTH_SHORT).show()
    }
}