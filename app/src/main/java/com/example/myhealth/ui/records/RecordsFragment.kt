package com.example.myhealth.ui.records

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myhealth.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate


class RecordsFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_records, container, false)
        val bar = root.findViewById<BarChart>(R.id.chart1)
        val bar2 = root.findViewById<BarChart>(R.id.chart2)

        val argue = this.arguments
        val inputData = argue?.getString("data")
        val inputData2 = argue?.getString("data2")
        val sugarData = argue?.getString("record")
//        val textview : TextView = root.findViewById(R.id.text_view)
//        textview.text = inputData.toString()
        val record = inputData.toString()
        val result = sugarData.toString()

        val entries: ArrayList<BarEntry> = ArrayList()
        val values: ArrayList<BarEntry> = ArrayList()


        for (i in result) {
                val score = sugarData
                if (score != null) {
                    if (i != null) {
                        values.add(BarEntry(i.toFloat(), score.toFloat()))
                    }
                }
            }

        if (record != null) {
            for (i in record) {
                val score = inputData
                if (score != null) {
                    values.add(BarEntry(i.toFloat(),score.toFloat()))
                }
                val score2 = inputData2
                if (score2 != null) {
                    values.add(BarEntry(i.toFloat(),score2.toFloat()))
                }
            }
        }

        val barDataSet = BarDataSet(values, "BP")
        barDataSet.setColors(*ColorTemplate.COLORFUL_COLORS)

        val barDataSet2 = BarDataSet(entries, "Sugar")
        barDataSet2.setColors(*ColorTemplate.COLORFUL_COLORS)

        val data = BarData(barDataSet)
        bar.data = data

        val data2 = BarData(barDataSet2)
        bar2.data = data2


        //hide grid lines
        bar.axisLeft.setDrawGridLines(false)
        bar.xAxis.setDrawGridLines(false)
        bar.xAxis.setDrawAxisLine(false)

        bar2.axisLeft.setDrawGridLines(false)
        bar2.xAxis.setDrawGridLines(false)
        bar2.xAxis.setDrawAxisLine(false)

        //remove right y-axis
        bar.axisRight.isEnabled = false

        bar2.axisRight.isEnabled = false

        //remove legend
        bar.legend.isEnabled = false

        bar2.legend.isEnabled = false


        //remove description label
        bar.description.isEnabled = false

        bar2.description.isEnabled = false


        //add animation
        bar.animateY(3000)

        bar2.animateY(3000)


        //draw chart
        bar.invalidate()
        bar2.invalidate()
        // Inflate the layout for this fragment
        return root
    }
}