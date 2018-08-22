package com.shasin.notificationbanner;

import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.logging.Handler;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Shasin on 14/03/2018.
 */

public class Banner {

    private Context mContext;
    private View popupView;
    private View rootView;
    private  boolean focusable;
    private  boolean asDropDown;
    private  boolean fillScreen;
    private PopupWindow popupWindow;

    public static int TOP = Gravity.TOP;
    public static int BOTTOM = Gravity.BOTTOM;

    public static int SUCCESS = 1;
    public static int INFO = 2;
    public static int WARNING = 3;
    public static int ERROR = 4;
    public static int CUSTOM = 5;

    private boolean showBanner = false;
    private int gravity = TOP;
    private int delay = 1500;
    private int duration = 0;
    private int bannerType;

    private TextView textMessage;
    private RelativeLayout rlCancel;

    private Integer animationStyle;

    private int layout;

    private String TAG = getClass().getName();

    private static Banner instance;

    public interface BannerListener {
        void onViewClickListener(View view);
    }

    //Constructors
    public Banner(){

    }

    public  Banner(View view, final Context context) {
        // create the popup window
        this.mContext = context;
        this.rootView = view;
    }

    public static Banner make(View view,Context context, int bannerType, String message, int position) {

        if(instance == null){
            instance = new Banner();
        }else {
            if(instance.showBanner){
                instance.dismissBanner();
            }
        }
            instance.rootView = view;
            instance.mContext = context;
            instance.setBannerLayout(bannerType);
            instance.setLayout(instance.layout);
            instance.setBannerText(message);
            instance.setDuration(0);
            instance.setGravity(position);
            instance.setCancelButton();
            instance.setAnimationstyle();
            instance.fillScreen = false;
            instance.asDropDown = false;

        return instance;
    }

    /**
     * This constructor is used for autodismiss
     *
     */
    public static Banner make(View view,Context context, int bannerType, String message, int position, int duration) {
        if(instance == null){
            instance = new Banner();
        }else {
            if(instance.showBanner){
                instance.dismissBanner();
            }
        }
        instance.rootView = view;
        instance.mContext = context;
        instance.setBannerLayout(bannerType);
        instance.setLayout(instance.layout);
        instance.setBannerText(message);
        instance.setDuration(duration);
        instance.setGravity(position);
        instance.setCancelButton();
        instance.setAnimationstyle();
        instance.fillScreen = false;
        instance.asDropDown = false;
        return instance;
    }

    /**
     * this constructor is used for customlayout
     *
     */
    public static Banner make(View view,Context context, int position, int Customlayout) {

        if(instance == null){
            instance = new Banner();
        }else {
            if(instance.showBanner){
                instance.dismissBanner();
            }
        }
        instance.rootView = view;
        instance.mContext = context;
        instance.setLayout(Customlayout);
        instance.setDuration(0);
        instance.setGravity(position);
        instance.fillScreen = false;
        instance.asDropDown = false;

        return instance;
    }

    /**
     * this constructor is used for customlayout and show notification as dropdown of a view
     *
     */
    public static Banner make(View view,Context context, int position, int Customlayout,boolean asDropDown) {

        if(instance == null){
            instance = new Banner();
        }else {
            if(instance.showBanner){
                instance.dismissBanner();
            }
        }
        instance.rootView = view;
        instance.mContext = context;
        instance.setLayout(Customlayout);
        instance.setDuration(0);
        instance.setGravity(position);
        instance.asDropDown = asDropDown;
        instance.fillScreen = false;

        return instance;
    }

    public static Banner make(View view,Context context, int Customlayout,boolean fillScreen) {

        if(instance == null){
            instance = new Banner();
        }else {
            if(instance.showBanner){
                instance.dismissBanner();
            }
        }
        instance.rootView = view;
        instance.mContext = context;
        instance.setLayout(Customlayout);
        instance.setDuration(0);
        instance.fillScreen = fillScreen;
        instance.asDropDown = false;

        return instance;
    }




    public static Banner getInstance(){
        if(instance == null){
            instance = new Banner();
        }
        return instance;
    }

    public int getDelay() {
        return delay;
    }

