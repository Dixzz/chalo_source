package defpackage;

import android.util.SparseArray;
import android.util.SparseIntArray;

/* renamed from: fl  reason: default package */
/* compiled from: ViewTypeStorage */
public interface fl {

    /* renamed from: fl$a */
    /* compiled from: ViewTypeStorage */
    public static class a implements fl {

        /* renamed from: a  reason: collision with root package name */
        public SparseArray<qk> f1136a = new SparseArray<>();
        public int b = 0;

        /* renamed from: fl$a$a  reason: collision with other inner class name */
        /* compiled from: ViewTypeStorage */
        public class C0022a implements b {

            /* renamed from: a  reason: collision with root package name */
            public SparseIntArray f1137a = new SparseIntArray(1);
            public SparseIntArray b = new SparseIntArray(1);
            public final qk c;

            public C0022a(qk qkVar) {
                this.c = qkVar;
            }

            @Override // defpackage.fl.b
            public int a(int i) {
                int indexOfKey = this.b.indexOfKey(i);
                if (indexOfKey >= 0) {
                    return this.b.valueAt(indexOfKey);
                }
                StringBuilder j0 = hj1.j0("requested global type ", i, " does not belong to the adapter:");
                j0.append(this.c.c);
                throw new IllegalStateException(j0.toString());
            }

            @Override // defpackage.fl.b
            public int b(int i) {
                int indexOfKey = this.f1137a.indexOfKey(i);
                if (indexOfKey > -1) {
                    return this.f1137a.valueAt(indexOfKey);
                }
                a aVar = a.this;
                qk qkVar = this.c;
                int i2 = aVar.b;
                aVar.b = i2 + 1;
                aVar.f1136a.put(i2, qkVar);
                this.f1137a.put(i, i2);
                this.b.put(i2, i);
                return i2;
            }
        }
    }

    /* renamed from: fl$b */
    /* compiled from: ViewTypeStorage */
    public interface b {
        int a(int i);

        int b(int i);
    }
}
