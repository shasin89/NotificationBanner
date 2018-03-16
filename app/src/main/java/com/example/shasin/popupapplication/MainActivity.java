package com.example.shasin.popupapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shasin.notificationbanner.Banner;

public class MainActivity extends AppCompatActivity {

    Banner banner;
    TextView textView;
    RelativeLayout relativeLayout;
    View rootview;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        rootview = findViewById(android.R.id.content);
        button = findViewById(R.id.button);
        setBanner();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void setBanner() {
        banner = new Banner(rootview,getBaseContext());
        banner.setLayout(R.layout.banner);
        textView = banner.getBannerView().findViewById(R.id.status_text);
        relativeLayout = banner.getBannerView().findViewById(R.id.rlCancel);
        textView.setText("This is text for the banner");
        banner.setFocusable(true);
        banner.setGravity(Banner.TOP);
        initlistener();
    }

    public void initlistener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBanner();
            }
        });

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

    //example to invoke notification banner
    private void callBanner(){
        banner.setPopupWindow();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
