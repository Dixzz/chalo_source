package defpackage;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.ui.R;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: pj  reason: default package */
/* compiled from: AbstractAppBarOnDestinationChangedListener */
public abstract class pj implements NavController.b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2810a;
    public final Set<Integer> b;
    public final WeakReference<ea> c;
    public y0 d;
    public ValueAnimator e;

    public pj(Context context, rj rjVar) {
        this.f2810a = context;
        this.b = rjVar.f3086a;
        ea eaVar = rjVar.b;
        if (eaVar != null) {
            this.c = new WeakReference<>(eaVar);
        } else {
            this.c = null;
        }
    }

    @Override // androidx.navigation.NavController.b
    public void a(NavController navController, ej ejVar, Bundle bundle) {
        boolean z;
        int i;
        if (!(ejVar instanceof ui)) {
            WeakReference<ea> weakReference = this.c;
            ea eaVar = weakReference != null ? weakReference.get() : null;
            if (this.c == null || eaVar != null) {
                CharSequence charSequence = ejVar.j;
                if (charSequence != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle == null || !bundle.containsKey(group)) {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill label " + ((Object) charSequence));
                        }
                        matcher.appendReplacement(stringBuffer, "");
                        stringBuffer.append(bundle.get(group).toString());
                    }
                    matcher.appendTail(stringBuffer);
                    ((qj) this).f.getSupportActionBar().z(stringBuffer);
                }
                boolean g0 = h.g0(ejVar, this.b);
                if (eaVar != null || !g0) {
                    boolean z2 = eaVar != null && g0;
                    if (this.d == null) {
                        this.d = new y0(this.f2810a);
                        z = false;
                    } else {
                        z = true;
                    }
                    y0 y0Var = this.d;
                    if (z2) {
                        i = R.string.nav_app_bar_open_drawer_description;
                    } else {
                        i = R.string.nav_app_bar_navigate_up_description;
                    }
                    b(y0Var, i);
                    float f = z2 ? 0.0f : 1.0f;
                    if (z) {
                        float f2 = this.d.i;
                        ValueAnimator valueAnimator = this.e;
                        if (valueAnimator != null) {
                            valueAnimator.cancel();
                        }
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.d, "progress", f2, f);
                        this.e = ofFloat;
                        ofFloat.start();
                        return;
                    }
                    this.d.setProgress(f);
                    return;
                }
                b(null, 0);
                return;
            }
            navController.l.remove(this);
        }
    }

    public abstract void b(Drawable drawable, int i);
}
