package com.example.semana9dpafirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.semana9dpafirebase.model.UserModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val etFullName: EditText=findViewById(R.id.etFullName)
        val etCountry: EditText=findViewById(R.id.etCountry)
        val etEmailRegister: EditText=findViewById(R.id.etEmailRegister)
        val etPasswordRegister: EditText=findViewById(R.id.etPasswordRegsiter)
        val btnSaveRegister: Button=findViewById(R.id.btnSaveRegister)

        val auth = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()
        val collectionRef = db.collection("users")

        btnSaveRegister.setOnClickListener {
            val fullName = etFullName.text.toString()
            val country = etCountry.text.toString()
            val email = etEmailRegister.text.toString()
            val password=etPasswordRegister.text.toString()

            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){task->
                    if (task.isSuccessful){
                        var user: FirebaseUser?= auth.currentUser
                        var uid = user?.uid
                        var userModel = UserModel(email,password,fullName, country,uid.toString())
                        collectionRef.add(userModel)
                            .addOnCompleteListener {
                                Snackbar.make(findViewById(android.R.id.content),
                                    "Registro Exitoso", Snackbar.LENGTH_LONG).show()
                            }.addOnFailureListener {
                                Snackbar.make(findViewById(android.R.id.content),
                                    "No se pudo completar la transaccion", Snackbar.ANIMATION_MODE_FADE).show()
                            }


                    }else{
                        Snackbar.make(findViewById(android.R.id.content),
                            "Ocurrio un error a registrarse", Snackbar.ANIMATION_MODE_FADE).show()
                    }
                }

            startActivity(Intent(this, loginActivity::class.java))

        }



    }
}