package defpackage;

import java.util.Map;

/* renamed from: z25  reason: default package */
/* compiled from: MultiFormatWriter */
public final class z25 implements i35 {
    @Override // defpackage.i35
    public f45 a(String str, o25 o25, int i, int i2, Map<u25, ?> map) throws j35 {
        i35 i35;
        switch (o25.ordinal()) {
            case 0:
                i35 = new m35();
                break;
            case 1:
                i35 = new u55();
                break;
            case 2:
                i35 = new y55();
                break;
            case 3:
                i35 = new a65();
                break;
            case 4:
                i35 = new w55();
                break;
            case 5:
                i35 = new v45();
                break;
            case 6:
                i35 = new e65();
                break;
            case 7:
                i35 = new c65();
                break;
            case 8:
                i35 = new h65();
                break;
            case 9:
            case 12:
            case 13:
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(o25)));
            case 10:
                i35 = new z75();
                break;
            case 11:
                i35 = new w85();
                break;
            case 14:
                i35 = new n65();
                break;
            case 15:
                i35 = new u65();
                break;
        }
        return i35.a(str, o25, i, i2, map);
    }

    public f45 b(String str, o25 o25, int i, int i2) throws j35 {
        return a(str, o25, i, i2, null);
    }
}
