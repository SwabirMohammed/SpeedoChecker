package com.example.speedochecker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var enteremaillogin:EditText
    private lateinit var enterpassword:EditText
    private lateinit var loginbuttonpage:Button
    private lateinit var createaccountbutton:Button
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        enteremaillogin = findViewById(R.id.edtEmailLoginPage)
        enterpassword = findViewById(R.id.edtPassLoginPage)
        loginbuttonpage = findViewById(R.id.btnLoginPage)
        createaccountbutton = findViewById(R.id.btnCreateAccountLoginPage)
        auth = FirebaseAuth.getInstance()



        createaccountbutton.setOnClickListener {

            var gotoregister = Intent(this, RegisterActivity::class.java)
            startActivity(gotoregister)
        }




        loginbuttonpage.setOnClickListener {
            var enteremail = enteremaillogin.text.toString().trim()
            var enterpass = enterpassword.text.toString().trim()

            // Validate the user's input

            if (enteremail.isEmpty() || enterpass.isEmpty()) {
                Toast.makeText(this, "Cannot submit an empty field !", Toast.LENGTH_SHORT).show()
            } else {

                auth.signInWithEmailAndPassword(enteremail, enterpass).addOnCompleteListener(this) {

                    if (it.isSuccessful) {

                        Toast.makeText(this, "Login Success !", Toast.LENGTH_SHORT).show()

                        var gotospeedtracker = Intent(this, SpeedTrackerActivity::class.java)
                        startActivity(gotospeedtracker)
                        // Prevent the user from going back to the login page
                        finish()

                    } else {
                            Toast.makeText(this, "Unable to login", Toast.LENGTH_SHORT).show()
                        }



                    }
                }
            }



        }



    }
