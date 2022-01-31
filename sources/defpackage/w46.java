package defpackage;

import defpackage.t46;

/* renamed from: w46  reason: default package */
/* compiled from: Parser */
public final class w46 implements t46.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t46.b f3729a;

    public w46(t46.b bVar) {
        this.f3729a = bVar;
    }

    @Override // defpackage.t46.b
    public void a(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            String valueOf = String.valueOf(str.length());
            int length = valueOf.length() + 2;
            byte[] bArr = new byte[length];
            bArr[0] = 0;
            int i = 0;
            while (i < valueOf.length()) {
                int i2 = i + 1;
                bArr[i2] = (byte) Character.getNumericValue(valueOf.charAt(i));
                i = i2;
            }
            bArr[length - 1] = -1;
            t46.b bVar = this.f3729a;
            byte[][] bArr2 = new byte[2][];
            bArr2[0] = bArr;
            int length2 = str.length();
            byte[] bArr3 = new byte[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                bArr3[i3] = (byte) Character.codePointAt(str, i3);
            }
            bArr2[1] = bArr3;
            bVar.a(hd3.L(bArr2));
            return;
        }
        byte[] bArr4 = (byte[]) obj;
        String valueOf2 = String.valueOf(bArr4.length);
        int length3 = valueOf2.length() + 2;
        byte[] bArr5 = new byte[length3];
        bArr5[0] = 1;
        int i4 = 0;
        while (i4 < valueOf2.length()) {
            int i5 = i4 + 1;
            bArr5[i5] = (byte) Character.getNumericValue(valueOf2.charAt(i4));
            i4 = i5;
        }
        bArr5[length3 - 1] = -1;
        this.f3729a.a(hd3.L(new byte[][]{bArr5, bArr4}));
    }
}
