package defpackage;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

/* renamed from: q53  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class q53 extends q33 implements Serializable {
    public final Pattern f;

    public q53(Pattern pattern) {
        Objects.requireNonNull(pattern);
        this.f = pattern;
    }

    public final String toString() {
        return this.f.toString();
    }
}
