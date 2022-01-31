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
/* renamed from: qx3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public enum qx3 {
    DOUBLE(xx3.DOUBLE, 1),
    FLOAT(xx3.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(xx3.BOOLEAN, 0),
    STRING(xx3.STRING, 2) {
    },
    GROUP(r13, 3) {
    },
    MESSAGE(r13, 2) {
    },
    BYTES(xx3.BYTE_STRING, 2) {
    },
    UINT32(r11, 0),
    ENUM(xx3.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final xx3 zzs;
    private final int zzt;

    /* access modifiers changed from: public */
    static {
        xx3 xx3 = xx3.LONG;
        xx3 xx32 = xx3.INT;
        xx3 xx33 = xx3.MESSAGE;
    }

    private qx3(xx3 xx3, int i) {
        this.zzs = xx3;
        this.zzt = i;
    }

    public final xx3 zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
