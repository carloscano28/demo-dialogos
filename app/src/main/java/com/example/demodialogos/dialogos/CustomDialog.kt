package com.example.demodialogos.dialogos

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.demodialogos.R
import com.example.demodialogos.listeners.DialogoListener

class CustomDialog(val listener: DialogoListener ) : DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;
            val vista = inflater.inflate(R.layout.dialog_singin, null)
            val txtUserName = vista.findViewById<EditText>(R.id.username)
            val txtpassword = vista.findViewById<EditText>(R.id.password)
            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.dialog_singin, null))
                // Add action buttons
                .setPositiveButton(
                    R.string.signin,
                    DialogInterface.OnClickListener { dialog, id ->
                        // sign in the user ...
                        listener.onSingInSuccess(txtUserName.text.toString(),
                        txtpassword.text.toString())
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }



}