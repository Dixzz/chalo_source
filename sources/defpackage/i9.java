package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import defpackage.l9;

/* renamed from: i9  reason: default package */
/* compiled from: InputConnectionCompat */
public class i9 extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k9 f1493a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i9(InputConnection inputConnection, boolean z, k9 k9Var) {
        super(inputConnection, z);
        this.f1493a = k9Var;
    }

    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        k9 k9Var = this.f1493a;
        l9 l9Var = null;
        if (inputContentInfo != null && Build.VERSION.SDK_INT >= 25) {
            l9Var = new l9(new l9.a(inputContentInfo));
        }
        if (k9Var.onCommitContent(l9Var, i, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
