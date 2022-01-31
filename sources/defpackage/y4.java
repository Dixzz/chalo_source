package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import defpackage.e8;
import defpackage.zg;

/* renamed from: y4  reason: default package */
/* compiled from: ComponentActivity */
public class y4 extends Activity implements fh, e8.a {
    private u2<Class<? extends a>, a> mExtraDataMap = new u2<>();
    private gh mLifecycleRegistry = new gh(this);

    @Deprecated
    /* renamed from: y4$a */
    /* compiled from: ComponentActivity */
    public static class a {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e8.a(decorView, keyEvent)) {
            return e8.b(this, decorView, this, keyEvent);
        }
        return true;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !e8.a(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Deprecated
    public <T extends a> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.getOrDefault(cls, null);
    }

    @Override // defpackage.fh
    public zg getLifecycle() {
        throw null;
    }

    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vh.c(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        gh ghVar = this.mLifecycleRegistry;
        zg.b bVar = zg.b.CREATED;
        ghVar.d("markState");
        ghVar.d("setCurrentState");
        ghVar.g(bVar);
        super.onSaveInstanceState(bundle);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: u2<java.lang.Class<? extends y4$a>, y4$a> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void putExtraData(a aVar) {
        this.mExtraDataMap.put(aVar.getClass(), aVar);
    }

    @Override // defpackage.e8.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
