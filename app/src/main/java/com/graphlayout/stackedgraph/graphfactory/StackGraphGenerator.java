package com.graphlayout.stackedgraph.graphfactory;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.graphlayout.stackedgraph.R;
import com.graphlayout.stackedgraph.StackGraphModel;

import java.util.ArrayList;

/**
 * Created by CIPL0310 on 6/27/2016.
 */

public class StackGraphGenerator extends View {
    Context context;
    double highest = 1;
    double highestDown = 1;
    LinearLayout linearUpLayout,linearDownLayout;
    ArrayList<Integer> xUpSeries;
    ArrayList<Integer> xDownSeries;

    public StackGraphGenerator(Context context) {
        super(context);
        this.context = context;
    }

    public View generateStackedGraph(StackGraphModel stackModel, ArrayList<Integer> xUpSeries, ArrayList<Integer> xDownSeries) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dynamicGraph = layoutInflater.inflate(R.layout.activity_stacked_linear_layout, null);
        linearUpLayout = (LinearLayout) dynamicGraph.findViewById(R.id.xUpLinearLayout);
        linearDownLayout=(LinearLayout)dynamicGraph.findViewById(R.id.xDownLinearLayout);
        this.xUpSeries = xUpSeries;
        this.xDownSeries = xDownSeries;
        generateGraph();
        return dynamicGraph;
    }

    private void generateGraph() {

        for (Integer highestXup : xUpSeries) {
            if (highestXup > highest) {
                highest = highestXup;
            }
        }

        for (Integer highestDownn : xUpSeries) {
            if (highestDownn > highestDown) {
                highestDown = highestDownn;
            }
        }


        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        llp.setMargins(0, 0, 10, 0);
        int xUpSize = xUpSeries.size();

        for (int i = 0; i < xUpSize; i++) {
            TextView xupTextView = new TextView(context);
            xupTextView.setLayoutParams(llp);
            xupTextView.setText(String.valueOf(xUpSeries.get(i)));
            xupTextView.setTextColor(Color.BLUE);
            xupTextView.setGravity(Gravity.BOTTOM);
            double currentHeight = (xUpSeries.get(i) / highest) * 200;
            xupTextView.setHeight((int) currentHeight);
            xupTextView.setWidth(30);
            xupTextView.setBackgroundColor(0xff66ff66);
            linearUpLayout.addView(xupTextView);
        }

            int xDownSize = xDownSeries.size();

            for (int j = 0; j < xDownSize; j++) {
                TextView xdownTextView = new TextView(context);
                xdownTextView.setLayoutParams(llp);
                xdownTextView.setText(String.valueOf(xDownSeries.get(j)));
                xdownTextView.setTextColor(Color.BLUE);
                xdownTextView.setGravity(Gravity.TOP);
                double downHeight = (xDownSeries.get(j) / highest) * 200;
                xdownTextView.setHeight((int) downHeight);
                xdownTextView.setWidth(30);
                xdownTextView.setBackgroundColor(0xff66ff66);
                linearDownLayout.addView(xdownTextView);
            }

    }
}
