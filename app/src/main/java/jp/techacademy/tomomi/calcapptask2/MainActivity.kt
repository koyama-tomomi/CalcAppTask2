package jp.techacademy.tomomi.calcapptask2


import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.content.Intent
import android.text.Editable
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), View.OnClickListener {

//    // 上のEditText
//    private var editText1 : EditText? = null
//    // 下のEditText
//    private var editText2 : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }


    override fun onClick(v: View) {

        val intent = Intent(this, SecondActivity::class.java)

        if ((editText1.text.length != 0 && editText1.text.toString() != "." && editText1.text.toString() != "-") && (editText2.text.length != 0 && editText2.text.toString() != "." && editText2.text.toString() != "-")) {


            var num1: kotlin.Double = editText1.text.toString().toDouble()
            var num2: kotlin.Double = editText2.text.toString().toDouble()

            when (v.id) {
                R.id.button1 -> intent.putExtra("VALUE1", num1 + num2)
                R.id.button2 -> intent.putExtra("VALUE1", num1 - num2)
                R.id.button3 -> intent.putExtra("VALUE1", num1 * num2)
                R.id.button4 -> intent.putExtra("VALUE1", num1 / num2)
            }

            startActivity(intent)

        } else {
            Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action") {
                    Log.d("UI_PARTS", "Snackbarをタップした")
                }.show()
        }


    }
}




