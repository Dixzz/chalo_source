package defpackage;

/* renamed from: w65  reason: default package */
/* compiled from: DataCharacter */
public class w65 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3736a;
    public final int b;

    public w65(int i, int i2) {
        this.f3736a = i;
        this.b = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof w65)) {
            return false;
        }
        w65 w65 = (w65) obj;
        if (this.f3736a == w65.f3736a && this.b == w65.b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f3736a ^ this.b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3736a);
        sb.append("(");
        return hj1.W(sb, this.b, ')');
    }
}
