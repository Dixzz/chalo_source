package com.urbanairship.iam.modal;

import android.view.View;
import android.webkit.WebView;
import com.urbanairship.iam.DisplayHandler;
import com.urbanairship.iam.view.InAppButtonLayout;
import com.urbanairship.iam.view.MediaView;

public class ModalActivity extends fr5 implements InAppButtonLayout.ButtonClickListener {
    public static final /* synthetic */ int n = 0;
    public MediaView m;

    public class a implements View.OnClickListener {
        public final /* synthetic */ ws5 f;

        public a(ws5 ws5) {
            this.f = ws5;
        }

        public void onClick(View view) {
            ModalActivity.this.b(view, this.f.n);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            ModalActivity modalActivity = ModalActivity.this;
            int i = ModalActivity.n;
            DisplayHandler displayHandler = modalActivity.h;
            if (displayHandler != null) {
                displayHandler.a(xr5.c(), ModalActivity.this.d0());
            }
            ModalActivity.this.finish();
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

    /* JADX WARNING: Removed duplicated region for block: B:41:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x017a  */
    @Override // defpackage.fr5
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e0(android.os.Bundle r14) {
        /*
        // Method dump skipped, instructions count: 410
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.iam.modal.ModalActivity.e0(android.os.Bundle):void");
    }

    @Override // defpackage.fr5, defpackage.ve
    public void onPause() {
        super.onPause();
        WebView webView = this.m.f;
        if (webView != null) {
            webView.onPause();
        }
    }

    @Override // defpackage.fr5, defpackage.ve
    public void onResume() {
        super.onResume();
        WebView webView = this.m.f;
        if (webView != null) {
            webView.onResume();
        }
    }
}
