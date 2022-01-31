package j$.time;

import a.C0079d;
import a.C0081e;
import a.C0083f;
import a.C0085g;
import java.math.BigInteger;
import java.util.regex.Pattern;

public final class Duration implements Object, Comparable<Duration> {
    public static final Duration c = new Duration(0, 0);

    /* renamed from: a  reason: collision with root package name */
    private final long f1589a;
    private final int b;

    static {
        BigInteger.valueOf(1000000000);
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    }

    private Duration(long j, int i) {
        this.f1589a = j;
        this.b = i;
    }

    private static Duration h(long j, int i) {
        return (((long) i) | j) == 0 ? c : new Duration(j, i);
    }

    public static Duration j(long j) {
        long j2 = j / 1000000000;
        int i = (int) (j % 1000000000);
        if (i < 0) {
            i = (int) (((long) i) + 1000000000);
            j2--;
        }
        return h(j2, i);
    }

    public static Duration l(long j, long j2) {
        return h(C0079d.a(j, C0081e.a(j2, 1000000000)), (int) C0083f.a(j2, 1000000000));
    }

    public static Duration ofSeconds(long j) {
        return h(j, 0);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(Duration duration) {
        Duration duration2 = duration;
        int compare = Long.compare(this.f1589a, duration2.f1589a);
        return compare != 0 ? compare : this.b - duration2.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.f1589a == duration.f1589a && this.b == duration.b;
    }

    public int hashCode() {
        long j = this.f1589a;
        return (this.b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public long toMillis() {
        return C0079d.a(C0085g.a(this.f1589a, 1000), (long) (this.b / 1000000));
    }

    public String toString() {
        if (this == c) {
            return "PT0S";
        }
        long j = this.f1589a;
        long j2 = j / 3600;
        int i = (int) ((j % 3600) / 60);
        int i2 = (int) (j % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j2 != 0) {
            sb.append(j2);
            sb.append('H');
        }
        if (i != 0) {
            sb.append(i);
            sb.append('M');
        }
        if (i2 == 0 && this.b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (i2 >= 0 || this.b <= 0) {
            sb.append(i2);
        } else if (i2 == -1) {
            sb.append("-0");
        } else {
            sb.append(i2 + 1);
        }
        if (this.b > 0) {
            int length = sb.length();
            if (i2 < 0) {
                sb.append(2000000000 - ((long) this.b));
            } else {
                sb.append(((long) this.b) + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }
}
