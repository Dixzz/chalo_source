package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;

/* compiled from: PassApplicationActionRequired.kt */
public enum PassApplicationActionRequired implements Parcelable {
    INVALID("invalid"),
    FRESH("fresh"),
    REAPPLY("reapply"),
    REINITIATE("reInitiate");
    
    public static final Parcelable.Creator<PassApplicationActionRequired> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    private final String s;

    /* compiled from: PassApplicationActionRequired.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        public final String convertPassApplicationActionRequiredToString(PassApplicationActionRequired passApplicationActionRequired) {
            n86.e(passApplicationActionRequired, "lPassApplicationActionRequired");
            String json = new Gson().toJson(passApplicationActionRequired);
            n86.d(json, "lGson.toJson(lPassApplicationActionRequired)");
            return json;
        }

        public final PassApplicationActionRequired getPassApplicationActionRequiredFromString(String str) {
            n86.e(str, "lPassApplicationActionRequiredString");
            Object fromJson = new Gson().fromJson(str, PassApplicationActionRequired.class);
            n86.d(fromJson, "lGson.fromJson(lPassAppl…tionRequired::class.java)");
            return (PassApplicationActionRequired) fromJson;
        }
    }

    /* compiled from: PassApplicationActionRequired.kt */
    public static final class Creator implements Parcelable.Creator<PassApplicationActionRequired> {
        @Override // android.os.Parcelable.Creator
        public final PassApplicationActionRequired createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return PassApplicationActionRequired.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final PassApplicationActionRequired[] newArray(int i) {
            return new PassApplicationActionRequired[i];
        }
    }

    private PassApplicationActionRequired(String str) {
        this.s = str;
    }

    public int describeContents() {
        return 0;
    }

    public PassApplicationActionRequired fromJsonString(String str) {
        if (str == null) {
            return null;
        }
        return (PassApplicationActionRequired) hj1.s(str, PassApplicationActionRequired.class);
    }

    public final String getS() {
        return this.s;
    }

    public String toConverterString(PassApplicationActionRequired passApplicationActionRequired) {
        if (passApplicationActionRequired == null) {
            return null;
        }
        return new Gson().toJson(passApplicationActionRequired);
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(name());
    }
}
