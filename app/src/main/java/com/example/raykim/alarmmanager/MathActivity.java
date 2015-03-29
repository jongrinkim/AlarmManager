package com.example.raykim.alarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class MathActivity extends Activity {

    PendingIntent pendingIntent;

    EditText answer1;
    //EditText answer2;
    String answer1Entered;
    //String answer2Entered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);

        findViewById(R.id.checkAnswer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });

    }

    public void check() {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        //add user answers
        answer1 = (EditText) findViewById(R.id.answer1);
        //answer2 = (EditText) findViewById(R.id.answer2);
        answer1Entered = answer1.getText().toString();
        //answer2Entered = answer2.getText().toString();

        /* Retrieve a PendingIntent that will perform a broadcast */
        Intent alarmIntent = new Intent(MathActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MathActivity.this, 0, alarmIntent, 0);

        int interval = 0; // in milliseconds

        // first example question is 20 + 10
        if (answer1Entered.equals("30")){
            // stop the alarm
            manager.cancel(pendingIntent);
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show();
            // switch activity
            Intent i = new Intent(MathActivity.this, AlarmSetter.class);
            startActivity(i);
            finish();
        } else {
            manager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent);
          //manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        }
//        Answered ans = Answered.getInstance();
//        ans.setAnswers(true);

    }

}
