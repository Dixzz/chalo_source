package com.urbanairship.actions;

import android.os.Parcel;
import android.os.Parcelable;
import com.urbanairship.json.JsonValue;

public class ActionValue implements cu5, Parcelable {
    public static final Parcelable.Creator<ActionValue> CREATOR = new a();
    public final JsonValue f;

    public static class a implements Parcelable.Creator<ActionValue> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public ActionValue createFromParcel(Parcel parcel) {
            return new ActionValue((JsonValue) parcel.readParcelable(JsonValue.class.getClassLoader()));
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public ActionValue[] newArray(int i) {
            return new ActionValue[i];
        }
    }

    public ActionValue(JsonValue jsonValue) {
        this.f = jsonValue == null ? JsonValue.g : jsonValue;
    }

    public static ActionValue e(boolean z) {
        return new ActionValue(JsonValue.x(Boolean.valueOf(z)));
    }

    public yt5 a() {
        return this.f.f();
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        return this.f;
    }

    public zt5 c() {
        return this.f.h();
    }

    public String d() {
        return this.f.i();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ActionValue) {
            return this.f.equals(((ActionValue) obj).f);
        }
        return false;
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public String toString() {
        return this.f.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f, i);
    }

    public ActionValue() {
        this.f = JsonValue.g;
    }
}
