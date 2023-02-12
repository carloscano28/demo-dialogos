package com.example.demodialogos.dialogos

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.demodialogos.R
import com.example.demodialogos.listeners.DialogoListener

class FireMissilesDialogFragment(val listener: DialogoListener) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog { // Agrega ? para recibir null
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)

            builder.setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.fire,
                    DialogInterface.OnClickListener { dialog, id ->
                        // FIRE ZE MISSILES!
                        // ejecutar en caso positivo
                        listener.onMissileFired("Si acepto en hora buena")
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                        // ejecutar en caso negativo
                        listener.onMissileFired("Nooooo")

                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}