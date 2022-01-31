package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.customview.view.AbsSavedState;

public class CheckableImageButton extends AppCompatImageButton implements Checkable {
    public static final int[] i = {16842912};
    public boolean f;
    public boolean g = true;
    public boolean h = true;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean f;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f = parcel.readInt() != 1 ? false : true;
        }
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.imageButtonStyle);
        r8.v(this, new dn4(this));
    }

    public boolean isChecked() {
        return this.f;
    }

    public int[] onCreateDrawableState(int i2) {
        if (!this.f) {
            return super.onCreateDrawableState(i2);
        }
        int[] iArr = i;
        return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i2 + iArr.length), iArr);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.f);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f = this.f;
        return savedState;
    }

    public void setCheckable(boolean z) {
        if (this.g != z) {
            this.g = z;
            sendAccessibilityEvent(0);
        }
    }

    public void setChecked(boolean z) {
        if (this.g && this.f != z) {
            this.f = z;
            refreshDrawableState();
            sendAccessibilityEvent(2048);
        }
    }

    public void setPressable(boolean z) {
        this.h = z;
    }

    public void setPressed(boolean z) {
        if (this.h) {
            super.setPressed(z);
        }
    }

    public void toggle() {
        setChecked(!this.f);
    }
}
