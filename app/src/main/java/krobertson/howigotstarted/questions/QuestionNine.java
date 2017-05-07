/**
 *
 *This class is responsible for handling the functionality of the ninth question.
 * Once the user selects an answer and clicks the "Next" button, the user will be
 * taken to the tenth question
 */

package krobertson.howigotstarted.questions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import krobertson.howigotstarted.R;

public class QuestionNine extends AppCompatActivity {

    private RadioGroup radioQuestionNine;
    private RadioButton radioAnswerButton;
    private Button btnDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_nine);

        addButtonListener();
    }
    /*Once the "Next" button is clicked, this method is responsible for making sure the
    next question is displayed
     */
    public void addButtonListener() {

        radioQuestionNine = (RadioGroup) findViewById(R.id.radioQuestions);
        btnDisplay = (Button) findViewById(R.id.btn_next);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuestionNine.this, QuestionTen.class);
                //intent.putExtra("username", user);
                startActivity(intent);
                finish();

            }

        });

    }





}
