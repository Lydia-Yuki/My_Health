package com.example.myhealth.ui.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.myhealth.R
import com.example.myhealth.ui.notifications.NotificationsViewModel

class FoodFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_food, container, false)
        val btn: Button = root.findViewById<Button>(R.id.back)
        btn.setOnClickListener {
            view?.findNavController()?.navigate(R.id.navigation_home)
            true
        }
        return root
    }
}