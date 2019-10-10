package com.example.ungdungbaothuc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    static final String SHARED_PREFERENCES_NAME="620woaini";
    private ListView listViewbaothuc;
    private ArrayList<baothuc> arrayListBaoThuc;
    private baothucAdapter baothucAdapter;
    private TimePicker timePicker;
    private ImageView imageViewThem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intivity();
        initTimePicker();
        activity();
    }

    public void intivity(){

        imageViewThem = findViewById(R.id.imageViewthem);
        timePicker = findViewById(R.id.timePicker);
        listViewbaothuc = findViewById(R.id.listViewBaothuc);
        arrayListBaoThuc  = new ArrayList<>();

        arrayListBaoThuc.add(new baothuc("6:40","Dạy đi học.",0));
        arrayListBaoThuc.add(new baothuc("7:40","Dạy đi học k .",0));

//        baothucAdapter = new baothucAdapter(this,R.layout.dongbaothuc,arrayListBaoThuc);
//        listViewbaothuc.setAdapter(baothucAdapter);

    }

    public void getData()
    {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFERENCES_NAME,MODE_PRIVATE);
        int count=sharedPreferences.getInt("count",0);
        for(int i=0;i<count;i++)
        {
            baothuc keep_temp=new baothuc(sharedPreferences.getString("Gio"+i,""),sharedPreferences.getString("Ghi chu"+i,""),0);
            arrayListBaoThuc.add(keep_temp);
        }
    }

    public void  activity(){
        imageViewThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Add_Activity.class);
                startActivity(intent);
            }
        });

        listViewbaothuc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                clear();
                baothucAdapter.notifyDataSetChanged();
                return false;
            }
        });

    }
    public void initTimePicker(){
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, hourOfDay+":"+minute, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void clear(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    @Override
    protected void onStart() {
        Log.d("A","onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("A","onStop");
        arrayListBaoThuc.clear();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("A","onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.d("A","onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.d("A","onResume");
        getData();
        baothucAdapter= new baothucAdapter(MainActivity.this,R.layout.dongbaothuc,arrayListBaoThuc);
        listViewbaothuc.setAdapter(baothucAdapter);
        Collections.reverse(arrayListBaoThuc);               //dao nguoc list
        super.onResume();
    }
    @Override
    protected void onRestart() {
        Log.d("A","onRestart");
        super.onRestart();
    }
}
