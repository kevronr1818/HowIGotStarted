/*
Source: https://www.mkyong.com/android/android-spinner-drop-down-list-example/

This class is responsible for allowing the user to select a major.
This class requires the CustomOnItemSelectedListener class which
shows what the user selected after they made their selection
 */

package krobertson.howigotstarted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.List;

import krobertson.howigotstarted.questions.QuestionOne;


public class ChooseMajor extends AppCompatActivity{

    private Spinner spinner1;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_major);

        //populates the spinner with the following majors
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        List<String> list = new ArrayList<String>();
        list.add("Accounting");
        list.add("Anthropology");
        list.add("Business");
        list.add("Communications");
        list.add("Computer Science");
        list.add("Journalism");
        list.add("Liberal Arts");
        list.add("Marketing");
        list.add("Mathematics");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);

        // Spinner item selection Listener
        addListenerOnSpinnerItemSelection();

        // Button click Listener
        addListenerOnButton();
    }

    // Add spinner data
    public void addListenerOnSpinnerItemSelection(){
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    //Get the selected dropdown list value
    public void addListenerOnButton() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        btnNext = (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseMajor.this, QuestionOne.class);
                startActivity(intent);
                finish();
            }

        });
    }

}


