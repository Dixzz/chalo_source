package defpackage;

import android.view.View;
import android.view.ViewParent;

/* renamed from: i8  reason: default package */
/* compiled from: NestedScrollingChildHelper */
public class i8 {

    /* renamed from: a  reason: collision with root package name */
    public ViewParent f1488a;
    public ViewParent b;
    public final View c;
    public boolean d;
    public int[] e;

    public i8(View view) {
        this.c = view;
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent g;
        if (!this.d || (g = g(0)) == null) {
            return false;
        }
        try {
            return g.onNestedFling(this.c, f, f2, z);
        } catch (AbstractMethodError unused) {
            String str = "ViewParent " + g + " does not implement interface method onNestedFling";
            return false;
        }
    }

    public boolean b(float f, float f2) {
        ViewParent g;
        if (!this.d || (g = g(0)) == null) {
            return false;
        }
        try {
            return g.onNestedPreFling(this.c, f, f2);
        } catch (AbstractMethodError unused) {
            String str = "ViewParent " + g + " does not implement interface method onNestedPreFling";
            return false;
        }
    }

    public boolean c(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent g;
        int i4;
        int i5;
        int[] iArr3;
        if (!this.d || (g = g(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i4 = iArr2[1];
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr3 = this.e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        View view = this.c;
        if (g instanceof j8) {
            ((j8) g).onNestedPreScroll(view, i, i2, iArr3, i3);
        } else if (i3 == 0) {
            try {
                g.onNestedPreScroll(view, i, i2, iArr3);
            } catch (AbstractMethodError unused) {
                String str = "ViewParent " + g + " does not implement interface method onNestedPreScroll";
            }
        }
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i4;
        }
        if (iArr3[0] == 0 && iArr3[1] == 0) {
            return false;
        }
        return true;
    }

    public void d(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        f(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public boolean e(int i, int i2, int i3, int i4, int[] iArr) {
        return f(i, i2, i3, i4, iArr, 0, null);
    }

    public final boolean f(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent g;
        int i6;
        int i7;
        int[] iArr3;
        if (!this.d || (g = g(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            i7 = iArr[0];
            i6 = iArr[1];
        } else {
            i7 = 0;
            i6 = 0;
        }
        if (iArr2 == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            int[] iArr4 = this.e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        View view = this.c;
        if (g instanceof k8) {
            ((k8) g).onNestedScroll(view, i, i2, i3, i4, i5, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i3;
            iArr3[1] = iArr3[1] + i4;
            if (g instanceof j8) {
                ((j8) g).onNestedScroll(view, i, i2, i3, i4, i5);
            } else if (i5 == 0) {
                try {
                    g.onNestedScroll(view, i, i2, i3, i4);
                } catch (AbstractMethodError unused) {
                    String str = "ViewParent " + g + " does not implement interface method onNestedScroll";
                }
            }
        }
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i7;
            iArr[1] = iArr[1] - i6;
        }
        return true;
    }

    public final ViewParent g(int i) {
        if (i == 0) {
            return this.f1488a;
        }
        if (i != 1) {
            return null;
        }
        return this.b;
    }

    public boolean h(int i) {
        return g(i) != null;
    }

    public boolean i(int i, int i2) {
        boolean z;
        if (g(i2) != null) {
            return true;
        }
        if (this.d) {
            View view = this.c;
            for (ViewParent parent = this.c.getParent(); parent != null; parent = parent.getParent()) {
                View view2 = this.c;
                boolean z2 = parent instanceof j8;
                if (z2) {
                    z = ((j8) parent).onStartNestedScroll(view, view2, i, i2);
                } else {
                    if (i2 == 0) {
                        try {
                            z = parent.onStartNestedScroll(view, view2, i);
                        } catch (AbstractMethodError unused) {
                            String str = "ViewParent " + parent + " does not implement interface method onStartNestedScroll";
                        }
                    }
                    z = false;
                }
                if (z) {
                    if (i2 == 0) {
                        this.f1488a = parent;
                    } else if (i2 == 1) {
                        this.b = parent;
                    }
                    View view3 = this.c;
                    if (z2) {
                        ((j8) parent).onNestedScrollAccepted(view, view3, i, i2);
                    } else if (i2 == 0) {
                        try {
                            parent.onNestedScrollAccepted(view, view3, i);
                        } catch (AbstractMethodError unused2) {
                            String str2 = "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted";
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public void j(int i) {
        ViewParent g = g(i);
        if (g != null) {
            View view = this.c;
            if (g instanceof j8) {
                ((j8) g).onStopNestedScroll(view, i);
            } else if (i == 0) {
                try {
                    g.onStopNestedScroll(view);
                } catch (AbstractMethodError unused) {
                    String str = "ViewParent " + g + " does not implement interface method onStopNestedScroll";
                }
            }
            if (i == 0) {
                this.f1488a = null;
            } else if (i == 1) {
                this.b = null;
            }
        }
    }
}
