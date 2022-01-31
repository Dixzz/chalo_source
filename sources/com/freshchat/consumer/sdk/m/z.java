package com.freshchat.consumer.sdk.m;

import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import com.freshchat.consumer.sdk.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class z implements DialogInterface.OnShowListener {
    public final /* synthetic */ gl4 ln;
    public final /* synthetic */ y pw;

    public z(y yVar, gl4 gl4) {
        this.pw = yVar;
        this.ln = gl4;
    }

    public void onShow(DialogInterface dialogInterface) {
        this.pw.pq = (FrameLayout) this.ln.findViewById(R.id.design_bottom_sheet);
        if (this.pw.pq != null) {
            View findViewById = this.ln.findViewById(R.id.freshchat_calendar_bottomsheet_title_layout);
            if (findViewById != null) {
                this.pw.pt = findViewById.getHeight();
            }
            BottomSheetBehavior H = BottomSheetBehavior.H(this.pw.pq);
            H.w = true;
            H.L(0);
            H.M(3);
        }
    }
}
