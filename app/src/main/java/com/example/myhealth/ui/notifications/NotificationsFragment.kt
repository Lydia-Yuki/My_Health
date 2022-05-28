package com.example.myhealth.ui.notifications

import android.R.attr.defaultValue
import android.R.attr.key
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.drawable.Icon
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import com.example.myhealth.R
import com.example.myhealth.ui.options.FoodFragment


class NotificationsFragment : Fragment() {


    private val CHANNEL_ID: String? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {

        val CHANNEL_ID = "com.example.myhealth.ui.notifications"
        lateinit var builder: Notification.Builder
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val btn = root.findViewById<Button>(R.id.refresh)
        val argue = this.arguments
        val inputData = argue?.getIntegerArrayList("data")
        //val textview = inputData.toString()
        //val record = textview.
        val first: Int = 122
        val second: Int = 117
        val mid : ArrayList<Int> = arrayListOf(first, second)


        val notificationManager: NotificationManager =
                requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        btn.setOnClickListener {

            val intent = Intent(root.context, FoodFragment::class.java)
            val pendingIntent = NavDeepLinkBuilder(root.context)
                    .setGraph(R.navigation.mobile_navigation)
                    .setDestination(R.id.foodFragment)
                    .setArguments(argue)
                    .createPendingIntent()

            val pendingIntent2 = NavDeepLinkBuilder(root.context)
                    .setGraph(R.navigation.mobile_navigation)
                    .setDestination(R.id.lowBPFragment)
                    .setArguments(argue)
                    .createPendingIntent()

            val icon: Icon = Icon.createWithResource(root.context, android.R.drawable.ic_dialog_info)
            val action: Notification.Action =
                    Notification.Action.Builder(icon, "Open", pendingIntent).build()

            val val1 = inputData[0].toString()
            val comp1 = mid[0].toString()
            val val2 = inputData[1].toString()
            val comp2 = mid[1].toString()
            val ans = val1.compareTo(comp1)
            val wer = val2.compareTo(comp2)
            when {
                val1 <= 122.toString() -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        val name = getString(R.string.app_name)
                        val descriptionText = "BP is too low."
                        val channel = NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH)
                        channel.description = descriptionText
                        channel.enableLights(true)
                        channel.enableVibration(false)
                        notificationManager.createNotificationChannel(channel)

                        builder = Notification.Builder(root.context, CHANNEL_ID)
                                .setSmallIcon(R.drawable.health)
                                .setContentTitle("BP Notification")
                                .setContentText("BP is too low.")
                                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.health))
                                .setNumber(10)
                                .setActions(action)
                                .setContentIntent(pendingIntent2)
                    } else {

                        builder = Notification.Builder(root.context)
                                .setSmallIcon(R.drawable.health)
                                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.health))
                                .setNumber(10)
                                .setActions(action)
                                .setContentIntent(pendingIntent2)
                    }
                    notificationManager.notify(1234, builder.build())
                }
            }

            when {
                val1 >= 122.toString() -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        val name = getString(R.string.app_name)
                        val descriptionText = "BP is too high."
                        val channel = NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH)
                        channel.description = descriptionText
                        channel.enableLights(true)
                        channel.enableVibration(false)
                        notificationManager.createNotificationChannel(channel)

                        builder = Notification.Builder(root.context, CHANNEL_ID)
                                .setSmallIcon(R.drawable.health)
                                .setContentTitle("BP Notification")
                                .setContentText("BP is too high.")
                                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.health))
                                .setNumber(10)
                                .setActions(action)
                                .setContentIntent(pendingIntent)
                    } else {

                        builder = Notification.Builder(root.context)
                                .setSmallIcon(R.drawable.health)
                                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.health))
                                .setNumber(10)
                                .setActions(action)
                                .setContentIntent(pendingIntent)
                    }
                    notificationManager.notify(1235, builder.build())
                }

                else -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        val name = getString(R.string.app_name)
                        val descriptionText = "BP is normal."
                        val channel = NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH)
                        channel.description = descriptionText
                        channel.enableLights(true)
                        channel.enableVibration(false)
                        notificationManager.createNotificationChannel(channel)

                        builder = Notification.Builder(root.context, CHANNEL_ID)
                                .setSmallIcon(R.drawable.health)
                                .setContentTitle("BP Notification")
                                .setContentText("BP is normal.")
                                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.health))
                                .setNumber(10)
                    } else {

                        builder = Notification.Builder(root.context)
                                .setSmallIcon(R.drawable.health)
                                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.health))
                                .setNumber(10)
                    }
                    notificationManager.notify(1236, builder.build())
                }
            }
        }



        return root
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.app_name)
            val descriptionText = getString(R.string.title_notifications)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
                channel.description = descriptionText
            // Register the channel with the system
            val notificationManager: NotificationManager =
                requireActivity().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }
    }
}


private operator fun Any?.get(key: Int?, vararg bundles: Bundle?): Any? {
    for (bundle in bundles) {
        if (bundle != null && bundle.containsKey(key.toString())) {
            return bundle.get(key)
        }
    }
    return null
}


//fun getStringArrayList(key: String?, vararg bundles: Bundle?): ArrayList<String?>? { //from ww  w . j a  v a2 s .c  o  m
//    for (bundle in bundles) {
//        if (bundle != null && bundle.containsKey(key)) {
//            return bundle.getStringArrayList(key)
//        }
//    }
//    MTLog.d(TAG,
//            "Can't find the string array list value for key '%s' (returned null)",
//            key)
//    return null
//}
