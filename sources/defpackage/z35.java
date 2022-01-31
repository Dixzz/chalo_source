package defpackage;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* renamed from: z35  reason: default package */
/* compiled from: DecodeFormatManager */
public final class z35 {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f4118a = Pattern.compile(",");
    public static final Set<o25> b;
    public static final Set<o25> c;
    public static final Set<o25> d;
    public static final Set<o25> e;
    public static final Set<o25> f;
    public static final Set<o25> g;
    public static final Set<o25> h;
    public static final Map<String, Set<o25>> i;

    static {
        EnumSet of = EnumSet.of(o25.QR_CODE);
        e = of;
        EnumSet of2 = EnumSet.of(o25.DATA_MATRIX);
        f = of2;
        EnumSet of3 = EnumSet.of(o25.AZTEC);
        g = of3;
        EnumSet of4 = EnumSet.of(o25.PDF_417);
        h = of4;
        EnumSet of5 = EnumSet.of(o25.UPC_A, o25.UPC_E, o25.EAN_13, o25.EAN_8, o25.RSS_14, o25.RSS_EXPANDED);
        b = of5;
        EnumSet of6 = EnumSet.of(o25.CODE_39, o25.CODE_93, o25.CODE_128, o25.ITF, o25.CODABAR);
        c = of6;
        EnumSet copyOf = EnumSet.copyOf((Collection) of5);
        d = copyOf;
        copyOf.addAll(of6);
        HashMap hashMap = new HashMap();
        i = hashMap;
        hashMap.put("ONE_D_MODE", copyOf);
        hashMap.put("PRODUCT_MODE", of5);
        hashMap.put("QR_CODE_MODE", of);
        hashMap.put("DATA_MATRIX_MODE", of2);
        hashMap.put("AZTEC_MODE", of3);
        hashMap.put("PDF417_MODE", of4);
    }
}
