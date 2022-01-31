package defpackage;

/* renamed from: zu2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public enum zu2 implements ga3 {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    
    private static final ha3<zu2> zzf = new yu2();
    private final int zzg;

    private zu2(int i) {
        this.zzg = i;
    }

    public static zu2 zzb(int i) {
        if (i == 0) {
            return UNKNOWN_STATUS;
        }
        if (i == 1) {
            return ENABLED;
        }
        if (i == 2) {
            return DISABLED;
        }
        if (i != 3) {
            return null;
        }
        return DESTROYED;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zu2.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=");
            sb.append(zza());
        }
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzg;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
