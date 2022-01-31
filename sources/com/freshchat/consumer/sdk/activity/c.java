package com.freshchat.consumer.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.j.aw;

public class c extends WebView {
    public static final FrameLayout.LayoutParams bJ = new FrameLayout.LayoutParams(-1, -1);
    private FrameLayout bA;
    private FrameLayout bB;
    private VideoView bC;
    public b bD = null;
    private int bE = 0;
    private int bF;
    private int bG;
    private int bH;
    private boolean bI = false;
    private a bv;
    private View bw;
    private FrameLayout bx;
    private WebChromeClient.CustomViewCallback by;
    private FrameLayout bz;
    private float density;
    private Context mContext;
    private int scrollPosition;

    public class a extends WebChromeClient {
        private View bK;

        private a() {
        }

        public View getVideoLoadingProgressView() {
            if (this.bK == null) {
                this.bK = LayoutInflater.from(c.this.mContext).inflate(R.layout.freshchat_partial_html5_video_progress, (ViewGroup) null);
            }
            return this.bK;
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            callback.invoke(str, true, false);
        }

        public void onHideCustomView() {
            if (c.this.bw != null) {
                c.this.bw.setVisibility(8);
                c.this.bx.removeView(c.this.bw);
                c.this.bw = null;
                c.this.bx.setVisibility(8);
                c.this.by.onCustomViewHidden();
                c.this.setVisibility(0);
                c.this.goBack();
                c.this.bD.k();
            }
        }

        public void onProgressChanged(WebView webView, int i) {
            ((Activity) c.this.mContext).getWindow().setFeatureInt(2, i * 100);
        }

        public void onReceivedTitle(WebView webView, String str) {
            if (c.this.mContext instanceof f0) {
                f0 f0Var = (f0) c.this.mContext;
                if (f0Var.getSupportActionBar() != null) {
                    f0Var.getSupportActionBar().z(str);
                }
            } else if (c.this.mContext instanceof Activity) {
                ((Activity) c.this.mContext).setTitle(str);
            }
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            c.this.bD.j();
            c.this.setVisibility(8);
            if (c.this.bw != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            view.setBackgroundColor(-16777216);
            c.this.bx.addView(view, c.bJ);
            c.this.bw = view;
            c.this.by = customViewCallback;
            c.this.bx.setVisibility(0);
            c.this.d((c) view);
        }
    }

    public interface b {
        void h();

        void i();

        void j();

        void k();
    }

    public c(Context context) {
        super(context);
        d(context);
    }

    private void d(Context context) {
        this.mContext = context;
        this.bB = new FrameLayout(context);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.freshchat_custom_html5_webview, (ViewGroup) null);
        this.bA = frameLayout;
        this.bz = (FrameLayout) frameLayout.findViewById(R.id.main_content);
        this.bx = (FrameLayout) this.bA.findViewById(R.id.fullscreen_custom_content);
        FrameLayout frameLayout2 = this.bB;
        FrameLayout frameLayout3 = this.bA;
        FrameLayout.LayoutParams layoutParams = bJ;
        frameLayout2.addView(frameLayout3, layoutParams);
        WebSettings settings = getSettings();
        settings.setAppCacheEnabled(true);
        settings.setBuiltInZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setSaveFormData(true);
        a aVar = new a();
        this.bv = aVar;
        setWebChromeClient(aVar);
        setWebViewClient(new WebViewClient());
        this.bz.addView(this, layoutParams);
        this.density = getResources().getDisplayMetrics().density == 0.0f ? 1.0f : getResources().getDisplayMetrics().density;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void d(View view) {
        if (aw.eR() && (view instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) view;
            if (frameLayout.getFocusedChild() instanceof VideoView) {
                this.bC = (VideoView) frameLayout.getFocusedChild();
            }
        }
    }

    public void a(b bVar, int i) {
        this.bD = bVar;
        this.bE = i;
    }

    public void aA() {
        this.bv.onHideCustomView();
    }

    public void aB() {
        VideoView videoView = this.bC;
        if (videoView != null) {
            videoView.pause();
        }
    }

    public boolean az() {
        return this.bw != null;
    }

    public FrameLayout getLayout() {
        return this.bB;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.bw != null || !canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.bD != null) {
            this.bG = (int) (((float) getContentHeight()) * this.density);
            int measuredHeight = getMeasuredHeight();
            this.bF = measuredHeight;
            int i5 = (this.bG - i2) - measuredHeight;
            this.scrollPosition = i5;
            int i6 = (int) (((double) (((float) this.bE) * this.density)) * 0.4d);
            this.bH = i6;
            if (i5 <= i6 && !this.bI) {
                this.bD.h();
                this.bI = true;
            }
            if (this.bI && this.scrollPosition > this.bH) {
                this.bD.i();
                this.bI = false;
            }
        }
    }
}
