package krobertson.howigotstarted.questions;

/**
 * Created by Kevron on 3/21/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
        //startActivity(new Intent("krobertson.howigotstarted.questions.QuestionOne"));

    }

    public void addButtonListener() {

        radioQuestionOne = (RadioGroup) findViewById(R.id.radioQuestions);
        btnDisplay = (Button) findViewById(R.id.btn_next);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioQuestionOne.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioAnswerButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(QuestionOne.this,
                        radioAnswerButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });

    }

    public void nextButtonClicked(){
        Intent intent = new Intent(QuestionOne.this, QuestionTwo.class);
        //intent.putExtra("username", user);
        startActivity(intent);
        finish();
    }

}
