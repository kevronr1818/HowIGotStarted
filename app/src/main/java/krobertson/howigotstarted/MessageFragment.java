/*
Source: https://www.tutorialspoint.com/android/android_sending_email.htm

This class is responsible for sending an email message to the matched users
(This is the "Messages" tab as well). The matches shown in the "Matches" tab
will display the user's name and email and if they choose to, the student will
go to the "Messages" tab to send a message to each user's email that they are
matched with.
 */

package krobertson.howigotstarted;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.net.Uri;
import android.content.Intent;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MessageFragment extends Fragment{

    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_message, container, false);

        //Calls sendEmail() once "Compose Message" button is clicked
        Button startBtn = (Button) v.findViewById(R.id.sendEmail);
        startBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });

        return v;
    }

    protected void sendEmail(){
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Your Message");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            Log.i("Email sent...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity().getApplicationContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    } //end sendEmail()
}