package defpackage;

import java.util.List;

/* renamed from: tc5  reason: default package */
/* compiled from: MixpanelNotificationData */
public class tc5 {

    /* renamed from: a  reason: collision with root package name */
    public int f3332a = -1;
    public int b = -1;
    public int c = -1;
    public String d;
    public CharSequence e;
    public CharSequence f;
    public String g;
    public List<a> h;
    public String i = "mp";
    public String j;
    public String k;
    public boolean l;
    public String m;
    public int n;
    public boolean o;
    public String p;
    public b q;
    public String r;
    public String s;
    public String t;

    /* renamed from: tc5$a */
    /* compiled from: MixpanelNotificationData */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f3333a;
        public b b;
        public String c;

        public a(String str, b bVar, String str2) {
            this.f3333a = str;
            this.b = bVar;
            this.c = str2;
        }
    }

    /* renamed from: tc5$c */
    /* compiled from: MixpanelNotificationData */
    public enum c {
        HOMESCREEN("homescreen"),
        URL_IN_BROWSER("browser"),
        DEEP_LINK("deeplink"),
        ERROR("error");
        
        private String stringVal;

        private c(String str) {
            this.stringVal = str;
        }

        public static c fromString(String str) {
            c[] values = values();
            for (int i = 0; i < 4; i++) {
                c cVar = values[i];
                if (cVar.toString().equals(str)) {
                    return cVar;
                }
            }
            return ERROR;
        }

        public String toString() {
            return this.stringVal;
        }
    }

    /* renamed from: tc5$b */
    /* compiled from: MixpanelNotificationData */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final c f3334a;
        public final String b;

        public b(c cVar) {
            this.f3334a = cVar;
            this.b = null;
        }

        public b(c cVar, String str) {
            this.f3334a = cVar;
            this.b = str;
        }
    }
}
