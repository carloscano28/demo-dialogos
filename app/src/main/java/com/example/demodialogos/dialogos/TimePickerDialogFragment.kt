package com.example.demodialogos.dialogos

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.demodialogos.listeners.DialogoListener
import java.util.*

class TimePickerDialogFragment(private val listener:DialogoListener):DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        var hora = calendar.get(Calendar.HOUR_OF_DAY)
        var minuto = calendar.get(Calendar.MINUTE)


        return TimePickerDialog(activity as Context, this, hora, minuto, false)
    }

    override fun onTimeSet(p0: TimePicker?, hourOfDay: Int, minute: Int) {
        listener.onTimeSelected(isSelected = true, hora=hourOfDay, minuto = minute  )
        listener.onTimeEdtSelected(isSelected = true, hora=hourOfDay, minuto = minute  )
    }


}