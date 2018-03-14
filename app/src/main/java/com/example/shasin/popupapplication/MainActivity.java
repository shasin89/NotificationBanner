package com.example.shasin.popupapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.popupbanner.Banner;

public class MainActivity extends AppCompatActivity {

    Banner banner;
    TextView textView;
    RelativeLayout relativeLayout;
    View rootview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        rootview = findViewById(android.R.id.content);

        banner = new Banner(rootview,getBaseContext());

    }

    @Override
    protected void onResume() {
        super.onResume();
        setBanner();

    }

    public void setBanner() {
        banner.setLayout(R.layout.banner);
        textView = banner.getBannerView().findViewById(R.id.status_text);
        relativeLayout = banner.getBannerView().findViewById(R.id.rlCancel);
        textView.setText("This is text for the banner");
        banner.setFocusable(true);
        banner.setGravity(Banner.TOP);
        initlistener();
        banner.setPopupWindow();
    }

    public void initlistener(){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Toast", Toast.LENGTH_LONG).show();
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG","Clicked");
                banner.dismissBanner();
            }
        });

    }
}
