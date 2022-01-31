package com.mixpanel.android.takeoverinapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mixpanel.android.R;
import com.mixpanel.android.mpmetrics.InAppButton;
import com.mixpanel.android.mpmetrics.TakeoverInAppNotification;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"ClickableViewAccessibility"})
@TargetApi(16)
public class TakeoverInAppActivity extends Activity {
    public nc5 f;
    public UpdateDisplayState g;
    public int h = -1;

    public void onBackPressed() {
        UpdateDisplayState.c(this.h);
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.INTENT_ID_KEY", Integer.MAX_VALUE);
        this.h = intExtra;
        UpdateDisplayState a2 = UpdateDisplayState.a(intExtra);
        this.g = a2;
        if (a2 == null) {
            finish();
            return;
        }
        this.f = nc5.k(this, a2.g);
        setContentView(R.layout.com_mixpanel_android_activity_notification_full);
        ImageView imageView = (ImageView) findViewById(R.id.com_mixpanel_android_notification_gradient);
        FadingImageView fadingImageView = (FadingImageView) findViewById(R.id.com_mixpanel_android_notification_image);
        TextView textView = (TextView) findViewById(R.id.com_mixpanel_android_notification_title);
        TextView textView2 = (TextView) findViewById(R.id.com_mixpanel_android_notification_subtext);
        ArrayList arrayList = new ArrayList();
        Button button = (Button) findViewById(R.id.com_mixpanel_android_notification_button);
        arrayList.add(button);
        arrayList.add((Button) findViewById(R.id.com_mixpanel_android_notification_second_button));
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.com_mixpanel_android_button_exit_wrapper);
        ImageView imageView2 = (ImageView) findViewById(R.id.com_mixpanel_android_image_close);
        TakeoverInAppNotification takeoverInAppNotification = (TakeoverInAppNotification) ((UpdateDisplayState.DisplayState.InAppNotificationState) this.g.h).f;
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = 0;
        if (getResources().getConfiguration().orientation == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, (int) (((float) point.y) * 0.06f));
            linearLayout.setLayoutParams(layoutParams);
        }
        fadingImageView.m = takeoverInAppNotification.u;
        imageView.setBackgroundColor(takeoverInAppNotification.j);
        int i2 = 8;
        if (takeoverInAppNotification.s != null) {
            textView.setVisibility(0);
            textView.setText(takeoverInAppNotification.s);
            textView.setTextColor(takeoverInAppNotification.t);
        } else {
            textView.setVisibility(8);
        }
        if (takeoverInAppNotification.k != null) {
            textView2.setVisibility(0);
            textView2.setText(takeoverInAppNotification.k);
            textView2.setTextColor(takeoverInAppNotification.l);
        } else {
            textView2.setVisibility(8);
        }
        fadingImageView.setImageBitmap(takeoverInAppNotification.o);
        int i3 = 0;
        while (i3 < arrayList.size()) {
            InAppButton inAppButton = takeoverInAppNotification.q.size() > i3 ? takeoverInAppNotification.q.get(i3) : null;
            Button button2 = (Button) arrayList.get(i3);
            if (inAppButton != null) {
                button2.setVisibility(i);
                button2.setText(inAppButton.g);
                button2.setTextColor(inAppButton.h);
                button2.setTransformationMethod(null);
                GradientDrawable gradientDrawable = new GradientDrawable();
                int i4 = inAppButton.i;
                button2.setOnTouchListener(new kd5(this, i4 != 0 ? Color.rgb((int) ((float) ((Color.red(864454278) / 2) + (Color.red(i4) / 2))), (int) ((float) ((Color.green(864454278) / 2) + (Color.green(i4) / 2))), (int) ((float) ((Color.blue(864454278) / 2) + (Color.blue(i4) / 2)))) : 864454278, gradientDrawable, inAppButton));
                gradientDrawable.setColor(inAppButton.i);
                gradientDrawable.setStroke((int) hd3.J0(2.0f, this), inAppButton.j);
                gradientDrawable.setCornerRadius((float) ((int) hd3.J0(5.0f, this)));
                button2.setBackground(gradientDrawable);
                button2.setOnClickListener(new ld5(this, inAppButton, takeoverInAppNotification, i3));
                i2 = 8;
            } else {
                button2.setVisibility(i2);
            }
            i3++;
            i = 0;
        }
        if (takeoverInAppNotification.q.size() == 1) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams2.weight = 0.0f;
            layoutParams2.width = -2;
            button.setLayoutParams(layoutParams2);
        }
        imageView2.setColorFilter(takeoverInAppNotification.r);
        linearLayout.setOnClickListener(new jd5(this));
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.95f, 1.0f, 0.95f, 1.0f, 1, 0.5f, 1, 1.0f);
        scaleAnimation.setDuration(200);
        fadingImageView.startAnimation(scaleAnimation);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.5f, 1, 0.0f);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(200);
        textView.startAnimation(translateAnimation);
        textView2.startAnimation(translateAnimation);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Button) it.next()).startAnimation(translateAnimation);
        }
        linearLayout.startAnimation(AnimationUtils.loadAnimation(this, R.anim.com_mixpanel_android_fade_in));
    }
}
