package defpackage;

/* renamed from: ua1  reason: default package */
/* compiled from: FavoriteTutorialView */
public class ua1 implements Runnable {
    public final /* synthetic */ va1 f;

    public ua1(va1 va1) {
        this.f = va1;
    }

    public void run() {
        va1 va1 = this.f;
        if (va1.e.getParent() != null) {
            va1.b.removeView(va1.e);
        }
    }
}
