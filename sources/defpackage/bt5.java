package defpackage;

import android.view.ViewTreeObserver;
import com.urbanairship.iam.assets.Assets;
import com.urbanairship.iam.view.MediaView;
import java.lang.ref.WeakReference;

/* renamed from: bt5  reason: default package */
/* compiled from: InAppViewUtils */
public final class bt5 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ WeakReference f;
    public final /* synthetic */ vr5 g;
    public final /* synthetic */ Assets h;

    public bt5(WeakReference weakReference, vr5 vr5, Assets assets) {
        this.f = weakReference;
        this.g = vr5;
        this.h = assets;
    }

    public boolean onPreDraw() {
        MediaView mediaView = (MediaView) this.f.get();
        if (mediaView == null) {
            return false;
        }
        hd3.d2(mediaView, this.g, this.h);
        mediaView.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}
