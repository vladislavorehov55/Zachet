package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Integer max_value = 100;
    Integer min_value = 1;
    Integer value_gen;
    Button btn1;Button btn2;Button btn3;Button btn4;Button btn5;Button btn6;Button btn7;Button btn8;
    Button btn9;Button btn10;Button btn11;Button btn12;Button btn13;Button btn14;Button btn15;Button btn16;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();
    Timer timer;
    TimerTask mTimerTask;
    Boolean flag_lv_1 = false;
    Boolean flag_lv_2 = false;
    Boolean flag_lv_3 = false;
    Boolean flag = false;
    Chronometer chronometer;
    MenuItem it1,it2,it3;
    Button restart;
    Dialog dialog;
    TextView text;
    Integer lvl_1 = 60000, lvl_2 = 30000, lvl_3 = 15000;
    MenuItem items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        mainListView.setAdapter(mArrayAdapter);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn10 = (Button)findViewById(R.id.btn10);
        btn11 = (Button)findViewById(R.id.btn11);
        btn12 = (Button)findViewById(R.id.btn12);
        btn13 = (Button)findViewById(R.id.btn13);
        btn14 = (Button)findViewById(R.id.btn14);
        btn15 = (Button)findViewById(R.id.btn15);
        btn16 = (Button)findViewById(R.id.btn16);
        restart = (Button)findViewById(R.id.restart);
        chronometer = (Chronometer) findViewById(R.id.chronometer);

        restart.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);

}
    @Override
    public void onClick(View v) {
        Button but = (Button)findViewById(v.getId());
        if(flag_lv_1 == true || flag_lv_2 == true || flag_lv_3 == true){
            if (but.getText().toString().equals("Начать заново") ){
                chronometer.stop();
                timer.cancel();
                mNameList.clear();
                mArrayAdapter.notifyDataSetChanged();
                switch (items.getItemId()){
                    case R.id.level_1:
                        RunGame(lvl_1);
                        break;
                    case R.id.level_2:
                        RunGame(lvl_2);
                        break;
                    case R.id.level_3:
                        RunGame(lvl_3);
                        break;
                }
            }
            else{
                int value = Integer.parseInt(but.getText().toString());
                mNameList.add(value);
                mArrayAdapter.notifyDataSetChanged();
            }
        }
        else if (flag_lv_1 == false &&  flag_lv_2 == false && flag_lv_3 == false){
            dialog = new Dialog(MainActivity.this);
            dialog.setTitle("Error");
            dialog.setContentView(R.layout.dialog_view);
            dialog.show();
        }
    }
    public void RunGame(int duration){
        value_gen = GenValue();
        btn1.setText(value_gen.toString());
        value_gen = GenValue();
        btn2.setText(value_gen.toString());
        value_gen = GenValue();
        btn3.setText(value_gen.toString());
        value_gen = GenValue();
        btn4.setText(value_gen.toString());
        value_gen = GenValue();
        btn5.setText(value_gen.toString());
        value_gen = GenValue();
        btn6.setText(value_gen.toString());
        value_gen = GenValue();
        btn7.setText(value_gen.toString());
        value_gen = GenValue();
        btn8.setText(value_gen.toString());
        value_gen = GenValue();
        btn9.setText(value_gen.toString());
        value_gen = GenValue();
        btn10.setText(value_gen.toString());
        value_gen = GenValue();
        btn11.setText(value_gen.toString());
        value_gen = GenValue();
        btn12.setText(value_gen.toString());
        value_gen = GenValue();
        btn13.setText(value_gen.toString());
        value_gen = GenValue();
        btn14.setText(value_gen.toString());
        value_gen = GenValue();
        btn15.setText(value_gen.toString());
        value_gen = GenValue();
        btn16.setText(value_gen.toString());
        long startTime = SystemClock.elapsedRealtime();
        chronometer.setBase(startTime);
        chronometer.start();
        timer = new Timer();
        mTimerTask = new MyTimerTask();
        timer.schedule(mTimerTask, duration);
    }
    public int GenValue(){
        Integer value_gen = min_value + (int) (Math.random() * (max_value - min_value + 1));
        return value_gen;
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        items = item;
        switch (item.getItemId()){
            case R.id.level_1:
                it1 = item;
                flag_lv_1 = true;
                if(flag_lv_2 == true){
                    timer.cancel();
                    chronometer.stop();
                    it2.setVisible(true);
                    flag_lv_2 = false;
                    RunGame(lvl_1);
                }
                else if(flag_lv_3 == true){
                    timer.cancel();
                    chronometer.stop();
                    it3.setVisible(true);
                    flag_lv_3 = false;
                    RunGame(lvl_1);
                }
                else if(flag_lv_2 == false && flag_lv_3 == false){
                    RunGame(lvl_1);
                }
                item.setVisible(false);
                break;

            case R.id.level_2:
                it2 = item;
                flag_lv_2 = true;
                if(flag_lv_1 == true){
                    timer.cancel();
                    chronometer.stop();
                    it1.setVisible(true);
                    flag_lv_1 = false;
                    RunGame(lvl_2);
                }
                else if(flag_lv_3 == true){
                    timer.cancel();
                    chronometer.stop();
                    it3.setVisible(true);
                    flag_lv_3 = false;
                    RunGame(lvl_2);
                }
                else if(flag_lv_1 == false && flag_lv_3 == false){
                    RunGame(lvl_2);
                }
                item.setVisible(false);
                break;

            case R.id.level_3:
                it3 = item;
                flag_lv_3 = true;
                if(flag_lv_1 == true){
                    timer.cancel();
                    chronometer.stop();
                    it1.setVisible(true);
                    flag_lv_1 = false;
                    RunGame(lvl_3);
                }
                else if(flag_lv_2 == true){
                    timer.cancel();
                    chronometer.stop();
                    it2.setVisible(true);
                    flag_lv_2 = false;
                    RunGame(lvl_3);
                }
                else if(flag_lv_1 == false && flag_lv_2 == false){
                    RunGame(lvl_3);
                }
                item.setVisible(false);
                break;
            case R.id.rules:
                if(flag_lv_1 == true ||  flag_lv_2 == true || flag_lv_3 == true){
                    break;
                }
                else if(flag_lv_1 == false &&  flag_lv_2 == false && flag_lv_3 == false){
                    Intent intent1 = new Intent(this, RulesActivity.class);
                    startActivity(intent1);
                    break;
                }
            case R.id.menu_exit:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            chronometer.stop();
            for (int i=0;i<mNameList.size()-1;i++){
                if (Integer.parseInt(mNameList.get(i+1).toString()) >= Integer.parseInt(mNameList.get(i).toString())){
                    flag= true;
                }
                else{
                    flag = false;
                }
            }
            if (mNameList.size() == 16 && flag == true){
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("result", "1");
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("result", "0");
                startActivity(intent);
            }
        }
    }
}

