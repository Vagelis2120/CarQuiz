package com.example.android.carquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.android.carquiz.R.string.lost;


public class HardMode extends AppCompatActivity {

    /*
     * Global variables
     */

    int numberOfCorrectAnswers = 0;
    int score = 0;
    String nameOfPerson;
    String resultQuestion1;
    String resultQuestion2;
    String resultQuestion3;
    String resultQuestion4;
    String resultQuestion5;
    RadioButton q1a1;
    RadioButton q1a2;
    RadioButton q1a3;
    EditText q2a;
    CheckBox q3a1;
    CheckBox q3a2;
    CheckBox q3a3;
    RadioButton q4a1;
    RadioButton q4a2;
    RadioButton q4a3;
    CheckBox q5a1;
    CheckBox q5a2;
    CheckBox q5a3;
    RadioGroup group1;
    RadioGroup group2;
    Button finishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hard_mode);

        /*
         * Get name from start page.
         */
        Intent normali = getIntent();
        nameOfPerson = normali.getExtras().getString("message");

        /*
         * FindViews
         */
        q1a1 = (RadioButton) findViewById(R.id.one);
        q1a2 = (RadioButton) findViewById(R.id.two);
        q1a3 = (RadioButton) findViewById(R.id.four);
        q2a = (EditText) findViewById(R.id.BrandEdtTxt);
        q3a1 = (CheckBox) findViewById(R.id.AudiCheckBox);
        q3a2 = (CheckBox) findViewById(R.id.FerrariCheckBox);
        q3a3 = (CheckBox) findViewById(R.id.PorscheCheckBox);
        q4a1 = (RadioButton) findViewById(R.id.Bugatti);
        q4a2 = (RadioButton) findViewById(R.id.Venom);
        q4a3 = (RadioButton) findViewById(R.id.Aero);
        q5a1 = (CheckBox) findViewById(R.id.Opel);
        q5a2 = (CheckBox) findViewById(R.id.Fiat);
        q5a3 = (CheckBox) findViewById(R.id.AlfaRomeo);
        group1 = (RadioGroup) findViewById(R.id.SeatsRadio);
        group2 = (RadioGroup) findViewById(R.id.VerticalRadio);
        finishBtn = (Button) findViewById(R.id.FinishBtn);
    }

    public void finished(View v) {
        /*
         * Local variables
         */
        int na = 0;
        String answer2 = getString(R.string.ferrari);
        /*
         * q2 EditText to string.
         */
        String question2a = q2a.getText().toString();
        /*
         * Check if radios for q1 and q4 are checked.
         */
        boolean question1answer1 = q1a1.isChecked();
        boolean question1answer2 = q1a2.isChecked();
        boolean question1answer3 = q1a3.isChecked();
        boolean question4answer1 = q4a1.isChecked();
        boolean question4answer2 = q4a2.isChecked();
        boolean question4answer3 = q4a3.isChecked();
        /*
         * Check if boxes for q3 and q5 are checked.
         */
        boolean question3answer1 = q3a1.isChecked();
        boolean question3answer2 = q3a2.isChecked();
        boolean question3answer3 = q3a3.isChecked();
        boolean question5answer1 = q5a1.isChecked();
        boolean question5answer2 = q5a2.isChecked();
        boolean question5answer3 = q5a3.isChecked();

        /*
         * Check the correct answer for q1.
         */
        if (question1answer2) {
            numberOfCorrectAnswers++;
            score++;
            resultQuestion1 = getString(R.string.correct);
        } else if (!question1answer1 && !question1answer2 && !question1answer3) {
            Toast.makeText(this, getString(R.string.q1na), Toast.LENGTH_SHORT).show();
            na = 1;
        } else {
            resultQuestion1 = getString(R.string.wrong);
            score = score - 1;
        }

        /*
         * Check the correct answer for q2.
         */
        if (question2a.equals(answer2)) {
            numberOfCorrectAnswers++;
            score++;
            resultQuestion2 = getString(R.string.correct);
        } else if (question2a.matches("")) {
            Toast.makeText(this, getString(R.string.q2na), Toast.LENGTH_SHORT).show();
            na = 1;
        } else {
            resultQuestion2 = getString(R.string.wrong);
            score = score - 1;
        }

        /*
         * Check the correct answers for q3.
         */
        if (question3answer1 && !question3answer2 && question3answer3) {
            numberOfCorrectAnswers++;
            score++;
            resultQuestion3 = getString(R.string.correct);
        } else if (!question3answer1 && !question3answer2 && !question3answer3) {
            Toast.makeText(this, getString(R.string.q3na), Toast.LENGTH_SHORT).show();
            na = 1;
        } else {
            resultQuestion3 = getString(R.string.wrong);
            score = score - 1;
        }

        /*
         * Check the correct answer for q4.
         */
        if (question4answer2) {
            numberOfCorrectAnswers++;
            score++;
            resultQuestion4 = getString(R.string.correct);
        } else if (!question4answer1 && !question4answer2 && !question4answer3) {
            Toast.makeText(this, getString(R.string.q4na), Toast.LENGTH_SHORT).show();
            na = 1;
        } else {
            resultQuestion4 = getString(R.string.wrong);
            score = score - 1;
        }

        /*
         * Check the correct answer for q5.
         */
        if (!question5answer1 && question5answer2 && question5answer3) {
            numberOfCorrectAnswers++;
            score++;
            resultQuestion5 = getString(R.string.correct);
        } else if (!question5answer1 && !question5answer2 && !question5answer3) {
            Toast.makeText(this, getString(R.string.q5na), Toast.LENGTH_SHORT).show();
            na = 1;
        } else {
            resultQuestion5 = getString(R.string.wrong);
            score = score - 1;
        }

        /*
         * If user didn't type a name
         */
        if (nameOfPerson.isEmpty()) {
            nameOfPerson = getString(R.string.user);
        }

        /*
         * Results
         */
        String lose = nameOfPerson + " " + getString(R.string.answered) + " " + numberOfCorrectAnswers + " " + getString(R.string.questions) + " " + getString(R.string.correctly) +
                "\n" + getString(R.string.score) + ": " + score +
                "\n" + getString(R.string.result) + ": " + getString(lost);

        String win = nameOfPerson + " " + getString(R.string.answered) + " " + numberOfCorrectAnswers + " " + getString(R.string.questions) + " " + getString(R.string.correctly) +
                "\n" + getString(R.string.score) + ": " + score +
                "\n" + getString(R.string.result) + ": " + getString(R.string.won);

        /*
         * Prevent results toast message if user has not answered a question
         */
        if (na == 1) {
            numberOfCorrectAnswers = 0;
            score = 0;
        /*
         *
         */
        } else if (numberOfCorrectAnswers <= 3) {
            Toast.makeText(this, lose, Toast.LENGTH_LONG).show();
            numberOfCorrectAnswers = 0;
            score = 0;
        } else {
            Toast.makeText(this, win, Toast.LENGTH_LONG).show();
            numberOfCorrectAnswers = 0;
            score = 0;
        }
    }
}
