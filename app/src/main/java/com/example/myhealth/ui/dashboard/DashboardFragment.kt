package com.example.myhealth.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.myhealth.R
import com.example.myhealth.ui.notifications.NotificationsFragment
import com.example.myhealth.ui.records.RecordsFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import java.lang.Integer.decode
import java.util.ArrayList

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val btn: Button = root.findViewById<Button>(R.id.cancel)
        val con: Button = root.findViewById<Button>(R.id.confirm)
        btn.setOnClickListener {
            view?.findNavController()?.navigate(R.id.navigation_home)
            true
        }

        con.setOnClickListener {
            val fig1 : EditText = root.findViewById(R.id.bp1)
            val value1 = fig1.text.toString()

            val fig2 : EditText = root.findViewById(R.id.bp2)
            val value2 = fig2.text.toString()

            //val arr : ArrayList<Int> = arrayListOf(value1,value2)

            val bundle = Bundle()
            bundle.putString("data",value1)
            bundle.putString("data2",value2)

            val records = RecordsFragment()
            records.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.nav_host_fragment, records)?.commit()

            val notif = NotificationsFragment()
            notif.arguments = bundle

            //view?.findNavController()?.navigate(R.id.navigation_records)
            //true

            //val num1 = value1.toInt()
//            val fig2 = bp2.text
//            val value2 = fig2.toString()
//            val num2 = value2.toInt()
//
//            //Toast.makeText(root.context,value1,Toast.LENGTH_SHORT).show()
//
//            val first: IntArray = intArrayOf(num1)
//            val second: IntArray = intArrayOf(num2)
//
//            var reading: Array<IntArray> = arrayOf(first, second)


        }

        return root
    }
}

