package com.graphlayout.stackedgraph.graphfactory;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.graphlayout.stackedgraph.R;
import com.graphlayout.stackedgraph.model.StackGraphModel;

import java.util.ArrayList;

/**
 * Created by KEERTHINI on 6/27/2016.
 */

public class StackGraphGenerator extends View {
    Context context;
    double highest = 1;
    double highestDown = 1;
    LinearLayout linearUpLayout, linearDownLayout;
    ArrayList<Integer> xUpSeries;
    ArrayList<Integer> xDownSeries;
    StackGraphModel stackModel;

    public StackGraphGenerator(Context context) {
        super(context);
        this.context = context;

    }

    public View generateStackedGraph(StackGraphModel stackModel, ArrayList<Integer> xUpSeries, ArrayList<Integer> xDownSeries) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dynamicGraph = layoutInflater.inflate(R.layout.activity_stacked_linear_layout, null);

        linearUpLayout = (LinearLayout) dynamicGraph.findViewById(R.id.xUpLinearLayout);
        linearUpLayout.setBackgroundColor(stackModel.getxUpBackgrdColor());
        linearDownLayout = (LinearLayout) dynamicGraph.findViewById(R.id.xDownLinearLayout);
        linearDownLayout.setBackgroundColor(stackModel.getxDownBackgrdColor());

        this.xUpSeries = xUpSeries;
        this.xDownSeries = xDownSeries;
        this.stackModel=stackModel;

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
            final TextView xupTextView = new TextView(context);
            xupTextView.setLayoutParams(llp);
            xupTextView.setTag(i+"x");
            xupTextView.setId(i);
            xupTextView.setText(String.valueOf(xUpSeries.get(i)));
            xupTextView.setTextColor(stackModel.getxUpBarcolor());
            xupTextView.setGravity(Gravity.BOTTOM);
            double currentHeight = (xUpSeries.get(i) / highest) * 400;
            xupTextView.setHeight((int) currentHeight);
            xupTextView.setWidth(stackModel.getBarWidth());
            xupTextView.setBackgroundColor(stackModel.getxUpBarcolor());
            linearUpLayout.addView(xupTextView);
        }

        int xDownSize = xDownSeries.size();

        for (int j = 0; j < xDownSize; j++) {
            TextView xdownTextView = new TextView(context);
            xdownTextView.setLayoutParams(llp);
            xdownTextView.setTag(j+"y");
            xdownTextView.setId(j+1000);
            xdownTextView.setText(String.valueOf(xDownSeries.get(j)));
            xdownTextView.setTextColor(stackModel.getxDownBarColor());
            xdownTextView.setGravity(Gravity.TOP);
            double downHeight = (xDownSeries.get(j) / highest) * 400;
            xdownTextView.setHeight((int) downHeight);
            xdownTextView.setWidth(stackModel.getBarWidth());
            xdownTextView.setBackgroundColor(stackModel.getxDownBarColor());
            linearDownLayout.addView(xdownTextView);
        }

    }
}
