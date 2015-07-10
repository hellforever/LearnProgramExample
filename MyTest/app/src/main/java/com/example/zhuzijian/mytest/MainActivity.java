package com.example.zhuzijian.mytest;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout layout = (GridLayout) findViewById(R.id.grid_layout);

        for (int i = 0; i < 6; i++) {
            LinearLayout view = new LinearLayout(this);
            view.setGravity(Gravity.CENTER_HORIZONTAL);
            view.setOrientation(LinearLayout.VERTICAL);
            view.inflate(this, R.layout.layout_frame, view);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = dip2Px(113);
            params.height = dip2Px(105);
            if (i % 3 == 1) {
                int padding = getResources().getDimensionPixelSize(R.dimen.home_service_padding);
                params.setMargins(padding, 0, padding, 0);
            }
            view.setLayoutParams(params);
            //view.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
            TextView textView = (TextView) view.findViewById(R.id.text1);
            textView.setText("日常保洁");
            View imageView = view.findViewById(R.id.icon);
            if (i == 0 || i == 4) {
                TextView textViewTag = (TextView) view.findViewById(R.id.text2);
                textViewTag.setVisibility(View.VISIBLE);
                textViewTag.setText("19.9起");
                textViewTag.setBackgroundDrawable(getDrawable(8, Color.BLUE));
                textViewTag.setTextColor(Color.BLUE);
            }
            if (i == 2 || i == 3) {
                TextView textViewTag = (TextView) view.findViewById(R.id.text3);
                textViewTag.setVisibility(View.VISIBLE);
                textViewTag.setText("休息中");
                textViewTag.setBackgroundDrawable(getDrawable(8, Color.BLUE));
                textViewTag.setTextColor(Color.BLUE);
            }
            layout.addView(view, params);
        }

        LinearLayout channelLayout = (LinearLayout) findViewById(R.id.channel);
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(2);
        int size = getWindowManager().getDefaultDisplay().getWidth() / 2;
        for (int i = 0; i < 8; i++) {
            ItemView itemView = new ItemView(this);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = size;
            params.height = dip2Px(90);
            itemView.setBackgroundDrawable(getResources().getDrawable(R.drawable.border));
            gridLayout.addView(itemView, params);
        }
        channelLayout.addView(gridLayout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private int dip2Px(float dip) {
        return (int) (dip * getApplicationContext().getResources().getDisplayMetrics().density + 0.5f);
    }

    private Drawable getDrawable(int dipRadius, int badgeColor) {
        int strokeWidth = 3; // 3px not dp
        int roundRadius = dip2Px(dipRadius); // 8px not dp
        int strokeColor = badgeColor;
        int fillColor = Color.parseColor("#FFFFFF");

        GradientDrawable gd = new GradientDrawable();
        gd.setColor(fillColor);
        gd.setCornerRadius(roundRadius);
        gd.setStroke(strokeWidth, strokeColor);
        return gd;
    }
}
