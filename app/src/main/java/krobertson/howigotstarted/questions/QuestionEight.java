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

public class QuestionEight extends AppCompatActivity {

    private RadioGroup radioQuestionEight;
    private RadioButton radioAnswerButton;
    private Button btnDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_eight);

        addButtonListener();
        //startActivity(new Intent("krobertson.howigotstarted.questions.QuestionEight"));

    }

    public void addButtonListener() {

        radioQuestionEight = (RadioGroup) findViewById(R.id.radioQuestions);
        btnDisplay = (Button) findViewById(R.id.btn_next);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioQuestionEight.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioAnswerButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(QuestionEight.this,
                        radioAnswerButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });

    }

    public void nextButtonClicked(){
        Intent intent = new Intent(QuestionEight.this, QuestionNine.class);
        //intent.putExtra("username", user);
        startActivity(intent);
        finish();
    }



}
