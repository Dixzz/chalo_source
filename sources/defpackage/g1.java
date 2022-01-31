package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: g1  reason: default package */
/* compiled from: SupportMenuInflater */
public class g1 extends MenuInflater {
    public static final Class<?>[] e;
    public static final Class<?>[] f;

    /* renamed from: a  reason: collision with root package name */
    public final Object[] f1199a;
    public final Object[] b;
    public Context c;
    public Object d;

    /* renamed from: g1$a */
    /* compiled from: SupportMenuInflater */
    public static class a implements MenuItem.OnMenuItemClickListener {
        public static final Class<?>[] c = {MenuItem.class};

        /* renamed from: a  reason: collision with root package name */
        public Object f1200a;
        public Method b;

        public a(Object obj, String str) {
            this.f1200a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.b = cls.getMethod(str, c);
            } catch (Exception e) {
                StringBuilder l0 = hj1.l0("Couldn't resolve menu item onClick handler ", str, " in class ");
                l0.append(cls.getName());
                InflateException inflateException = new InflateException(l0.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.b.invoke(this.f1200a, menuItem)).booleanValue();
                }
                this.b.invoke(this.f1200a, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: g1$b */
    /* compiled from: SupportMenuInflater */
    public class b {
        public a8 A;
        public CharSequence B;
        public CharSequence C;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;

        /* renamed from: a  reason: collision with root package name */
        public Menu f1201a;
        public int b;
        public int c;
        public int d;
        public int e;
        public boolean f;
        public boolean g;
        public boolean h;
        public int i;
        public int j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;

        public b(Menu menu) {
            this.f1201a = menu;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = true;
            this.g = true;
        }

        public SubMenu a() {
            this.h = true;
            SubMenu addSubMenu = this.f1201a.addSubMenu(this.b, this.i, this.j, this.k);
            c(addSubMenu.getItem());
            return addSubMenu;
        }

        public final <T> T b(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g1.this.c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception unused) {
                return null;
            }
        }

        public final void c(MenuItem menuItem) {
            int i2 = Build.VERSION.SDK_INT;
            boolean z2 = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i3 = this.v;
            if (i3 >= 0) {
                menuItem.setShowAsAction(i3);
            }
            if (this.z != null) {
                if (!g1.this.c.isRestricted()) {
                    g1 g1Var = g1.this;
                    if (g1Var.d == null) {
                        g1Var.d = g1Var.a(g1Var.c);
                    }
                    menuItem.setOnMenuItemClickListener(new a(g1Var.d, this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof r1) {
                    r1 r1Var = (r1) menuItem;
                    r1Var.x = (r1Var.x & -5) | 4;
                } else if (menuItem instanceof s1) {
                    s1 s1Var = (s1) menuItem;
                    try {
                        if (s1Var.e == null) {
                            s1Var.e = s1Var.d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        s1Var.e.invoke(s1Var.d, Boolean.TRUE);
                    } catch (Exception unused) {
                    }
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) b(str, g1.e, g1.this.f1199a));
                z2 = true;
            }
            int i4 = this.w;
            if (i4 > 0 && !z2) {
                menuItem.setActionView(i4);
            }
            a8 a8Var = this.A;
            if (a8Var != null && (menuItem instanceof r6)) {
                ((r6) menuItem).a(a8Var);
            }
            CharSequence charSequence = this.B;
            boolean z3 = menuItem instanceof r6;
            if (z3) {
                ((r6) menuItem).setContentDescription(charSequence);
            } else if (i2 >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.C;
            if (z3) {
                ((r6) menuItem).setTooltipText(charSequence2);
            } else if (i2 >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c2 = this.n;
            int i5 = this.o;
            if (z3) {
                ((r6) menuItem).setAlphabeticShortcut(c2, i5);
            } else if (i2 >= 26) {
                menuItem.setAlphabeticShortcut(c2, i5);
            }
            char c3 = this.p;
            int i6 = this.q;
            if (z3) {
                ((r6) menuItem).setNumericShortcut(c3, i6);
            } else if (i2 >= 26) {
                menuItem.setNumericShortcut(c3, i6);
            }
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                if (z3) {
                    ((r6) menuItem).setIconTintMode(mode);
                } else if (i2 >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList == null) {
                return;
            }
            if (z3) {
                ((r6) menuItem).setIconTintList(colorStateList);
            } else if (i2 >= 26) {
                menuItem.setIconTintList(colorStateList);
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        e = clsArr;
        f = clsArr;
    }

    public g1(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.f1199a = objArr;
        this.b = objArr;
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        char c2;
        char c3;
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException(hj1.S("Expecting menu, got ", name));
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                            eventType = xmlPullParser.next();
                        } else if (name2.equals("group")) {
                            bVar.b = 0;
                            bVar.c = 0;
                            bVar.d = 0;
                            bVar.e = 0;
                            bVar.f = true;
                            bVar.g = true;
                        } else if (name2.equals("item")) {
                            if (!bVar.h) {
                                a8 a8Var = bVar.A;
                                if (a8Var == null || !a8Var.hasSubMenu()) {
                                    bVar.h = true;
                                    bVar.c(bVar.f1201a.add(bVar.b, bVar.i, bVar.j, bVar.k));
                                } else {
                                    bVar.a();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                            eventType = xmlPullParser.next();
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        TypedArray obtainStyledAttributes = g1.this.c.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
                        bVar.b = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
                        bVar.c = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
                        bVar.d = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
                        bVar.e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
                        bVar.f = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
                        bVar.g = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
                        obtainStyledAttributes.recycle();
                    } else if (name3.equals("item")) {
                        TintTypedArray obtainStyledAttributes2 = TintTypedArray.obtainStyledAttributes(g1.this.c, attributeSet, R.styleable.MenuItem);
                        bVar.i = obtainStyledAttributes2.getResourceId(R.styleable.MenuItem_android_id, 0);
                        bVar.j = (obtainStyledAttributes2.getInt(R.styleable.MenuItem_android_menuCategory, bVar.c) & -65536) | (obtainStyledAttributes2.getInt(R.styleable.MenuItem_android_orderInCategory, bVar.d) & 65535);
                        bVar.k = obtainStyledAttributes2.getText(R.styleable.MenuItem_android_title);
                        bVar.l = obtainStyledAttributes2.getText(R.styleable.MenuItem_android_titleCondensed);
                        bVar.m = obtainStyledAttributes2.getResourceId(R.styleable.MenuItem_android_icon, 0);
                        String string = obtainStyledAttributes2.getString(R.styleable.MenuItem_android_alphabeticShortcut);
                        if (string == null) {
                            c2 = 0;
                        } else {
                            c2 = string.charAt(0);
                        }
                        bVar.n = c2;
                        bVar.o = obtainStyledAttributes2.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
                        String string2 = obtainStyledAttributes2.getString(R.styleable.MenuItem_android_numericShortcut);
                        if (string2 == null) {
                            c3 = 0;
                        } else {
                            c3 = string2.charAt(0);
                        }
                        bVar.p = c3;
                        bVar.q = obtainStyledAttributes2.getInt(R.styleable.MenuItem_numericModifiers, 4096);
                        int i = R.styleable.MenuItem_android_checkable;
                        if (obtainStyledAttributes2.hasValue(i)) {
                            bVar.r = obtainStyledAttributes2.getBoolean(i, false) ? 1 : 0;
                        } else {
                            bVar.r = bVar.e;
                        }
                        bVar.s = obtainStyledAttributes2.getBoolean(R.styleable.MenuItem_android_checked, false);
                        bVar.t = obtainStyledAttributes2.getBoolean(R.styleable.MenuItem_android_visible, bVar.f);
                        bVar.u = obtainStyledAttributes2.getBoolean(R.styleable.MenuItem_android_enabled, bVar.g);
                        bVar.v = obtainStyledAttributes2.getInt(R.styleable.MenuItem_showAsAction, -1);
                        bVar.z = obtainStyledAttributes2.getString(R.styleable.MenuItem_android_onClick);
                        bVar.w = obtainStyledAttributes2.getResourceId(R.styleable.MenuItem_actionLayout, 0);
                        bVar.x = obtainStyledAttributes2.getString(R.styleable.MenuItem_actionViewClass);
                        String string3 = obtainStyledAttributes2.getString(R.styleable.MenuItem_actionProviderClass);
                        bVar.y = string3;
                        if ((string3 != null) && bVar.w == 0 && bVar.x == null) {
                            bVar.A = (a8) bVar.b(string3, f, g1.this.b);
                        } else {
                            bVar.A = null;
                        }
                        bVar.B = obtainStyledAttributes2.getText(R.styleable.MenuItem_contentDescription);
                        bVar.C = obtainStyledAttributes2.getText(R.styleable.MenuItem_tooltipText);
                        int i2 = R.styleable.MenuItem_iconTintMode;
                        if (obtainStyledAttributes2.hasValue(i2)) {
                            bVar.E = DrawableUtils.parseTintMode(obtainStyledAttributes2.getInt(i2, -1), bVar.E);
                        } else {
                            bVar.E = null;
                        }
                        int i3 = R.styleable.MenuItem_iconTint;
                        if (obtainStyledAttributes2.hasValue(i3)) {
                            bVar.D = obtainStyledAttributes2.getColorStateList(i3);
                        } else {
                            bVar.D = null;
                        }
                        obtainStyledAttributes2.recycle();
                        bVar.h = false;
                    } else {
                        if (name3.equals("menu")) {
                            b(xmlPullParser, attributeSet, bVar.a());
                        } else {
                            z2 = true;
                            str = name3;
                        }
                        eventType = xmlPullParser.next();
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    public void inflate(int i, Menu menu) {
        if (!(menu instanceof q6)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.c.getResources().getLayout(i);
            b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            xmlResourceParser.close();
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
