package com.example.ungdungbaothuc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Add_Activity extends AppCompatActivity implements View.OnClickListener {

    static final String SHARED_PREFERENCES_NAME="620woaini";
    public static final String BUNDLE = "bundel";
    public static final String TITLE = "gio";
    public static final String DESCRIPTION = "ghi chu";
    private Button buttonAdd;
    private Button buttonCancel;
    private EditText editTextGio;
    private EditText editTextGhiChu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_);
        editTextGio = findViewById(R.id.editTextGio);
        editTextGhiChu = findViewById(R.id.editTextGhiChu);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonCancel = findViewById(R.id.buttonCancel);
        buttonAdd.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
        editTextGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chongio();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        String s = editTextGio.getText().toString();

            switch (v.getId()) {
                case R.id.buttonAdd: {
                    SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_NAME, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    int pos = sharedPreferences.getInt("count", 0);
                    editor.putString("Gio" + pos, editTextGio.getText().toString());
                    editor.putString("Ghi chu" + pos, editTextGhiChu.getText().toString());
                    editor.putInt("count", pos + 1);
                    editor.apply();
                    intent = new Intent(Add_Activity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                }
                case R.id.buttonCancel: {
                    intent = new Intent(Add_Activity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                }

        }
    }
    public void chongio(){
        final Calendar calendar = Calendar.getInstance();
        int gio = calendar.get(Calendar.HOUR_OF_DAY);
        int phut = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(0,0,0,hourOfDay,minute);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                editTextGio.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, gio, phut, true );
        timePickerDialog.show();
    }
}
