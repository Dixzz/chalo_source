package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();
    public final int f;
    public final long g;
    public final long h;
    public final float i;
    public final long j;
    public final int k;
    public final CharSequence l;
    public final long m;
    public List<CustomAction> n;
    public final long o;
    public final Bundle p;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();
        public final String f;
        public final CharSequence g;
        public final int h;
        public final Bundle i;

        public static class a implements Parcelable.Creator<CustomAction> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        }

        public CustomAction(Parcel parcel) {
            this.f = parcel.readString();
            this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.h = parcel.readInt();
            this.i = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("Action:mName='");
            i0.append((Object) this.g);
            i0.append(", mIcon=");
            i0.append(this.h);
            i0.append(", mExtras=");
            i0.append(this.i);
            return i0.toString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f);
            TextUtils.writeToParcel(this.g, parcel, i2);
            parcel.writeInt(this.h);
            parcel.writeBundle(this.i);
        }
    }

    public static class a implements Parcelable.Creator<PlaybackStateCompat> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f = parcel.readInt();
        this.g = parcel.readLong();
        this.i = parcel.readFloat();
        this.m = parcel.readLong();
        this.h = parcel.readLong();
        this.j = parcel.readLong();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.n = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.o = parcel.readLong();
        this.p = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.k = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f + ", position=" + this.g + ", buffered position=" + this.h + ", speed=" + this.i + ", updated=" + this.m + ", actions=" + this.j + ", error code=" + this.k + ", error message=" + this.l + ", custom actions=" + this.n + ", active item id=" + this.o + "}";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f);
        parcel.writeLong(this.g);
        parcel.writeFloat(this.i);
        parcel.writeLong(this.m);
        parcel.writeLong(this.h);
        parcel.writeLong(this.j);
        TextUtils.writeToParcel(this.l, parcel, i2);
        parcel.writeTypedList(this.n);
        parcel.writeLong(this.o);
        parcel.writeBundle(this.p);
        parcel.writeInt(this.k);
    }
}
