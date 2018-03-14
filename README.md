# PopUp Notification Banner

A pop up notification banner for in app local notifcation

![demo](/screenshot.png)


## Installation

Add the library to your **build.gradle**:

```gradle

dependencies {
      compile 'compile 'com.github.shasin89:PopUpBanner:0.1.1'
    }
```
This library is distributed via jitpack. Add following in your gradle if doesn't exist:

```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

## Prerequisites

The minimum API level supported by this library is **API 14 (ICE_CREAM_SANDWICH)**.

## Usage

In onCreate() of your activity, create a new Banner object:

```
rootview = findViewById(android.R.id.content);
banner = new Banner(rootview,getBaseContext());
```
The constructor requires view, context

Once a banner object is instantiated, you must set your custom banner layout, in order to instantiate new banner view:

```
banner.setLayout(R.layout.banner);
```

If your banner has views that need to be set on runtime, instantiate your view objects as below:
```
textView = banner.getBannerView().findViewById(R.id.status_text);
rlCancel = banner.getBannerView().findViewById(R.id.rlCancel);
textView.setText("This is text for the banner");
```

To listen to click events, you can implement the following code:
```
textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),"Toast", Toast.LENGTH_LONG).show();
            }
        });

        rlcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG","Clicked");
                banner.dismissBanner();
            }
        });
```

Finally, invoke pop up window:
```
banner.setPopupWindow();
```

By default the gravity of the banner is set to top of the rootview. You can change the location of the banner to top,center and bottom :
```
banner.setGravity(Banner.TOP);
```

