package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();
    public ArrayList<FragmentState> f;
    public ArrayList<String> g;
    public BackStackState[] h;
    public int i;
    public String j = null;
    public ArrayList<String> k = new ArrayList<>();
    public ArrayList<Bundle> l = new ArrayList<>();
    public ArrayList<FragmentManager.LaunchedFragmentInfo> m;

    public class a implements Parcelable.Creator<FragmentManagerState> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    }

    public FragmentManagerState() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f);
        parcel.writeStringList(this.g);
        parcel.writeTypedArray(this.h, i2);
        parcel.writeInt(this.i);
        parcel.writeString(this.j);
        parcel.writeStringList(this.k);
        parcel.writeTypedList(this.l);
        parcel.writeTypedList(this.m);
    }

    public FragmentManagerState(Parcel parcel) {
        this.f = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.g = parcel.createStringArrayList();
        this.h = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.i = parcel.readInt();
        this.j = parcel.readString();
        this.k = parcel.createStringArrayList();
        this.l = parcel.createTypedArrayList(Bundle.CREATOR);
        this.m = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }
}
