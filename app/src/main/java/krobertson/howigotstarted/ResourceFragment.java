/*
Source: http://blog.blundellapps.co.uk/button-to-open-web-browser/

This class is responsible for providing additional resources to the student if
they find that their matches are not quite working out as anticipated.
(This is the "Resource" tab as well)
*/

package krobertson.howigotstarted;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ResourceFragment extends Fragment{

    public ResourceFragment() {
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
        View v = inflater.inflate(R.layout.fragment_resource, container, false);

        Button resourceLinkOne = (Button) v.findViewById(R.id.btn_resourceLinkOne);
        Button resourceLinkTwo = (Button) v.findViewById(R.id.btn_resourceLinkTwo);
        Button resourceLinkThree = (Button) v.findViewById(R.id.btn_resourceLinkThree);
        Button resourceLinkFour = (Button) v.findViewById(R.id.btn_resourceLinkFour);

        /*Once button is clicked, it will take the user to the webpage shown
        in "sendToLinkOne.setData()" method
         */
        resourceLinkOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendToLinkOne = new Intent();
                sendToLinkOne.setAction(Intent.ACTION_VIEW);
                sendToLinkOne.addCategory(Intent.CATEGORY_BROWSABLE);
                sendToLinkOne.setData(Uri.parse("http://www.thecareeradvicecentre.com"));
                startActivity(sendToLinkOne);
            }
        });
        resourceLinkTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendToLinkTwo = new Intent();
                sendToLinkTwo.setAction(Intent.ACTION_VIEW);
                sendToLinkTwo.addCategory(Intent.CATEGORY_BROWSABLE);
                sendToLinkTwo.setData(Uri.parse("https://www.prospects.ac.uk/careers-advice"));
                startActivity(sendToLinkTwo);
            }
        });
        resourceLinkThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendToLinkThree = new Intent();
                sendToLinkThree.setAction(Intent.ACTION_VIEW);
                sendToLinkThree.addCategory(Intent.CATEGORY_BROWSABLE);
                sendToLinkThree.setData(Uri.parse("https://medium.com/the-mission/career-advice-no-one-tells-you-8be1bcd330cb"));
                startActivity(sendToLinkThree);
            }
        });
        resourceLinkFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendToLinkFour = new Intent();
                sendToLinkFour.setAction(Intent.ACTION_VIEW);
                sendToLinkFour.addCategory(Intent.CATEGORY_BROWSABLE);
                sendToLinkFour.setData(Uri.parse("http://danschawbel.com/blog/my-10-best-pieces-of-career-advice-for-college-graduates"));
                startActivity(sendToLinkFour);
            }
        });
        return v;
    }
}
