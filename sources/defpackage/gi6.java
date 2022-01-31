package defpackage;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import defpackage.fi6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* renamed from: gi6  reason: default package */
/* compiled from: MultipartBody.kt */
public final class gi6 extends mi6 {
    public static final fi6 f = fi6.a.a("multipart/mixed");
    public static final fi6 g = fi6.a.a("multipart/form-data");
    public static final byte[] h = {(byte) 58, (byte) 32};
    public static final byte[] i = {(byte) 13, (byte) 10};
    public static final byte[] j;
    public static final b k = new b(null);

    /* renamed from: a  reason: collision with root package name */
    public final fi6 f1267a;
    public long b = -1;
    public final zm6 c;
    public final fi6 d;
    public final List<c> e;

    /* renamed from: gi6$a */
    /* compiled from: MultipartBody.kt */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final zm6 f1268a;
        public fi6 b = gi6.f;
        public final List<c> c = new ArrayList();

        public a() {
            String uuid = UUID.randomUUID().toString();
            n86.b(uuid, "UUID.randomUUID().toString()");
            n86.f(uuid, "boundary");
            this.f1268a = zm6.j.c(uuid);
        }

        public final a a(c cVar) {
            n86.f(cVar, "part");
            this.c.add(cVar);
            return this;
        }

        public final gi6 b() {
            if (!this.c.isEmpty()) {
                return new gi6(this.f1268a, this.b, vi6.y(this.c));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        public final a c(fi6 fi6) {
            n86.f(fi6, "type");
            if (n86.a(fi6.b, "multipart")) {
                this.b = fi6;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + fi6).toString());
        }
    }

    /* renamed from: gi6$b */
    /* compiled from: MultipartBody.kt */
    public static final class b {
        public b(j86 j86) {
        }

        public final void a(StringBuilder sb, String str) {
            n86.f(sb, "$this$appendQuotedString");
            n86.f(str, AnalyticsConstants.KEY);
            sb.append('\"');
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt == '\n') {
                    sb.append("%0A");
                } else if (charAt == '\r') {
                    sb.append("%0D");
                } else if (charAt == '\"') {
                    sb.append("%22");
                } else {
                    sb.append(charAt);
                }
            }
            sb.append('\"');
        }
    }

    /* renamed from: gi6$c */
    /* compiled from: MultipartBody.kt */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final ci6 f1269a;
        public final mi6 b;

        public c(ci6 ci6, mi6 mi6, j86 j86) {
            this.f1269a = ci6;
            this.b = mi6;
        }

        public static final c a(ci6 ci6, mi6 mi6) {
            n86.f(mi6, ProductPromotionsObject.KEY_BODY);
            boolean z = false;
            if (ci6.b("Content-Type") == null) {
                if (ci6.b("Content-Length") == null) {
                    z = true;
                }
                if (z) {
                    return new c(ci6, mi6, null);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            }
            throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
        }

        public static final c b(String str, String str2, mi6 mi6) {
            n86.f(str, "name");
            n86.f(mi6, ProductPromotionsObject.KEY_BODY);
            StringBuilder sb = new StringBuilder();
            sb.append("form-data; name=");
            b bVar = gi6.k;
            bVar.a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                bVar.a(sb, str2);
            }
            String sb2 = sb.toString();
            n86.b(sb2, "StringBuilder().apply(builderAction).toString()");
            ArrayList arrayList = new ArrayList(20);
            n86.f("Content-Disposition", "name");
            n86.f(sb2, FirebaseAnalytics.Param.VALUE);
            for (int i = 0; i < 19; i++) {
                char charAt = "Content-Disposition".charAt(i);
                if (!('!' <= charAt && '~' >= charAt)) {
                    throw new IllegalArgumentException(vi6.i("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), "Content-Disposition").toString());
                }
            }
            n86.f("Content-Disposition", "name");
            n86.f(sb2, FirebaseAnalytics.Param.VALUE);
            arrayList.add("Content-Disposition");
            arrayList.add(ea6.K(sb2).toString());
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return a(new ci6((String[]) array, null), mi6);
            }
            throw new p56("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    static {
        fi6.a aVar = fi6.f;
        fi6.a.a("multipart/alternative");
        fi6.a.a("multipart/digest");
        fi6.a.a("multipart/parallel");
        byte b2 = (byte) 45;
        j = new byte[]{b2, b2};
    }

    public gi6(zm6 zm6, fi6 fi6, List<c> list) {
        n86.f(zm6, "boundaryByteString");
        n86.f(fi6, "type");
        n86.f(list, "parts");
        this.c = zm6;
        this.d = fi6;
        this.e = list;
        fi6.a aVar = fi6.f;
        this.f1267a = fi6.a.a(fi6 + "; boundary=" + zm6.p());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: vm6 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: vm6 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: vm6 */
    /* JADX WARN: Multi-variable type inference failed */
    public final long a(xm6 xm6, boolean z) throws IOException {
        vm6 vm6;
        if (z) {
            xm6 = new vm6();
            vm6 = xm6;
        } else {
            vm6 = 0;
        }
        int size = this.e.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = this.e.get(i2);
            ci6 ci6 = cVar.f1269a;
            mi6 mi6 = cVar.b;
            if (xm6 != null) {
                xm6.N0(j);
                xm6.P0(this.c);
                xm6.N0(i);
                if (ci6 != null) {
                    int size2 = ci6.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        xm6.k0(ci6.d(i3)).N0(h).k0(ci6.n(i3)).N0(i);
                    }
                }
                fi6 contentType = mi6.contentType();
                if (contentType != null) {
                    xm6.k0("Content-Type: ").k0(contentType.f1129a).N0(i);
                }
                long contentLength = mi6.contentLength();
                if (contentLength != -1) {
                    xm6.k0("Content-Length: ").f1(contentLength).N0(i);
                } else if (z) {
                    if (vm6 != 0) {
                        vm6.d(vm6.g);
                        return -1;
                    }
                    n86.k();
                    throw null;
                }
                byte[] bArr = i;
                xm6.N0(bArr);
                if (z) {
                    j2 += contentLength;
                } else {
                    mi6.writeTo(xm6);
                }
                xm6.N0(bArr);
            } else {
                n86.k();
                throw null;
            }
        }
        if (xm6 != null) {
            byte[] bArr2 = j;
            xm6.N0(bArr2);
            xm6.P0(this.c);
            xm6.N0(bArr2);
            xm6.N0(i);
            if (!z) {
                return j2;
            }
            if (vm6 != 0) {
                long j3 = vm6.g;
                long j4 = j2 + j3;
                vm6.d(j3);
                return j4;
            }
            n86.k();
            throw null;
        }
        n86.k();
        throw null;
    }

    @Override // defpackage.mi6
    public long contentLength() throws IOException {
        long j2 = this.b;
        if (j2 != -1) {
            return j2;
        }
        long a2 = a(null, true);
        this.b = a2;
        return a2;
    }

    @Override // defpackage.mi6
    public fi6 contentType() {
        return this.f1267a;
    }

    @Override // defpackage.mi6
    public void writeTo(xm6 xm6) throws IOException {
        n86.f(xm6, "sink");
        a(xm6, false);
    }
}
