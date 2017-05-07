/**
 *
 *This class is responsible for handling the functionality of the fourth question.
 * Once the user selects an answer and clicks the "Next" button, the user will be
 * taken to the fifth question
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

public class QuestionFour extends AppCompatActivity {

    private RadioGroup radioQuestionFour;
    private RadioButton radioAnswerButton;
    private Button btnDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_four);

        addButtonListener();

    }
    /*Once the "Next" button is clicked, this method is responsible for making sure the
    next question is displayed
     */
    public void addButtonListener() {

        radioQuestionFour = (RadioGroup) findViewById(R.id.radioQuestions);
        btnDisplay = (Button) findViewById(R.id.btn_next);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuestionFour.this, QuestionFive.class);
                startActivity(intent);
                finish();

            }

        });
    }
}
