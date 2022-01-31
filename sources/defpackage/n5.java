package defpackage;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;

/* renamed from: n5  reason: default package */
/* compiled from: RemoteInput */
public final class n5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2515a;
    public final CharSequence b;
    public final CharSequence[] c;
    public final boolean d;
    public final int e;
    public final Bundle f;
    public final Set<String> g;

    public static RemoteInput[] a(n5[] n5VarArr) {
        Set<String> set;
        if (n5VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[n5VarArr.length];
        for (int i = 0; i < n5VarArr.length; i++) {
            n5 n5Var = n5VarArr[i];
            int i2 = Build.VERSION.SDK_INT;
            RemoteInput.Builder addExtras = new RemoteInput.Builder(n5Var.f2515a).setLabel(n5Var.b).setChoices(n5Var.c).setAllowFreeFormInput(n5Var.d).addExtras(n5Var.f);
            if (i2 >= 26 && (set = n5Var.g) != null) {
                for (String str : set) {
                    addExtras.setAllowDataType(str, true);
                }
            }
            if (i2 >= 29) {
                addExtras.setEditChoicesBeforeSending(n5Var.e);
            }
            remoteInputArr[i] = addExtras.build();
        }
        return remoteInputArr;
    }
}
