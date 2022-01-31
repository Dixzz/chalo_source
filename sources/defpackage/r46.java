package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.appindexing.Indexable;
import defpackage.hi6;
import defpackage.i46;
import defpackage.ji6;
import defpackage.t46;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.TreeMap;
import java.util.logging.Logger;

/* renamed from: r46  reason: default package */
/* compiled from: WebSocket */
public class r46 extends i46 {
    public static final Logger o = Logger.getLogger(l46.class.getName());
    public ri6 n;

    /* renamed from: r46$a */
    /* compiled from: WebSocket */
    public class a extends si6 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r46 f3041a;

        public a(r46 r46, r46 r462) {
            this.f3041a = r462;
        }
    }

    /* renamed from: r46$b */
    /* compiled from: WebSocket */
    public class b implements Runnable {
        public final /* synthetic */ r46 f;

        /* renamed from: r46$b$a */
        /* compiled from: WebSocket */
        public class a implements Runnable {
            public a() {
            }

            public void run() {
                r46 r46 = b.this.f;
                r46.b = true;
                r46.a("drain", new Object[0]);
            }
        }

        public b(r46 r46, r46 r462) {
            this.f = r462;
        }

        public void run() {
            c56.b(new a());
        }
    }

    /* renamed from: r46$c */
    /* compiled from: WebSocket */
    public class c implements t46.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r46 f3042a;
        public final /* synthetic */ int[] b;
        public final /* synthetic */ Runnable c;

        public c(r46 r46, r46 r462, int[] iArr, Runnable runnable) {
            this.f3042a = r462;
            this.b = iArr;
            this.c = runnable;
        }

        @Override // defpackage.t46.b
        public void a(Object obj) {
            try {
                if (obj instanceof String) {
                    this.f3042a.n.send((String) obj);
                } else if (obj instanceof byte[]) {
                    ri6 ri6 = this.f3042a.n;
                    byte[] bArr = (byte[]) obj;
                    zm6 zm6 = zm6.i;
                    n86.f(bArr, "data");
                    byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                    n86.b(copyOf, "java.util.Arrays.copyOf(this, size)");
                    ri6.a(new zm6(copyOf));
                }
            } catch (IllegalStateException unused) {
                r46.o.fine("websocket closed before we could write");
            }
            int[] iArr = this.b;
            int i = iArr[0] - 1;
            iArr[0] = i;
            if (i == 0) {
                this.c.run();
            }
        }
    }

    public r46(i46.c cVar) {
        super(cVar);
        this.c = "websocket";
    }

    @Override // defpackage.i46
    public void f() {
        ri6 ri6 = this.n;
        if (ri6 != null) {
            ri6.close(Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, "");
            this.n = null;
        }
    }

    @Override // defpackage.i46
    public void g() {
        String str;
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        boolean z = false;
        a("requestHeaders", treeMap);
        Object obj = this.l;
        if (obj == null) {
            obj = new hi6();
        }
        ji6.a aVar = new ji6.a();
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str2 = this.e ? "wss" : "ws";
        if (this.g <= 0 || ((!"wss".equals(str2) || this.g == 443) && (!"ws".equals(str2) || this.g == 80))) {
            str = "";
        } else {
            StringBuilder i0 = hj1.i0(ProductDiscountsObject.KEY_DELIMITER);
            i0.append(this.g);
            str = i0.toString();
        }
        if (this.f) {
            map.put(this.j, f56.b());
        }
        String M0 = hd3.M0(map);
        if (M0.length() > 0) {
            M0 = hj1.S("?", M0);
        }
        boolean contains = this.i.contains(ProductDiscountsObject.KEY_DELIMITER);
        StringBuilder k0 = hj1.k0(str2, "://");
        k0.append(contains ? hj1.a0(hj1.i0("["), this.i, "]") : this.i);
        k0.append(str);
        k0.append(this.h);
        k0.append(M0);
        aVar.i(k0.toString());
        for (Map.Entry entry : treeMap.entrySet()) {
            for (String str3 : (List) entry.getValue()) {
                aVar.a((String) entry.getKey(), str3);
            }
        }
        ji6 b2 = aVar.b();
        a aVar2 = new a(this, this);
        hi6 hi6 = (hi6) obj;
        Objects.requireNonNull(hi6);
        n86.f(b2, "request");
        n86.f(aVar2, "listener");
        km6 km6 = new km6(ij6.h, b2, aVar2, new Random(), (long) hi6.G, null, hi6.H);
        n86.f(hi6, "client");
        if (km6.t.b("Sec-WebSocket-Extensions") != null) {
            km6.h(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
        } else {
            hi6.a b3 = hi6.b();
            xh6 xh6 = xh6.f3929a;
            n86.f(xh6, "eventListener");
            byte[] bArr = vi6.f3652a;
            n86.f(xh6, "$this$asFactory");
            b3.e = new ti6(xh6);
            List<ii6> list = km6.z;
            n86.f(list, "protocols");
            List B = y56.B(list);
            ii6 ii6 = ii6.H2_PRIOR_KNOWLEDGE;
            ArrayList arrayList = (ArrayList) B;
            if (arrayList.contains(ii6) || arrayList.contains(ii6.HTTP_1_1)) {
                if (!arrayList.contains(ii6) || arrayList.size() <= 1) {
                    z = true;
                }
                if (!z) {
                    throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + B).toString());
                } else if (!(!arrayList.contains(ii6.HTTP_1_0))) {
                    throw new IllegalArgumentException(("protocols must not contain http/1.0: " + B).toString());
                } else if (!arrayList.contains(null)) {
                    arrayList.remove(ii6.SPDY_3);
                    if (!n86.a(B, b3.t)) {
                        b3.D = null;
                    }
                    List<? extends ii6> unmodifiableList = Collections.unmodifiableList(B);
                    n86.b(unmodifiableList, "Collections.unmodifiableList(protocolsCopy)");
                    b3.t = unmodifiableList;
                    hi6 hi62 = new hi6(b3);
                    ji6.a aVar3 = new ji6.a(km6.t);
                    aVar3.d("Upgrade", "websocket");
                    aVar3.d("Connection", "Upgrade");
                    aVar3.d("Sec-WebSocket-Key", km6.f2081a);
                    aVar3.d("Sec-WebSocket-Version", "13");
                    aVar3.d("Sec-WebSocket-Extensions", "permessage-deflate");
                    ji6 b4 = aVar3.b();
                    nj6 nj6 = new nj6(hi62, b4, true);
                    km6.b = nj6;
                    nj6.L(new lm6(km6, b4));
                } else {
                    throw new IllegalArgumentException("protocols must not contain null".toString());
                }
            } else {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + B).toString());
            }
        }
        this.n = km6;
    }

    @Override // defpackage.i46
    public void l(s46[] s46Arr) throws e56 {
        this.b = false;
        b bVar = new b(this, this);
        int[] iArr = {s46Arr.length};
        for (s46 s46 : s46Arr) {
            i46.d dVar = this.k;
            if (dVar == i46.d.OPENING || dVar == i46.d.OPEN) {
                t46.c(s46, false, new c(this, this, iArr, bVar));
            } else {
                return;
            }
        }
    }
}
