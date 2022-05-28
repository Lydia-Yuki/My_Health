package com.example.myhealth.ui.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myhealth.R

class SugarData : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_sugardata, container, false)

        //val argue = thi.arguments
        val resultdata = arguments?.getString("record")
        val datedata = arguments?.getString("date")
        val timedata = arguments?.getString("time")

        val textview1 : TextView = root.findViewById(R.id.day)
        textview1.text = datedata.toString()

        val textview2 : TextView = root.findViewById(R.id.time)
        textview2.text = timedata.toString()

        val textview3 : TextView = root.findViewById(R.id.res)
        textview3.text = resultdata.toString()
        //val layout = root.findViewById<TableLayout>(R.id.lay)

        //Create TableRow programmatically
        //val tableRow = TableRow(root.context)
        //tableRow.layoutParams = TableLayout.LayoutParams(
                //ViewGroup.LayoutParams.MATCH_PARENT,
               // ViewGroup.LayoutParams.MATCH_PARENT)

        //layout?.addView(tableRow)
        // Create TextView programmatically.
        //val textView = TextView(root.context)

        // setting height and width
        //textView.layoutParams= TableLayout.LayoutParams(
               // ViewGroup.LayoutParams.WRAP_CONTENT,
               // ViewGroup.LayoutParams.WRAP_CONTENT)

        // setting text
        //textView.setText(datedata)

        // setting text
        //textView.setText(timedata)

        // setting text
        //textView.setText(resultdata)
        //layout?.addView(textView)


        return root
    }
}