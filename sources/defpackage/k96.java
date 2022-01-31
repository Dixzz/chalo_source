package defpackage;

/* renamed from: k96  reason: default package */
/* compiled from: Ranges.kt */
public final class k96 extends i96 {
    public static final k96 i = new k96(1, 0);
    public static final k96 j = null;

    public k96(int i2, int i3) {
        super(i2, i3, 1);
    }

    @Override // defpackage.i96
    public boolean equals(Object obj) {
        if (obj instanceof k96) {
            if (!isEmpty() || !((k96) obj).isEmpty()) {
                k96 k96 = (k96) obj;
                if (!(this.f == k96.f && this.g == k96.g)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.i96
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f * 31) + this.g;
    }

    @Override // defpackage.i96
    public boolean isEmpty() {
        return this.f > this.g;
    }

    @Override // defpackage.i96
    public String toString() {
        return this.f + ".." + this.g;
    }
}
