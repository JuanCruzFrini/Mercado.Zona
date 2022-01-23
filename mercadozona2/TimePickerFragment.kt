package com.example.mercadozona2

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerFragment(val listener:(String)-> Unit): DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val t = Calendar.getInstance()
        val hour = t.get(Calendar.HOUR_OF_DAY)
        val min = t.get(Calendar.MINUTE)
        val dialog = TimePickerDialog(activity as Context, this, hour, min, true) //este ultimo true indica si queremos am/pm o 24hs
        return dialog
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        if (hourOfDay < 10 && minute < 10){
            listener("0$hourOfDay:0$minute")
        } else if (hourOfDay < 10) {
            listener("0$hourOfDay:$minute")
        } else if (minute < 10) {
            listener("$hourOfDay:0$minute")
        } else {
            listener("$hourOfDay:$minute")
        }
    }

}