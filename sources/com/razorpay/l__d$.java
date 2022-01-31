package com.razorpay;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

/* compiled from: CustomViews */
public final class l__d$ {
    public static View a(Context context, ArrayList<ApplicationDetails> arrayList, boolean z, int i, View.OnClickListener onClickListener) {
        return a(context, arrayList, z, i, onClickListener, (String) null);
    }

    public static View a(Context context, ArrayList<ApplicationDetails> arrayList, boolean z, int i, View.OnClickListener onClickListener, String str) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        if (!z || arrayList.size() == 1) {
            return a(context, arrayList, i, onClickListener, str);
        }
        return a(context, arrayList, i, onClickListener);
    }

    private static View a(Context context, ArrayList<ApplicationDetails> arrayList, int i, View.OnClickListener onClickListener) {
        GridLayout gridLayout = new GridLayout(context);
        gridLayout.setColumnCount(4);
        int dpToPixels = BaseUtils.dpToPixels(context, 12);
        int dpToPixels2 = BaseUtils.dpToPixels(context, 16);
        int dpToPixels3 = BaseUtils.dpToPixels(context, 6);
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.height = -2;
        layoutParams.width = -1;
        layoutParams.setMargins(dpToPixels, dpToPixels2, dpToPixels, dpToPixels3);
        gridLayout.setLayoutParams(layoutParams);
        gridLayout.setOrientation(0);
        gridLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.razorpay_card));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (((float) ((i - dpToPixels) - dpToPixels)) / 4.0f), -2);
        layoutParams2.addRule(14);
        a(gridLayout, R.layout.apps_display_grid_element, context, arrayList, onClickListener, layoutParams2);
        return gridLayout;
    }

    private static View a(Context context, ArrayList<ApplicationDetails> arrayList, int i, View.OnClickListener onClickListener, String str) {
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int dpToPixels = BaseUtils.dpToPixels(context, 12);
        layoutParams.setMargins(dpToPixels, BaseUtils.dpToPixels(context, 12), dpToPixels, BaseUtils.dpToPixels(context, 6));
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.razorpay_card));
        if (!(str == null || str.length() == 0)) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.app_display_list_heading_tv, (ViewGroup) null);
            ((TextView) relativeLayout.findViewById(R.id.text_view)).setText(str);
            linearLayout.addView(relativeLayout);
        }
        a(linearLayout, R.layout.apps_display_list_element, context, arrayList, onClickListener, (ViewGroup.LayoutParams) null);
        return linearLayout;
    }

    private static void a(ViewGroup viewGroup, int i, Context context, ArrayList<ApplicationDetails> arrayList, View.OnClickListener onClickListener, ViewGroup.LayoutParams layoutParams) {
        int size = arrayList.size();
        LayoutInflater from = LayoutInflater.from(context);
        for (int i2 = 0; i2 < size; i2++) {
            ApplicationDetails applicationDetails = arrayList.get(i2);
            if (applicationDetails != null) {
                String appName = applicationDetails.getAppName();
                String iconBase64 = applicationDetails.getIconBase64();
                String packageName = applicationDetails.getPackageName();
                if (!(appName == null || iconBase64 == null || packageName == null)) {
                    byte[] decode = Base64.decode(iconBase64.substring(iconBase64.indexOf(",") + 1), 0);
                    Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                    if (decodeByteArray != null) {
                        View inflate = from.inflate(i, (ViewGroup) null);
                        ((ImageView) inflate.findViewById(R.id.app_logo)).setImageBitmap(decodeByteArray);
                        ((TextView) inflate.findViewById(R.id.app_name)).setText(appName);
                        inflate.setTag(packageName);
                        inflate.setClickable(true);
                        inflate.setOnClickListener(onClickListener);
                        if (layoutParams != null) {
                            inflate.setLayoutParams(layoutParams);
                        }
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{16843534});
                        inflate.setBackgroundResource(obtainStyledAttributes.getResourceId(0, 0));
                        obtainStyledAttributes.recycle();
                        viewGroup.addView(inflate);
                    }
                }
            }
        }
    }
}
