package defpackage;

import android.view.View;

/* renamed from: tk4  reason: default package */
/* compiled from: ViewOffsetHelper */
public class tk4 {

    /* renamed from: a  reason: collision with root package name */
    public final View f3370a;
    public int b;
    public int c;
    public int d;
    public int e;

    public tk4(View view) {
        this.f3370a = view;
    }

    public void a() {
        View view = this.f3370a;
        r8.o(view, this.d - (view.getTop() - this.b));
        View view2 = this.f3370a;
        r8.n(view2, this.e - (view2.getLeft() - this.c));
    }

    public boolean b(int i) {
        if (this.d == i) {
            return false;
        }
        this.d = i;
        a();
        return true;
    }
}
