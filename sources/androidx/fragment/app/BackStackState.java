package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import defpackage.mf;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();
    public final int[] f;
    public final ArrayList<String> g;
    public final int[] h;
    public final int[] i;
    public final int j;
    public final String k;
    public final int l;
    public final int m;
    public final CharSequence n;
    public final int o;
    public final CharSequence p;
    public final ArrayList<String> q;
    public final ArrayList<String> r;
    public final boolean s;

    public class a implements Parcelable.Creator<BackStackState> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public BackStackState[] newArray(int i) {
            return new BackStackState[i];
        }
    }

    public BackStackState(ke keVar) {
        int size = keVar.f2365a.size();
        this.f = new int[(size * 5)];
        if (keVar.g) {
            this.g = new ArrayList<>(size);
            this.h = new int[size];
            this.i = new int[size];
            int i2 = 0;
            int i3 = 0;
            while (i2 < size) {
                mf.a aVar = keVar.f2365a.get(i2);
                int i4 = i3 + 1;
                this.f[i3] = aVar.f2366a;
                ArrayList<String> arrayList = this.g;
                Fragment fragment = aVar.b;
                arrayList.add(fragment != null ? fragment.mWho : null);
                int[] iArr = this.f;
                int i5 = i4 + 1;
                iArr[i4] = aVar.c;
                int i6 = i5 + 1;
                iArr[i5] = aVar.d;
                int i7 = i6 + 1;
                iArr[i6] = aVar.e;
                iArr[i7] = aVar.f;
                this.h[i2] = aVar.g.ordinal();
                this.i[i2] = aVar.h.ordinal();
                i2++;
                i3 = i7 + 1;
            }
            this.j = keVar.f;
            this.k = keVar.i;
            this.l = keVar.s;
            this.m = keVar.j;
            this.n = keVar.k;
            this.o = keVar.l;
            this.p = keVar.m;
            this.q = keVar.n;
            this.r = keVar.o;
            this.s = keVar.p;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f);
        parcel.writeStringList(this.g);
        parcel.writeIntArray(this.h);
        parcel.writeIntArray(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        TextUtils.writeToParcel(this.n, parcel, 0);
        parcel.writeInt(this.o);
        TextUtils.writeToParcel(this.p, parcel, 0);
        parcel.writeStringList(this.q);
        parcel.writeStringList(this.r);
        parcel.writeInt(this.s ? 1 : 0);
    }

    public BackStackState(Parcel parcel) {
        this.f = parcel.createIntArray();
        this.g = parcel.createStringArrayList();
        this.h = parcel.createIntArray();
        this.i = parcel.createIntArray();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.o = parcel.readInt();
        this.p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.q = parcel.createStringArrayList();
        this.r = parcel.createStringArrayList();
        this.s = parcel.readInt() != 0;
    }
}
