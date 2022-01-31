package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

@SuppressLint({"BanParcelableUsage"})
public final class NavBackStackEntryState implements Parcelable {
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new a();
    public final UUID f;
    public final int g;
    public final Bundle h;
    public final Bundle i;

    public class a implements Parcelable.Creator<NavBackStackEntryState> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public NavBackStackEntryState[] newArray(int i) {
            return new NavBackStackEntryState[i];
        }
    }

    public NavBackStackEntryState(aj ajVar) {
        this.f = ajVar.j;
        this.g = ajVar.f.h;
        this.h = ajVar.g;
        Bundle bundle = new Bundle();
        this.i = bundle;
        ajVar.i.b(bundle);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f.toString());
        parcel.writeInt(this.g);
        parcel.writeBundle(this.h);
        parcel.writeBundle(this.i);
    }

    public NavBackStackEntryState(Parcel parcel) {
        this.f = UUID.fromString(parcel.readString());
        this.g = parcel.readInt();
        this.h = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        this.i = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
    }
}
