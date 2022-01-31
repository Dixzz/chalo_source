package defpackage;

import com.truecaller.android.sdk.clients.CustomDataBundle;

/* renamed from: wg5  reason: default package */
/* compiled from: SdkScopeEvaluator */
public class wg5 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3777a;
    public final int b;
    public CustomDataBundle c;

    public wg5(int i, int i2, CustomDataBundle customDataBundle) {
        this.f3777a = i;
        this.b = i2;
        this.c = customDataBundle;
    }

    public final boolean a(int i) {
        return (this.f3777a & i) == i;
    }
}
