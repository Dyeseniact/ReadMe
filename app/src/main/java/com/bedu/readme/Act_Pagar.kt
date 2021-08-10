package com.bedu.readme

//import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bedu.readme.models.Validation

//class Act_Pagar : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_act_pagar)
//    }
//}

class Act_Pagar : AppCompatActivity() {

//    var validation: Validation? = null
//    var progress: ProgressDialog? = null
//    var txtcardnumber: TextView? = null
//    var txtcvv: TextView? = null
//    var txtmonth: TextView? = null
//    var txtyear: TextView? = null


    private lateinit var validation: Validation
    private lateinit var txtcardnumber: TextView
    private lateinit var txtcvv: TextView
    private lateinit var txtmonth: TextView
    private lateinit var txtyear: TextView
    private lateinit var btnPay: Button
    private lateinit var btnCancel: Button

    var tarjetaTrue: Boolean = false
    var cvvTrue: Boolean = false
    var monthTrue: Boolean = false
    var yearTrue: Boolean = false


    //private var cvv by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act_pagar)
        validation = Validation()


//        progress = ProgressDialog(this)
//        progress!!.setMessage("Validando informacion de la tarjeta")
//        progress!!.setCancelable(false)
//        progress!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)

//        txtcardnumber = findViewById<View>(R.id.txt_cardnumber) as TextView
//        txtcvv = findViewById<View>(R.id.txt_cvv) as TextView
//        txtmonth = findViewById<View>(R.id.txt_month) as TextView
//        txtyear = findViewById<View>(R.id.txt_year) as TextView

        txtcardnumber = findViewById(R.id.txt_cardnumber)
        txtcvv = findViewById(R.id.txt_cvv)
        txtmonth = findViewById(R.id.txt_month)
        txtyear = findViewById(R.id.txt_year)


//
        btnPay = findViewById(R.id.btn_pay)
        btnCancel = findViewById(R.id.btn_cancelar)


       // txtcvv.isEnabled = false





        txtcardnumber!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.length == 0) {
                    txtcvv.isEnabled = true
                }
            }

            override fun afterTextChanged(s: Editable) {
                val text = txtcardnumber.text.toString()
                if (s.length == 0) {
                    txtcardnumber!!.setBackgroundResource(R.drawable.border_error)
                    tarjetaTrue = false
                }
                if (validation!!.luhn(text)) {
                    txtcardnumber!!.setBackgroundResource(R.drawable.border_sucess)
                    tarjetaTrue = true
                } else {
                    txtcardnumber!!.setBackgroundResource(R.drawable.border_error)
                    tarjetaTrue = false
                }

//                if (cvv > 0) {
//                    txtcvv!!.filters = arrayOf(InputFilter.LengthFilter(cvv))
//                    txtcvv!!.isEnabled = true
//                } else {
//                    txtcvv.isEnabled = false
//                    txtcvv.text = ""
//                }
            }
        })

        txtcvv.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                val text = txtcvv
                if (text.length()==3) {
                    txtcvv.setBackgroundResource(R.drawable.border_sucess)
                    cvvTrue = true
                } else {
                    txtcvv.setBackgroundResource(R.drawable.border_error)
                    cvvTrue = false
                }
            }
        })




        txtyear.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                val text = txtyear!!.text.toString()
                if (validation!!.year(text)) {
                    txtyear!!.setBackgroundResource(R.drawable.border_error)
                    yearTrue = false
                } else {
                    txtyear!!.setBackgroundResource(R.drawable.border_sucess)
                    yearTrue = true
                }
            }
        })


        txtmonth.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                val text = txtmonth!!.text.toString()
                if (validation!!.month(text)) {
                    txtmonth!!.setBackgroundResource(R.drawable.border_error)
                    monthTrue = false
                } else {
                    txtmonth!!.setBackgroundResource(R.drawable.border_sucess)
                    monthTrue = true
                }
            }
        })



        btnPay.setOnClickListener {

          if (tarjetaTrue==true && cvvTrue == true && yearTrue == true && monthTrue == true ){
              //Toast.makeText(this,"Pago Exitoso. Y llevar a ventana de confirmacion", Toast.LENGTH_SHORT).show()
              val intent = Intent(this,Act_ConfirmarPago::class.java)
              startActivity(intent)
              finish()

            }else{
                Toast.makeText(this,"Complete todos los campos. Y seguir en la view", Toast.LENGTH_SHORT).show()
                tarjetaTrue==false && cvvTrue == false && yearTrue == false && monthTrue == false
          }
        }


        btnCancel.setOnClickListener {
            val intent = Intent(this,Act3_Home::class.java)
                startActivity(intent)
                finish()
        }





    }
}
