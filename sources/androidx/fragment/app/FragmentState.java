package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();
    public final String f;
    public final String g;
    public final boolean h;
    public final int i;
    public final int j;
    public final String k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final Bundle o;
    public final boolean p;
    public final int q;
    public Bundle r;

    public class a implements Parcelable.Creator<FragmentState> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f = fragment.getClass().getName();
        this.g = fragment.mWho;
        this.h = fragment.mFromLayout;
        this.i = fragment.mFragmentId;
        this.j = fragment.mContainerId;
        this.k = fragment.mTag;
        this.l = fragment.mRetainInstance;
        this.m = fragment.mRemoving;
        this.n = fragment.mDetached;
        this.o = fragment.mArguments;
        this.p = fragment.mHidden;
        this.q = fragment.mMaxState.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f);
        sb.append(" (");
        sb.append(this.g);
        sb.append(")}:");
        if (this.h) {
            sb.append(" fromLayout");
        }
        if (this.j != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.j));
        }
        String str = this.k;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.k);
        }
        if (this.l) {
            sb.append(" retainInstance");
        }
        if (this.m) {
            sb.append(" removing");
        }
        if (this.n) {
            sb.append(" detached");
        }
        if (this.p) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l ? 1 : 0);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeInt(this.n ? 1 : 0);
        parcel.writeBundle(this.o);
        parcel.writeInt(this.p ? 1 : 0);
        parcel.writeBundle(this.r);
        parcel.writeInt(this.q);
    }

    public FragmentState(Parcel parcel) {
        this.f = parcel.readString();
        this.g = parcel.readString();
        boolean z = true;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt() != 0;
        this.m = parcel.readInt() != 0;
        this.n = parcel.readInt() != 0;
        this.o = parcel.readBundle();
        this.p = parcel.readInt() == 0 ? false : z;
        this.r = parcel.readBundle();
        this.q = parcel.readInt();
    }
}
