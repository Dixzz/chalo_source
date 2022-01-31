package defpackage;

import defpackage.zm6;
import java.io.EOFException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ck6  reason: default package */
/* compiled from: HttpHeaders.kt */
public final class ck6 {

    /* renamed from: a  reason: collision with root package name */
    public static final zm6 f575a;
    public static final zm6 b;

    static {
        zm6.a aVar = zm6.j;
        f575a = aVar.c("\"\\");
        b = aVar.c("\t ,=");
    }

    public static final boolean a(ni6 ni6) {
        n86.f(ni6, "$this$promisesBody");
        if (n86.a(ni6.g.c, "HEAD")) {
            return false;
        }
        int i = ni6.j;
        if (((i >= 100 && i < 200) || i == 204 || i == 304) && vi6.k(ni6) == -1 && !ea6.f("chunked", ni6.c(ni6, "Transfer-Encoding", null, 2), true)) {
            return false;
        }
        return true;
    }

    public static final void b(vm6 vm6, List<mh6> list) throws EOFException {
        String c;
        int t;
        int i;
        int i2;
        String str;
        String str2;
        String str3;
        List<mh6> list2 = list;
        while (true) {
            String str4 = null;
            String str5 = null;
            while (true) {
                if (str4 == null) {
                    e(vm6);
                    str4 = c(vm6);
                    if (str4 == null) {
                        return;
                    }
                }
                boolean e = e(vm6);
                c = c(vm6);
                if (c != null) {
                    byte b2 = (byte) 61;
                    t = vi6.t(vm6, b2);
                    boolean e2 = e(vm6);
                    i2 = 1;
                    if (e || (!e2 && !vm6.R())) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        int t2 = vi6.t(vm6, b2) + t;
                        while (true) {
                            if (c == null) {
                                c = c(vm6);
                                if (e(vm6)) {
                                    continue;
                                    break;
                                }
                                t2 = vi6.t(vm6, b2);
                            }
                            if (t2 == 0) {
                                continue;
                                break;
                            } else if (t2 <= 1 && !e(vm6)) {
                                byte b3 = (byte) 34;
                                if (!(!vm6.R() && vm6.e(0) == b3)) {
                                    str = str4;
                                    str2 = c(vm6);
                                } else if (vm6.readByte() == b3) {
                                    vm6 vm62 = new vm6();
                                    while (true) {
                                        long g = vm6.g(f575a);
                                        if (g == -1) {
                                            break;
                                        } else if (vm6.e(g) == b3) {
                                            vm62.s0(vm6, g);
                                            vm6.readByte();
                                            str5 = vm62.o();
                                            break;
                                        } else {
                                            str = str4;
                                            if (vm6.g == g + 1) {
                                                str2 = null;
                                                break;
                                            }
                                            vm62.s0(vm6, g);
                                            vm6.readByte();
                                            vm62.s0(vm6, 1);
                                            str4 = str;
                                            str5 = null;
                                        }
                                    }
                                    str2 = str5;
                                    str = str4;
                                } else {
                                    throw new IllegalArgumentException("Failed requirement.".toString());
                                }
                                if (str2 == null || ((String) linkedHashMap.put(c, str2)) != null) {
                                    return;
                                }
                                if (e(vm6) || vm6.R()) {
                                    c = null;
                                    str4 = str;
                                    str5 = null;
                                    list2 = list;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        list2.add(new mh6(str4, linkedHashMap));
                        str4 = c;
                    }
                } else if (vm6.R()) {
                    list2.add(new mh6(str4, c66.f));
                    return;
                } else {
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            n86.e("=", "$this$repeat");
            if (t >= 0) {
                if (t != 0) {
                    if (t != 1) {
                        int length = "=".length();
                        if (length != 0) {
                            if (length != 1) {
                                StringBuilder sb2 = new StringBuilder("=".length() * t);
                                if (1 <= t) {
                                    while (true) {
                                        sb2.append((CharSequence) "=");
                                        if (i2 == t) {
                                            break;
                                        }
                                        i2++;
                                    }
                                }
                                str3 = sb2.toString();
                                n86.d(str3, "sb.toString()");
                            } else {
                                char charAt = "=".charAt(0);
                                char[] cArr = new char[t];
                                for (i = 0; i < t; i++) {
                                    cArr[i] = charAt;
                                }
                                str3 = new String(cArr);
                            }
                        }
                    } else {
                        str3 = "=".toString();
                    }
                    sb.append(str3);
                    Map singletonMap = Collections.singletonMap(str5, sb.toString());
                    n86.b(singletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
                    list2.add(new mh6(str4, singletonMap));
                }
                str3 = "";
                sb.append(str3);
                Map singletonMap2 = Collections.singletonMap(str5, sb.toString());
                n86.b(singletonMap2, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
                list2.add(new mh6(str4, singletonMap2));
            } else {
                throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + t + '.').toString());
            }
        }
    }

    public static final String c(vm6 vm6) {
        long g = vm6.g(b);
        if (g == -1) {
            g = vm6.g;
        }
        if (g != 0) {
            return vm6.p(g);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01b1, code lost:
        if (defpackage.vi6.f.a(r2) == false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b6, code lost:
        if (r8 != false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01cb, code lost:
        if (okhttp3.internal.publicsuffix.PublicSuffixDatabase.g.a(r5) == null) goto L_0x0204;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0211 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0207  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void d(defpackage.th6 r30, defpackage.di6 r31, defpackage.ci6 r32) {
        /*
        // Method dump skipped, instructions count: 561
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ck6.d(th6, di6, ci6):void");
    }

    public static final boolean e(vm6 vm6) {
        boolean z = false;
        while (!vm6.R()) {
            byte e = vm6.e(0);
            if (e == 9 || e == 32) {
                vm6.readByte();
            } else if (e != 44) {
                break;
            } else {
                vm6.readByte();
                z = true;
            }
        }
        return z;
    }
}
