package krobertson.howigotstarted.questions;

/**
 *
 *This class is responsible for handling the functionality of the first question.
 * The first question appears after the user chooses their major as seen in the
 * ChooseMajor.java class. Once the user selects an answer and clicks the
 * "Next" button, the user will be taken to the second question
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import krobertson.howigotstarted.R;

public class QuestionOne extends AppCompatActivity {

    private RadioGroup radioQuestionOne;
    private RadioButton radioAnswerButton;
    private Button btnDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_one);

        addButtonListener();
    }
    /*Once the "Next" button is clicked, this method is responsible for making sure the
    next question is displayed
     */
    public void addButtonListener() {

        radioQuestionOne = (RadioGroup) findViewById(R.id.radioQuestions);
        btnDisplay = (Button) findViewById(R.id.btn_next);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuestionOne.this, QuestionTwo.class);
                startActivity(intent);
                finish();

            }

        });
    }
}