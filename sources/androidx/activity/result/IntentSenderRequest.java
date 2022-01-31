package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();
    public final IntentSender f;
    public final Intent g;
    public final int h;
    public final int i;

    public class a implements Parcelable.Creator<IntentSenderRequest> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest[] newArray(int i) {
            return new IntentSenderRequest[i];
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i2, int i3) {
        this.f = intentSender;
        this.g = intent;
        this.h = i2;
        this.i = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f, i2);
        parcel.writeParcelable(this.g, i2);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
    }

    public IntentSenderRequest(Parcel parcel) {
        this.f = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.g = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.h = parcel.readInt();
        this.i = parcel.readInt();
    }
}
