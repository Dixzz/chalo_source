package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* renamed from: oo  reason: default package */
/* compiled from: VersionedParcelParcel */
public class oo extends no {
    public final SparseIntArray d;
    public final Parcel e;
    public final int f;
    public final int g;
    public final String h;
    public int i;
    public int j;
    public int k;

    public oo(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new n2(), new n2(), new n2());
    }

    @Override // defpackage.no
    public void a() {
        int i2 = this.i;
        if (i2 >= 0) {
            int i3 = this.d.get(i2);
            int dataPosition = this.e.dataPosition();
            this.e.setDataPosition(i3);
            this.e.writeInt(dataPosition - i3);
            this.e.setDataPosition(dataPosition);
        }
    }

    @Override // defpackage.no
    public no b() {
        Parcel parcel = this.e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.j;
        if (i2 == this.f) {
            i2 = this.g;
        }
        return new oo(parcel, dataPosition, i2, hj1.a0(new StringBuilder(), this.h, "  "), this.f2578a, this.b, this.c);
    }

    @Override // defpackage.no
    public boolean f() {
        return this.e.readInt() != 0;
    }

    @Override // defpackage.no
    public byte[] g() {
        int readInt = this.e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.e.readByteArray(bArr);
        return bArr;
    }

    @Override // defpackage.no
    public CharSequence h() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }

    @Override // defpackage.no
    public boolean i(int i2) {
        while (this.j < this.g) {
            int i3 = this.k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.j);
            int readInt = this.e.readInt();
            this.k = this.e.readInt();
            this.j += readInt;
        }
        if (this.k == i2) {
            return true;
        }
        return false;
    }

    @Override // defpackage.no
    public int j() {
        return this.e.readInt();
    }

    @Override // defpackage.no
    public <T extends Parcelable> T l() {
        return (T) this.e.readParcelable(oo.class.getClassLoader());
    }

    @Override // defpackage.no
    public String n() {
        return this.e.readString();
    }

    @Override // defpackage.no
    public void p(int i2) {
        a();
        this.i = i2;
        this.d.put(i2, this.e.dataPosition());
        this.e.writeInt(0);
        this.e.writeInt(i2);
    }

    @Override // defpackage.no
    public void q(boolean z) {
        this.e.writeInt(z ? 1 : 0);
    }

    @Override // defpackage.no
    public void r(byte[] bArr) {
        if (bArr != null) {
            this.e.writeInt(bArr.length);
            this.e.writeByteArray(bArr);
            return;
        }
        this.e.writeInt(-1);
    }

    @Override // defpackage.no
    public void s(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.e, 0);
    }

    @Override // defpackage.no
    public void t(int i2) {
        this.e.writeInt(i2);
    }

    @Override // defpackage.no
    public void u(Parcelable parcelable) {
        this.e.writeParcelable(parcelable, 0);
    }

    @Override // defpackage.no
    public void v(String str) {
        this.e.writeString(str);
    }

    public oo(Parcel parcel, int i2, int i3, String str, n2<String, Method> n2Var, n2<String, Method> n2Var2, n2<String, Class> n2Var3) {
        super(n2Var, n2Var2, n2Var3);
        this.d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.e = parcel;
        this.f = i2;
        this.g = i3;
        this.j = i2;
        this.h = str;
    }
}
