package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: ef  reason: default package */
/* compiled from: FragmentHostCallback */
public abstract class ef<E> extends bf {
    public final Activity f;
    public final Context g;
    public final Handler h;
    public final FragmentManager i = new hf();

    public ef(ve veVar) {
        Handler handler = new Handler();
        this.f = veVar;
        h.o(veVar, "context == null");
        this.g = veVar;
        h.o(handler, "handler == null");
        this.h = handler;
    }

    public abstract void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract E e();

    public abstract LayoutInflater f();

    public abstract boolean g(Fragment fragment);

    public abstract boolean h(String str);

    public abstract void i();
}
