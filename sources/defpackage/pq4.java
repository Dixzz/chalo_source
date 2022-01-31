package defpackage;

/* renamed from: pq4  reason: default package */
public abstract class pq4 {
    public static pq4 c(int i) {
        Integer valueOf = Integer.valueOf(i);
        Boolean bool = Boolean.FALSE;
        String str = "";
        if (valueOf == null) {
            str = str.concat(" appUpdateType");
        }
        if (bool == null) {
            str = String.valueOf(str).concat(" allowAssetPackDeletion");
        }
        if (str.isEmpty()) {
            return new gr4(valueOf.intValue(), bool.booleanValue());
        }
        throw new IllegalStateException(str.length() != 0 ? "Missing required properties:".concat(str) : new String("Missing required properties:"));
    }

    public abstract boolean a();

    public abstract int b();
}
