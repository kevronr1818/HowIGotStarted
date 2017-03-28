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
        //startActivity(new Intent("krobertson.howigotstarted.questions.QuestionTen"));

    }

    public void addButtonListener() {

        radioQuestionTen = (RadioGroup) findViewById(R.id.radioQuestions);
        btnDisplay = (Button) findViewById(R.id.btn_next);

        btnDisplay.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioQuestionTen.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioAnswerButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(QuestionTen.this,
                        radioAnswerButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });

    }

    public void nextButtonClicked(){
        Intent intent = new Intent(QuestionTen.this, UserActivity.class);
        //intent.putExtra("username", user);
        startActivity(intent);
        finish();
    }



}
