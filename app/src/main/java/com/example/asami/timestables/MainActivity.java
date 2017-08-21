package com.example.asami.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

       ListView myList ;

     public void generateTable(int number)
           {

               List <String> myList2 = new ArrayList<String>();

               for(int i = 1; i<=10;i++)
                  {

                     myList2.add(Integer.toString(number*i));

                  }

               ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList2);
                myList.setAdapter(myAdapter);



           }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar mySeek  = (SeekBar) findViewById(R.id.seekBar3);
        myList = (ListView) findViewById(R.id.timesList);



        mySeek.setMax(20);
        mySeek.setProgress(10); // at start i want it at 10

        mySeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 int min = 1;
                int tableTimes;


                if (progress<min) //  if its 0
                   {

                             tableTimes =1;

                            mySeek.setProgress(min); //user will not be able to drag it all the way to 0, this will force it to be 1
                   }else
                         {
                             tableTimes =progress;

                         }


                         generateTable(tableTimes);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


  generateTable(10); // so i can start with 10


    }
}
