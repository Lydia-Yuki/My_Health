package com.example.myhealth.ui.home

import android.os.Bundle
import android.text.Editable
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.myhealth.R
import com.example.myhealth.ui.dashboard.DashboardFragment
import com.example.myhealth.ui.options.BlankFragment
import com.example.myhealth.ui.options.FoodFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val button2: ImageButton = root.findViewById<ImageButton>(R.id.add_button)
        val popupBox: PopupWindow = PopupWindow(root.context)
        button2.setOnClickListener {
            val popupMenu: PopupMenu = PopupMenu(root.context, add_button)
            popupMenu.menuInflater.inflate(R.menu.nav_options, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.options_bp -> {
                        view?.findNavController()?.navigate(R.id.action_navigation_home_to_dashboardFragment)
                        true
                    }
                    R.id.options_medicine -> {
                        view?.findNavController()?.navigate(R.id.action_navigation_home_to_medicineFragment)
                        true
                    }
                    R.id.options_sugar -> {
                        view?.findNavController()?.navigate(R.id.action_navigation_home_to_sugarFragment)
                        true
                    }
                }
                true
            })
            popupMenu.show()
        }
        // Inflate the layout for this fragment
        return root
    }

}
