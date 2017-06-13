package com.example.admin.androidtp9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public abstract class Traceur extends AppCompatActivity {
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        toast = Toast.makeText(this, "billy onCreate", Toast.LENGTH_LONG);
        toast.show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        toast = Toast.makeText(this, "billy onPause", Toast.LENGTH_LONG);
        toast.show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        toast = Toast.makeText(this, "billy onResume", Toast.LENGTH_LONG);
        toast.show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        toast = Toast.makeText(this, "billy onStop", Toast.LENGTH_LONG);
        toast.show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        toast = Toast.makeText(this, "billy onDestroy", Toast.LENGTH_LONG);
        toast.show();
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        toast = Toast.makeText(this, "billy onRestore", Toast.LENGTH_LONG);
        toast.show();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        toast = Toast.makeText(this, "billy onSave", Toast.LENGTH_LONG);
        toast.show();
    }
}
