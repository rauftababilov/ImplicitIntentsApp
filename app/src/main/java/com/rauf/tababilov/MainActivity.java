package com.rauf.tababilov;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rauf.tababilov.R;

public class MainActivity extends AppCompatActivity {

    private static final Object HTTP = null ;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOpenWebpageButton(View view) {
       openWebPage("https://www.google.com");
    }

    public void onClickOpenMapButton(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        Uri addressUri = Uri.parse("geo:0,0")
                .buildUpon().appendQueryParameter("q", "мельникайте, 125").build();

        intent.setData(addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClickOpenPhoneButton(View view) {
        dialPhoneNumber("89654537857");
    }

    private void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}