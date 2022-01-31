package defpackage;

import java.util.ArrayList;

/* renamed from: se  reason: default package */
/* compiled from: DefaultSpecialEffectsController */
public class se implements Runnable {
    public final /* synthetic */ ArrayList f;

    public se(le leVar, ArrayList arrayList) {
        this.f = arrayList;
    }

    public void run() {
        tf.p(this.f, 4);
    }
}
