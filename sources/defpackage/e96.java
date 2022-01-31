package defpackage;

import java.util.Random;

/* renamed from: e96  reason: default package */
/* compiled from: PlatformRandom.kt */
public abstract class e96 extends g96 {
    @Override // defpackage.g96
    public int a() {
        return b().nextInt();
    }

    public abstract Random b();
}
