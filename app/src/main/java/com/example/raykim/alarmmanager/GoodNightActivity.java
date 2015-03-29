package com.example.raykim.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class GoodNightActivity extends ActionBarActivity {

    private PendingIntent pendingIntent;
    int hour;
    int minute;

    TextView timeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_night);

        timeInfo = (TextView) findViewById(R.id.timeInfo);

        //INTENTS EXTRAS FROM AlarmSetter ACTIVITY
        hour = getIntent().getIntExtra("hour", 7);
        minute = getIntent().getIntExtra("minute", 30);

        //System.out.println("You have set your alarm to:" + hour + " : " + minute);

        timeInfo.setText("You have set your alarm to:" + hour + " : " + minute);

        findViewById(R.id.stopAlarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    public void cancel() {
        Answered ans = Answered.getInstance();
        if (ans.getAnswers()){
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            manager.cancel(pendingIntent);
            Toast.makeText(this, "Alarm Canceled", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(GoodNightActivity.this, CancelActivity.class);
            startActivity(i);
            finish();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_good_night, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
