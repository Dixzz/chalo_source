package defpackage;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

/* renamed from: mp  reason: default package */
/* compiled from: ContentUriTriggers */
public final class mp {

    /* renamed from: a  reason: collision with root package name */
    public final Set<a> f2421a = new HashSet();

    /* renamed from: mp$a */
    /* compiled from: ContentUriTriggers */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f2422a;
        public final boolean b;

        public a(Uri uri, boolean z) {
            this.f2422a = uri;
            this.b = z;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b != aVar.b || !this.f2422a.equals(aVar.f2422a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f2422a.hashCode() * 31) + (this.b ? 1 : 0);
        }
    }

    public int a() {
        return this.f2421a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || mp.class != obj.getClass()) {
            return false;
        }
        return this.f2421a.equals(((mp) obj).f2421a);
    }

    public int hashCode() {
        return this.f2421a.hashCode();
    }
}
