package defpackage;

import android.view.View;
import defpackage.r8;

/* renamed from: s8  reason: default package */
/* compiled from: ViewCompat */
public class s8 extends r8.b<Boolean> {
    public s8(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.r8.b
    public Boolean b(View view) {
        return Boolean.valueOf(view.isScreenReaderFocusable());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.view.View, java.lang.Object] */
    @Override // defpackage.r8.b
    public void c(View view, Boolean bool) {
        view.setScreenReaderFocusable(bool.booleanValue());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.r8.b
    public boolean f(Boolean bool, Boolean bool2) {
        return !a(bool, bool2);
    }
}
