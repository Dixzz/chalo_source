package defpackage;

import java.util.List;

/* renamed from: i45  reason: default package */
/* compiled from: DecoderResult */
public final class i45 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f1475a;
    public int b;
    public final String c;
    public final List<byte[]> d;
    public final String e;
    public Object f;
    public final int g;
    public final int h;

    public i45(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public i45(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        int i3;
        this.f1475a = bArr;
        if (bArr == null) {
            i3 = 0;
        } else {
            i3 = bArr.length * 8;
        }
        this.b = i3;
        this.c = str;
        this.d = list;
        this.e = str2;
        this.g = i2;
        this.h = i;
    }
}
