package app.zophop.models.mTicketing;

import android.os.Parcel;
import android.os.Parcelable;
import app.zophop.R;

/* compiled from: Gender.kt */
public enum Gender implements Parcelable {
    MALE("male", R.string.male),
    FEMALE("female", R.string.female),
    OTHER("other", R.string.other_sex),
    NULL("", R.string.not_set);
    
    public static final Parcelable.Creator<Gender> CREATOR = new Creator();
    public static final Companion Companion = new Companion(null);
    private final String _value;
    private final int resId;

    /* compiled from: Gender.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j86 j86) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final app.zophop.models.mTicketing.Gender fromString(java.lang.String r7) {
            /*
                r6 = this;
                if (r7 == 0) goto L_0x0024
                app.zophop.models.mTicketing.Gender[] r0 = app.zophop.models.mTicketing.Gender.values()
                r1 = 0
                r2 = 4
            L_0x0008:
                if (r1 >= r2) goto L_0x0024
                r3 = r0[r1]
                int r1 = r1 + 1
                java.lang.String r4 = r3.toString()
                r5 = 1
                boolean r4 = defpackage.ea6.f(r7, r4, r5)
                if (r4 != 0) goto L_0x0023
                java.lang.String r4 = r3.name()
                boolean r4 = defpackage.ea6.f(r7, r4, r5)
                if (r4 == 0) goto L_0x0008
            L_0x0023:
                return r3
            L_0x0024:
                app.zophop.models.mTicketing.Gender r7 = app.zophop.models.mTicketing.Gender.MALE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: app.zophop.models.mTicketing.Gender.Companion.fromString(java.lang.String):app.zophop.models.mTicketing.Gender");
        }
    }

    /* compiled from: Gender.kt */
    public static final class Creator implements Parcelable.Creator<Gender> {
        @Override // android.os.Parcelable.Creator
        public final Gender createFromParcel(Parcel parcel) {
            n86.e(parcel, "parcel");
            return Gender.valueOf(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Gender[] newArray(int i) {
            return new Gender[i];
        }
    }

    private Gender(String str, int i) {
        this._value = str;
        this.resId = i;
    }

    public static final Gender fromString(String str) {
        return Companion.fromString(str);
    }

    public int describeContents() {
        return 0;
    }

    public final int getResId() {
        return this.resId;
    }

    public String toString() {
        return this._value;
    }

    public void writeToParcel(Parcel parcel, int i) {
        n86.e(parcel, "out");
        parcel.writeString(name());
    }
}
