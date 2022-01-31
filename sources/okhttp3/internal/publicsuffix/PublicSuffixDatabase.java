package okhttp3.internal.publicsuffix;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: PublicSuffixDatabase.kt */
public final class PublicSuffixDatabase {
    public static final byte[] e = {(byte) 42};
    public static final List<String> f = hd3.c2("*");
    public static final PublicSuffixDatabase g = new PublicSuffixDatabase();
    public static final a h = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f2708a = new AtomicBoolean(false);
    public final CountDownLatch b = new CountDownLatch(1);
    public byte[] c;
    public byte[] d;

    /* compiled from: PublicSuffixDatabase.kt */
    public static final class a {
        public a(j86 j86) {
        }

        public static final String a(a aVar, byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            boolean z;
            int i3;
            int i4;
            int length = bArr.length;
            int i5 = 0;
            while (i5 < length) {
                int i6 = (i5 + length) / 2;
                while (i6 > -1 && bArr[i6] != ((byte) 10)) {
                    i6--;
                }
                int i7 = i6 + 1;
                int i8 = 1;
                while (true) {
                    i2 = i7 + i8;
                    if (bArr[i2] == ((byte) 10)) {
                        break;
                    }
                    i8++;
                }
                int i9 = i2 - i7;
                int i10 = i;
                boolean z2 = false;
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (z2) {
                        i3 = 46;
                        z = false;
                    } else {
                        byte b = bArr2[i10][i11];
                        byte[] bArr3 = vi6.f3652a;
                        int i13 = b & 255;
                        z = z2;
                        i3 = i13;
                    }
                    byte b2 = bArr[i7 + i12];
                    byte[] bArr4 = vi6.f3652a;
                    i4 = i3 - (b2 & 255);
                    if (i4 != 0) {
                        break;
                    }
                    i12++;
                    i11++;
                    if (i12 == i9) {
                        break;
                    } else if (bArr2[i10].length != i11) {
                        z2 = z;
                    } else if (i10 == bArr2.length - 1) {
                        break;
                    } else {
                        i10++;
                        z2 = true;
                        i11 = -1;
                    }
                }
                if (i4 >= 0) {
                    if (i4 <= 0) {
                        int i14 = i9 - i12;
                        int length2 = bArr2[i10].length - i11;
                        int length3 = bArr2.length;
                        for (int i15 = i10 + 1; i15 < length3; i15++) {
                            length2 += bArr2[i15].length;
                        }
                        if (length2 >= i14) {
                            if (length2 <= i14) {
                                Charset charset = StandardCharsets.UTF_8;
                                n86.b(charset, "UTF_8");
                                return new String(bArr, i7, i9, charset);
                            }
                        }
                    }
                    i5 = i2 + 1;
                }
                length = i7 - 1;
            }
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x0205  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x018f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 547
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005d, code lost:
        defpackage.hd3.H(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() throws java.io.IOException {
        /*
            r4 = this;
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r0 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r1 = "publicsuffixes.gz"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)
            if (r0 == 0) goto L_0x0061
            en6 r1 = new en6
            java.lang.String r2 = "$this$source"
            defpackage.n86.f(r0, r2)
            gn6 r2 = new gn6
            rn6 r3 = new rn6
            r3.<init>()
            r2.<init>(r0, r3)
            r1.<init>(r2)
            java.lang.String r0 = "$this$buffer"
            defpackage.n86.f(r1, r0)
            kn6 r0 = new kn6
            r0.<init>(r1)
            int r1 = r0.readInt()     // Catch:{ all -> 0x005a }
            long r1 = (long) r1     // Catch:{ all -> 0x005a }
            byte[] r1 = r0.I0(r1)     // Catch:{ all -> 0x005a }
            int r2 = r0.readInt()     // Catch:{ all -> 0x005a }
            long r2 = (long) r2     // Catch:{ all -> 0x005a }
            byte[] r2 = r0.I0(r2)     // Catch:{ all -> 0x005a }
            r3 = 0
            defpackage.hd3.H(r0, r3)
            monitor-enter(r4)
            if (r1 == 0) goto L_0x0054
            r4.c = r1     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x004e
            r4.d = r2     // Catch:{ all -> 0x0052 }
            monitor-exit(r4)
            java.util.concurrent.CountDownLatch r0 = r4.b
            r0.countDown()
            return
        L_0x004e:
            defpackage.n86.k()
            throw r3
        L_0x0052:
            r0 = move-exception
            goto L_0x0058
        L_0x0054:
            defpackage.n86.k()
            throw r3
        L_0x0058:
            monitor-exit(r4)
            throw r0
        L_0x005a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x005c }
        L_0x005c:
            r2 = move-exception
            defpackage.hd3.H(r0, r1)
            throw r2
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.b():void");
    }

    public final List<String> c(String str) {
        int i = 0;
        List<String> A = ea6.A(str, new char[]{'.'}, false, 0, 6);
        n86.e(A, "$this$last");
        if (A.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        } else if (!n86.a(A.get(y56.j(A)), "")) {
            return A;
        } else {
            n86.e(A, "$this$dropLast");
            int size = A.size() - 1;
            if (size < 0) {
                size = 0;
            }
            n86.e(A, "$this$take");
            if (!(size >= 0)) {
                throw new IllegalArgumentException(hj1.J("Requested element count ", size, " is less than zero.").toString());
            } else if (size == 0) {
                return b66.f;
            } else {
                if (size >= A.size()) {
                    return y56.y(A);
                }
                if (size == 1) {
                    n86.e(A, "$this$first");
                    return hd3.c2(y56.h(A));
                }
                ArrayList arrayList = new ArrayList(size);
                Iterator<T> it = A.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                    i++;
                    if (i == size) {
                        break;
                    }
                }
                return y56.q(arrayList);
            }
        }
    }
}
