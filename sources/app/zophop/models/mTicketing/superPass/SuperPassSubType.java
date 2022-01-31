package app.zophop.models.mTicketing.superPass;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SuperPassSubType.kt */
public enum SuperPassSubType implements Parcelable {
    MAGIC_SUPER_PASS,
    RIDE_BASED_SUPER_PASS;
    
    public static final Parcelable.Creator<SuperPassSubType> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);

    /* compiled from: SuperPassSubType.kt */
    public static final class Companion {

        /* compiled from: SuperPassSubType.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2};

            static {
                SuperPassSubType.values();
                SuperPassSubType superPassSubType = SuperPassSubType.MAGIC_SUPER_PASS;
                SuperPassSubType superPassSubType2 = SuperPassSubType.RIDE_BASED_SUPER_PASS;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        public final SuperPassSubType fromString(String str) {
            n86.e(str, "superPassSubTypeString");
            if (n86.a(str, "magicPass")) {
                return SuperPassSubType.MAGIC_SUPER_PASS;
            }
            if (n86.a(str, SuperPassConstants.SUBTYPE_RIDE_PASS)) {
                return SuperPassSubType.RIDE_BASED_SUPER_PASS;
            }
            return SuperPassSubType.MAGIC_SUPER_PASS;
        }

        public final String toString(SuperPassSubType superPassSubType) {
            n86.e(superPassSubType, "superPassSubType");
            int ordinal = superPassSubType.ordinal();
            if (ordinal == 0) {
                return "magicPass";
            }
            if (ordinal == 1) {
                return SuperPassConstants.SUBTYPE_RIDE_PASS;
            }
            throw new l56();
        }
    }

    /* compiled from: SuperPassSubType.kt */
    public static final class Creator implements Parcelable.Creator<SuperPassSubType> {
        @Override // android.os.Parcelable.Creator
        public final SuperPassSubType createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return SuperPassSubType.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SuperPassSubType[] newArray(int i) {
            return new SuperPassSubType[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(name());
    }
}
