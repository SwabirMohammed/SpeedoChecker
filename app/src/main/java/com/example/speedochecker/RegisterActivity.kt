package com.example.speedochecker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var enterfirstname:EditText
    private lateinit var entersecondname:EditText
    private lateinit var enteremailreg:EditText
    private lateinit var enterpasswordreg:EditText
    private lateinit var registerbutton:Button
    private lateinit var loginregbutton:Button
    private lateinit var auth: FirebaseAuth


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        enterfirstname = findViewById(R.id.edtFirstName)
        entersecondname = findViewById(R.id.edtLastName)
        enteremailreg = findViewById(R.id.edtEmailReg)
        enterpasswordreg = findViewById(R.id.edtPasswordRegPage)
        registerbutton = findViewById(R.id.btnRegisterRegPage)
        loginregbutton = findViewById(R.id.btnLoginRegPage)
        auth = FirebaseAuth.getInstance()



        loginregbutton.setOnClickListener {

            var gobacktologin = Intent(this, LoginActivity::class.java)
            startActivity(gobacktologin)
        }


        registerbutton.setOnClickListener {
            var firstname = enterfirstname.text.toString().trim()
            var secondname = entersecondname.text.toString().trim()
            var emailreg = enteremailreg.text.toString().trim()
            var passwordreg = enterpasswordreg.text.toString().trim()

            if (firstname.isEmpty() || secondname.isEmpty() || emailreg.isEmpty() || passwordreg.isEmpty()) {

                Toast.makeText(this, "Cannot submit an empty field", Toast.LENGTH_SHORT).show()
            } else {

                auth.createUserWithEmailAndPassword(emailreg, passwordreg).addOnCompleteListener(this){

                    if (it.isSuccessful) {
                        Toast.makeText(this, "User Created Successfully !", Toast.LENGTH_SHORT).show()

                        var gotologin = Intent(this, LoginActivity::class.java)
                        startActivity(gotologin)

                    } else {

                        Toast.makeText(this, "Unable to Create User !", Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }



    }
}