package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new a();
    public final int f;
    public final MediaDescriptionCompat g;

    public static class a implements Parcelable.Creator<MediaBrowserCompat$MediaItem> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public MediaBrowserCompat$MediaItem createFromParcel(Parcel parcel) {
            return new MediaBrowserCompat$MediaItem(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public MediaBrowserCompat$MediaItem[] newArray(int i) {
            return new MediaBrowserCompat$MediaItem[i];
        }
    }

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f = parcel.readInt();
        this.g = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "MediaItem{" + "mFlags=" + this.f + ", mDescription=" + this.g + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f);
        this.g.writeToParcel(parcel, i);
    }
}
