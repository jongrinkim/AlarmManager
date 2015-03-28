package com.example.raykim.alarmmanager;

import android.app.Activity;
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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raykim on 3/28/15.
 */
public class AlarmSetter extends Activity {

    ImageButton done;
    EditText hour, minute;

    TextView hourView, minuteView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeset);

        done = (ImageButton) findViewById(R.id.done);

        hourView = (TextView) findViewById(R.id.hour);
        minuteView = (TextView) findViewById(R.id.minute);

    done.setOnClickListener(new View.OnClickListener()    {

        @Override
        public void onClick(View v){

            hour = (EditText) findViewById(R.id.hourField);
            minute = (EditText) findViewById(R.id.minuteField);

            InputMethodManager imm = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(minute.getWindowToken(), 0);

            //model = (EditText) findViewById(R.id.modelField);

            String hourEntered = hour.getText().toString();
            String minuteEntered = minute.getText().toString();

//            Intent i = new Intent(AlarmSetter.this, MainActivity.class);

//            startActivity(i);
            finish();

            }
        });
    }
}