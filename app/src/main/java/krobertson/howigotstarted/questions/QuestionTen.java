/**
 *
 *This class is responsible for handling the functionality of the tenth question.
 * Once the user selects an answer and clicks the "Next" button, the user will be
 * taken to the "Home" tab, which is a fragment of UserActivity.java
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
import krobertson.howigotstarted.UserActivity;

public class QuestionTen extends AppCompatActivity {

    private RadioGroup radioQuestionTen;
    private RadioButton radioAnswerButton;
    private Button btnDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_ten);

        addButtonListener();
    }
    /*Once the "Next" button is clicked, this method is responsible for making sure the next
    screen is the UserActivity.java class
     */
    public void addButtonListener() {

        radioQuestionTen = (RadioGroup) findViewById(R.id.radioQuestions);
        btnDisplay = (Button) findViewById(R.id.btn_next);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuestionTen.this, UserActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }
}
