package mx.edu.ittepic.ladm_u1_practica1_disenio_menu_principal

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import mx.edu.ittepic.ladm_u1_practica1_disenio_menu_principal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //<editor-fold desc="REGISTRAR">
        //**************************************** REGISTRAR ************************************
        binding.registrar.setOnClickListener {
            //Declaramos variables de datos
            var mensajeDatos: String =
                "Sus datos han sido registrados:\nNombre:${binding.nombre.text}" +
                        "\nEmail:${
                            binding.email.text
                        }\n" +
                        "Cumpleaños:${binding.birthday.text}\n" +
                        "Genero:${
                            if (binding.hombre.isChecked) "Hombre" else "Mujer"
                        }\n" +
                        "Usuario:${binding.usuario.text}"
            var mensaje: String =
                if (binding.password.text.toString() != binding.confirmPassword.text.toString()) "Favor " +
                        "de" +
                        " escribir la misma contraseña"
                else (if (!binding.terminos.isChecked) "Favor de aceptar terminos y condiciones"
                else mensajeDatos)
            //Lo que cambia entre cada uno
            // es el como se escriben, por ejemplo el de java es {condicion ? verdadero : falso}, los
            // de python y kotlin por lo que podemos ver son {if(condicion) verdadero else falso},
            // parece un if en una sola linea (literal)
            AlertDialog.Builder(this).setTitle("Datos registrados")
                .setMessage(mensaje)
                .setNeutralButton("Salir") { d, i ->
                    finish()
                }.setPositiveButton("Aceptar") { d, i ->
                    d.dismiss()
                    limpiarCampos()
                }
                .show()
        }
        //</editor-fold>

        //<editor-fold desc="SALIR">
        //********************************* SALIR ******************************************
        binding.salir.setOnClickListener {
            finish()
        }
        //</editor-fold>

    }


    //<editor-fold desc="FUNCIONES">
    //********************************** FUNCIONES *****************************************
    fun limpiarCampos() {
        binding.nombre.setText("")
        binding.email.setText("")
        binding.birthday.setText("")
        binding.password.setText("")
        binding.confirmPassword.setText("")
        binding.usuario.setText("")
        binding.terminos.isChecked = false
    }
    //</editor-fold>
}

//Procedemos a la grabacion?AJÁ, sale pasame el ... zoom >:3 porfa