package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.j;

@SuppressLint({"BanParcelableUsage"})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();
    public j f;

    public class a implements Parcelable.Creator<ResultReceiver> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    }

    public class b extends j.a {
        public b() {
        }
    }

    public ResultReceiver(Parcel parcel) {
        j jVar;
        IBinder readStrongBinder = parcel.readStrongBinder();
        int i = j.a.f;
        if (readStrongBinder == null) {
            jVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof j)) {
                jVar = new j.a.C0038a(readStrongBinder);
            } else {
                jVar = (j) queryLocalInterface;
            }
        }
        this.f = jVar;
    }

    public void a(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f == null) {
                this.f = new b();
            }
            parcel.writeStrongBinder(this.f.asBinder());
        }
    }
}
