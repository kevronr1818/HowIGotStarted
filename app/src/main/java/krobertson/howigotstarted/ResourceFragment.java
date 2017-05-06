package krobertson.howigotstarted;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class ResourceFragment extends Fragment{
    //private Button ResourceLinkOne;

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


        //setResourceLinks();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_four, container, false);
        Button resourceLinkOne = (Button) v.findViewById(R.id.btn_resourceLinkOne);
        Button resourceLinkTwo = (Button) v.findViewById(R.id.btn_resourceLinkTwo);
        Button resourceLinkThree = (Button) v.findViewById(R.id.btn_resourceLinkThree);
        Button resourceLinkFour = (Button) v.findViewById(R.id.btn_resourceLinkFour);

        resourceLinkOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendToLinkOne = new Intent();
                sendToLinkOne.setAction(Intent.ACTION_VIEW);
                sendToLinkOne.addCategory(Intent.CATEGORY_BROWSABLE);
                sendToLinkOne.setData(Uri.parse("http://www.yahoo.com"));
                startActivity(sendToLinkOne);
            }
        });
        resourceLinkTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendToLinkTwo = new Intent();
                sendToLinkTwo.setAction(Intent.ACTION_VIEW);
                sendToLinkTwo.addCategory(Intent.CATEGORY_BROWSABLE);
                sendToLinkTwo.setData(Uri.parse("http://www.bing.com"));
                startActivity(sendToLinkTwo);
            }
        });
        resourceLinkThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendToLinkThree = new Intent();
                sendToLinkThree.setAction(Intent.ACTION_VIEW);
                sendToLinkThree.addCategory(Intent.CATEGORY_BROWSABLE);
                sendToLinkThree.setData(Uri.parse("http://www.ask.com"));
                startActivity(sendToLinkThree);
            }
        });
        resourceLinkFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendToLinkFour = new Intent();
                sendToLinkFour.setAction(Intent.ACTION_VIEW);
                sendToLinkFour.addCategory(Intent.CATEGORY_BROWSABLE);
                sendToLinkFour.setData(Uri.parse("http://www.google.com"));
                startActivity(sendToLinkFour);
            }
        });
        return v;



    }



}
