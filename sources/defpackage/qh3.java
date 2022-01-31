package defpackage;

import java.lang.reflect.Type;

/* JADX WARN: Init of enum zzho can be incorrect */
/* JADX WARN: Init of enum zzhp can be incorrect */
/* JADX WARN: Init of enum zzhq can be incorrect */
/* JADX WARN: Init of enum zzhr can be incorrect */
/* JADX WARN: Init of enum zzhs can be incorrect */
/* JADX WARN: Init of enum zzht can be incorrect */
/* JADX WARN: Init of enum zzhu can be incorrect */
/* JADX WARN: Init of enum zzhv can be incorrect */
/* JADX WARN: Init of enum zzhw can be incorrect */
/* JADX WARN: Init of enum zzhx can be incorrect */
/* JADX WARN: Init of enum zzhy can be incorrect */
/* JADX WARN: Init of enum zzhz can be incorrect */
/* JADX WARN: Init of enum zzia can be incorrect */
/* JADX WARN: Init of enum zzib can be incorrect */
/* JADX WARN: Init of enum zzic can be incorrect */
/* JADX WARN: Init of enum zzid can be incorrect */
/* JADX WARN: Init of enum zzie can be incorrect */
/* JADX WARN: Init of enum zzif can be incorrect */
/* JADX WARN: Init of enum zzig can be incorrect */
/* JADX WARN: Init of enum zzih can be incorrect */
/* JADX WARN: Init of enum zzii can be incorrect */
/* JADX WARN: Init of enum zzij can be incorrect */
/* JADX WARN: Init of enum zzik can be incorrect */
/* JADX WARN: Init of enum zzil can be incorrect */
/* JADX WARN: Init of enum zzim can be incorrect */
/* JADX WARN: Init of enum zzin can be incorrect */
/* JADX WARN: Init of enum zzio can be incorrect */
/* JADX WARN: Init of enum zzip can be incorrect */
/* JADX WARN: Init of enum zziq can be incorrect */
/* JADX WARN: Init of enum zzir can be incorrect */
/* JADX WARN: Init of enum zzis can be incorrect */
/* JADX WARN: Init of enum zzit can be incorrect */
/* JADX WARN: Init of enum zziu can be incorrect */
/* JADX WARN: Init of enum zziv can be incorrect */
/* JADX WARN: Init of enum zziw can be incorrect */
/* JADX WARN: Init of enum zzix can be incorrect */
/* JADX WARN: Init of enum zziy can be incorrect */
/* JADX WARN: Init of enum zziz can be incorrect */
/* JADX WARN: Init of enum zzja can be incorrect */
/* JADX WARN: Init of enum zzjb can be incorrect */
/* JADX WARN: Init of enum zzjc can be incorrect */
/* JADX WARN: Init of enum zzjd can be incorrect */
/* JADX WARN: Init of enum zzje can be incorrect */
/* JADX WARN: Init of enum zzjf can be incorrect */
/* JADX WARN: Init of enum zzjg can be incorrect */
/* JADX WARN: Init of enum zzjh can be incorrect */
/* JADX WARN: Init of enum zzji can be incorrect */
/* JADX WARN: Init of enum zzjj can be incorrect */
/* JADX WARN: Init of enum zzjk can be incorrect */
/* JADX WARN: Init of enum zzjl can be incorrect */
/* renamed from: qh3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public enum qh3 {
    DOUBLE(0, r7, r8),
    FLOAT(1, r7, r9),
    INT64(2, r7, r10),
    UINT64(3, r7, r10),
    INT32(4, r7, r11),
    FIXED64(5, r7, r10),
    FIXED32(6, r7, r11),
    BOOL(7, r7, r12),
    STRING(8, r7, r13),
    MESSAGE(9, r7, r14),
    BYTES(10, r7, r15),
    UINT32(11, r7, r11),
    ENUM(12, r7, r16),
    SFIXED32(13, r7, r11),
    SFIXED64(14, r7, r10),
    SINT32(15, r7, r11),
    SINT64(16, r7, r10),
    GROUP(17, r7, r14),
    DOUBLE_LIST(18, r7, r8),
    FLOAT_LIST(19, r7, r9),
    INT64_LIST(20, r7, r10),
    UINT64_LIST(21, r7, r10),
    INT32_LIST(22, r7, r11),
    FIXED64_LIST(23, r7, r10),
    FIXED32_LIST(24, r7, r11),
    BOOL_LIST(25, r7, r12),
    STRING_LIST(26, r7, r13),
    MESSAGE_LIST(27, r7, r14),
    BYTES_LIST(28, r7, r15),
    UINT32_LIST(29, r7, r11),
    ENUM_LIST(30, r7, r16),
    SFIXED32_LIST(31, r7, r11),
    SFIXED64_LIST(32, r7, r10),
    SINT32_LIST(33, r7, r11),
    SINT64_LIST(34, r7, r10),
    DOUBLE_LIST_PACKED(35, r13, r8),
    FLOAT_LIST_PACKED(36, r13, r9),
    INT64_LIST_PACKED(37, r13, r10),
    UINT64_LIST_PACKED(38, r13, r10),
    INT32_LIST_PACKED(39, r13, r11),
    FIXED64_LIST_PACKED(40, r13, r10),
    FIXED32_LIST_PACKED(41, r13, r11),
    BOOL_LIST_PACKED(42, r13, r12),
    UINT32_LIST_PACKED(43, r13, r11),
    ENUM_LIST_PACKED(44, r13, r16),
    SFIXED32_LIST_PACKED(45, r13, r11),
    SFIXED64_LIST_PACKED(46, r13, r8),
    SINT32_LIST_PACKED(47, r13, hi3.INT),
    SINT64_LIST_PACKED(48, r13, r8),
    GROUP_LIST(49, r7, r14),
    MAP(50, sh3.MAP, hi3.VOID);
    
    private static final qh3[] zzjr = new qh3[51];
    private static final Type[] zzjs = new Type[0];
    private final int id;
    private final hi3 zzjn;
    private final sh3 zzjo;
    private final Class<?> zzjp;
    private final boolean zzjq;

    /* access modifiers changed from: public */
    static {
        sh3 sh3 = sh3.SCALAR;
        hi3 hi3 = hi3.DOUBLE;
        hi3 hi32 = hi3.FLOAT;
        hi3 hi33 = hi3.LONG;
        hi3 hi34 = hi3.INT;
        hi3 hi35 = hi3.BOOLEAN;
        hi3 hi36 = hi3.STRING;
        hi3 hi37 = hi3.MESSAGE;
        hi3 hi38 = hi3.BYTE_STRING;
        hi3 hi39 = hi3.ENUM;
        sh3 sh32 = sh3.VECTOR;
        sh3 sh33 = sh3.PACKED_VECTOR;
        hi3 hi310 = hi3.LONG;
        qh3[] values = values();
        for (qh3 qh3 : values) {
            zzjr[qh3.id] = qh3;
        }
    }

    private qh3(int i, sh3 sh3, hi3 hi3) {
        int i2;
        this.id = i;
        this.zzjo = sh3;
        this.zzjn = hi3;
        int i3 = th3.f3356a[sh3.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzjp = hi3.zzcb();
        } else if (i3 != 2) {
            this.zzjp = null;
        } else {
            this.zzjp = hi3.zzcb();
        }
        this.zzjq = (sh3 != sh3.SCALAR || (i2 = th3.b[hi3.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int id() {
        return this.id;
    }
}
