package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* renamed from: d1  reason: default package */
/* compiled from: ContextThemeWrapper */
public class d1 extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public int f776a;
    public Resources.Theme b;
    public LayoutInflater c;
    public Configuration d;
    public Resources e;

    public d1() {
        super(null);
    }

    public void a(Configuration configuration) {
        if (this.e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.d == null) {
            this.d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.b == null) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.b.applyStyle(this.f776a, true);
    }

    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    public Resources getResources() {
        if (this.e == null) {
            Configuration configuration = this.d;
            if (configuration == null) {
                this.e = super.getResources();
            } else {
                this.e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.e;
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.c == null) {
            this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.c;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
        }
        if (this.f776a == 0) {
            this.f776a = R.style.Theme_AppCompat_Light;
        }
        b();
        return this.b;
    }

    public void setTheme(int i) {
        if (this.f776a != i) {
            this.f776a = i;
            b();
        }
    }

    public d1(Context context, int i) {
        super(context);
        this.f776a = i;
    }

    public d1(Context context, Resources.Theme theme) {
        super(context);
        this.b = theme;
    }
}
