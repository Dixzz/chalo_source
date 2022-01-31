package defpackage;

/* JADX WARN: Init of enum zzqe can be incorrect */
/* JADX WARN: Init of enum zzqf can be incorrect */
/* JADX WARN: Init of enum zzqg can be incorrect */
/* JADX WARN: Init of enum zzqh can be incorrect */
/* JADX WARN: Init of enum zzqi can be incorrect */
/* JADX WARN: Init of enum zzql can be incorrect */
/* JADX WARN: Init of enum zzqm can be incorrect */
/* JADX WARN: Init of enum zzqo can be incorrect */
/* JADX WARN: Init of enum zzqq can be incorrect */
/* JADX WARN: Init of enum zzqr can be incorrect */
/* JADX WARN: Init of enum zzqs can be incorrect */
/* JADX WARN: Init of enum zzqt can be incorrect */
/* renamed from: rj2  reason: default package */
public enum rj2 {
    DOUBLE(wj2.DOUBLE, 1),
    FLOAT(wj2.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(wj2.BOOLEAN, 0),
    STRING(wj2.STRING, 2) {
    },
    GROUP(r13, 3) {
    },
    MESSAGE(r13, 2) {
    },
    BYTES(wj2.BYTE_STRING, 2) {
    },
    UINT32(r11, 0),
    ENUM(wj2.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final wj2 zzqu;
    private final int zzqv;

    /* access modifiers changed from: public */
    static {
        wj2 wj2 = wj2.LONG;
        wj2 wj22 = wj2.INT;
        wj2 wj23 = wj2.MESSAGE;
    }

    private rj2(wj2 wj2, int i) {
        this.zzqu = wj2;
        this.zzqv = i;
    }

    public final wj2 zzek() {
        return this.zzqu;
    }

    public final int zzel() {
        return this.zzqv;
    }
}
