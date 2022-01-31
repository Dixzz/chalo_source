package defpackage;

import android.content.Context;
import app.zophop.R;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;
import java.util.Locale;

/* renamed from: h30  reason: default package */
/* compiled from: LanguageFeature.kt */
public final class h30 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1334a;
    public final String b = "current_language_key";

    /* renamed from: h30$a */
    /* compiled from: LanguageFeature.kt */
    public enum a {
        ENGLISH(R.string.english, "en"),
        HINDI(R.string.hindi, "hi"),
        TAMIL(R.string.tamil, "tm"),
        TELUGU(R.string.telugu, "tl"),
        BENGALI(R.string.bengali, "bn"),
        MARATHI(R.string.marathi, "mr"),
        MALAYALAM(R.string.malaylam, "ml"),
        ASSAMESE(R.string.assamese, "as"),
        KANNADA(R.string.kannada, "kn");
        
        private final int languageResId;
        private final String locale;

        private a(int i, String str) {
            this.languageResId = i;
            this.locale = str;
        }

        public final String getLanguageName(Context context) {
            n86.e(context, AnalyticsConstants.CONTEXT);
            String string = context.getString(this.languageResId);
            n86.d(string, "context.getString(languageResId)");
            return string;
        }

        public final String getLocale() {
            return this.locale;
        }
    }

    public h30(Context context) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        this.f1334a = context;
    }

    public final String a() {
        return c(b());
    }

    public final String b() {
        String str;
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.l().get(this.b) == null) {
            sf1 l = t1Var.l();
            String str2 = this.b;
            String locale = Locale.getDefault().toString();
            n86.d(locale, "getDefault().toString()");
            String substring = locale.substring(0, 2);
            n86.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            a aVar = a.MARATHI;
            if (n86.a(substring, aVar.getLocale())) {
                str = aVar.getLocale();
            } else {
                a aVar2 = a.HINDI;
                if (n86.a(substring, aVar2.getLocale())) {
                    str = aVar2.getLocale();
                } else {
                    a aVar3 = a.BENGALI;
                    if (n86.a(substring, aVar3.getLocale())) {
                        str = aVar3.getLocale();
                    } else {
                        str = a.ENGLISH.getLocale();
                    }
                }
            }
            l.put(str2, str);
        }
        return (String) t1Var.l().get(this.b);
    }

    public final String c(String str) {
        a[] values = a.values();
        int i = 0;
        while (i < 9) {
            a aVar = values[i];
            i++;
            if (n86.a(aVar.getLocale(), str)) {
                return aVar.getLanguageName(this.f1334a);
            }
        }
        return a.ENGLISH.getLanguageName(this.f1334a);
    }
}
