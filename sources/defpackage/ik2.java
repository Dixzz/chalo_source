package defpackage;

/* renamed from: ik2  reason: default package */
public enum ik2 implements xg2 {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4);
    
    private static final yg2<ik2> zzbq = new mk2();
    private final int value;

    private ik2(int i) {
        this.value = i;
    }

    public static ik2 zzbc(int i) {
        if (i == 0) {
            return DEFAULT;
        }
        if (i == 1) {
            return UNMETERED_ONLY;
        }
        if (i == 2) {
            return UNMETERED_OR_DAILY;
        }
        if (i == 3) {
            return FAST_IF_RADIO_AWAKE;
        }
        if (i != 4) {
            return null;
        }
        return NEVER;
    }

    public static yg2<ik2> zzd() {
        return zzbq;
    }

    @Override // defpackage.xg2
    public final int zzc() {
        return this.value;
    }
}
