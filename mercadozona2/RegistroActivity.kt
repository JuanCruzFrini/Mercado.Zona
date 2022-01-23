package com.example.mercadozona2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_registro.*

class RegistroActivity : AppCompatActivity() {

    //identificador para recoger la rta de la auth
    val GOOGLE_SIGN_IN = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val registrarbtn = findViewById<Button>(R.id.registrarbtn)
        val accederbtn = findViewById<Button>(R.id.accederbtn)

        //signIn resgistrar con email
        registrarbtn.setOnClickListener {
            val email:String = findViewById<EditText>(R.id.email_registro).text.toString()
            val contra:String = findViewById<EditText>(R.id.contra_registro).text.toString()
            if (contra.isNotEmpty() && email.isNotEmpty()){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.toString(), contra.toString()).addOnCompleteListener {
                if (it.isSuccessful){
                    startActivity(Intent(this, RegistroCompletadoActivity::class.java)
                        .putExtra("Email", email.toString())
                        .putExtra("Contra", contra.toString()))
                } else {
                    Toast.makeText(this, "Error de registro", Toast.LENGTH_SHORT).show()
                }
            }
            } else {
              Toast.makeText(this, "Debes completar todos los campos para registrarte", Toast.LENGTH_SHORT).show()
            }
        }

        //log in acceder
        accederbtn.setOnClickListener {
            val email:String = findViewById<EditText>(R.id.email_registro).text.toString()
            val contra:String = findViewById<EditText>(R.id.contra_registro).text.toString()
            if (contra.isNotEmpty() && email.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email.toString(), contra.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        startActivity(Intent(this, RegistroCompletadoActivity::class.java)
                            .putExtra("Email", email.toString())
                            .putExtra("Contra", contra.toString()))
                    } else {
                        Toast.makeText(this, "Error de registro", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Debes completar todos los campos para acceder", Toast.LENGTH_SHORT).show()
            }
        }

        //autenticacion con google
        googlebtn.setOnClickListener {

            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))//token id asociado a nuestra app
                .requestEmail()//solicitamos el email del usuario cuand hacemos login
                .build()

            val googleClient = GoogleSignIn.getClient(this, googleConf)

            startActivityForResult(googleClient.signInIntent,GOOGLE_SIGN_IN)

        }

        subirfoto.setOnClickListener { startActivity(Intent(this, SubirFotoFbStorage::class.java)) }

        sesion()
    }

    @SuppressLint("CommitPrefEdits")
    fun sesion(){
        val prefs: SharedPreferences = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val email = prefs.getString("email", null)
        val contra = prefs.getString("contraseña", null)

        if (email != null && contra != null){
            startActivity(Intent(this, RegistroCompletadoActivity::class.java)
                .putExtra("Email", email.toString())
                .putExtra("Contra", contra.toString()))
        }
    }
}