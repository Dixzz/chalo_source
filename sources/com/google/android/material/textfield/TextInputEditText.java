package com.google.android.material.textfield;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.R;
import java.util.Locale;

public class TextInputEditText extends AppCompatEditText {
    public final Rect f = new Rect();
    public boolean g;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputEditText(android.content.Context r11, android.util.AttributeSet r12) {
        /*
            r10 = this;
            int r6 = com.google.android.material.R.attr.editTextStyle
            r7 = 0
            android.content.Context r0 = defpackage.bq4.a(r11, r12, r6, r7)
            r10.<init>(r0, r12, r6)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.f = r0
            int[] r8 = com.google.android.material.R.styleable.TextInputEditText
            int r9 = com.google.android.material.R.style.Widget_Design_TextInputEditText
            int[] r5 = new int[r7]
            defpackage.mn4.a(r11, r12, r6, r9)
            r0 = r11
            r1 = r12
            r2 = r8
            r3 = r6
            r4 = r9
            defpackage.mn4.b(r0, r1, r2, r3, r4, r5)
            android.content.res.TypedArray r11 = r11.obtainStyledAttributes(r12, r8, r6, r9)
            int r12 = com.google.android.material.R.styleable.TextInputEditText_textInputLayoutFocusedRectEnabled
            boolean r12 = r11.getBoolean(r12, r7)
            r10.setTextInputLayoutFocusedRectEnabled(r12)
            r11.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputEditText.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private CharSequence getHintFromLayout() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    private TextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.g && rect != null) {
            textInputLayout.getFocusedRect(this.f);
            rect.bottom = this.f.bottom;
        }
    }

    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (!(textInputLayout == null || !this.g || rect == null)) {
            textInputLayout.getGlobalVisibleRect(this.f, point);
            rect.bottom = this.f.bottom;
        }
        return globalVisibleRect;
    }

    public CharSequence getHint() {
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !textInputLayout.F) {
            return super.getHint();
        }
        return textInputLayout.getHint();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.F && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return onCreateInputConnection;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT < 23 && textInputLayout != null) {
            Editable text = getText();
            CharSequence hint = textInputLayout.getHint();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            setLabelFor(R.id.textinput_helper_text);
            String str = "";
            String charSequence = z2 ? hint.toString() : str;
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append((Object) text);
                if (!TextUtils.isEmpty(charSequence)) {
                    str = hj1.S(", ", charSequence);
                }
                sb.append(str);
                str = sb.toString();
            } else if (!TextUtils.isEmpty(charSequence)) {
                str = charSequence;
            }
            accessibilityNodeInfo.setText(str);
        }
    }

    public boolean requestRectangleOnScreen(Rect rect) {
        boolean requestRectangleOnScreen = super.requestRectangleOnScreen(rect);
        TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.g) {
            this.f.set(0, textInputLayout.getHeight() - getResources().getDimensionPixelOffset(R.dimen.mtrl_edittext_rectangle_top_offset), textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.f, true);
        }
        return requestRectangleOnScreen;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.g = z;
    }
}
