package com.example.shasin.notificationbanner;

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

    TextView textView;
    RelativeLayout relativeLayout;
    View rootview;
    Button buttonSuccess,buttonInfo,buttonWarning,buttonError,buttonCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        rootview = findViewById(android.R.id.content);
        buttonSuccess = findViewById(R.id.buttonSuccess);
        buttonInfo = findViewById(R.id.buttonInfo);
        buttonWarning = findViewById(R.id.buttonWarning);
        buttonError = findViewById(R.id.buttonError);
        buttonCustom = findViewById(R.id.buttonCustom);
        initlistener();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    public void initlistener(){
        buttonSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner.make(rootview,getBaseContext(),Banner.SUCCESS,"This is a successful message",Banner.TOP).show();
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner.make(rootview,getBaseContext(),Banner.INFO,"This is a info message",Banner.BOTTOM).show();
            }
        });

        buttonWarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner.make(rootview,getBaseContext(),Banner.WARNING,"This is a warning message",Banner.TOP).show();
            }
        });

        buttonError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner.make(rootview,getBaseContext(),Banner.ERROR,"This is a error message",Banner.BOTTOM).show();
            }
        });

        buttonCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBanner();
            }
        });

    }

    //example to invoke notification banner
    private void callBanner(){
        Banner.make(rootview,getBaseContext(),"This is a error message",Banner.TOP,R.layout.banner);
        textView = Banner.getInstance().getBannerView().findViewById(R.id.status_text);
        relativeLayout = Banner.getInstance().getBannerView().findViewById(R.id.rlCancel);
        textView.setText("This is text for the banner");
        bannerClickListener();
        Banner.getInstance().setCustomAnimationStyle(R.style.NotificationAnimation);
        Banner.getInstance().show();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void bannerClickListener(){
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Banner has been clicked", Toast.LENGTH_LONG).show();
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG","Clicked");
                Banner.getInstance().dismissBanner();
            }
        });
    }

}
