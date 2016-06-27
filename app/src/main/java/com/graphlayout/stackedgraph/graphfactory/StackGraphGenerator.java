package com.graphlayout.stackedgraph.graphfactory;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.graphlayout.stackedgraph.R;
import com.graphlayout.stackedgraph.StackGraphModel;

import java.util.ArrayList;

/**
 * Created by CIPL0310 on 6/27/2016.
 */

public class StackGraphGenerator extends View {
    Context context;

    public StackGraphGenerator(Context context) {
        super(context);
        this.context = context;
    }

    public void generateStackedGraph(StackGraphModel stackModel, ArrayList xUpSeries, ArrayList xDownSeries) {
        RelativeLayout mainBaseLayout;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mainBaseLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        View dynamicGraph = layoutInflater.inflate(R.layout.activity_stacked_graph, null);
        mainBaseLayout.addView(dynamicGraph);
    }
}
