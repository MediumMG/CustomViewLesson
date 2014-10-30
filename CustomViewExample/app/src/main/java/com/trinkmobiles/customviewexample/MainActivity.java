package com.trinkmobiles.customviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private PieChart mPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPieChart = (PieChart) this.findViewById(R.id.Pie);
        mPieChart.addItem("Agamemnon", 2, getResources().getColor(R.color.seafoam));
        mPieChart.addItem("Bocephus", 3.5f, getResources().getColor(R.color.chartreuse));
        mPieChart.addItem("Calliope", 2.5f, getResources().getColor(R.color.emerald));
        mPieChart.addItem("Daedalus", 3, getResources().getColor(R.color.bluegrass));
        mPieChart.addItem("Euripides", 1, getResources().getColor(R.color.turquoise));
        mPieChart.addItem("Ganymede", 3, getResources().getColor(R.color.slate));

        (findViewById(R.id.Reset)).setOnClickListener(new NextOnClick());
    }

    private class NextOnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int current = mPieChart.getCurrentItem();
            if (current == mPieChart.getItemCount() -1 )
                mPieChart.setCurrentItem(0);
            else
                mPieChart.setCurrentItem(current + 1);
        }
    }

}
