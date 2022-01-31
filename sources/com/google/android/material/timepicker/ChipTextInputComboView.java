package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputLayout;

public class ChipTextInputComboView extends FrameLayout implements Checkable {
    public final Chip f;
    public final TextInputLayout g;
    public final EditText h;
    public TextWatcher i;

    public class b extends ln4 {
        public b(a aVar) {
        }

        @Override // defpackage.ln4
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView chipTextInputComboView = ChipTextInputComboView.this;
                chipTextInputComboView.f.setText(ChipTextInputComboView.a(chipTextInputComboView, "00"));
                return;
            }
            ChipTextInputComboView chipTextInputComboView2 = ChipTextInputComboView.this;
            chipTextInputComboView2.f.setText(ChipTextInputComboView.a(chipTextInputComboView2, editable));
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f = chip;
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.g = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.h = editText;
        editText.setVisibility(4);
        b bVar = new b(null);
        this.i = bVar;
        editText.addTextChangedListener(bVar);
        b();
        addView(chip);
        addView(textInputLayout);
        TextView textView = (TextView) findViewById(R.id.material_label);
        editText.setSaveEnabled(false);
    }

    public static String a(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        return String.format(chipTextInputComboView.getResources().getConfiguration().locale, "%02d", Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
    }

    public final void b() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.h.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public boolean isChecked() {
        return this.f.isChecked();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    public void setChecked(boolean z) {
        this.f.setChecked(z);
        int i2 = 0;
        this.h.setVisibility(z ? 0 : 4);
        Chip chip = this.f;
        if (z) {
            i2 = 8;
        }
        chip.setVisibility(i2);
        if (isChecked()) {
            this.h.requestFocus();
            if (!TextUtils.isEmpty(this.h.getText())) {
                EditText editText = this.h;
                editText.setSelection(editText.getText().length());
            }
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f.setOnClickListener(onClickListener);
    }

    public void setTag(int i2, Object obj) {
        this.f.setTag(i2, obj);
    }

    public void toggle() {
        this.f.toggle();
    }
}
