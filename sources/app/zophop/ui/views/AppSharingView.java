package app.zophop.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import app.zophop.R;
import butterknife.ButterKnife;
import defpackage.li1;

public class AppSharingView extends RelativeLayout {
    public a f;
    public String g;

    public interface a {
        void a(li1.a aVar);
    }

    public AppSharingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.layout.app_sharing_view, (ViewGroup) this, true);
        ButterKnife.inject(this, this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0080, code lost:
        if (r0 == false) goto L_0x0082;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(defpackage.li1.a r9) {
        /*
        // Method dump skipped, instructions count: 176
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.views.AppSharingView.a(li1$a):void");
    }

    public void setErrorInfo(String str) {
        this.g = str;
    }

    public void setOnSharedClick(a aVar) {
        this.f = aVar;
    }
}
