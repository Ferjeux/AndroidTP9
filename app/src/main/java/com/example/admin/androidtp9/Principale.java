package com.example.admin.androidtp9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Principale extends Traceur {

    private TextView textView;
    Point point = new Point();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.notlose);
        textView.setText(String.valueOf(point.getCompteur()));

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
