package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

/* renamed from: fg5  reason: default package */
/* compiled from: Receiver */
public class fg5 {

    /* renamed from: a  reason: collision with root package name */
    public dg5 f1121a;
    public final Context b;
    public final bg5 c;
    public final ag5 d;
    public int e;
    public boolean f;
    public ArrayList<short[]> g;
    public int h;
    public boolean i;

    public fg5(Context context, bg5 bg5) {
        this.e = -1;
        this.f = false;
        this.h = 48000;
        this.i = false;
        this.e = 0;
        this.b = context;
        this.c = bg5;
        this.d = new ag5(context);
        new Handler(Looper.getMainLooper());
        this.g = new ArrayList<>();
        this.f1121a = new dg5(context, false);
    }
}
