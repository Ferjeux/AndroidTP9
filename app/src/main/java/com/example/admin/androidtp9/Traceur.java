package com.example.admin.androidtp9;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public abstract class Traceur extends AppCompatActivity {
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        toast = Toast.makeText(this, "billy onCreate", Toast.LENGTH_LONG);
        notify("OnCreate");
    }
    @Override
    protected void onPause(){
        super.onPause();
        toast = Toast.makeText(this, "billy onPause", Toast.LENGTH_LONG);
        notify("onPause");
    }
    @Override
    protected void onResume(){
        super.onResume();
        toast = Toast.makeText(this, "billy onResume", Toast.LENGTH_LONG);
        notify("onResume");
    }
    @Override
    protected void onStop(){
        super.onStop();
        toast = Toast.makeText(this, "billy onStop", Toast.LENGTH_LONG);
        notify("onStop");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        toast = Toast.makeText(this, "billy onDestroy", Toast.LENGTH_LONG);
        notify("onDestroy");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        toast = Toast.makeText(this, "billy onRestore", Toast.LENGTH_LONG);
        notify("onRestoreInstanceState");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        toast = Toast.makeText(this, "billy onSave", Toast.LENGTH_LONG);
        notify("onSaveInstanceState");
    }

    private void notify(String methodName){
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification noti = new Notification.Builder(this)
                .setContentTitle(methodName + " " + strings[strings.length-1])
                .setAutoCancel(true).setSmallIcon(R.mipmap.ic_launcher).setContentText(name).build();
        NotificationManager notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int) System.currentTimeMillis(), noti);
    }
}
