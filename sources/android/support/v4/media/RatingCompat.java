package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();
    public final int f;
    public final float g;

    public static class a implements Parcelable.Creator<RatingCompat> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    }

    public RatingCompat(int i, float f2) {
        this.f = i;
        this.g = f2;
    }

    public int describeContents() {
        return this.f;
    }

    public String toString() {
        String str;
        StringBuilder i0 = hj1.i0("Rating:style=");
        i0.append(this.f);
        i0.append(" rating=");
        float f2 = this.g;
        if (f2 < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(f2);
        }
        i0.append(str);
        return i0.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f);
        parcel.writeFloat(this.g);
    }
}
