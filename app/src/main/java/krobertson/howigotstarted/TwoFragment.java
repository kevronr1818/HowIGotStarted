package krobertson.howigotstarted;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class TwoFragment extends Fragment{

    public TwoFragment() {
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
        View v = inflater.inflate(R.layout.fragment_two, container, false);

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
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Enter message here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            Log.i("Email sent...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity().getApplicationContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    } //end sendEmail()

}