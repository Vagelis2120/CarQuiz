package com.example.android.carquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.android.carquiz.R.id.RadioA;
import static com.example.android.carquiz.R.id.RadioB;
import static com.example.android.carquiz.R.id.RadioC;

public class MainActivity extends AppCompatActivity {

    RadioButton radioButtonA, radioButtonB, radioButtonC;
    EditText username;
    String nameOfPerson;
    Button startBtn;
    RadioGroup RadioGrp;
    int checkedRadio;

    private CheckBox checkBoxA, checkBoxB, checkBoxC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        RadioGrp = (RadioGroup) findViewById(R.id.RadioGrp);
        radioButtonA = (RadioButton) findViewById(RadioA);
        radioButtonB = (RadioButton) findViewById(R.id.RadioB);
        radioButtonC = (RadioButton) findViewById(R.id.RadioC);
        username = (EditText) findViewById(R.id.name);
        startBtn = (Button) findViewById(R.id.StartQuizBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCheckedRadio();
                getNameOfPerson();
                if (checkedRadio == RadioA) {
                    Intent easy = new Intent(MainActivity.this, EasyMode.class);
                    easy.putExtra("message", nameOfPerson);
                    startActivity(easy);
                } else if (checkedRadio == RadioB) {
                    Intent normal = new Intent(MainActivity.this, NormalMode.class);
                    normal.putExtra("message", nameOfPerson);
                    startActivity(normal);
                } else if (checkedRadio == RadioC) {
                    Intent hard = new Intent(MainActivity.this, HardMode.class);
                    hard.putExtra("message", nameOfPerson);
                    startActivity(hard);
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.selectcar), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public String getNameOfPerson() {
        nameOfPerson = username.getText().toString();
        return nameOfPerson;
    }

    public int getCheckedRadio() {
        checkedRadio = RadioGrp.getCheckedRadioButtonId();
        return checkedRadio;
    }
}


