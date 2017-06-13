package com.example.admin.androidtp9;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class Principale extends Traceur {

    private static final String PREFS = "PROGRESS";

    SharedPreferences sharedPreferences;
    private TextView textView;
    Point point = new Point();
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.notlose);
        textView.setText(String.valueOf(point.getCompteur()));
        seekBar = (SeekBar) findViewById(R.id.Bar);
        chargerParametres();
    }

    private void chargerParametres(){
        sharedPreferences = getSharedPreferences("TP9", MODE_PRIVATE);
        if(sharedPreferences.contains(PREFS)){
            int progress = sharedPreferences.getInt(PREFS,0);
            seekBar.setProgress(progress);
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        sauvegderParametres();
    }

    private void sauvegderParametres(){
        sharedPreferences = getSharedPreferences("TP9", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(PREFS,seekBar.getProgress());
        edit.apply();

    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        point = savedInstanceState.getParcelable("value");
        textView.setText(String.valueOf(point.getCompteur()));

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("value", point);
    }

    public void plus(View view) {
        point.setCompteur(point.getCompteur()+1);
        textView.setText(String.valueOf(point.getCompteur()));
    }

    public void reset(View view) {
        point.setCompteur(0);
        textView.setText(String.valueOf(point.getCompteur()));
    }
}
