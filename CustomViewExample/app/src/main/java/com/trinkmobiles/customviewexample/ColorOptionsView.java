package com.trinkmobiles.customviewexample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by MediumMG on 30.10.2014.
 */
public class ColorOptionsView extends LinearLayout {

    private View mValue;
    private TextView mTitle;

    public ColorOptionsView(Context context, AttributeSet attrs) {
        super(context, attrs);

        String titleText = "";
        int valueColor;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ColorOptionsView, 0, 0);
        try {
            titleText = a.getString(R.styleable.ColorOptionsView_titleText);
            valueColor = a.getColor(R.styleable.ColorOptionsView_valueColor, android.R.color.black);
        }
        finally {
            a.recycle();
        }

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_color_options, this, true);

        mTitle = (TextView) getChildAt(0);
        mTitle.setText(titleText);

        mValue = getChildAt(1);
        mValue.setBackgroundColor(valueColor);
    }

    public ColorOptionsView(Context context) {
        this(context, null);
    }

    public void setValueColor(int color) {
        mValue.setBackgroundColor(color);
    }

    public int getValueColor() {
        return ((ColorDrawable) mValue.getBackground()).getColor();
    }

    public void setColorVisible(boolean visible) {
        mValue.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    public String getTitle() {
        return mTitle.getText().toString();
    }

}