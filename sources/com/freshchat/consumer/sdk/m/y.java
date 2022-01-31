package com.freshchat.consumer.sdk.m;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.freshchat.consumer.sdk.b.i;

public abstract class y extends hl4 {
    private int orientation;
    private FrameLayout pq;
    private DisplayMetrics pr = new DisplayMetrics();
    private int ps;
    private int pt;
    private int pu = 1;

    private int S(int i) {
        int i2;
        int T = T(i) - (getContext() != null ? i.cb(getContext()) + i.ca(getContext()) : 0);
        return (this.pu != 2 && (i2 = this.ps) < T) ? i2 : T;
    }

    private int T(int i) {
        int i2;
        if (i == 1) {
            DisplayMetrics displayMetrics = this.pr;
            int i3 = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
            if (i3 > i2) {
                return i3;
            }
        } else {
            DisplayMetrics displayMetrics2 = this.pr;
            int i4 = displayMetrics2.heightPixels;
            i2 = displayMetrics2.widthPixels;
            if (i4 < i2) {
                return i4;
            }
        }
        return i2;
    }

    private void hT() {
        CoordinatorLayout.f fVar = (CoordinatorLayout.f) this.pq.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) fVar).height = S(this.orientation);
        this.pq.setLayoutParams(fVar);
    }

    public void R(int i) {
        this.pu = 1;
        this.ps = i + this.pt;
        hT();
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void hS() {
        if (this.pu != 2) {
            this.pu = 2;
            hT();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.orientation = configuration.orientation;
        hT();
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (c() != null && c().getWindowManager() != null) {
            c().getWindowManager().getDefaultDisplay().getMetrics(this.pr);
        }
    }

    @Override // defpackage.ue, defpackage.hl4, defpackage.o0
    public Dialog onCreateDialog(Bundle bundle) {
        gl4 gl4 = (gl4) super.onCreateDialog(bundle);
        gl4.setOnShowListener(new z(this, gl4));
        return gl4;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }
}
