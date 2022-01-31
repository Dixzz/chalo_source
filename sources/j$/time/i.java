package j$.time;

import j$.time.zone.c;
import j$.time.zone.d;
import j$.time.zone.e;
import java.io.Serializable;

/* access modifiers changed from: package-private */
public final class i extends ZoneId implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final String f1623a;
    private final transient c b;

    i(String str, c cVar) {
        this.f1623a = str;
        this.b = cVar;
    }

    static i x(String str, boolean z) {
        int length = str.length();
        if (length >= 2) {
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i == 0) && ((charAt < '0' || charAt > '9' || i == 0) && ((charAt != '~' || i == 0) && ((charAt != '.' || i == 0) && ((charAt != '_' || i == 0) && ((charAt != '+' || i == 0) && (charAt != '-' || i == 0))))))))) {
                    throw new b("Invalid ID for region-based ZoneId, invalid format: " + str);
                }
            }
            c cVar = null;
            try {
                cVar = e.a(str, true);
            } catch (d e) {
                if (z) {
                    throw e;
                }
            }
            return new i(str, cVar);
        }
        throw new b("Invalid ID for region-based ZoneId, invalid format: " + str);
    }

    @Override // j$.time.ZoneId
    public String g() {
        return this.f1623a;
    }

    @Override // j$.time.ZoneId
    public c t() {
        c cVar = this.b;
        return cVar != null ? cVar : e.a(this.f1623a, false);
    }
}
