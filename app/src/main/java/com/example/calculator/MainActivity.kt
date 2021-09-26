package com.example.calculator

//import android.graphics.BlendModeColorFilter
//mport android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.MotionEvent
import android.view.View
import android.widget.Button
//import androidx.core.graphics.BlendModeColorFilterCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun buNumberEvent(view: View)
    {
        if(isNewop)
        {
            textView2.setText("")
        }
        isNewop = false
        val buSelect = view as Button
        //buttonEffect(buSelect)

        //This line takes already existing text from the textview and then concatenates it with text received
        //from the switch/when case.
        var buClickValue:String = textView2.text.toString()


        when(buSelect.id)
        {
            buttonzero.id -> {buClickValue += "0"}
            buttondoublezero.id -> {buClickValue += "00"}
            buttondot.id -> {buClickValue += "."}
            button1.id -> {buClickValue += "1"}
            button2.id -> {buClickValue += "2"}
            button3.id -> {buClickValue += "3"}
            button4.id -> {buClickValue += "4"}
            button5.id -> {buClickValue += "5"}
            button6.id -> {buClickValue += "6"}
            button7.id -> {buClickValue += "7"}
            button8.id -> {buClickValue += "8"}
            button9.id -> {buClickValue += "9"}
        }

        //this line pushes text received from buclick into the textview.
        textView2.setText(buClickValue)

    }
    var op = "*"
    var oldNumbers = ""
    var isNewop = true
    fun buOpEvent(view: View)
    {
        val buSelect2 = view as Button

        //var buClickValue:String = textView2.text.toString()

        when(buSelect2.id)
        {
            mul.id -> {op = "*"}
            div.id -> {op = "/"}
            add.id -> {op = "+"}
            subt.id -> {op = "-"}

        }
        oldNumbers = textView2.text.toString()
        isNewop = true

    }

    fun buEqualEvent(view: View)
    {
        val newNumber = textView2.text.toString()
        var outPut:Double ? = null
        when(op)
        {
            "*" -> {
                outPut = oldNumbers.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                outPut = oldNumbers.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                outPut = oldNumbers.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                outPut = oldNumbers.toDouble() - newNumber.toDouble()
            }
        }
        textView2.setText(outPut.toString())
        isNewop = true


    }

    fun buClear(view: View) {
        textView2.setText("0")
        isNewop = true

    }


}