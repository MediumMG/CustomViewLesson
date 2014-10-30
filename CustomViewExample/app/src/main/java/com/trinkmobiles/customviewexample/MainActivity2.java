package com.trinkmobiles.customviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by MediumMG on 30.10.2014.
 */
public class MainActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        ViewOnClick listener = new ViewOnClick();
        findViewById(R.id.view1).setOnClickListener(listener);
        findViewById(R.id.view2).setOnClickListener(listener);
    }

    private class ViewOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String text = ((ColorOptionsView) v).getTitle() + " " + ((ColorOptionsView) v).getValueColor();
            Toast.makeText(MainActivity2.this, text, Toast.LENGTH_SHORT).show();
        }
    }

}
