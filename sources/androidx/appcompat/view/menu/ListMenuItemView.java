package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.TintTypedArray;
import defpackage.w1;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ListMenuItemView extends LinearLayout implements w1.a, AbsListView.SelectionBoundsAdjuster {
    public r1 f;
    public ImageView g;
    public RadioButton h;
    public TextView i;
    public CheckBox j;
    public TextView k;
    public ImageView l;
    public ImageView m;
    public LinearLayout n;
    public Drawable o;
    public int p;
    public Context q;
    public boolean r;
    public Drawable s;
    public boolean t;
    public LayoutInflater u;
    public boolean v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2 = R.attr.listMenuViewStyle;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(getContext(), attributeSet, R.styleable.MenuView, i2, 0);
        this.o = obtainStyledAttributes.getDrawable(R.styleable.MenuView_android_itemBackground);
        this.p = obtainStyledAttributes.getResourceId(R.styleable.MenuView_android_itemTextAppearance, -1);
        this.r = obtainStyledAttributes.getBoolean(R.styleable.MenuView_preserveIconSpacing, false);
        this.q = context;
        this.s = obtainStyledAttributes.getDrawable(R.styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, R.attr.dropDownListViewStyle, 0);
        this.t = obtainStyledAttributes2.hasValue(0);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes2.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.u == null) {
            this.u = LayoutInflater.from(getContext());
        }
        return this.u;
    }

    private void setSubMenuArrowVisible(boolean z) {
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // defpackage.w1.a
    public void a(r1 r1Var, int i2) {
        this.f = r1Var;
        setVisibility(r1Var.isVisible() ? 0 : 8);
        setTitle(r1Var.e);
        setCheckable(r1Var.isCheckable());
        boolean m2 = r1Var.m();
        r1Var.e();
        d(m2);
        setIcon(r1Var.getIcon());
        setEnabled(r1Var.isEnabled());
        setSubMenuArrowVisible(r1Var.hasSubMenu());
        setContentDescription(r1Var.q);
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.m;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            rect.top = this.m.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
        }
    }

    public final void b() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.j = checkBox;
        LinearLayout linearLayout = this.n;
        if (linearLayout != null) {
            linearLayout.addView(checkBox, -1);
        } else {
            addView(checkBox, -1);
        }
    }

    public final void c() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.h = radioButton;
        LinearLayout linearLayout = this.n;
        if (linearLayout != null) {
            linearLayout.addView(radioButton, -1);
        } else {
            addView(radioButton, -1);
        }
    }

    public void d(boolean z) {
        String str;
        int i2 = (!z || !this.f.m()) ? 8 : 0;
        if (i2 == 0) {
            TextView textView = this.k;
            r1 r1Var = this.f;
            char e = r1Var.e();
            if (e == 0) {
                str = "";
            } else {
                Resources resources = r1Var.n.f2757a.getResources();
                StringBuilder sb = new StringBuilder();
                if (ViewConfiguration.get(r1Var.n.f2757a).hasPermanentMenuKey()) {
                    sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
                }
                int i3 = r1Var.n.n() ? r1Var.k : r1Var.i;
                r1.c(sb, i3, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
                r1.c(sb, i3, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
                r1.c(sb, i3, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
                r1.c(sb, i3, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
                r1.c(sb, i3, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
                r1.c(sb, i3, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
                if (e == '\b') {
                    sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
                } else if (e == '\n') {
                    sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
                } else if (e != ' ') {
                    sb.append(e);
                } else {
                    sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                }
                str = sb.toString();
            }
            textView.setText(str);
        }
        if (this.k.getVisibility() != i2) {
            this.k.setVisibility(i2);
        }
    }

    @Override // defpackage.w1.a
    public r1 getItemData() {
        return this.f;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        Drawable drawable = this.o;
        AtomicInteger atomicInteger = r8.f3055a;
        setBackground(drawable);
        TextView textView = (TextView) findViewById(R.id.title);
        this.i = textView;
        int i2 = this.p;
        if (i2 != -1) {
            textView.setTextAppearance(this.q, i2);
        }
        this.k = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.l = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.s);
        }
        this.m = (ImageView) findViewById(R.id.group_divider);
        this.n = (LinearLayout) findViewById(R.id.content);
    }

    public void onMeasure(int i2, int i3) {
        if (this.g != null && this.r) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.g.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (z || this.h != null || this.j != null) {
            if (this.f.h()) {
                if (this.h == null) {
                    c();
                }
                compoundButton2 = this.h;
                compoundButton = this.j;
            } else {
                if (this.j == null) {
                    b();
                }
                compoundButton2 = this.j;
                compoundButton = this.h;
            }
            if (z) {
                compoundButton2.setChecked(this.f.isChecked());
                if (compoundButton2.getVisibility() != 0) {
                    compoundButton2.setVisibility(0);
                }
                if (compoundButton != null && compoundButton.getVisibility() != 8) {
                    compoundButton.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.j;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.h;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f.h()) {
            if (this.h == null) {
                c();
            }
            compoundButton = this.h;
        } else {
            if (this.j == null) {
                b();
            }
            compoundButton = this.j;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.v = z;
        this.r = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setVisibility((this.t || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        Objects.requireNonNull(this.f.n);
        boolean z = this.v;
        if (z || this.r) {
            ImageView imageView = this.g;
            if (imageView != null || drawable != null || this.r) {
                if (imageView == null) {
                    ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                    this.g = imageView2;
                    LinearLayout linearLayout = this.n;
                    if (linearLayout != null) {
                        linearLayout.addView(imageView2, 0);
                    } else {
                        addView(imageView2, 0);
                    }
                }
                if (drawable != null || this.r) {
                    ImageView imageView3 = this.g;
                    if (!z) {
                        drawable = null;
                    }
                    imageView3.setImageDrawable(drawable);
                    if (this.g.getVisibility() != 0) {
                        this.g.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.g.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.i.setText(charSequence);
            if (this.i.getVisibility() != 0) {
                this.i.setVisibility(0);
            }
        } else if (this.i.getVisibility() != 8) {
            this.i.setVisibility(8);
        }
    }
}
