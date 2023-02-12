package com.example.demodialogos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.demodialogos.databinding.DialogSinginBinding
import com.example.demodialogos.dialogos.DatePickerDialogFragment
import com.example.demodialogos.dialogos.TimePickerDialogFragment
import com.example.demodialogos.listeners.DialogoListener

class RetoDialog : AppCompatActivity(), DialogoListener {

    private lateinit var binding: DialogSinginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DialogSinginBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_reto_dialog)
        setContentView(binding.root)

    }

    fun abrirDialogo(view: View) {

        when (view.id) {

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

    }
    override fun onTimeSelected(isSelected: Boolean, hora: Int, minuto: Int) {

    }
    override fun onListSelected(lista: ArrayList<String>) {

    }

    override fun onDateSelected(isSelected: Boolean, anio: Int, mes: Int, dia: Int) {
        TODO("Not yet implemented")
    }


    override fun onSingleSelected(topping: String) {

    }
    override fun onSingInSuccess(username: String, password: String) {

    }

    override fun onTimeEdtSelected(isSelected: Boolean, hora: Int, minuto: Int) {
        //val otraHora = binding.edthora
        //otraHora.setText("Selecciono ${hora} : $minuto")
    }

    override fun onDateEdtSelected(isSelected: Boolean, anio: Int, mes: Int, dia: Int) {
        TODO("Not yet implemented")
    }



}

