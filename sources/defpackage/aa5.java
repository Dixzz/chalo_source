package defpackage;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: aa5  reason: default package */
/* compiled from: DecoderThread */
public class aa5 {
    public static final String k = "aa5";

    /* renamed from: a  reason: collision with root package name */
    public ka5 f141a;
    public HandlerThread b;
    public Handler c;
    public x95 d;
    public Handler e;
    public Rect f;
    public boolean g = false;
    public final Object h = new Object();
    public final Handler.Callback i = new a();
    public final ta5 j = new b();

    /* renamed from: aa5$a */
    /* compiled from: DecoderThread */
    public class a implements Handler.Callback {
        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0089  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x00ad  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean handleMessage(android.os.Message r22) {
            /*
            // Method dump skipped, instructions count: 362
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.aa5.a.handleMessage(android.os.Message):boolean");
        }
    }

    /* renamed from: aa5$b */
    /* compiled from: DecoderThread */
    public class b implements ta5 {
        public b() {
        }
    }

    public aa5(ka5 ka5, x95 x95, Handler handler) {
        hd3.g3();
        this.f141a = ka5;
        this.d = x95;
        this.e = handler;
    }
}
