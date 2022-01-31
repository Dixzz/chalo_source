package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: nz5  reason: default package */
/* compiled from: PendingPost */
public final class nz5 {
    public static final List<nz5> d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public Object f2626a;
    public sz5 b;
    public nz5 c;

    public nz5(Object obj, sz5 sz5) {
        this.f2626a = obj;
        this.b = sz5;
    }

    public static nz5 a(sz5 sz5, Object obj) {
        List<nz5> list = d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new nz5(obj, sz5);
            }
            nz5 remove = list.remove(size - 1);
            remove.f2626a = obj;
            remove.b = sz5;
            remove.c = null;
            return remove;
        }
    }
}
