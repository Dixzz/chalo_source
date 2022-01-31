package defpackage;

/* JADX WARN: Init of enum zzc can be incorrect */
/* JADX WARN: Init of enum zzd can be incorrect */
/* JADX WARN: Init of enum zze can be incorrect */
/* JADX WARN: Init of enum zzf can be incorrect */
/* JADX WARN: Init of enum zzg can be incorrect */
/* JADX WARN: Init of enum zzj can be incorrect */
/* JADX WARN: Init of enum zzk can be incorrect */
/* JADX WARN: Init of enum zzm can be incorrect */
/* JADX WARN: Init of enum zzo can be incorrect */
/* JADX WARN: Init of enum zzp can be incorrect */
/* JADX WARN: Init of enum zzq can be incorrect */
/* JADX WARN: Init of enum zzr can be incorrect */
/* renamed from: rn2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public enum rn2 {
    DOUBLE(sn2.DOUBLE, 1),
    FLOAT(sn2.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(sn2.BOOLEAN, 0),
    STRING(sn2.STRING, 2),
    GROUP(r13, 3),
    MESSAGE(r13, 2),
    BYTES(sn2.BYTE_STRING, 2),
    UINT32(r11, 0),
    ENUM(sn2.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final sn2 zzs;

    /* access modifiers changed from: public */
    static {
        sn2 sn2 = sn2.LONG;
        sn2 sn22 = sn2.INT;
        sn2 sn23 = sn2.MESSAGE;
    }

    private rn2(sn2 sn2, int i) {
        this.zzs = sn2;
    }

    public final sn2 zza() {
        return this.zzs;
    }
}
