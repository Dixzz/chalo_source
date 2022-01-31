package defpackage;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* renamed from: xk4  reason: default package */
/* compiled from: BottomAppBar */
public class xk4 extends FloatingActionButton.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f3937a;
    public final /* synthetic */ BottomAppBar b;

    /* renamed from: xk4$a */
    /* compiled from: BottomAppBar */
    public class a extends FloatingActionButton.a {
        public a() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
        public void b(FloatingActionButton floatingActionButton) {
            BottomAppBar.a(xk4.this.b);
        }
    }

    public xk4(BottomAppBar bottomAppBar, int i) {
        this.b = bottomAppBar;
        this.f3937a = i;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.a
    public void a(FloatingActionButton floatingActionButton) {
        BottomAppBar bottomAppBar = this.b;
        int i = this.f3937a;
        int i2 = BottomAppBar.o;
        floatingActionButton.setTranslationX(bottomAppBar.f(i));
        floatingActionButton.m(new a(), true);
    }
}
