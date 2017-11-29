package com.ahnews.ahnewshouse;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/29 0029.
 */

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search_activity);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.little_white)));
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        View actionView = LayoutInflater.from(this).inflate(R.layout.layout_search_action,null);
        getSupportActionBar().setCustomView(actionView);
        textView = actionView.findViewById(R.id.acitonbatr_righttext);
        textView.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.acitonbatr_righttext:
                finish();
                break;
        }
    }
}
