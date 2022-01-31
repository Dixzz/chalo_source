package defpackage;

import java.util.Map;

/* renamed from: sd3  reason: default package */
public class sd3 extends yb3 {
    public static sd3 h;

    public sd3(ac3 ac3) {
        super(ac3);
    }

    public static String m0(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        String str = "-";
        if (obj instanceof Long) {
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) != '-') {
                str = "";
            }
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            StringBuilder i0 = hj1.i0(str);
            i0.append(Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1))));
            i0.append("...");
            i0.append(str);
            i0.append(Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d));
            return i0.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            return obj instanceof Throwable ? obj.getClass().getCanonicalName() : str;
        }
    }

    @Override // defpackage.yb3
    public final void a0() {
        synchronized (sd3.class) {
            h = this;
        }
    }

    public final void i0(nd3 nd3, String str) {
        J(str.length() != 0 ? "Discarding hit. ".concat(str) : new String("Discarding hit. "), nd3.toString());
    }

    public final void j0(Map<String, String> map, String str) {
        String str2;
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
            }
            str2 = sb.toString();
        } else {
            str2 = "no hit data";
        }
        J(str.length() != 0 ? "Discarding hit. ".concat(str) : new String("Discarding hit. "), str2);
    }
}
