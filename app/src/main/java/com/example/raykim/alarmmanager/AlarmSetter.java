package com.example.raykim.alarmmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by raykim on 3/28/15.
 */
public class AlarmSetter extends Activity {

    private PendingIntent pendingIntent;

    ImageButton done;
    EditText hourText, minuteText;

    TextView hourView, minuteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeset);


        /* Retrieve a PendingIntent that will perform a broadcast */
        Intent alarmIntent = new Intent(AlarmSetter.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(AlarmSetter.this, 0, alarmIntent, 0);


        done = (ImageButton) findViewById(R.id.done);

        hourView = (TextView) findViewById(R.id.hourText);
        minuteView = (TextView) findViewById(R.id.minuteText);

        done.setOnClickListener(new View.OnClickListener()    {

            @Override
            public void onClick(View v){

                hourText = (EditText) findViewById(R.id.hourField);
                minuteText = (EditText) findViewById(R.id.minuteField);

                InputMethodManager imm = (InputMethodManager) getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(minuteText.getWindowToken(), 0);

                //model = (EditText) findViewById(R.id.modelField);

                String hourEntered = hourText.getText().toString();
                String minuteEntered = minuteText.getText().toString();


                AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                // interval of alarm ring
                int interval = 1000 * 60 * 60 * 24; // 24 hours in milliseconds
//                int interval = 8000 // every 8 seconds

                /* Set the alarm to start at HH:MM */
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());

                // Hardcode the time for test-purpose
//                calendar.set(Calendar.HOUR_OF_DAY, 7);
//                calendar.set(Calendar.MINUTE, 30);

                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hourEntered));
                calendar.set(Calendar.MINUTE, Integer.parseInt(minuteEntered));
                manager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), interval, pendingIntent);


                Intent i = new Intent(AlarmSetter.this, GoodNightActivity.class);

                i.putExtra("hour", "HH");
                i.putExtra("minute", "MM");

                startActivity(i);
                finish();

                }
        });

    }

}