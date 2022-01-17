/*
 * Taken from com.leondzn.simpleanalogclock
 * https://github.com/leondzn/simple-analog-clock
 *
 * Copyright (C) 2019 Leonard Dizon.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.woheller69.altimeterview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;

public class AltimeterView extends RelativeLayout {
  private final AppCompatImageView back;
  private final AppCompatImageView face;
  private final AppCompatImageView dial;
  private final AppCompatImageView hour;
  private final AppCompatImageView minute;
  private final AppCompatImageView second;

  public AltimeterView(Context context) {
    this(context, null);
  }

  public AltimeterView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public AltimeterView(Context context, AttributeSet attrs, int defStyleAttr) {
    this(context, attrs, defStyleAttr, 0);
  }


  @SuppressWarnings("WeakerAccess")
  public AltimeterView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);

    inflate(context, R.layout.analog_clock, this);

    back = findViewById(R.id.back);
    face = findViewById(R.id.face);
    dial = findViewById(R.id.dial);
    hour = findViewById(R.id.hour_hand);
    minute = findViewById(R.id.minute_hand);
    second = findViewById(R.id.second_hand);

    TypedArray typedArray = context.getTheme().obtainStyledAttributes(
        attrs, R.styleable.AltimeterView, defStyleAttr, defStyleRes);

    Drawable backDrawable = typedArray.getDrawable(R.styleable.AltimeterView_backDrawable);
    Drawable faceDrawable = typedArray.getDrawable(R.styleable.AltimeterView_faceDrawable);
    Drawable dialDrawable = typedArray.getDrawable(R.styleable.AltimeterView_dialDrawable);
    Drawable hourDrawable = typedArray.getDrawable(R.styleable.AltimeterView_hourDrawable);
    Drawable minuteDrawable = typedArray.getDrawable(R.styleable.AltimeterView_minuteDrawable);
    Drawable secondDrawable = typedArray.getDrawable(R.styleable.AltimeterView_secondDrawable);

    setBackDrawable(backDrawable != null ? backDrawable : context.getDrawable(R.drawable.ic_altimeter_back))
        .setFaceDrawable(faceDrawable != null ? faceDrawable : context.getDrawable(R.drawable.ic_altimeter_face))
        .setDialDrawable(faceDrawable != null ? dialDrawable : context.getDrawable(R.drawable.ic_altimeter_dial))
        .setHourDrawable(hourDrawable != null ? hourDrawable : context.getDrawable(R.drawable.ic_altimeter_10k))
        .setMinuteDrawable(minuteDrawable != null ? minuteDrawable : context.getDrawable(R.drawable.ic_altimeter_1k))
        .setSecondDrawable(secondDrawable != null ? secondDrawable : context.getDrawable(R.drawable.ic_altimeter_1));

    int backColor = typedArray.getColor(R.styleable.AltimeterView_backTint, -1);
    int faceColor = typedArray.getColor(R.styleable.AltimeterView_faceTint, -1);
    int dialColor = typedArray.getColor(R.styleable.AltimeterView_dialTint, -1);
    int hourColor = typedArray.getColor(R.styleable.AltimeterView_hourTint, -1);
    int minuteColor = typedArray.getColor(R.styleable.AltimeterView_minuteTint, -1);
    int secondColor = typedArray.getColor(R.styleable.AltimeterView_secondTint, -1);
    if (backColor != -1) setBackTint(backColor);
    if (faceColor != -1) setFaceTint(faceColor);
    if (dialColor != -1) setDialTint(dialColor);
    if (hourColor != -1) setHourTint(hourColor);
    if (minuteColor != -1) setMinuteTint(minuteColor);
    if (secondColor != -1) setSecondTint(secondColor);

    rotateHourHand(typedArray.getFloat(R.styleable.AltimeterView_hourRotation, 0));
    rotateMinuteHand(typedArray.getFloat(R.styleable.AltimeterView_minuteRotation, 0));
    rotateSecondHand(typedArray.getFloat(R.styleable.AltimeterView_secondRotation, 0));
  }

  @SuppressWarnings("WeakerAccess")
  public AltimeterView setBackDrawable(Drawable drawable) {
    back.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings("WeakerAccess")
  public AltimeterView setFaceDrawable(Drawable drawable) {
    face.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings("WeakerAccess")
  public AltimeterView setDialDrawable(Drawable drawable) {
    dial.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings("WeakerAccess")
  public AltimeterView setHourDrawable(Drawable drawable) {
    hour.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings("WeakerAccess")
  public AltimeterView setMinuteDrawable(Drawable drawable) {
    minute.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setSecondDrawable(Drawable drawable) {
    second.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView rotateHourHand(float angle) {
    hour.setRotation(angle);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView rotateMinuteHand(float angle) {
    minute.setRotation(angle);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView rotateSecondHand(float angle) {
    second.setRotation(angle);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setAltitude(double value) {

    rotateSecondHand((float) ((float) 360*(value%1000)/1000));
    rotateMinuteHand((float) ((float) 360*(value%10000)/10000));
    rotateHourHand((float) ((float) 360*(value%100000)/100000));

    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setBackTint(int color) {
    back.setColorFilter(color);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setFaceTint(int color) {
    face.setColorFilter(color);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setDialTint(int color) {
    dial.setColorFilter(color);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setHourTint(int color) {
    hour.setColorFilter(color);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setMinuteTint(int color) {
    minute.setColorFilter(color);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setSecondTint(int color) {
    second.setColorFilter(color);
    return this;
  }
}
