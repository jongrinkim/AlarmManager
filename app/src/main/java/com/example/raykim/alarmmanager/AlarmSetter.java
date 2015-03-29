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
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raykim on 3/28/15.
 */
public class AlarmSetter extends Activity {

    ImageButton done;
    EditText hourText, minuteText;

    TextView hourView, minuteView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeset);

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

                Intent i = new Intent(AlarmSetter.this, GoodNightActivity.class);

                startActivity(i);
                finish();

                }
        });

    }

}