package com.bedu.readme

import android.app.AlertDialog
import android.content.Context
import android.content.Intent


import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import db.countUsers
import db.listUsr
import models.User


class Act2_Signin : AppCompatActivity() {

    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act2_signin)

        sharedPreferences = getSharedPreferences("Preferencias", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        val name = findViewById<TextView>(R.id.editText_name_register)
        val userName = findViewById<TextView>(R.id.editText_emailUpdate)
        val email = findViewById<TextView>(R.id.editText_email_register)
        val password = findViewById<TextView>(R.id.editText_password_register)
        val phone = findViewById<TextView>(R.id.editText_phone_register)
        val buttonRegistrar = findViewById<Button>(R.id.btn_register_user)
        val btnTerms = findViewById<TextView>(R.id.textView_terms)
        var checkTerms = findViewById<CheckBox>(R.id.check_register)


        buttonRegistrar.setOnClickListener {
            if((name.text.trim().isNotEmpty()) && (userName.text.trim().isNotEmpty()) && (email.text.trim().isNotEmpty()) && (password.text.trim().isNotEmpty()) && (phone.text.trim().isNotEmpty()) && checkTerms.isChecked){
                listUsr[countUsers]= User(countUsers+1,name.text.toString(),userName.text.toString(),password.text.toString(),email.text.toString())

                val newUser = User(countUsers+1,name.text.toString(),userName.text.toString(),password.text.toString(),email.text.toString(),
                    "user", arrayListOf(mutableSetOf(), mutableSetOf(), mutableSetOf()) )

                listUsr[countUsers]= newUser
                userLogin = newUser

                editor.putBoolean("userLog",true).apply()
                editor.putInt("userId", userLogin.getId()).apply()
                editor.putString("userName", userLogin.getName() ).apply()
                editor.putString("userUserName", userLogin.getUserName() ).apply()
                editor.putString("userPassword", userLogin.getPassword() ).apply()
                editor.putString("userEmail", userLogin.getEmail() ).apply()
                editor.putString("userTypeAccount", userLogin.getEmail() ).apply()
                editor.putString("userPreferredBooks",
                    ", "+userLogin.preferredGenre[0].toString().replace("[","")
                        .replace("]","")+",").apply()
                editor.putString("userPreferredMagazine",
                    ", "+userLogin.preferredGenre[1].toString().replace("[","")
                        .replace("]","")+",").apply()
                editor.putString("userPreferredArticle",
                    ", "+userLogin.preferredGenre[2].toString().replace("[","")
                        .replace("]","")+",").apply()

                countUsers++

                mensaje("¡Bienvenido a la comunidad!","Es lo que lees cuando no tienes que hacerlo, lo que determina lo que serás. -Oscar Wilde.")
            }else{
                Toast.makeText(this,"Error, debes de llenar todos los campos y aceptar los terminos y condiciones.", Toast.LENGTH_LONG).show()
            }
        }

        btnTerms.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Terminos y Condiciones")
            builder.setMessage("La actividad del usuario en la aplicación como publicaciones o comentarios estarán sujetos a los presentes términos y condiciones. El usuario se compromete a utilizar el contenido, productos y/o servicios de forma lícita, sin faltar a la moral o al orden público, absteniéndose de realizar cualquier acto que afecte los derechos de terceros o el funcionamiento del sitio web.\n" +
                    "\n" +
                    "El usuario se compromete a proporcionar información verídica en los formularios del sitio web.\n" +
                    "\n" +
                    "El acceso al sitio web no supone una relación entre el usuario y el titular del sitio web.\n" +
                    "\n" +
                    "El usuario manifiesta ser mayor de edad y contar con la capacidad jurídica de acatar los presentes términos y condiciones." +
                    "Conforme a lo establecido en la Ley Federal de Protección de Datos Personales en Posesión de Particulares, el titular de compromete a tomar las medidas necesarias que garanticen la seguridad del usuario, evitando que se haga uso indebido de los datos personales que el usuario proporcione en el sitio web.\n" +
                    "\n" +
                    "El titular corroborará que los datos personales contenidos en las bases de datos sean correctos, verídicos y actuales, así como que se utilicen únicamente con el fin con el que fueron recabados.")
            builder.setPositiveButton("Aceptar", null)

            val dialog = builder.create()
            dialog.show()
        }






    }
    private fun mensaje(title:String,message:String){
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK"){dialogInterface, which ->
                val intent = Intent(this,Act2_SelectsPreferredGenres::class.java)
                startActivity(intent)
                loginactive?.finish()
                finish()
            }
            .create()
            .show()
    }


}