package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: dt4  reason: default package */
public final class dt4 {
    public static final nv4 g = new nv4("ExtractorSessionStoreView");

    /* renamed from: a  reason: collision with root package name */
    public final bs4 f888a;
    public final kw4<vu4> b;
    public final ss4 c;
    public final kw4<Executor> d;
    public final Map<Integer, at4> e = new HashMap();
    public final ReentrantLock f = new ReentrantLock();

    public dt4(bs4 bs4, kw4<vu4> kw4, ss4 ss4, kw4<Executor> kw42) {
        this.f888a = bs4;
        this.b = kw4;
        this.c = ss4;
        this.d = kw42;
    }

    public static String d(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new os4("Session without pack received.");
    }

    public final void a(int i) {
        b(new ws4(this, i));
    }

    public final <T> T b(ct4<T> ct4) {
        try {
            this.f.lock();
            return ct4.a();
        } finally {
            this.f.unlock();
        }
    }

    public final at4 c(int i) {
        Map<Integer, at4> map = this.e;
        Integer valueOf = Integer.valueOf(i);
        at4 at4 = map.get(valueOf);
        if (at4 != null) {
            return at4;
        }
        throw new os4(String.format("Could not find session %d while trying to get it", valueOf), i);
    }
}
