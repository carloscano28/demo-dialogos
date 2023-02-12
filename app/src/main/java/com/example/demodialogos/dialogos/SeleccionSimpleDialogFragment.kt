package com.example.demodialogos.dialogos

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.demodialogos.R
import com.example.demodialogos.listeners.DialogoListener

class SeleccionSimpleDialogFragment(val listener:DialogoListener):DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val arrayToppings = arrayOf<String>("Bufaalo", "MAyonesa", "Caesar", "Chip", "fdsfds")
        var seleccionado: String = arrayToppings[0]
            return activity?.let {
            val selectedItems = ArrayList<Int>() // Where we track the selected items
            val selectedToppings = ArrayList<String>()
            val builder = AlertDialog.Builder(it)
            // Set the dialog title
            builder.setTitle(R.string.pick_toppings)
                // Specify the list array, the items to be selected by default (null for none),
                // and the listener through which to receive callbacks when items are selected
                .setSingleChoiceItems(arrayToppings, 0, //Elementos seleccionados por default
                    DialogInterface.OnClickListener { dialog, which->
                        seleccionado=arrayToppings[which]
                    })
                // Set the action buttons
                .setPositiveButton(R.string.ok,
                    DialogInterface.OnClickListener { dialog, id ->
                        // User clicked OK, so save the selectedItems results somewhere
                        // or return them to the component that opened the dialog
                        listener.onSingleSelected(seleccionado)
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->

                    })

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}