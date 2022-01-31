package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: un2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class un2 {

    /* renamed from: a  reason: collision with root package name */
    public final tn2 f3528a;

    public un2(tn2 tn2) {
        this.f3528a = tn2;
    }

    public static un2 a(String str) {
        int i = b83.f396a;
        q53 q53 = new q53(Pattern.compile("[.-]"));
        Matcher matcher = q53.f.matcher("");
        Objects.requireNonNull(matcher);
        if (!matcher.matches()) {
            return new un2(new jm2(q53));
        }
        throw new IllegalArgumentException(gj1.F1("The pattern may not match the empty string: %s", q53));
    }

    public final List<String> b(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        Iterator<String> a2 = this.f3528a.a(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (a2.hasNext()) {
            arrayList.add(a2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
