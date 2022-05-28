package com.example.myhealth.ui.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myhealth.R
import com.example.myhealth.ui.records.RecordsFragment
import kotlinx.android.synthetic.main.fragment_sugar.view.*
import java.util.*


class SugarFragment : Fragment() {

    private lateinit var cal : String
    private lateinit var clo : String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sugar, container, false)
        val binding = root.findViewById<DatePicker>(R.id.datePicker)
        val binder = root.findViewById<TimePicker>(R.id.timePicker)
        val fig1 = root.findViewById<EditText>(R.id.result)

        val btn: Button = root.findViewById<Button>(R.id.cancel)
        val con: Button = root.findViewById<Button>(R.id.confirm)


        btn.setOnClickListener {
            view?.findNavController()?.navigate(R.id.navigation_home)
            true
        }

        con.setOnClickListener {

            val today = Calendar.getInstance()
            binding.datePicker.init(
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH)

            ) { view, year, monthOfYear, dayOfMonth ->
                val month = monthOfYear + 1
                val msg = "Selected Date is $dayOfMonth/$month/$year"
                cal = "$dayOfMonth/$month/$year"
                //Toast.makeText(root.context, msg, Toast.LENGTH_SHORT).show()
                true

            }
            val month = today.get(Calendar.MONTH) + 1
            cal = "${today.get(Calendar.DAY_OF_MONTH)}/$month/${today.get(Calendar.YEAR)}"

            binder.timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
                val dayHour = when {
                    hourOfDay == 0 -> {
                        hourOfDay + 12
                    }
                    hourOfDay > 12 -> {
                        hourOfDay - 12
                    }
                    else -> hourOfDay
                }

                val format = when {
                    hourOfDay >= 12 -> {
                        "PM"
                    }
                    else -> "AM"
                }

                val hour = if (dayHour < 10) "0$dayHour" else dayHour
                val min = if (minute < 10) "0$minute" else minute

                val text = "The selected time is:" + " " + hour + " : " + min + " " + format
                val clock = "$hour:$min$format"
                //Toast.makeText(root.context, text, Toast.LENGTH_SHORT).show()
                true

        }
            val hourOfDay = today.get(Calendar.HOUR_OF_DAY)
            val minute = today.get(Calendar.MINUTE)
            val dayHour = when {
                hourOfDay == 0 -> {
                    hourOfDay + 12
                }
                hourOfDay > 12 -> {
                    hourOfDay - 12
                }
                else -> hourOfDay
            }

            val format = when {
                hourOfDay >= 12 -> {
                    "PM"
                }
                else -> "AM"
            }

            val hour = if (dayHour < 10) "0$dayHour" else dayHour
            val min = if (minute < 10) "0$minute" else minute

            clo = "$hour:$min$format"

            val value1 = fig1.text.toString()
           // Toast.makeText(root.context, value1, Toast.LENGTH_SHORT).show()
            //clo = "$hour:$min$format"
                val res = value1
                val tim = clo
                val date = cal
                val bundle = Bundle()
                bundle.putString("record", res)
                bundle.putString("date", date)
                bundle.putString("time", tim)

                val data = SugarData()
                data.arguments = bundle

                val records = RecordsFragment()
                records.arguments = bundle

            fragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment, data)?.commit()
//                view?.findNavController()?.navigate(R.id.sugarData)
//                true
        }


        return root
    }
    fun onClick(v: View?) {
        var text: String? = null
        if (v is TextView) {
            text = v.text.toString()
        }
    }
}