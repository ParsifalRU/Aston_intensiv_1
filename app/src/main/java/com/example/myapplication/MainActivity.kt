package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "Show Toast", Toast.LENGTH_SHORT).show()

        onClick()

        sealedTest()
    }

    private fun onClick(){
        val btnRuble = findViewById<Button>(R.id.man)
        btnRuble.setOnClickListener {
            val manDataClass1 = ManDataClass("Ivan", 21)
            val manDataClass2 = ManDataClass("Pavel", 99)
            Toast.makeText(this, "man1 = $manDataClass1 \nman2 = $manDataClass2", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sealedTest(){
        val sealedClass = SealedClass.ExampleSealedClass()
        val testSealed =  TestSealedClass().Test(sealedClass)
    }

    override fun onResume() {
        super.onResume()
        scopeLet()
        scopeAlso()
        scopeApply()
        scopeRun()
        scopeWith()
    }

    private fun scopeLet(){
        val manLet = ManDataClass("Let", 1).let {
            Log.d("LOGTAG", "key $it")
        }
    }

    private fun scopeRun(){
        val manRun = ManDataClass("Run", 4).run {
            Log.d("LOGTAG", "key $this")
        }
    }

    private fun scopeWith(){
        val mans = mutableListOf("Ivan", "With")
        val manLast = with(mans) {
            Log.d("LOGTAG", "key ${this.last()}")
        }
    }

    private fun scopeAlso(){
        val manAlso = ManDataClass("Also", 2).also {
            Log.d("LOGTAG", "key $it")
        }
    }

    private fun scopeApply(){
        val manApply = ManDataClass("Apply", 3).apply {
            Log.d("LOGTAG", "key $this")
        }
    }
}