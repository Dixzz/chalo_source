package app.zophop.sharedflowevents;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: TrillSoundValidationResponse.kt */
public final class TrillSoundValidationResponse implements Parcelable {
    public static final Parcelable.Creator<TrillSoundValidationResponse> CREATOR = new a();
    public final a90 f;
    public final int g;

    /* compiled from: TrillSoundValidationResponse.kt */
    public static final class a implements Parcelable.Creator<TrillSoundValidationResponse> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public TrillSoundValidationResponse createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return new TrillSoundValidationResponse(a90.valueOf(parcel.readString()), parcel.readInt());
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public TrillSoundValidationResponse[] newArray(int i) {
            return new TrillSoundValidationResponse[i];
        }
    }

    public TrillSoundValidationResponse(a90 a90, int i) {
        n86.e(a90, "soundValidation");
        this.f = a90;
        this.g = i;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrillSoundValidationResponse)) {
            return false;
        }
        TrillSoundValidationResponse trillSoundValidationResponse = (TrillSoundValidationResponse) obj;
        return this.f == trillSoundValidationResponse.f && this.g == trillSoundValidationResponse.g;
    }

    public int hashCode() {
        return (this.f.hashCode() * 31) + this.g;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("TrillSoundValidationResponse(soundValidation=");
        i0.append(this.f);
        i0.append(", code=");
        return hj1.W(i0, this.g, ')');
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(this.f.name());
        parcel.writeInt(this.g);
    }
}
