package com.acadgild.weightlossmagic;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;

import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by DivyaVipin on 4/1/2017.
 */

public class BMIResult  extends AppCompatActivity{
    PieChart mChart;
    TextView result;
    Float bmiResult;
    String bmiConclusion;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_chart);
        mChart = (PieChart) findViewById(R.id.piechart);
        result=(TextView)findViewById(R.id.txtViewResult) ;
        Intent iin= getIntent();

        Bundle b = iin.getExtras();

        if(b!=null)
        {

            bmiResult =b.getFloat("value");
            bmiConclusion=b.getString("Conclusion");
           // result.setText(i);

        }
addData();

    }
    private void addData() {
        mChart.setDrawSliceText(false);
        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        yvalues.add(new Entry(16f,0));

        yvalues.add(new Entry(2.5f,1));
        yvalues.add(new Entry(6.5f,2));
        yvalues.add(new Entry(5f,3));
        yvalues.add(new Entry(330f,4));
        PieDataSet dataSet = new PieDataSet(yvalues, "BMI Result");
        ArrayList<Integer> colors=new ArrayList<Integer>();
        colors.add(Color.rgb(31,127,218));
        colors.add(Color.rgb(37,169,254));
        colors.add(Color.rgb(63,200,247));
        colors.add(Color.rgb(65,189,103));
        colors.add(Color.rgb(243,207,0));
        dataSet.setColors(colors);
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("Severly Underweight ");

        xVals.add("UnderWeight");
        xVals.add("Normal");
        xVals.add("OverWeight");
        xVals.add("Obese");
        //PieData data = new PieData(xVals, dataSet);
        PieData data = new PieData(xVals, dataSet);
        data.setDrawValues(false);
        if (bmiResult < 16) {
           // return "Severely underweight";
            mChart.setCenterText("BMI:" + bmiResult+"\n"+"Conclusion:"+bmiConclusion);

            mChart.setCenterTextSize(10f);
            mChart.setCenterTextColor(colors.get(0));
            mChart.invalidate();
        } else if ((bmiResult >16) &&(bmiResult < 18.5)) {
            mChart.setCenterText("BMI:" + bmiResult+"\n"+"Conclusion:"+bmiConclusion);

            mChart.setCenterTextColor(colors.get(1));
            mChart.setCenterTextColor(Color.CYAN);
            mChart.setCenterTextSize(10f);

            mChart.invalidate();
           // return "Underweight";
        } else if ((bmiResult >18.5)&&(bmiResult < 25)) {

            mChart.setCenterText("BMI:" + bmiResult+"\n"+"Conclusion:"+bmiConclusion);

            mChart.setCenterTextColor(colors.get(2));
            mChart.setCenterTextSize(10f);

            mChart.invalidate();
            //return "Normal";
        } else if ((bmiResult > 25)&&(bmiResult < 30) ){
            mChart.setCenterText("BMI:" + bmiResult+"\n"+"Conclusion:"+bmiConclusion);

            mChart.setCenterTextColor(colors.get(3));
            mChart.setCenterTextSize(10f);
            mChart.invalidate();
            //return "Overweight";
        } else {
            mChart.setCenterText("BMI:" + bmiResult+"\n"+"Conclusion:"+bmiConclusion);



            mChart.setCenterTextSize(10f);

            mChart.setCenterTextColor(colors.get(4));
            mChart.invalidate();
           // return "Obese";
        }



        mChart.setData(data);

        mChart.setDescription("BMI Calculator");
        mChart.setDrawHoleEnabled(true);
        mChart.setTransparentCircleRadius(25f);
        mChart.setHoleRadius(50f);

        data.setValueTextSize(20f);



    }

}
