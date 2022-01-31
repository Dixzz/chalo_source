package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;

/* renamed from: xe6  reason: default package */
/* compiled from: StateFlow.kt */
public final class xe6<T> extends cf6<ze6> implements ve6<T>, Object<T> {
    private volatile /* synthetic */ Object _state;
    public int i;

    @y66(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {336, 348, 353}, m = "collect")
    /* renamed from: xe6$a */
    /* compiled from: StateFlow.kt */
    public static final class a extends w66 {
        public Object f;
        public Object g;
        public Object h;
        public Object i;
        public Object j;
        public /* synthetic */ Object k;
        public final /* synthetic */ xe6<T> l;
        public int m;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(xe6<T> xe6, k66<? super a> k66) {
            super(k66);
            this.l = xe6;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.k = obj;
            this.m |= RtlSpacingHelper.UNDEFINED;
            return this.l.b(null, this);
        }
    }

    public xe6(Object obj) {
        this._state = obj;
    }

    public Object a(T t, k66<? super s56> k66) {
        if (t == null) {
            t = (T) hf6.f1367a;
        }
        c(null, t);
        return s56.f3190a;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: java.util.concurrent.atomic.AtomicReferenceFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x017e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(defpackage.re6<? super T> r18, defpackage.k66<? super defpackage.s56> r19) {
        /*
        // Method dump skipped, instructions count: 419
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xe6.b(re6, k66):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v1, resolved type: java.util.concurrent.atomic.AtomicReferenceFieldUpdater */
    /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: java.util.concurrent.atomic.AtomicReferenceFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
        r11 = (defpackage.ze6[]) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0027, code lost:
        if (r11 != null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        r2 = r11.length;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002c, code lost:
        if (r3 >= r2) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        r4 = r11[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
        if (r4 != null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
        r5 = r4._state;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        if (r5 != null) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0038, code lost:
        r6 = defpackage.ye6.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        if (r5 != r6) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003d, code lost:
        r7 = defpackage.ye6.f4040a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        if (r5 != r7) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        if (defpackage.ze6.f4165a.compareAndSet(r4, r5, r6) == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
        if (defpackage.ze6.f4165a.compareAndSet(r4, r5, r7) == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0052, code lost:
        ((defpackage.sa6) r5).resumeWith(defpackage.s56.f3190a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0059, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x005c, code lost:
        monitor-enter(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r11 = r9.i;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005f, code lost:
        if (r11 != r10) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0061, code lost:
        r9.i = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0064, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0065, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0066, code lost:
        r10 = r9.f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0068, code lost:
        monitor-exit(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0069, code lost:
        r11 = r10;
        r10 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c(java.lang.Object r10, java.lang.Object r11) {
        /*
        // Method dump skipped, instructions count: 121
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xe6.c(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // defpackage.ve6
    public T getValue() {
        dg6 dg6 = hf6.f1367a;
        T t = (T) this._state;
        if (t == dg6) {
            return null;
        }
        return t;
    }

    @Override // defpackage.ve6
    public void setValue(T t) {
        c(null, t);
    }
}
