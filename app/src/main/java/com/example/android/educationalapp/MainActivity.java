package com.example.android.educationalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    float correctAnswerCount = 0;
    int incorrectAnswerCount = 0;
    String showCorrectAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void result(View view) {
        EditText q1EditText = (EditText) findViewById(R.id.answerQuestion1_);
        RadioButton q2RadioButton = (RadioButton) findViewById(R.id.answerQuestion2);
        CheckBox q3A_CheckBox = (CheckBox) findViewById(R.id.answerQuestion3A);
        CheckBox q3B_CheckBox = (CheckBox) findViewById(R.id.answerQuestion3B);
        CheckBox q3C_CheckBox = (CheckBox) findViewById(R.id.answerQuestion3C);
        CheckBox q3D_CheckBox = (CheckBox) findViewById(R.id.answerQuestion3D);
        RadioButton q4RadioButton = (RadioButton) findViewById(R.id.answerQuestion4);
        String getAnswer1 = q1EditText.getText().toString();
        boolean hasAnswer2 = q2RadioButton.isChecked();
        boolean hasAnswer3A = q3A_CheckBox.isChecked();
        boolean hasAnswer3B = q3B_CheckBox.isChecked();
        boolean hasAnswer3C = q3C_CheckBox.isChecked();
        boolean hasAnswer3D = q3D_CheckBox.isChecked();
        boolean hasAnswer4 = q4RadioButton.isChecked();

        // here check if two or more check box is checked

        String result = getResult(getAnswer1, hasAnswer2, hasAnswer3A, hasAnswer3B,hasAnswer3C, hasAnswer3D, hasAnswer4);
        displayResult(result);
        correctAnswerCount = 0;
        incorrectAnswerCount =0;
        showCorrectAnswer = "";
    }

    private String getResult(String getAnswer1, boolean hasAnswer2, boolean hasAnswer3A, boolean hasAnswer3B,boolean hasAnswer3C,boolean hasAnswer3D, boolean hasAnswer4) {
        if (getAnswer1.equalsIgnoreCase("Fossil fuels")) {
            correctAnswerCount += 1;
        } else {
            incorrectAnswerCount += 1;
            showCorrectAnswer += "\nAnswer Q1 is Fossil fuels";
        }

        if (hasAnswer2) correctAnswerCount += 1;
        else {
            incorrectAnswerCount += 1;
            showCorrectAnswer += "\nAnswer Q2 is B) 30 miles";
        }

        if (hasAnswer3A && hasAnswer3B && !hasAnswer3C && !hasAnswer3D) correctAnswerCount += 1;
        else {
            incorrectAnswerCount += 1;
            showCorrectAnswer += "\nAnswer Q3 is A) Graphite and B) Wooden Body";
        }

        if (hasAnswer4) correctAnswerCount += 1;
        else {
            incorrectAnswerCount += 1;
            showCorrectAnswer += "\nAnswer Q4 is A) Yes";
        }

        if (correctAnswerCount == 4) {
            return "Great!! \nYou Answer all Question Correct ";
        } else {
            double percentageResult = (correctAnswerCount / 4) * 100;
            String messege = "Score is " + percentageResult + "%";
            messege += "\nYou have " + incorrectAnswerCount + " Question incorrected";
            messege += "\nCorrect Answer:";
            messege += showCorrectAnswer;
            return messege;
        }

    }

    private void displayResult(String result) {
        Toast.makeText(this,result, Toast.LENGTH_LONG).show();
    }

}
