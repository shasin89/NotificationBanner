package com.example.shasin.notificationbanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shasin.notificationbanner.Banner;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RelativeLayout relativeLayout;
    View rootview;
    LinearLayout topBar;
    Button buttonSuccess,buttonInfo,buttonWarning,buttonError,buttonCustom;
    Button buttonSuccessBottom,buttonInfoBottom,buttonWarningBottom,buttonErrorBottom,buttonCustomBottom;
    Button buttonErrorAuto,buttonCustomAuto, buttonBelowView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootview = findViewById(android.R.id.content);
        topBar = findViewById(R.id.topbarview);
        buttonSuccess = findViewById(R.id.buttonSuccess);
        buttonInfo = findViewById(R.id.buttonInfo);
        buttonWarning = findViewById(R.id.buttonWarning);
        buttonError = findViewById(R.id.buttonError);
        buttonCustom = findViewById(R.id.buttonCustom);
        buttonSuccessBottom = findViewById(R.id.buttonSuccessBottom);
        buttonInfoBottom = findViewById(R.id.buttonInfoBottom);
        buttonWarningBottom = findViewById(R.id.buttonWarningBottom);
        buttonErrorBottom = findViewById(R.id.buttonErrorBottom);
        buttonCustomBottom = findViewById(R.id.buttonCustomBottom);
        buttonErrorAuto= findViewById(R.id.buttonErrorAuto);
        buttonCustomAuto = findViewById(R.id.buttonCustomAuto);
        buttonBelowView = findViewById(R.id.buttonBelowView);
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
                Banner.make(rootview,getBaseContext(),Banner.INFO,"This is an info message",Banner.TOP).show();
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
                Banner.make(rootview,getBaseContext(),Banner.ERROR,"This is an error message",Banner.TOP).show();
            }
        });

        buttonCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBannerTop();
            }
        });

        buttonSuccessBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner.make(rootview,getBaseContext(),Banner.SUCCESS,"This is a successful message",Banner.BOTTOM).show();
            }
        });

        buttonInfoBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner.make(rootview,getBaseContext(),Banner.INFO,"This is an info message",Banner.BOTTOM).show();
            }
        });

        buttonWarningBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner.make(rootview,getBaseContext(),Banner.WARNING,"This is a warning message",Banner.BOTTOM).show();
            }
        });

        buttonErrorBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner.make(rootview,getBaseContext(),Banner.ERROR,"This is an error message",Banner.BOTTOM).show();
            }
        });

        buttonCustomBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBannerBottom();
            }
        });

        buttonErrorAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner.make(rootview,getBaseContext(),Banner.ERROR,"This is an error message",Banner.BOTTOM,2000).show();
            }
        });

        buttonCustomAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBannerAuto();
            }
        });

        buttonBelowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Banner.make(topBar,getBaseContext(),Banner.TOP,R.layout.banner,true).show();
            }
        });

    }

    //example to invoke notification banner
    private void callBannerTop(){
        Banner.make(rootview,getBaseContext(),Banner.TOP,R.layout.banner);
        textView = Banner.getInstance().getBannerView().findViewById(R.id.status_text);
        relativeLayout = Banner.getInstance().getBannerView().findViewById(R.id.rlCancel);
        textView.setText("This is text for the banner");
        bannerClickListener();
        Banner.getInstance().setCustomAnimationStyle(R.style.NotificationAnimationTop);
        Banner.getInstance().setAsDropDown(true);
        Banner.getInstance().show();
    }

    //example to invoke notification banner
    private void callBannerBottom(){
        Banner.make(rootview,getBaseContext(),Banner.BOTTOM,R.layout.banner);
        textView = Banner.getInstance().getBannerView().findViewById(R.id.status_text);
        relativeLayout = Banner.getInstance().getBannerView().findViewById(R.id.rlCancel);
        textView.setText("This is text for the banner");
        bannerClickListener();
        Banner.getInstance().setCustomAnimationStyle(R.style.NotificationAnimationBottom);
        Banner.getInstance().show();
    }

    //example to invoke notification banner
    private void callBannerAuto(){
        Banner.make(rootview,getBaseContext(),Banner.TOP,R.layout.banner);
        textView = Banner.getInstance().getBannerView().findViewById(R.id.status_text);
        relativeLayout = Banner.getInstance().getBannerView().findViewById(R.id.rlCancel);
        textView.setText("This is text for the banner");
        bannerClickListener();
        Banner.getInstance().setDuration(2000);
        Banner.getInstance().setCustomAnimationStyle(R.style.NotificationAnimationTop);
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
                Banner.getInstance().dismissBanner();
            }
        });
    }

}
