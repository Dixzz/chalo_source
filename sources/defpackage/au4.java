package defpackage;

/* renamed from: au4  reason: default package */
public final class au4 {

    /* renamed from: a  reason: collision with root package name */
    public final int f332a;
    public final String b;
    public final long c;
    public final long d;
    public final int e;

    public au4() {
    }

    public au4(int i, String str, long j, long j2, int i2) {
        this.f332a = i;
        this.b = str;
        this.c = j;
        this.d = j2;
        this.e = i2;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof au4) {
            au4 au4 = (au4) obj;
            return this.f332a == au4.f332a && ((str = this.b) != null ? str.equals(au4.b) : au4.b == null) && this.c == au4.c && this.d == au4.d && this.e == au4.e;
        }
    }

    public int hashCode() {
        int i = (this.f332a ^ 1000003) * 1000003;
        String str = this.b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.c;
        long j2 = this.d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.e;
    }

    public String toString() {
        int i = this.f332a;
        String str = this.b;
        long j = this.c;
        long j2 = this.d;
        int i2 = this.e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
