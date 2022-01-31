package defpackage;

/* renamed from: f73  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public enum f73 {
    REFRESH_TOKEN("refresh_token"),
    AUTHORIZATION_CODE("authorization_code");
    
    private final String zzc;

    private f73(String str) {
        this.zzc = str;
    }

    public final String toString() {
        return this.zzc;
    }
}
