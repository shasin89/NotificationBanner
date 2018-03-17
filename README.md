# Notification Banner for Android

A pop up notification banner for in app local notification. Easy to use with default layouts for success, info, warning, and error banners. The library allow to customize the layout with your own design and click events.

**Top:**

![demo](/art/demoTop.gif)

**Bottom:**

![demo](/art/demoBottom.gif) 

**Auto dismiss and onClick listener:**

![demo](/art/demoAuto.gif)

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

In onCreate() of your activity, create a root view object for the banner:

```java
View rootview = findViewById(android.R.id.content);
```

With the latest release of v1.1.0, you can now call the banner with one line of code:

**Option 1: Choose default layouts**
```java
Banner.make(View view,Context context, int bannerType, String message, int position);
```

**Option 2: Choose default layouts with auto dismiss after the given duration**
```java
Banner.make(View view,Context context, int bannerType, String message, int position, int duration);
```
**Option 3: With custom layout:**
```java
Banner.make(View view,Context context, int position, int Customlayout);
```

**Example:**
```java
Banner.make(rootview,getBaseContext(),Banner.SUCCESS,"This is a successful message",Banner.TOP).show();
```

```java
Banner.make(rootview,getBaseContext(),Banner.ERROR,"This is an error message",Banner.BOTTOM,2000).show();
```

For custom layout, pass your layout as shown below:
```java
Banner.make(rootview,getBaseContext(),Banner.TOP,R.layout.banner);
```

If your custom banner has views that need to be set on runtime, instantiate your view objects as below:
```java
textView = Banner.getInstance().getBannerView().findViewById(R.id.status_text);
relativeLayout = Banner.getInstance().getBannerView().findViewById(R.id.rlCancel);
textView.setText("This is text for the banner");
```

To listen to click events, you can implement the following code:
```java
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
```

The library allow to set custom animation for the banner. You can set your own animation style as below:
```java
Banner.getInstance().setCustomAnimationStyle(R.style.NotificationAnimationBottom);
```

If you want to auto dismiss your custom banner, set the duration as below:
```java
Banner.getInstance().setDuration(2000);
```

Finally, invoke show method:
```java
 Banner.getInstance().show();
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


