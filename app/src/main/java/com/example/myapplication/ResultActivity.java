package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = (TextView) findViewById(R.id.textView1);
        Bundle argument = getIntent().getExtras();
        if (argument.get("result").toString().equals("0")){
            textView.setText(getResources().getString(R.string.game_result_1));
        }
        else{
            textView.setText(getResources().getString(R.string.game_result_2));
        }
    }
}
