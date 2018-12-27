package com.feed.owner.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timeTableListView;

    public void generateTimesTable(int timesTable){
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int i = 1; i <= 10; i++){

            timesTableContent.add(Integer.toString(i * timesTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);

        timeTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timeTableSeekBar = (SeekBar) findViewById(R.id.timeTableSeekBar);
        timeTableListView = (ListView) findViewById(R.id.timeTableListView);

        timeTableSeekBar.setMax(20);
        timeTableSeekBar.setProgress(10);

        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTable;

                if (progress < min){
                    timesTable = min;
                    timeTableSeekBar.setProgress(timesTable);
                }else {
                    timesTable = progress;
                }

                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generateTimesTable(10);
        generateTimesTable(10);
    }
}
