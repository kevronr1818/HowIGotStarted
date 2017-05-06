/*
Source: http://www.theappguruz.com/blog/android-take-photo-camera-gallery-code-sample. Step 3.

This class is responsible for handling what happens in the "Home" tab of the application. The
"Home" tab allows for the user to upload a profile picture as well as log out of the application
 */

package krobertson.howigotstarted;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class HomeFragment extends Fragment{

    private static final String TAG = "FragmentOne";
    private static int RESULT_LOAD_IMAGE = 1;

    private TextView greetingTextView;
    private Button btnLogOut;

    public HomeFragment() {
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
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        greetingTextView = (TextView) v.findViewById(R.id.greeting_text_view);
        btnLogOut = (Button) v.findViewById(R.id.logout_button);
        greetingTextView.setText("Welcome!");

        //Take user back to Login screen once the user clicks the "Sign Out" button
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        //Takes user to Camera gallery once the user clicks the "Upload Picture" button
        Button buttonLoadImage = (Button) v.findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE  && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageButton imageButton = (ImageButton)getView().findViewById(R.id.user_profile_photo);
            imageButton.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
    }
}