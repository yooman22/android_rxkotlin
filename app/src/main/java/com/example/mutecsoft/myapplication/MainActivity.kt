package com.example.mutecsoft.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

        list.toObservable() // extension function for Iterables
            .subscribeOn(Schedulers.io())
            .filter { it.length >= 5 }
            .map { it -> "Delta" }
            .observeOn(Schedulers.newThread())
            .subscribe {
                edit.setText(it)
            }

        Thread.sleep(1000)

    }
}

