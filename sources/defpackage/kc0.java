package defpackage;

import android.view.View;
import android.widget.ImageView;
import app.zophop.R;
import app.zophop.ui.activities.ActiveScanPayScreen;
import java.util.Objects;

/* renamed from: kc0  reason: default package */
/* compiled from: ActiveScanPayScreen */
public class kc0 implements View.OnClickListener {
    public final ImageView f;
    public final /* synthetic */ ImageView g;
    public final /* synthetic */ ActiveScanPayScreen h;

    public kc0(ActiveScanPayScreen activeScanPayScreen, ImageView imageView) {
        this.h = activeScanPayScreen;
        this.g = imageView;
        this.f = imageView;
    }

    public void onClick(View view) {
        ActiveScanPayScreen activeScanPayScreen = this.h;
        activeScanPayScreen.setContentView(activeScanPayScreen.s);
        ImageView imageView = (ImageView) this.h.s.findViewById(R.id.scan_pay_qr_code_zoomed);
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView.setImageDrawable(imageView2.getDrawable());
        } else {
            imageView.setImageDrawable(((ImageView) view).getDrawable());
        }
        imageView.startAnimation(this.h.l);
        ActiveScanPayScreen activeScanPayScreen2 = this.h;
        Objects.requireNonNull(activeScanPayScreen2);
        new lc0(activeScanPayScreen2, imageView).run();
        this.h.i0();
        this.h.j0(1.0f);
        this.h.m = true;
    }
}
