package com.urbanairship.iam.fullscreen;

import android.view.View;
import android.webkit.WebView;
import com.urbanairship.iam.DisplayHandler;
import com.urbanairship.iam.view.InAppButtonLayout;
import com.urbanairship.iam.view.MediaView;

public class FullScreenActivity extends fr5 implements InAppButtonLayout.ButtonClickListener {
    public static final /* synthetic */ int o = 0;
    public ns5 m;
    public MediaView n;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            FullScreenActivity fullScreenActivity = FullScreenActivity.this;
            fullScreenActivity.b(view, fullScreenActivity.m.n);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            FullScreenActivity fullScreenActivity = FullScreenActivity.this;
            int i = FullScreenActivity.o;
            DisplayHandler displayHandler = fullScreenActivity.h;
            if (displayHandler != null) {
                displayHandler.a(xr5.c(), FullScreenActivity.this.d0());
            }
            FullScreenActivity.this.finish();
        }
    }

    public class c implements m8 {
        public c(FullScreenActivity fullScreenActivity) {
        }

        @Override // defpackage.m8
        public c9 a(View view, c9 c9Var) {
            r8.p(view, c9Var);
            return c9Var;
        }
    }

    @Override // com.urbanairship.iam.view.InAppButtonLayout.ButtonClickListener
    public void b(View view, xq5 xq5) {
        if (this.h != null) {
            hd3.J2(xq5);
            this.h.a(xr5.a(xq5), d0());
            finish();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.fr5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e0(android.os.Bundle r11) {
        /*
        // Method dump skipped, instructions count: 414
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.fullscreen.FullScreenActivity.e0(android.os.Bundle):void");
    }

    @Override // defpackage.fr5, defpackage.ve
    public void onPause() {
        super.onPause();
        WebView webView = this.n.f;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // defpackage.fr5, defpackage.ve
    public void onResume() {
        super.onResume();
        WebView webView = this.n.f;
        if (webView != null) {
            webView.onResume();
        }
    }
}
