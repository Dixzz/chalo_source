package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MaterialComponentsViewInflater extends p0 {
    @Override // defpackage.p0
    public AppCompatAutoCompleteTextView a(Context context, AttributeSet attributeSet) {
        return new yp4(context, attributeSet);
    }

    @Override // defpackage.p0
    public AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // defpackage.p0
    public AppCompatCheckBox c(Context context, AttributeSet attributeSet) {
        return new kl4(context, attributeSet);
    }

    @Override // defpackage.p0
    public AppCompatRadioButton d(Context context, AttributeSet attributeSet) {
        return new tn4(context, attributeSet);
    }

    @Override // defpackage.p0
    public AppCompatTextView e(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
