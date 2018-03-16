# PopUp Notification Banner

A pop up notification banner for in app local notification

![demo](/demo.gif)

[![](https://jitpack.io/v/shasin89/NotificationBanner.svg)](https://jitpack.io/#shasin89/NotificationBanner)


## Installation

Add the library to your **build.gradle**:

```gradle

dependencies {
      compile 'com.github.shasin89:NotificationBanner:{latest-release}'
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

```java
View rootview = findViewById(android.R.id.content);
Banner banner = new Banner(rootview,getBaseContext());
```
The constructor requires view and context as parameters.

Once a banner object is instantiated, you must set your custom banner layout, in order to instantiate new banner view:

```java
banner.setLayout(R.layout.banner);
```

If your banner has views that need to be set on runtime, instantiate your view objects as below:
```java
textView = banner.getBannerView().findViewById(R.id.status_text);
rlCancel = banner.getBannerView().findViewById(R.id.rlCancel);
textView.setText("This is text for the banner");
```

To listen to click events, you can implement the following code:
```java
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
By default the gravity of the banner is set to top of the rootview. You can change the location of the banner to top,center and bottom :
```java
banner.setGravity(Banner.TOP);
```
The library allow to set custom animation for the banner. You can set your own animation style as below:
```java
banner.setAnimationstyle(R.style.PopupWindowAnimation);
```

Finally, invoke pop up window:
```java
banner.setPopupWindow();
```
## Contribution
Pull requests for new features, bug fixes, and suggestions are welcome!

## License

MIT License

> Copyright (c) 2018 Shasindran Poonudurai

> Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

> The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

> THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.


