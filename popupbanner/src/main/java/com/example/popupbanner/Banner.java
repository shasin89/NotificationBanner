package com.example.popupbanner;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;


import java.util.logging.Handler;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by Shasin on 14/03/2018.
 */

public class Banner {

    private Context mContext;
    private View popupView;
    private View rootView;
    private boolean belowView;
    private  boolean focusable;
    private PopupWindow popupWindow;

    public static int TOP = Gravity.TOP;
    public static int CENTER = Gravity.CENTER;
    public static int BOTTOM = Gravity.BOTTOM;

    private int gravity;

    private static Banner instance;

    public interface BannerListener {
        void onViewClickListener(View view);
    }


    public  Banner(View view, final Context context, int gravity) {
        // create the popup window
        this.mContext = context;
        this.rootView = view;
        this.gravity = gravity;
//        setPopupWindow(view);
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

    /**
     * Set the banner below or as dropdown of rootview
     * @param belowView
     *
     */
    public void setBelowView(boolean belowView) {
        this.belowView = belowView;
    }

    public boolean isBelowView() {
        return belowView;
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
    }

    /**
     * This method returns the banner view set by setLayout
     * This method must be invoke after setLayout in order to avoid null pointer
     */
    public View getBannerView() {
        return popupView;
    }

    public void dismissBanner(){
        popupWindow.dismiss();
    }

    /**
     * This method create a new popup window
     * Implemented runnable to delay in order to avoid bad window token exception
     * This method must be called after setLayout
     * focusable default value is false
     *
     *
     */
    public void setPopupWindow(){
        final android.os.Handler handler = new android.os.Handler();

        final int width = LinearLayout.LayoutParams.MATCH_PARENT;
        final int height = LinearLayout.LayoutParams.WRAP_CONTENT;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // delayed to 300ms to
                popupWindow = new PopupWindow(popupView, width, height, focusable);

                if(belowView){
                    popupWindow.showAsDropDown(rootView);
                }else{
                    popupWindow.showAtLocation(rootView, gravity, 0, 0);
                }

            }
        }, 500);




        // show the popup window

//        buttonCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                popupWindow.dismiss();
//                Log.d("Cancel", "Clicked");
//            }
//        });

    }



}
