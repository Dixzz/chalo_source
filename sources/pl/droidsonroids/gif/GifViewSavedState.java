package pl.droidsonroids.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class GifViewSavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<GifViewSavedState> CREATOR = new a();
    public final long[][] f;

    public static class a implements Parcelable.Creator<GifViewSavedState> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public GifViewSavedState createFromParcel(Parcel parcel) {
            return new GifViewSavedState(parcel, (a) null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public GifViewSavedState[] newArray(int i) {
            return new GifViewSavedState[i];
        }
    }

    public GifViewSavedState(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        long[] savedState;
        this.f = new long[drawableArr.length][];
        for (int i = 0; i < drawableArr.length; i++) {
            Drawable drawable = drawableArr[i];
            if (drawable instanceof wn6) {
                long[][] jArr = this.f;
                GifInfoHandle gifInfoHandle = ((wn6) drawable).l;
                synchronized (gifInfoHandle) {
                    savedState = GifInfoHandle.getSavedState(gifInfoHandle.f2819a);
                }
                jArr[i] = savedState;
            } else {
                this.f[i] = null;
            }
        }
    }

    public void a(Drawable drawable, int i) {
        int restoreSavedState;
        long[][] jArr = this.f;
        if (jArr[i] != null && (drawable instanceof wn6)) {
            wn6 wn6 = (wn6) drawable;
            GifInfoHandle gifInfoHandle = wn6.l;
            long[] jArr2 = jArr[i];
            Bitmap bitmap = wn6.k;
            synchronized (gifInfoHandle) {
                restoreSavedState = GifInfoHandle.restoreSavedState(gifInfoHandle.f2819a, jArr2, bitmap);
            }
            wn6.a((long) restoreSavedState);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.f.length);
        for (long[] jArr : this.f) {
            parcel.writeLongArray(jArr);
        }
    }

    public GifViewSavedState(Parcel parcel, a aVar) {
        super(parcel);
        this.f = new long[parcel.readInt()][];
        int i = 0;
        while (true) {
            long[][] jArr = this.f;
            if (i < jArr.length) {
                jArr[i] = parcel.createLongArray();
                i++;
            } else {
                return;
            }
        }
    }
}
