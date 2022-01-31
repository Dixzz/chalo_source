package defpackage;

import android.content.Context;
import java.io.IOException;
import java.util.Objects;

/* renamed from: nt5  reason: default package */
/* compiled from: NativeBridge */
public class nt5 implements Runnable {
    public final /* synthetic */ ck5 f;
    public final /* synthetic */ lt5 g;
    public final /* synthetic */ Context h;

    public nt5(ot5 ot5, ck5 ck5, lt5 lt5, Context context) {
        this.f = ck5;
        this.g = lt5;
        this.h = context;
    }

    public void run() {
        String str;
        ck5 ck5 = this.f;
        lt5 lt5 = this.g;
        Context context = this.h;
        Objects.requireNonNull(lt5);
        StringBuilder sb = new StringBuilder();
        sb.append("var _UAirship = {};");
        for (String str2 : lt5.f2268a) {
            sb.append(str2);
        }
        try {
            sb.append(lt5.a(context));
            str = sb.toString();
        } catch (IOException unused) {
            yj5.c("Failed to read native bridge.", new Object[0]);
            str = "";
        }
        ck5.d(str);
    }
}
