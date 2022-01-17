# Altimeter 

A simple altimeter view. The drawables can be changed with
your own custom assets.

Taken from com.leondzn.simpleanalogclock
https://github.com/leondzn/simple-analog-clock

## Prerequisites

Your project must be using AndroidX artifacts instead of Support Libraries. 
Otherwise your project build will fail due to `Manifest merger failed` error.

## Installation

```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

```gradle
dependencies {
  implementation 'com.github.woheller69:AltimeterView:-SNAPSHOT'
}
```


## Usage

### XML
```xml
<org.woheller69.altimeterview.AltimeterView
    android:id="@+id/clock"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="16dp"
    app:hourTint="@color/colorPrimary"                                        
    app:secondTint="@color/colorAccent" />
```

**The following XML attributes are supported:**

`app:backTint, app:dialTint, app:faceTint, app:hourTint, app:minuteTint, app:secondTint`

to colorize the clock's face and hands.

You can manually set the individual hands' rotation value given a specific angle using

`app:hourRotation, app:minuteRotation, app:secondRotation`

You can also provide custom drawables for the clock using

`app:backDrawable, app:dialDrawable, app:faceDrawable, app:hourDrawable, app:minuteDrawable, app:secondDrawable`

More info on providing custom drawables are detailed below.

### Java

```java
AltimeterView altimeter = findViewById(...);

altimeter.setSecondTint(...)
  .setTime(hour, minute, second);
```

You can rotate the clock hands individually using the following methods:

`rotateHourHand(angle), rotateMinuteHand(angle), rotateSecondHand(angle)`

Using the methods above requires you to calculate the corresponding angles for each time value.

To use exact altitude values, use the following methods:

`setAltitude(double altitude)`

Similar to the XML attributes, you can also provide custom drawables to use with the analog clock:

`setBackDrawable(Drawable), setDialDrawable(Drawable), setFaceDrawable(Drawable), setHourDrawable(Drawable), setMinuteDrawable(Drawable), setSecondDrawable(Drawable)`

## Using Custom Drawables

Simple default clock face and hands are provided but you are free to use custom drawables
provided that they follow these guidelines:

* All 6 layers (back, face, dial, hour hand, minute hand, second hand) should all be the same image size
* The images should be square
* Clock hands should be pointing at the 12 o' clock position
* SVG or PNG can be used

