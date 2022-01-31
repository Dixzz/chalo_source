package com.urbanairship.iam.html;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.urbanairship.UAirship;
import com.urbanairship.automation.R;
import com.urbanairship.iam.DisplayHandler;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.view.BoundedFrameLayout;
import com.urbanairship.webkit.AirshipWebView;
import java.lang.ref.WeakReference;

public class HtmlActivity extends fr5 {
    public static final /* synthetic */ int r = 0;
    public AirshipWebView m;
    public Integer n = null;
    public Handler o;
    public String p;
    public final Runnable q = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            HtmlActivity.this.f0(0);
        }
    }

    public class b extends ts5 {
        public final /* synthetic */ ProgressBar e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(InAppMessage inAppMessage, ProgressBar progressBar) {
            super(inAppMessage);
            this.e = progressBar;
        }

        @Override // defpackage.fz5
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            HtmlActivity htmlActivity = HtmlActivity.this;
            Integer num = htmlActivity.n;
            if (num != null) {
                int intValue = num.intValue();
                if (intValue == -8 || intValue == -6 || intValue == -1) {
                    HtmlActivity.this.f0(DefaultRefreshIntervals.ACTIVE_CONV_MIN_FETCH_INTERVAL);
                    return;
                }
                HtmlActivity htmlActivity2 = HtmlActivity.this;
                htmlActivity2.n = null;
                htmlActivity2.m.loadData("", "text/html", null);
                return;
            }
            AirshipWebView airshipWebView = htmlActivity.m;
            ProgressBar progressBar = this.e;
            if (airshipWebView != null) {
                airshipWebView.animate().alpha(1.0f).setDuration(200);
            }
            if (progressBar != null) {
                progressBar.animate().alpha(0.0f).setDuration(200).setListener(new os5(htmlActivity, progressBar));
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (str2 != null && str2.equals(HtmlActivity.this.getIntent().getDataString())) {
                yj5.c("HtmlActivity - Failed to load page %s with error %s %s", str2, Integer.valueOf(i), str);
                HtmlActivity.this.n = Integer.valueOf(i);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            HtmlActivity htmlActivity = HtmlActivity.this;
            int i = HtmlActivity.r;
            DisplayHandler displayHandler = htmlActivity.h;
            if (displayHandler != null) {
                displayHandler.a(xr5.c(), HtmlActivity.this.d0());
            }
            HtmlActivity.this.finish();
        }
    }

    @Override // defpackage.fr5
    public void e0(Bundle bundle) {
        boolean z;
        float f;
        View findViewById;
        InAppMessage inAppMessage = this.i;
        if (inAppMessage == null) {
            finish();
            return;
        }
        ss5 ss5 = (ss5) inAppMessage.c();
        if (ss5 == null) {
            yj5.c("HtmlActivity - Invalid display type: %s", this.i.c());
            finish();
            return;
        }
        if (!ss5.j) {
            z = false;
        } else {
            z = getResources().getBoolean(R.bool.ua_iam_html_allow_fullscreen_display);
        }
        if (z) {
            setTheme(R.style.UrbanAirship_InAppHtml_Activity_Fullscreen);
            setContentView(R.layout.ua_iam_html_fullscreen);
            f = 0.0f;
        } else {
            setContentView(R.layout.ua_iam_html);
            f = ss5.i;
        }
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        ImageButton imageButton = (ImageButton) findViewById(R.id.dismiss);
        int i = R.id.content_holder;
        BoundedFrameLayout boundedFrameLayout = (BoundedFrameLayout) findViewById(i);
        if (!((((long) ss5.k) == 0 && ((long) ss5.l) == 0) || (findViewById = findViewById(i)) == null)) {
            findViewById.getViewTreeObserver().addOnPreDrawListener(new ps5(this, new WeakReference(findViewById), (int) TypedValue.applyDimension(1, (float) ((long) ss5.k), getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, (float) ((long) ss5.l), getResources().getDisplayMetrics()), ss5.m));
        }
        this.m = (AirshipWebView) findViewById(R.id.web_view);
        this.o = new Handler(Looper.getMainLooper());
        this.p = ss5.f;
        if (!UAirship.l().k.d(this.p, 2)) {
            yj5.c("HTML in-app message URL is not allowed. Unable to display message.", new Object[0]);
            finish();
            return;
        }
        this.m.setWebViewClient(new b(this.i, progressBar));
        this.m.setAlpha(0.0f);
        this.m.getSettings().setSupportMultipleWindows(true);
        this.m.setWebChromeClient(new ez5(this));
        Drawable mutate = h.H0(imageButton.getDrawable()).mutate();
        mutate.setTint(ss5.g);
        imageButton.setImageDrawable(mutate);
        imageButton.setOnClickListener(new c());
        boundedFrameLayout.setBackgroundColor(ss5.h);
        if (f > 0.0f) {
            boundedFrameLayout.setClipPathBorderRadius(f);
        }
    }

    public void f0(long j) {
        AirshipWebView airshipWebView = this.m;
        if (airshipWebView != null) {
            airshipWebView.stopLoading();
            if (j > 0) {
                this.o.postDelayed(this.q, j);
                return;
            }
            yj5.f("Loading url: %s", this.p);
            this.n = null;
            this.m.loadUrl(this.p);
        }
    }

    @Override // defpackage.fr5, defpackage.ve
    public void onPause() {
        super.onPause();
        this.m.onPause();
        this.m.stopLoading();
        this.o.removeCallbacks(this.q);
    }

    @Override // defpackage.fr5, defpackage.ve
    public void onResume() {
        super.onResume();
        this.m.onResume();
        f0(0);
    }
}
