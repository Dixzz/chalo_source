package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new a();
    public final u2<String, Bundle> f;

    public static class a implements Parcelable.ClassLoaderCreator<ExtendableSavedState> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.ClassLoaderCreator
        public ExtendableSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader, null);
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new ExtendableSavedState[i];
        }

        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return new ExtendableSavedState(parcel, null, null);
        }
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.f = new u2<>();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("ExtendableSavedState{");
        i0.append(Integer.toHexString(System.identityHashCode(this)));
        i0.append(" states=");
        i0.append(this.f);
        i0.append("}");
        return i0.toString();
    }

    @Override // androidx.customview.view.AbsSavedState
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        int i2 = this.f.h;
        parcel.writeInt(i2);
        String[] strArr = new String[i2];
        Bundle[] bundleArr = new Bundle[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            strArr[i3] = this.f.h(i3);
            bundleArr[i3] = this.f.l(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcel parcel, ClassLoader classLoader, a aVar) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.f = new u2<>(readInt);
        for (int i = 0; i < readInt; i++) {
            this.f.put(strArr[i], bundleArr[i]);
        }
    }
}
