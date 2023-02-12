package com.example.demodialogos

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.demodialogos.databinding.ActivityMainBinding
import com.example.demodialogos.dialogos.*
import com.example.demodialogos.listeners.DialogoListener

class MainActivity : AppCompatActivity(),DialogoListener { // El main escucha al listener

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun abrirDialogo(view: View) {

        when (view.id){
            R.id.btnMissiles->{
                val newFragment = FireMissilesDialogFragment(this)
                newFragment.show(supportFragmentManager, "missiles")

            }
            R.id.btnHora->{
                val newFragment =TimePickerDialogFragment(this)
                newFragment.show(supportFragmentManager, "Time")

            }
            R.id.btnMultiple->{
                val newFragment =ListaDialogFragment(this)
                newFragment.show(supportFragmentManager, "Lista")

            }
            R.id.btnDate->{
                val newFragment =DatePickerDialogFragment(this)
                newFragment.show(supportFragmentManager, "date")

            }
            R.id.btnSimple->{
                val newFragment =SeleccionSimpleDialogFragment(this)
                newFragment.show(supportFragmentManager, "simple")
            }
            R.id.btnCustom->{
                val newFragment =CustomDialog(this)
                newFragment.show(supportFragmentManager, "custom")
            }
            R.id.edtfecha->{

                val newFragment = DatePickerDialogFragment(this)
                newFragment.show(supportFragmentManager, "Fecha ")
            }
            R.id.edthora->{
                val newFragment = TimePickerDialogFragment(this)
                newFragment.show(supportFragmentManager, "Edt Hora")
            }

        }
    }


    override fun onMissileFired(respuesta: String) {

        Toast.makeText(applicationContext, respuesta, Toast.LENGTH_SHORT).show()
    }

    override fun onTimeSelected(isSelected: Boolean, hora: Int, minuto: Int) {



        if (isSelected){
            /*var minutoString= if(minuto<10){
                "$minuto"
            }     */
            Toast.makeText(applicationContext, "$hora : $minuto", Toast.LENGTH_SHORT).show()
        }
        else{

            Toast.makeText(applicationContext, "No se selecciono hora", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onListSelected(lista: ArrayList<String>) {
        var mensaje= ""
        lista.forEach{
            mensaje+= "Topping= $it \n"

        }
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }

    override fun onDateSelected(isSelected: Boolean, anio: Int, mes: Int, dia: Int) {
        //binding.btnDate.isClickable=false
        Toast.makeText(applicationContext, "La fecha es $dia/ ${mes+1} / $anio  " , Toast.LENGTH_SHORT).show()


    }

    override fun onSingleSelected(topping: String) {

        Toast.makeText(applicationContext, "Seleccionado $topping", Toast.LENGTH_SHORT).show()
    }

    override fun onSingInSuccess(username: String, password: String) {
        Toast.makeText(applicationContext, "Custom $username $password", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    override fun onTimeEdtSelected(isSelected: Boolean, hora: Int, minuto: Int) {

        if (binding.btnHora.isClickable==true){
        val otraHora = binding.edthora
        otraHora.setText("Selecciono ${hora} : $minuto")
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onDateEdtSelected(isSelected: Boolean, anio: Int, mes: Int, dia: Int) {
        //binding.btnDate.isClickable=false

        if (binding.btnDate.isClickable==true){
            val otraFecha=binding.edtfecha
            otraFecha.setText("Selecciono $dia / ${mes+1} /$anio ")
        }


    }


}