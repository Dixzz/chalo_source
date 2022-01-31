package defpackage;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: wt5  reason: default package */
/* compiled from: UrlAllowList */
public class wt5 {
    public static final Pattern b = Pattern.compile("((\\*)|(\\*\\.[^/\\*]+)|([^/\\*]+))", 2);
    public static final Pattern c = Pattern.compile("([^\\s]*)", 2);

    /* renamed from: a  reason: collision with root package name */
    public final List<b> f3838a = new ArrayList();

    /* renamed from: wt5$b */
    /* compiled from: UrlAllowList */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f3839a;
        public final c b;

        public b(c cVar, int i, a aVar) {
            this.f3839a = i;
            this.b = cVar;
        }
    }

    /* renamed from: wt5$c */
    /* compiled from: UrlAllowList */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final Pattern f3840a;
        public final Pattern b;
        public final Pattern c;

        public c(Pattern pattern, Pattern pattern2, Pattern pattern3) {
            this.f3840a = pattern;
            this.b = pattern2;
            this.c = pattern3;
        }

        public boolean a(Uri uri) {
            if (this.f3840a != null && (uri.getScheme() == null || !this.f3840a.matcher(uri.getScheme()).matches())) {
                return false;
            }
            if (this.b != null && (uri.getHost() == null || !this.b.matcher(uri.getHost()).matches())) {
                return false;
            }
            String schemeSpecificPart = uri.isOpaque() ? uri.getSchemeSpecificPart() : uri.getPath();
            Pattern pattern = this.c;
            if (pattern == null || (schemeSpecificPart != null && pattern.matcher(schemeSpecificPart).matches())) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            Pattern pattern = this.f3840a;
            if (pattern == null ? cVar.f3840a != null : !pattern.equals(cVar.f3840a)) {
                return false;
            }
            Pattern pattern2 = this.b;
            if (pattern2 == null ? cVar.b != null : !pattern2.equals(cVar.b)) {
                return false;
            }
            Pattern pattern3 = this.c;
            Pattern pattern4 = cVar.c;
            if (pattern3 != null) {
                return pattern3.equals(pattern4);
            }
            if (pattern4 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Pattern pattern = this.f3840a;
            int i = 0;
            int hashCode = (pattern != null ? pattern.hashCode() : 0) * 31;
            Pattern pattern2 = this.b;
            int hashCode2 = (hashCode + (pattern2 != null ? pattern2.hashCode() : 0)) * 31;
            Pattern pattern3 = this.c;
            if (pattern3 != null) {
                i = pattern3.hashCode();
            }
            return hashCode2 + i;
        }
    }

    public final void a(c cVar, int i) {
        synchronized (this.f3838a) {
            this.f3838a.add(new b(cVar, i, null));
        }
    }

    public boolean b(String str, int i) {
        Pattern pattern;
        Pattern pattern2 = null;
        if (str.equals("*")) {
            a(new c(null, null, null), i);
            return true;
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            yj5.c("Invalid URL allow list pattern %s", str);
            return false;
        }
        String scheme = parse.getScheme();
        if (!hd3.G1(scheme)) {
            Pattern pattern3 = c;
            if (pattern3.matcher(scheme).matches()) {
                String encodedAuthority = parse.getEncodedAuthority();
                if (hd3.G1(encodedAuthority)) {
                    encodedAuthority = null;
                }
                if (encodedAuthority == null || b.matcher(encodedAuthority).matches()) {
                    String schemeSpecificPart = parse.isOpaque() ? parse.getSchemeSpecificPart() : parse.getPath();
                    if (schemeSpecificPart == null || pattern3.matcher(schemeSpecificPart).matches()) {
                        Pattern compile = (hd3.G1(scheme) || scheme.equals("*")) ? null : Pattern.compile(c(scheme, false));
                        if (hd3.G1(encodedAuthority) || encodedAuthority.equals("*")) {
                            pattern = null;
                        } else if (encodedAuthority.startsWith("*.")) {
                            StringBuilder i0 = hj1.i0("(.*\\.)?");
                            i0.append(c(encodedAuthority.substring(2), true));
                            pattern = Pattern.compile(i0.toString());
                        } else {
                            pattern = Pattern.compile(c(encodedAuthority, true));
                        }
                        if (!hd3.G1(schemeSpecificPart) && !schemeSpecificPart.equals("/*")) {
                            pattern2 = Pattern.compile(c(schemeSpecificPart, false));
                        }
                        a(new c(compile, pattern, pattern2), i);
                        return true;
                    }
                    yj5.c("Invalid path %s in URL allow list pattern %s", schemeSpecificPart, str);
                    return false;
                }
                yj5.c("Invalid host %s in URL allow list pattern %s", encodedAuthority, str);
                return false;
            }
        }
        yj5.c("Invalid scheme %s in URL allow list pattern %s", scheme, str);
        return false;
    }

    public final String c(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (char c2 : str.toCharArray()) {
            String valueOf = String.valueOf(c2);
            if (!z && valueOf.equals("*")) {
                sb.append(".");
            } else if ("\\.[]{}()^$?+|*".contains(valueOf)) {
                sb.append("\\");
            }
            sb.append(valueOf);
        }
        return sb.toString();
    }

    public boolean d(String str, int i) {
        int i2;
        if (str == null) {
            return false;
        }
        Uri parse = Uri.parse(str);
        synchronized (this.f3838a) {
            i2 = 0;
            for (b bVar : this.f3838a) {
                if (bVar.b.a(parse)) {
                    i2 |= bVar.f3839a;
                }
            }
        }
        if ((i2 & i) == i) {
            return true;
        }
        return false;
    }
}
