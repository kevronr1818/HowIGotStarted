package krobertson.howigotstarted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import krobertson.howigotstarted.questions.QuestionOne;

//import static com.example.howigotstarted.R.id.spinner1;

public class ChooseMajor extends AppCompatActivity{

    private Spinner spinner1, spinner2;
    private Button btnSubmit, btnPrev, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_major);

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

    //get the selected dropdown list value

    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);

        btnNext = (Button) findViewById(R.id.btnNext);



        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ChooseMajor.this, QuestionOne.class);
                //intent.putExtra("username", user);
                startActivity(intent);
                finish();
            }

        });



    }


/*
    public void nextButtonClicked(){
        Intent intent = new Intent(ChooseMajor.this, QuestionOne.class);
        //intent.putExtra("username", user);
        startActivity(intent);
        finish();
    }

    */

}