    /**
     * Set this delay for showing notification banner
     * By defauly delay is 1500
     * @param delay
     *
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * Set this to auto dismiss  notification banner
     * By defauly duration is 0
     * @param duration
     *
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    /**
     * Set the location of the banner to TOP,CENTER,BOTTOM
     * By defauly gravity is set to TOP
     * @param gravity
     *
     */
    public void setGravity(int gravity) {
        this.gravity = gravity;
    }


    public int getGravity() {
        return gravity;
    }

    /**
     * Banner will be disappear when clicked outside ot the banner, when focusable is true
     * focusable default value is false
     * @param focusable
     *
     */
    public void setFocusable(boolean focusable) {
        this.focusable = focusable;
    }


    public boolean isFocusable() {
        return focusable;
    }


    private void setBannerLayout(int type){

        bannerType = type;
        int result = 0;
        switch (bannerType){
            case 1:
                result = R.layout.success;
                break;
            case 2:
                result = R.layout.info;
                break;
            case 3:
                result = R.layout.warning;
                break;
            case 4:
                result = R.layout.error;
                break;
        }
        layout =  result;
    }


    /**
     * This method set textview for the default banners
     * @param text
     *
     */
    private void setBannerText(String text){
        switch (bannerType){
            case 1:
                textMessage = popupView.findViewById(R.id.success_message);
                textMessage.setText(text);
                break;
            case 2:
                textMessage = popupView.findViewById(R.id.info_message);
                textMessage.setText(text);
                break;
            case 3:
                textMessage = popupView.findViewById(R.id.warning_message);
                textMessage.setText(text);
                break;
            case 4:
                textMessage = popupView.findViewById(R.id.error_message);
                textMessage.setText(text);
                break;
        }
    }

    public void setAsDropDown(boolean asDropDown) {
        this.asDropDown = asDropDown;
    }

    public boolean isAsDropDown() {
        return asDropDown;
    }

    public void setFillScreen(boolean fillScreen) {
        this.fillScreen = fillScreen;
    }

    public boolean isFillScreen() {
        return fillScreen;
    }

    /**
     * Hide close icon if duration is already set
     *
     *
     */
    private void setCancelButton(){
        if(duration > 0){
            rlCancel.setVisibility(View.INVISIBLE);
        }else {
            rlCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    popupWindow.dismiss();
                }
            });
        }
    }

    /**
     *Initialize the banner view
     * @param layout
     *
     */
    public void setLayout(int layout){
        LayoutInflater inflater = (LayoutInflater)
                mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        popupView = inflater.inflate(layout, null);
        rlCancel = popupView.findViewById(R.id.rlCancel);
    }

    /**
     * This method returns the banner view set by setLayout
     * This method must be invoke after setLayout in order to avoid null pointer
     */
    public View getBannerView() {
        return popupView;
    }

    public void dismissBanner(){
        try{
            popupWindow.dismiss();
            showBanner = false;
            asDropDown = false;
        }catch (Exception e){
            Log.e(TAG,e.toString());
        }
    }
    /**
     * This method create a new popup window
     * This method must be called after setLayout
     * focusable default value is false
     *
     */
    public void show(){

        showBanner = true;

        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        if(fillScreen){
            height = LinearLayout.LayoutParams.MATCH_PARENT;
        }

        popupWindow = new PopupWindow(popupView, width, height, focusable);

        if(animationStyle != null){
            popupWindow.setAnimationStyle(animationStyle);
        }

        rootView.post(new Runnable() {
            public void run() {
                if(asDropDown){
                    popupWindow.showAsDropDown(rootView,0,0);
                }else{
                    popupWindow.showAtLocation(rootView, gravity, 0, 0);
                }
            }
        });

        autoDismiss(duration);
    }

    private void setAnimationstyle(){
        if(gravity == TOP)
            animationStyle = R.style.topAnimation;
        else if (gravity == BOTTOM)
            animationStyle = R.style.bottomAnimation;
    }

    public void setCustomAnimationStyle(int customAnimationStyle){
        animationStyle =customAnimationStyle;
    }


    /**
     * This method auto dismiss banner
     *
     *@param duration
     *
     */
    private void autoDismiss(int duration){
        if(duration > 0){
            android.os.Handler handler = new android.os.Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dismissBanner();
                }
            },duration);
        }
    }
}
