package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import com.google.firebase.perf.util.Constants;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: e0  reason: default package */
/* compiled from: AlertDialog */
public class e0 extends n0 implements DialogInterface {
    public final AlertController h = new AlertController(getContext(), this, getWindow());

    public e0(Context context, int i) {
        super(context, e(context, i));
    }

    public static int e(Context context, int i) {
        if (((i >>> 24) & Constants.MAX_HOST_LENGTH) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button d(int i) {
        AlertController alertController = this.h;
        Objects.requireNonNull(alertController);
        if (i == -3) {
            return alertController.w;
        }
        if (i == -2) {
            return alertController.s;
        }
        if (i != -1) {
            return null;
        }
        return alertController.o;
    }

    @Override // defpackage.n0
    public void onCreate(Bundle bundle) {
        int i;
        boolean z;
        View view;
        ListAdapter listAdapter;
        View view2;
        View view3;
        View findViewById;
        super.onCreate(bundle);
        AlertController alertController = this.h;
        if (alertController.K == 0) {
            i = alertController.J;
        } else {
            i = alertController.J;
        }
        alertController.b.setContentView(i);
        View findViewById2 = alertController.c.findViewById(R.id.parentPanel);
        int i2 = R.id.topPanel;
        View findViewById3 = findViewById2.findViewById(i2);
        int i3 = R.id.contentPanel;
        View findViewById4 = findViewById2.findViewById(i3);
        int i4 = R.id.buttonPanel;
        View findViewById5 = findViewById2.findViewById(i4);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(R.id.customPanel);
        View view4 = alertController.h;
        int i5 = 0;
        if (view4 == null) {
            view4 = alertController.i != 0 ? LayoutInflater.from(alertController.f193a).inflate(alertController.i, viewGroup, false) : null;
        }
        boolean z2 = view4 != null;
        if (!z2 || !AlertController.a(view4)) {
            alertController.c.setFlags(131072, 131072);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) alertController.c.findViewById(R.id.custom);
            frameLayout.addView(view4, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.n) {
                frameLayout.setPadding(alertController.j, alertController.k, alertController.l, alertController.m);
            }
            if (alertController.g != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(i2);
        View findViewById7 = viewGroup.findViewById(i3);
        View findViewById8 = viewGroup.findViewById(i4);
        ViewGroup d = alertController.d(findViewById6, findViewById3);
        ViewGroup d2 = alertController.d(findViewById7, findViewById4);
        ViewGroup d3 = alertController.d(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) alertController.c.findViewById(R.id.scrollView);
        alertController.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        alertController.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) d2.findViewById(16908299);
        alertController.F = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.A.removeView(alertController.F);
                if (alertController.g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.A.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(alertController.A);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    d2.setVisibility(8);
                }
            }
        }
        Button button = (Button) d3.findViewById(16908313);
        alertController.o = button;
        button.setOnClickListener(alertController.R);
        if (!TextUtils.isEmpty(alertController.p) || alertController.r != null) {
            alertController.o.setText(alertController.p);
            Drawable drawable = alertController.r;
            if (drawable != null) {
                int i6 = alertController.d;
                drawable.setBounds(0, 0, i6, i6);
                alertController.o.setCompoundDrawables(alertController.r, null, null, null);
            }
            alertController.o.setVisibility(0);
            z = true;
        } else {
            alertController.o.setVisibility(8);
            z = false;
        }
        Button button2 = (Button) d3.findViewById(16908314);
        alertController.s = button2;
        button2.setOnClickListener(alertController.R);
        if (!TextUtils.isEmpty(alertController.t) || alertController.v != null) {
            alertController.s.setText(alertController.t);
            Drawable drawable2 = alertController.v;
            if (drawable2 != null) {
                int i7 = alertController.d;
                drawable2.setBounds(0, 0, i7, i7);
                alertController.s.setCompoundDrawables(alertController.v, null, null, null);
            }
            alertController.s.setVisibility(0);
            z |= true;
        } else {
            alertController.s.setVisibility(8);
        }
        Button button3 = (Button) d3.findViewById(16908315);
        alertController.w = button3;
        button3.setOnClickListener(alertController.R);
        if (!TextUtils.isEmpty(alertController.x) || alertController.z != null) {
            alertController.w.setText(alertController.x);
            Drawable drawable3 = alertController.z;
            if (drawable3 != null) {
                int i8 = alertController.d;
                drawable3.setBounds(0, 0, i8, i8);
                view = null;
                alertController.w.setCompoundDrawables(alertController.z, null, null, null);
            } else {
                view = null;
            }
            alertController.w.setVisibility(0);
            z |= true;
        } else {
            alertController.w.setVisibility(8);
            view = null;
        }
        Context context = alertController.f193a;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (z) {
                alertController.b(alertController.o);
            } else if (z) {
                alertController.b(alertController.s);
            } else if (z) {
                alertController.b(alertController.w);
            }
        }
        if (!(z)) {
            d3.setVisibility(8);
        }
        if (alertController.G != null) {
            d.addView(alertController.G, 0, new ViewGroup.LayoutParams(-1, -2));
            alertController.c.findViewById(R.id.title_template).setVisibility(8);
        } else {
            alertController.D = (ImageView) alertController.c.findViewById(16908294);
            if (!(!TextUtils.isEmpty(alertController.e)) || !alertController.P) {
                alertController.c.findViewById(R.id.title_template).setVisibility(8);
                alertController.D.setVisibility(8);
                d.setVisibility(8);
            } else {
                TextView textView2 = (TextView) alertController.c.findViewById(R.id.alertTitle);
                alertController.E = textView2;
                textView2.setText(alertController.e);
                int i9 = alertController.B;
                if (i9 != 0) {
                    alertController.D.setImageResource(i9);
                } else {
                    Drawable drawable4 = alertController.C;
                    if (drawable4 != null) {
                        alertController.D.setImageDrawable(drawable4);
                    } else {
                        alertController.E.setPadding(alertController.D.getPaddingLeft(), alertController.D.getPaddingTop(), alertController.D.getPaddingRight(), alertController.D.getPaddingBottom());
                        alertController.D.setVisibility(8);
                    }
                }
            }
        }
        boolean z3 = viewGroup.getVisibility() != 8;
        int i10 = (d == null || d.getVisibility() == 8) ? 0 : 1;
        boolean z4 = d3.getVisibility() != 8;
        if (!z4 && (findViewById = d2.findViewById(R.id.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (i10 != 0) {
            NestedScrollView nestedScrollView2 = alertController.A;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            if (alertController.f == null && alertController.g == null) {
                view3 = view;
            } else {
                view3 = d.findViewById(R.id.titleDividerNoCustom);
            }
            if (view3 != null) {
                view3.setVisibility(0);
            }
        } else {
            View findViewById9 = d2.findViewById(R.id.textSpacerNoTitle);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        }
        ListView listView = alertController.g;
        if (listView instanceof AlertController.RecycleListView) {
            AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) listView;
            Objects.requireNonNull(recycleListView);
            if (!z4 || i10 == 0) {
                recycleListView.setPadding(recycleListView.getPaddingLeft(), i10 != 0 ? recycleListView.getPaddingTop() : recycleListView.f, recycleListView.getPaddingRight(), z4 ? recycleListView.getPaddingBottom() : recycleListView.g);
            }
        }
        if (!z3) {
            View view5 = alertController.g;
            if (view5 == null) {
                view5 = alertController.A;
            }
            if (view5 != null) {
                if (z4) {
                    i5 = 2;
                }
                int i11 = i10 | i5;
                View findViewById10 = alertController.c.findViewById(R.id.scrollIndicatorUp);
                View findViewById11 = alertController.c.findViewById(R.id.scrollIndicatorDown);
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 23) {
                    AtomicInteger atomicInteger = r8.f3055a;
                    if (i12 >= 23) {
                        view5.setScrollIndicators(i11, 3);
                    }
                    if (findViewById10 != null) {
                        d2.removeView(findViewById10);
                    }
                    if (findViewById11 != null) {
                        d2.removeView(findViewById11);
                    }
                } else {
                    if (findViewById10 != null && (i11 & 1) == 0) {
                        d2.removeView(findViewById10);
                        findViewById10 = view;
                    }
                    if (findViewById11 == null || (i11 & 2) != 0) {
                        view2 = findViewById11;
                    } else {
                        d2.removeView(findViewById11);
                        view2 = view;
                    }
                    if (!(findViewById10 == null && view2 == null)) {
                        if (alertController.f != null) {
                            alertController.A.setOnScrollChangeListener(new z(alertController, findViewById10, view2));
                            alertController.A.post(new a0(alertController, findViewById10, view2));
                        } else {
                            ListView listView2 = alertController.g;
                            if (listView2 != null) {
                                listView2.setOnScrollListener(new b0(alertController, findViewById10, view2));
                                alertController.g.post(new c0(alertController, findViewById10, view2));
                            } else {
                                if (findViewById10 != null) {
                                    d2.removeView(findViewById10);
                                }
                                if (view2 != null) {
                                    d2.removeView(view2);
                                }
                            }
                        }
                    }
                }
            }
        }
        ListView listView3 = alertController.g;
        if (listView3 != null && (listAdapter = alertController.H) != null) {
            listView3.setAdapter(listAdapter);
            int i13 = alertController.I;
            if (i13 > -1) {
                listView3.setItemChecked(i13, true);
                listView3.setSelection(i13);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.h.A;
        if (nestedScrollView != null && nestedScrollView.i(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.h.A;
        if (nestedScrollView != null && nestedScrollView.i(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // defpackage.n0, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.h;
        alertController.e = charSequence;
        TextView textView = alertController.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: e0$a */
    /* compiled from: AlertDialog */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final AlertController.b f908a;
        public final int b;

        public a(Context context) {
            int e = e0.e(context, 0);
            this.f908a = new AlertController.b(new ContextThemeWrapper(context, e0.e(context, e)));
            this.b = e;
        }

        public e0 a() {
            int i;
            e0 e0Var = new e0(this.f908a.f194a, this.b);
            AlertController.b bVar = this.f908a;
            AlertController alertController = e0Var.h;
            View view = bVar.e;
            if (view != null) {
                alertController.G = view;
            } else {
                CharSequence charSequence = bVar.d;
                if (charSequence != null) {
                    alertController.e = charSequence;
                    TextView textView = alertController.E;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = bVar.c;
                if (drawable != null) {
                    alertController.C = drawable;
                    alertController.B = 0;
                    ImageView imageView = alertController.D;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.D.setImageDrawable(drawable);
                    }
                }
            }
            CharSequence charSequence2 = bVar.f;
            if (charSequence2 != null) {
                alertController.f = charSequence2;
                TextView textView2 = alertController.F;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                }
            }
            CharSequence charSequence3 = bVar.g;
            if (charSequence3 != null) {
                alertController.e(-1, charSequence3, bVar.h, null, null);
            }
            CharSequence charSequence4 = bVar.i;
            if (charSequence4 != null) {
                alertController.e(-2, charSequence4, bVar.j, null, null);
            }
            if (!(bVar.n == null && bVar.o == null)) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) bVar.b.inflate(alertController.L, (ViewGroup) null);
                if (bVar.r) {
                    i = alertController.N;
                } else {
                    i = alertController.O;
                }
                ListAdapter listAdapter = bVar.o;
                if (listAdapter == null) {
                    listAdapter = new AlertController.d(bVar.f194a, i, 16908308, bVar.n);
                }
                alertController.H = listAdapter;
                alertController.I = bVar.s;
                if (bVar.p != null) {
                    recycleListView.setOnItemClickListener(new d0(bVar, alertController));
                }
                if (bVar.r) {
                    recycleListView.setChoiceMode(1);
                }
                alertController.g = recycleListView;
            }
            View view2 = bVar.q;
            if (view2 != null) {
                alertController.h = view2;
                alertController.i = 0;
                alertController.n = false;
            }
            e0Var.setCancelable(this.f908a.k);
            if (this.f908a.k) {
                e0Var.setCanceledOnTouchOutside(true);
            }
            e0Var.setOnCancelListener(this.f908a.l);
            Objects.requireNonNull(this.f908a);
            e0Var.setOnDismissListener(null);
            DialogInterface.OnKeyListener onKeyListener = this.f908a.m;
            if (onKeyListener != null) {
                e0Var.setOnKeyListener(onKeyListener);
            }
            return e0Var;
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f908a;
            bVar.g = bVar.f194a.getText(i);
            this.f908a.h = onClickListener;
            return this;
        }

        public a c(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.f908a;
            bVar.g = charSequence;
            bVar.h = onClickListener;
            return this;
        }

        public a(Context context, int i) {
            this.f908a = new AlertController.b(new ContextThemeWrapper(context, e0.e(context, i)));
            this.b = i;
        }
    }
}
