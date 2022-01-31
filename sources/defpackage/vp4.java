package defpackage;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: vp4  reason: default package */
/* compiled from: EndIconDelegate */
public abstract class vp4 {

    /* renamed from: a  reason: collision with root package name */
    public TextInputLayout f3673a;
    public Context b;
    public CheckableImageButton c;

    public vp4(TextInputLayout textInputLayout) {
        this.f3673a = textInputLayout;
        this.b = textInputLayout.getContext();
        this.c = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public boolean b(int i) {
        return true;
    }

    public void c(boolean z) {
    }

    public boolean d() {
        return false;
    }
}
