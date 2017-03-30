package krobertson.howigotstarted.questions;

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

public class QuestionSix extends AppCompatActivity {

    private RadioGroup radioQuestionSix;
    private RadioButton radioAnswerButton;
    private Button btnDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_six);

        addButtonListener();
       // nextButtonClicked();
        //startActivity(new Intent("krobertson.howigotstarted.questions.QuestionSix"));

    }

    public void addButtonListener() {

        radioQuestionSix = (RadioGroup) findViewById(R.id.radioQuestions);
        btnDisplay = (Button) findViewById(R.id.btn_next);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(QuestionSix.this, QuestionSeven.class);
                //intent.putExtra("username", user);
                startActivity(intent);
                finish();

            }

        });

    }




}
