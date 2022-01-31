package defpackage;

import android.content.pm.ResolveInfo;
import java.util.List;

/* renamed from: li1  reason: default package */
/* compiled from: ShareUtil */
public class li1 {

    /* renamed from: a  reason: collision with root package name */
    public static List<ResolveInfo> f2222a;

    /* renamed from: li1$a */
    /* compiled from: ShareUtil */
    public enum a {
        TWITTER("twitter"),
        FACEBOOK("facebook.katana"),
        GOOGLE("google.android.apps.plus"),
        WHATSAPP("whatsapp"),
        OTHER("other");
        
        private final String value;

        private a(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }
}
