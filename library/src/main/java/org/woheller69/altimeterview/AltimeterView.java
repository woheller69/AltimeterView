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
  private final AppCompatImageView ticks;
  private final AppCompatImageView numbers;
  private final AppCompatImageView hand10kView;
  private final AppCompatImageView hand1kView;
  private final AppCompatImageView hand100View;

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

    inflate(context, R.layout.altimeter, this);

    back = findViewById(R.id.back);
    ticks = findViewById(R.id.ticks);
    numbers = findViewById(R.id.numbers);
    hand10kView = findViewById(R.id.hand_10k);
    hand1kView = findViewById(R.id.hand_1k);
    hand100View = findViewById(R.id.hand_100);

    TypedArray typedArray = context.getTheme().obtainStyledAttributes(
        attrs, R.styleable.AltimeterView, defStyleAttr, defStyleRes);

    Drawable backDrawable = typedArray.getDrawable(R.styleable.AltimeterView_backDrawable);
    Drawable faceDrawable = typedArray.getDrawable(R.styleable.AltimeterView_ticksDrawable);
    Drawable dialDrawable = typedArray.getDrawable(R.styleable.AltimeterView_numbersDrawable);
    Drawable hourDrawable = typedArray.getDrawable(R.styleable.AltimeterView_hand10kDrawable);
    Drawable minuteDrawable = typedArray.getDrawable(R.styleable.AltimeterView_hand1kDrawable);
    Drawable secondDrawable = typedArray.getDrawable(R.styleable.AltimeterView_hand100Drawable);

    setBackDrawable(backDrawable != null ? backDrawable : context.getDrawable(R.drawable.ic_altimeter_back))
        .setTicksDrawable(faceDrawable != null ? faceDrawable : context.getDrawable(R.drawable.ic_altimeter_ticks))
        .setNumbersDrawable(faceDrawable != null ? dialDrawable : context.getDrawable(R.drawable.ic_altimeter_numbers))
        .setHand10kDrawable(hourDrawable != null ? hourDrawable : context.getDrawable(R.drawable.ic_altimeter_hand_10k))
        .setHand1kDrawable(minuteDrawable != null ? minuteDrawable : context.getDrawable(R.drawable.ic_altimeter_hand_1k))
        .setHand100Drawable(secondDrawable != null ? secondDrawable : context.getDrawable(R.drawable.ic_altimeter_hand_100));

    int backColor = typedArray.getColor(R.styleable.AltimeterView_backTint, -1);
    int ticksColor = typedArray.getColor(R.styleable.AltimeterView_ticksTint, -1);
    int numbersColor = typedArray.getColor(R.styleable.AltimeterView_numbersTint, -1);
    int hand10kColor = typedArray.getColor(R.styleable.AltimeterView_hand10kTint, -1);
    int hand1kColor = typedArray.getColor(R.styleable.AltimeterView_hand1kTint, -1);
    int hand100Color = typedArray.getColor(R.styleable.AltimeterView_hand100Tint, -1);
    if (backColor != -1) setBackTint(backColor);
    if (ticksColor != -1) setTicksTint(ticksColor);
    if (numbersColor != -1) setNumbersTint(numbersColor);
    if (hand10kColor != -1) set10kHandTint(hand10kColor);
    if (hand1kColor != -1) set1kHandTint(hand1kColor);
    if (hand100Color != -1) set100HandTint(hand100Color);

    rotate10kHand(typedArray.getFloat(R.styleable.AltimeterView_hand10kRotation, 0));
    rotate1kHand(typedArray.getFloat(R.styleable.AltimeterView_hand1kRotation, 0));
    rotate100Hand(typedArray.getFloat(R.styleable.AltimeterView_hand100Rotation, 0));
  }

  @SuppressWarnings("WeakerAccess")
  public AltimeterView setBackDrawable(Drawable drawable) {
    back.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings("WeakerAccess")
  public AltimeterView setTicksDrawable(Drawable drawable) {
    ticks.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings("WeakerAccess")
  public AltimeterView setNumbersDrawable(Drawable drawable) {
    numbers.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings("WeakerAccess")
  public AltimeterView setHand10kDrawable(Drawable drawable) {
    hand10kView.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings("WeakerAccess")
  public AltimeterView setHand1kDrawable(Drawable drawable) {
    hand1kView.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setHand100Drawable(Drawable drawable) {
    hand100View.setImageDrawable(drawable);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView rotate10kHand(float angle) {
    hand10kView.setRotation(angle);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView rotate1kHand(float angle) {
    hand1kView.setRotation(angle);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView rotate100Hand(float angle) {
    hand100View.setRotation(angle);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setAltitude(double value) {

    rotate100Hand((float) ((float) 360*(value%1000)/1000));
    rotate1kHand((float) ((float) 360*(value%10000)/10000));
    rotate10kHand((float) ((float) 360*(value%100000)/100000));

    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setBackTint(int color) {
    back.setColorFilter(color);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setTicksTint(int color) {
    ticks.setColorFilter(color);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView setNumbersTint(int color) {
    numbers.setColorFilter(color);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView set10kHandTint(int color) {
    hand10kView.setColorFilter(color);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView set1kHandTint(int color) {
    hand1kView.setColorFilter(color);
    return this;
  }

  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public AltimeterView set100HandTint(int color) {
    hand100View.setColorFilter(color);
    return this;
  }
}
