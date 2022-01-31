package defpackage;

import java.lang.reflect.Type;

/* JADX WARN: Init of enum zzgy can be incorrect */
/* JADX WARN: Init of enum zzgz can be incorrect */
/* JADX WARN: Init of enum zzha can be incorrect */
/* JADX WARN: Init of enum zzhb can be incorrect */
/* JADX WARN: Init of enum zzhc can be incorrect */
/* JADX WARN: Init of enum zzhd can be incorrect */
/* JADX WARN: Init of enum zzhe can be incorrect */
/* JADX WARN: Init of enum zzhf can be incorrect */
/* JADX WARN: Init of enum zzhg can be incorrect */
/* JADX WARN: Init of enum zzhh can be incorrect */
/* JADX WARN: Init of enum zzhi can be incorrect */
/* JADX WARN: Init of enum zzhj can be incorrect */
/* JADX WARN: Init of enum zzhk can be incorrect */
/* JADX WARN: Init of enum zzhl can be incorrect */
/* JADX WARN: Init of enum zzhm can be incorrect */
/* JADX WARN: Init of enum zzhn can be incorrect */
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
/* renamed from: pg2  reason: default package */
public enum pg2 {
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
    SINT32_LIST_PACKED(47, r13, ch2.INT),
    SINT64_LIST_PACKED(48, r13, r8),
    GROUP_LIST(49, r7, r14),
    MAP(50, rg2.MAP, ch2.VOID);
    
    private static final pg2[] zzjb = new pg2[51];
    private static final Type[] zzjc = new Type[0];
    private final int id;
    private final ch2 zzix;
    private final rg2 zziy;
    private final Class<?> zziz;
    private final boolean zzja;

    /* access modifiers changed from: public */
    static {
        rg2 rg2 = rg2.SCALAR;
        ch2 ch2 = ch2.DOUBLE;
        ch2 ch22 = ch2.FLOAT;
        ch2 ch23 = ch2.LONG;
        ch2 ch24 = ch2.INT;
        ch2 ch25 = ch2.BOOLEAN;
        ch2 ch26 = ch2.STRING;
        ch2 ch27 = ch2.MESSAGE;
        ch2 ch28 = ch2.BYTE_STRING;
        ch2 ch29 = ch2.ENUM;
        rg2 rg22 = rg2.VECTOR;
        rg2 rg23 = rg2.PACKED_VECTOR;
        ch2 ch210 = ch2.LONG;
        pg2[] values = values();
        for (pg2 pg2 : values) {
            zzjb[pg2.id] = pg2;
        }
    }

    private pg2(int i, rg2 rg2, ch2 ch2) {
        int i2;
        this.id = i;
        this.zziy = rg2;
        this.zzix = ch2;
        int i3 = qg2.f2943a[rg2.ordinal()];
        boolean z = true;
        this.zziz = (i3 == 1 || i3 == 2) ? ch2.zzbq() : null;
        this.zzja = (rg2 != rg2.SCALAR || (i2 = qg2.b[ch2.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int id() {
        return this.id;
    }
}
