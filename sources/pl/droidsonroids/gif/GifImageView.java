package pl.droidsonroids.gif;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import defpackage.zn6;
import java.util.List;

public class GifImageView extends ImageView {
    public boolean f;

    public GifImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        zn6.a aVar;
        List<String> list = zn6.f4192a;
        if (attributeSet == null || isInEditMode()) {
            aVar = new zn6.a();
        } else {
            aVar = new zn6.a(this, attributeSet, 0, 0);
            int i = aVar.b;
            if (i >= 0) {
                zn6.a(i, getDrawable());
                zn6.a(i, getBackground());
            }
        }
        this.f = aVar.f4193a;
        int i2 = aVar.c;
        if (i2 > 0) {
            super.setImageResource(i2);
        }
        int i3 = aVar.d;
        if (i3 > 0) {
            super.setBackgroundResource(i3);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof GifViewSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        gifViewSavedState.a(getDrawable(), 0);
        gifViewSavedState.a(getBackground(), 1);
    }

    public Parcelable onSaveInstanceState() {
        Drawable drawable = null;
        Drawable drawable2 = this.f ? getDrawable() : null;
        if (this.f) {
            drawable = getBackground();
        }
        return new GifViewSavedState(super.onSaveInstanceState(), drawable2, drawable);
    }

    public void setBackgroundResource(int i) {
        if (!zn6.b(this, false, i)) {
            super.setBackgroundResource(i);
        }
    }

    public void setFreezesAnimation(boolean z) {
        this.f = z;
    }

    public void setImageResource(int i) {
        if (!zn6.b(this, true, i)) {
            super.setImageResource(i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setImageURI(android.net.Uri r3) {
        /*
            r2 = this;
            java.util.List<java.lang.String> r0 = defpackage.zn6.f4192a
            if (r3 == 0) goto L_0x0016
            wn6 r0 = new wn6     // Catch:{ IOException -> 0x0016 }
            android.content.Context r1 = r2.getContext()     // Catch:{ IOException -> 0x0016 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ IOException -> 0x0016 }
            r0.<init>(r1, r3)     // Catch:{ IOException -> 0x0016 }
            r2.setImageDrawable(r0)     // Catch:{ IOException -> 0x0016 }
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            if (r0 != 0) goto L_0x001c
            super.setImageURI(r3)
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.droidsonroids.gif.GifImageView.setImageURI(android.net.Uri):void");
    }
}
