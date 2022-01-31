package defpackage;

import android.view.ViewTreeObserver;

/* renamed from: dc1  reason: default package */
/* compiled from: CollapseOnScrollView */
public class dc1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ int i;
    public final /* synthetic */ ec1 j;

    public dc1(ec1 ec1, int i2, int i3, int i4, int i5) {
        this.j = ec1;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = i5;
    }

    public void onGlobalLayout() {
        this.j.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i2 = this.f;
        if (i2 >= 0) {
            ec1 ec1 = this.j;
            ec1.n = ec1.findViewById(i2);
            ec1 ec12 = this.j;
            ec12.o = ec12.n.getHeight();
        }
        int i3 = this.g;
        if (i3 >= 0) {
            ec1 ec13 = this.j;
            ec13.k = ec13.findViewById(i3);
            ec1 ec14 = this.j;
            ec14.l = ec14.k.getHeight();
            this.j.k.getLayoutParams().height = 0;
        }
        int i4 = this.h;
        if (i4 >= 0) {
            ec1 ec15 = this.j;
            ec15.f = ec15.findViewById(i4);
            this.j.f.getLayoutParams().height = this.j.getHeight() - this.j.o;
        }
        int i5 = this.i;
        if (i5 >= 0) {
            ec1 ec16 = this.j;
            ec16.m = ec16.findViewById(i5);
        }
    }
}
