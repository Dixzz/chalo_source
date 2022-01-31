package defpackage;

import android.webkit.WebView;
import app.zophop.ui.activities.CheckoutActivity;
import com.razorpay.BaseRazorpay;
import com.razorpay.RazorpayWebChromeClient;

/* renamed from: qd0  reason: default package */
/* compiled from: CheckoutActivity */
public class qd0 extends RazorpayWebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CheckoutActivity f2930a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public qd0(CheckoutActivity checkoutActivity, BaseRazorpay baseRazorpay) {
        super(baseRazorpay);
        this.f2930a = checkoutActivity;
    }

    @Override // com.razorpay.RazorpayWebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.f2930a.v.setProgress(i);
    }
}
