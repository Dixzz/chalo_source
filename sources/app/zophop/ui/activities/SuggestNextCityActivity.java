package app.zophop.ui.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.AbsListView;

/* compiled from: SuggestNextCityActivity.kt */
public final class SuggestNextCityActivity extends au {
    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        x supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.o(true);
            supportActionBar.r(false);
            supportActionBar.q(false);
        }
        WebView webView = new WebView(this);
        webView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        webView.loadUrl("https://docs.google.com/forms/d/1Dt4uL0vmz6eiJln69j53XGX1z6E71cfudR3RFHmyo94/viewform?c=0&w=1&usp=mail_form_link");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new uf0());
        setContentView(webView);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setUseWideViewPort(true);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        n86.e(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }
}
