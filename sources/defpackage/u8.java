package defpackage;

import android.text.TextUtils;
import android.view.View;
import defpackage.r8;

/* renamed from: u8  reason: default package */
/* compiled from: ViewCompat */
public class u8 extends r8.b<CharSequence> {
    public u8(int i, Class cls, int i2, int i3) {
        super(i, cls, i2, i3);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.r8.b
    public CharSequence b(View view) {
        return view.getStateDescription();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // defpackage.r8.b
    public void c(View view, CharSequence charSequence) {
        view.setStateDescription(charSequence);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.r8.b
    public boolean f(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
