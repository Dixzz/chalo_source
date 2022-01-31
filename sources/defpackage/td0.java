package defpackage;

import android.graphics.Bitmap;
import android.webkit.WebView;
import app.zophop.ui.activities.CheckoutActivity;
import com.razorpay.BaseRazorpay;
import com.razorpay.RazorpayWebViewClient;

/* renamed from: td0  reason: default package */
/* compiled from: CheckoutActivity */
public class td0 extends RazorpayWebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckoutActivity f3336a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public td0(CheckoutActivity checkoutActivity, BaseRazorpay baseRazorpay) {
        super(baseRazorpay);
        this.f3336a = checkoutActivity;
    }

    @Override // com.razorpay.RazorpayWebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f3336a.v.setVisibility(8);
        jz5.b().g(new ed1("Razorpay webview loaded", Long.MAX_VALUE));
    }

    @Override // com.razorpay.RazorpayWebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }
}
