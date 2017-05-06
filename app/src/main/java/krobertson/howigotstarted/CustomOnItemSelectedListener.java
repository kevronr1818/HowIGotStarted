package krobertson.howigotstarted;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

/**
 * Created by Kevron on 1/15/2017.
 *
 *
 Source: https://www.mkyong.com/android/android-spinner-drop-down-list-example/

 This class is responsible for showing which major the user selected which is implemented
 in ChooseMajor.java
 */


public class CustomOnItemSelectedListener implements OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,
                               long id) {
        /*Toast is a tiny pop up box that generally appears at the bottom of the screen
        that typically provides feedback on what a user selects from a list of radio
        buttons or in this example, a spinner
         */
        Toast.makeText(parent.getContext(),
                "Major Selected: \n" + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_LONG).show();
    }
    /*Method is needed since it implements OnItemSelectedListener (default java class)
    and this method is in that class. Since it is not needed in this application, it
    will be an empty method
     */
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }


}
