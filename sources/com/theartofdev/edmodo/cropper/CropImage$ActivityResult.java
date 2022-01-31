package com.theartofdev.edmodo.cropper;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.theartofdev.edmodo.cropper.CropImageView;

public final class CropImage$ActivityResult extends CropImageView.b implements Parcelable {
    public static final Parcelable.Creator<CropImage$ActivityResult> CREATOR = new a();

    public static class a implements Parcelable.Creator<CropImage$ActivityResult> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public CropImage$ActivityResult createFromParcel(Parcel parcel) {
            return new CropImage$ActivityResult(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public CropImage$ActivityResult[] newArray(int i) {
            return new CropImage$ActivityResult[i];
        }
    }

    public CropImage$ActivityResult(Uri uri, Uri uri2, Exception exc, float[] fArr, Rect rect, int i, Rect rect2, int i2) {
        super(null, uri, null, uri2, exc, fArr, rect, rect2, i, i2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f, i);
        parcel.writeParcelable(this.g, i);
        parcel.writeSerializable(this.h);
        parcel.writeFloatArray(this.i);
        parcel.writeParcelable(this.j, i);
        parcel.writeParcelable(this.k, i);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }

    public CropImage$ActivityResult(Parcel parcel) {
        super(null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), null, (Uri) parcel.readParcelable(Uri.class.getClassLoader()), (Exception) parcel.readSerializable(), parcel.createFloatArray(), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), (Rect) parcel.readParcelable(Rect.class.getClassLoader()), parcel.readInt(), parcel.readInt());
    }
}
