package com.example.zhuzijian.mytest;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by zhuzijian on 15/7/9.
 */
public class ItemView extends LinearLayout {
    public ItemView(Context context) {
        super(context);
        init();
    }

    public void init() {
        setOrientation(HORIZONTAL);
        inflate(getContext(), R.layout.channel_item, this);
        TextView titleView = (TextView) findViewById(R.id.apollo_home_channel_item_title);
        titleView.setText("洗衣");

        TextView textView = (TextView) findViewById(R.id.apollo_home_channel_item_desc);
        textView.setText(Html.fromHtml("<font color=000000>" + "日常保洁 " + "</font>" + "<font color=#0000ff>" + "日常保洁 "
                + "</font>"  + "日常保洁 " +"<font color=000000>" + "日常保洁 " + "</font>"
                + "<font color=000000>" + "日常保洁 " + "</font>"));
        //textView.setText(Html.fromHtml("日常保洁 日常保洁 日常保洁"));
//        FlowLayout descView = (FlowLayout) findViewById(R.id.apollo_home_channel_item_desc);
//        descView.setPadding(dip2Px(5), 0);
//
//        for (int i = 0; i < 3; i++) {
//            TextView textView = new TextView(getContext());
//            textView.setTextSize(dip2Px(12));
//            textView.setTextColor(Color.parseColor("#999999"));
//            textView.setText("美甲");
//            descView.addView(textView);
//        }

    }

    private int dip2Px(float dip) {
        return (int) (dip * getContext().getResources().getDisplayMetrics().density + 0.5f);
    }

}
