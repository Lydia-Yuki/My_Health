package com.example.myhealth.ui.options

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.Toast
import android.widget.ToggleButton
import androidx.fragment.app.Fragment
import com.example.myhealth.R
import java.util.*


class MedicineFragment : Fragment() {
    var alarmTimePicker: TimePicker? = null
    var pendingIntent: PendingIntent? = null
    var alarmManager: AlarmManager? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_medicine, container, false)
        val btn : ToggleButton = root.findViewById<ToggleButton>(R.id.toggleButton)

        alarmTimePicker = root.findViewById<View>(R.id.timePicker) as TimePicker
        alarmManager = requireActivity().getSystemService(ALARM_SERVICE) as AlarmManager?

                var time: Long


            btn.setOnClickListener {
                Toast.makeText(root.context, "ALARM ON", Toast.LENGTH_SHORT).show()
                val calendar = Calendar.getInstance()

                // calendar is called to get current time in hour and minute
                calendar[Calendar.HOUR_OF_DAY] = alarmTimePicker!!.currentHour
                calendar[Calendar.MINUTE] = alarmTimePicker!!.currentMinute

                // using intent i have class AlarmReceiver class which inherits
                // BroadcastReceiver
                val intent = Intent(root.context, AlarmReceiver::class.java)

                // we call broadcast using pendingIntent
                pendingIntent = PendingIntent.getBroadcast(root.context, 0, intent, 0)
                time = calendar.timeInMillis - calendar.timeInMillis % 60000
                if (System.currentTimeMillis() > time) {
                    // setting time as AM and PM
                    time = if (calendar.get(Calendar.AM_PM) === 0) time + 1000 * 60 * 60 * 12
                    else time + 1000 * 60 * 60 * 24
                }
                // Alarm rings continuously until toggle button is turned off
                alarmManager?.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent)
                 //alarmManager?.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (time * 1000), pendingIntent);
            }
//            else {
//                alarmManager = requireActivity().getSystemService(ALARM_SERVICE) as AlarmManager?
//                pendingIntent?.cancel()
//                alarmManager?.cancel(pendingIntent)
//                Toast.makeText(root.context, "ALARM OFF", Toast.LENGTH_SHORT).show()
//            }

        return root
    }


}

