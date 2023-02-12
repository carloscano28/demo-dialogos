package com.example.demodialogos.dialogos

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.demodialogos.listeners.DialogoListener
import java.util.*

class DatePickerDialogFragment(private val listener:DialogoListener):DialogFragment(),
    DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        var anio = calendar.get(Calendar.YEAR)
        var mes = calendar.get(Calendar.MONTH)
        var dia = calendar.get(Calendar.DAY_OF_MONTH)


        return DatePickerDialog(activity as Context,this, anio,mes,dia )
    }

    override fun onDateSet(view: DatePicker?, anio: Int, mes: Int, dia: Int) {
        listener.onDateSelected( anio=anio, mes=mes, dia=dia)
        listener.onDateEdtSelected( anio=anio, mes=mes, dia=dia)
    }




}