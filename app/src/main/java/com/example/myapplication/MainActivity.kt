package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ResultFragment.CallbackResultFragment {

    override fun mcGiveBite(callback: String) {
        text_1.text = callback
    }

    lateinit var result1: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_1.setOnClickListener {
            result1 = edit_text_1.text.toString()

            var fragment = ResultFragment.newInstance(result1)

            supportFragmentManager.beginTransaction().add(R.id.frag1, fragment, ResultFragment.TAG).commit()

        }

    }
}
