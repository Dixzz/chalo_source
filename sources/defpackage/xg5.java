package defpackage;

import android.content.Context;
import com.truecaller.android.sdk.ITrueCallback;
import java.util.Locale;

/* renamed from: xg5  reason: default package */
/* compiled from: TcClient */
public abstract class xg5 {

    /* renamed from: a  reason: collision with root package name */
    public Context f3926a;
    public ITrueCallback b;
    public int c;
    public final String d;
    public String e;
    public Locale f;
    public int g;

    public xg5(Context context, String str, ITrueCallback iTrueCallback, int i) {
        this.f3926a = context;
        this.d = str;
        this.c = i;
        this.b = iTrueCallback;
    }
}
