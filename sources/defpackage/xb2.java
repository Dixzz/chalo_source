package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* renamed from: xb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class xb2 extends hl2 implements ua2 {
    public static final /* synthetic */ int g = 0;
    public final int f;

    public xb2(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        gj1.b(bArr.length == 25);
        this.f = Arrays.hashCode(bArr);
    }

    public static byte[] L(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // defpackage.hl2
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            ic2 zzd = zzd();
            parcel2.writeNoException();
            il2.c(parcel2, zzd);
            return true;
        } else if (i != 2) {
            return false;
        } else {
            int i3 = this.f;
            parcel2.writeNoException();
            parcel2.writeInt(i3);
            return true;
        }
    }

    public abstract byte[] F();

    public final boolean equals(Object obj) {
        ic2 zzd;
        if (obj != null && (obj instanceof ua2)) {
            try {
                ua2 ua2 = (ua2) obj;
                if (ua2.zze() == this.f && (zzd = ua2.zzd()) != null) {
                    return Arrays.equals(F(), (byte[]) kc2.L(zzd));
                }
                return false;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f;
    }

    @Override // defpackage.ua2
    public final ic2 zzd() {
        return new kc2(F());
    }

    @Override // defpackage.ua2
    public final int zze() {
        return this.f;
    }
}
