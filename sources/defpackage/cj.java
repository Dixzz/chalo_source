package defpackage;

import android.net.Uri;
import android.os.Bundle;
import com.rabbitmq.client.ConnectionFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: cj  reason: default package */
/* compiled from: NavDeepLink */
public final class cj {
    public static final Pattern i = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<String> f570a = new ArrayList<>();
    public final Map<String, b> b = new HashMap();
    public Pattern c = null;
    public boolean d = false;
    public boolean e = false;
    public final String f;
    public Pattern g = null;
    public final String h;

    /* renamed from: cj$a */
    /* compiled from: NavDeepLink */
    public static class a implements Comparable<a> {
        public String f;
        public String g;

        public a(String str) {
            String[] split = str.split(ConnectionFactory.DEFAULT_VHOST, -1);
            this.f = split[0];
            this.g = split[1];
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            int i = this.f.equals(aVar.f) ? 2 : 0;
            return this.g.equals(aVar.g) ? i + 1 : i;
        }
    }

    /* renamed from: cj$b */
    /* compiled from: NavDeepLink */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f571a;
        public ArrayList<String> b = new ArrayList<>();
    }

    public cj(String str, String str2, String str3) {
        this.f = str2;
        this.h = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            int i2 = 1;
            this.e = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!i.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.e) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    a(str.substring(0, matcher.start()), sb, compile);
                }
                this.d = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    b bVar = new b();
                    int i3 = 0;
                    while (matcher2.find()) {
                        bVar.b.add(matcher2.group(i2));
                        sb2.append(Pattern.quote(queryParameter.substring(i3, matcher2.start())));
                        sb2.append("(.+?)?");
                        i3 = matcher2.end();
                        i2 = 1;
                    }
                    if (i3 < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(i3)));
                    }
                    bVar.f571a = sb2.toString().replace(".*", "\\E.*\\Q");
                    this.b.put(str4, bVar);
                    i2 = 1;
                }
            } else {
                this.d = a(str, sb, compile);
            }
            this.c = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"), 2);
        }
        if (str3 == null) {
            return;
        }
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
            a aVar = new a(str3);
            StringBuilder i0 = hj1.i0("^(");
            i0.append(aVar.f);
            i0.append("|[*]+)/(");
            i0.append(aVar.g);
            i0.append("|[*]+)$");
            this.g = Pattern.compile(i0.toString().replace("*|[*]", "[\\s\\S]"));
            return;
        }
        throw new IllegalArgumentException(hj1.T("The given mimeType ", str3, " does not match to required \"type/subtype\" format"));
    }

    public final boolean a(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !str.contains(".*");
        int i2 = 0;
        while (matcher.find()) {
            this.f570a.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i2, matcher.start())));
            sb.append("(.+?)");
            i2 = matcher.end();
            z = false;
        }
        if (i2 < str.length()) {
            sb.append(Pattern.quote(str.substring(i2)));
        }
        sb.append("($|(\\?(.)*))");
        return z;
    }

    public final boolean b(Bundle bundle, String str, String str2, zi ziVar) {
        if (ziVar != null) {
            lj ljVar = ziVar.f4177a;
            try {
                ljVar.d(bundle, str, ljVar.c(str2));
                return false;
            } catch (IllegalArgumentException unused) {
                return true;
            }
        } else {
            bundle.putString(str, str2);
            return false;
        }
    }
}
