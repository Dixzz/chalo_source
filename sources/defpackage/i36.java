package defpackage;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;

/* renamed from: i36  reason: default package */
/* compiled from: Socket */
public class i36 implements q26 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean[] f1471a;
    public final /* synthetic */ int b;
    public final /* synthetic */ e36 c;

    /* renamed from: i36$a */
    /* compiled from: Socket */
    public class a implements Runnable {
        public final /* synthetic */ Object[] f;

        public a(Object[] objArr) {
            this.f = objArr;
        }

        public void run() {
            boolean[] zArr = i36.this.f1471a;
            if (!zArr[0]) {
                zArr[0] = true;
                Logger logger = e36.k;
                if (logger.isLoggable(Level.FINE)) {
                    Object[] objArr = this.f;
                    if (objArr.length == 0) {
                        objArr = null;
                    }
                    logger.fine(String.format("sending ack %s", objArr));
                }
                JSONArray jSONArray = new JSONArray();
                for (Object obj : this.f) {
                    jSONArray.put(obj);
                }
                a56 a56 = new a56(3, jSONArray);
                i36 i36 = i36.this;
                a56.b = i36.b;
                e36.g(i36.c, a56);
            }
        }
    }

    public i36(e36 e36, boolean[] zArr, int i, e36 e362) {
        this.f1471a = zArr;
        this.b = i;
        this.c = e362;
    }

    @Override // defpackage.q26
    public void a(Object... objArr) {
        c56.a(new a(objArr));
    }
}
