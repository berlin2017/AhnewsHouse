package com.ahnews.ahnewshouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017/11/29 0029.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {

    private RelativeLayout search_layout;
    private TextView location_tv;
    private TextView map_tv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM); //Enable自定义的View
        View actionView = LayoutInflater.from(getContext()).inflate(R.layout.layout_action,null);
        actionBar.setCustomView(actionView);
        location_tv = actionView.findViewById(R.id.location_text);
        map_tv = actionView.findViewById(R.id.acitonbatr_righttext);
        search_layout = actionView.findViewById(R.id.acitonbar_search_layout);
        search_layout.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_home, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.acitonbar_search_layout:
                Intent intent = new Intent(getContext(),SearchActivity.class);
                getContext().startActivity(intent);
                break;
        }
    }
}
