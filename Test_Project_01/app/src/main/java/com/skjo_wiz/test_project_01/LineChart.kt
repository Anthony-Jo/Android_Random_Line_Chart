package com.skjo_wiz.test_project_01

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet

class LineChart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart)

        val lineChart: LineChart = findViewById(R.id.line_chart)

        val dots: ArrayList<Entry> = ArrayList()

        setValues(dots, 20)

        val setup: LineDataSet = LineDataSet(dots, "DataSet")
        val dataSets: ArrayList<ILineDataSet> = ArrayList()
        dataSets.add(setup)

        val data: LineData = LineData(dataSets)

        /*  Description Text Setup  */
        lineChart.description.isEnabled = true
        val desText : Description = lineChart.description
        desText.isEnabled = true
        desText.text = "Random Data"
        desText.textSize = 15F
        desText.textColor = Color.WHITE

        setup.color = Color.WHITE           /*  Setting the color of traces on the graph   */
        setup.setCircleColor(Color.GRAY)    /*  Setting the color of points on the graph    */

        lineChart.setTouchEnabled(false)    /*  Disable chart touch */
        lineChart.isDragEnabled = false
        lineChart.setScaleEnabled(false)
        /*  Setup X axis    */
        lineChart.xAxis.setDrawGridLines(true)
        lineChart.xAxis.setDrawAxisLine(false)
        lineChart.xAxis.isEnabled = true
        lineChart.xAxis.setDrawGridLines(false)
        /*  Setup Y axis    */
        val leftAxis : YAxis = lineChart.axisLeft
        leftAxis.isEnabled = true
        leftAxis.textColor = Color.WHITE
        leftAxis.setDrawGridLines(true)
        leftAxis.gridColor = Color.WHITE

        val rightAxis : YAxis = lineChart.axisRight
        rightAxis.isEnabled = false
        /*  Apply data to chart    */
        lineChart.data = data
    }

    private fun setValues(dots: ArrayList<Entry>, numOfDots: Int) {
        for (i in 0..numOfDots) {
            val value: Float = (Math.random() * 10).toFloat()
            dots.add(Entry(i.toFloat(), value))
        }
    }
}