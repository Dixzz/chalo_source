package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.Month;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: em4  reason: default package */
/* compiled from: MaterialDatePicker */
public final class em4<S> extends ue {
    public static final /* synthetic */ int w = 0;
    public final LinkedHashSet<gm4<? super S>> f = new LinkedHashSet<>();
    public final LinkedHashSet<View.OnClickListener> g = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnCancelListener> h = new LinkedHashSet<>();
    public final LinkedHashSet<DialogInterface.OnDismissListener> i = new LinkedHashSet<>();
    public int j;
    public DateSelector<S> k;
    public mm4<S> l;
    public CalendarConstraints m;
    public wl4<S> n;
    public int o;
    public CharSequence p;
    public boolean q;
    public int r;
    public TextView s;
    public CheckableImageButton t;
    public ho4 u;
    public Button v;

    /* renamed from: em4$a */
    /* compiled from: MaterialDatePicker */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            Iterator<gm4<? super S>> it = em4.this.f.iterator();
            while (it.hasNext()) {
                it.next().a((Object) em4.this.e());
            }
            em4.this.dismiss();
        }
    }

    /* renamed from: em4$b */
    /* compiled from: MaterialDatePicker */
    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            Iterator<View.OnClickListener> it = em4.this.g.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            em4.this.dismiss();
        }
    }

    /* renamed from: em4$c */
    /* compiled from: MaterialDatePicker */
    public class c extends lm4<S> {
        public c() {
        }

        @Override // defpackage.lm4
        public void a() {
            em4.this.v.setEnabled(false);
        }

        @Override // defpackage.lm4
        public void b(S s) {
            em4 em4 = em4.this;
            int i = em4.w;
            em4.i();
            em4 em42 = em4.this;
            em42.v.setEnabled(em42.k.F0());
        }
    }

    public static int d(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i2 = Month.g().i;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i2;
        return ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean f(Context context) {
        return g(context, 16843277);
    }

    public static boolean g(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(hd3.G2(context, R.attr.materialCalendarStyle, wl4.class.getCanonicalName()), new int[]{i2});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public final S e() {
        return this.k.Q0();
    }

    public final void h() {
        mm4<S> mm4;
        Context requireContext = requireContext();
        int i2 = this.j;
        if (i2 == 0) {
            i2 = this.k.z0(requireContext);
        }
        DateSelector<S> dateSelector = this.k;
        CalendarConstraints calendarConstraints = this.m;
        wl4<S> wl4 = new wl4<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.i);
        wl4.setArguments(bundle);
        this.n = wl4;
        if (this.t.isChecked()) {
            DateSelector<S> dateSelector2 = this.k;
            CalendarConstraints calendarConstraints2 = this.m;
            mm4 = new hm4<>();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i2);
            bundle2.putParcelable("DATE_SELECTOR_KEY", dateSelector2);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints2);
            mm4.setArguments(bundle2);
        } else {
            mm4 = this.n;
        }
        this.l = mm4;
        i();
        ke keVar = new ke(getChildFragmentManager());
        keVar.g(R.id.mtrl_calendar_frame, this.l, null);
        keVar.e();
        this.l.d(new c());
    }

    public final void i() {
        String A = this.k.A(getContext());
        this.s.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), A));
        this.s.setText(A);
    }

    public final void j(CheckableImageButton checkableImageButton) {
        String str;
        if (this.t.isChecked()) {
            str = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_calendar_input_mode);
        } else {
            str = checkableImageButton.getContext().getString(R.string.mtrl_picker_toggle_to_text_input_mode);
        }
        this.t.setContentDescription(str);
    }

    @Override // defpackage.ue
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.h.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.j = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.k = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.m = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.o = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.p = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.r = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // defpackage.ue
    public final Dialog onCreateDialog(Bundle bundle) {
        Context requireContext = requireContext();
        Context requireContext2 = requireContext();
        int i2 = this.j;
        if (i2 == 0) {
            i2 = this.k.z0(requireContext2);
        }
        Dialog dialog = new Dialog(requireContext, i2);
        Context context = dialog.getContext();
        this.q = f(context);
        int G2 = hd3.G2(context, R.attr.colorSurface, em4.class.getCanonicalName());
        ho4 ho4 = new ho4(context, null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.u = ho4;
        ho4.n(context);
        this.u.q(ColorStateList.valueOf(G2));
        ho4 ho42 = this.u;
        View decorView = dialog.getWindow().getDecorView();
        AtomicInteger atomicInteger = r8.f3055a;
        ho42.p(decorView.getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.q ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.q) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(d(context), -2));
        } else {
            View findViewById = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R.id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(d(context), -1));
            Resources resources = requireContext().getResources();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
            int i2 = im4.k;
            findViewById2.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (i2 - 1)) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i2) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.s = textView;
        AtomicInteger atomicInteger = r8.f3055a;
        textView.setAccessibilityLiveRegion(1);
        this.t = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.p;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.o);
        }
        this.t.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.t;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, u0.b(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], u0.b(context, R.drawable.material_ic_edit_black_24dp));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.t.setChecked(this.r != 0);
        r8.v(this.t, null);
        j(this.t);
        this.t.setOnClickListener(new fm4(this));
        this.v = (Button) inflate.findViewById(R.id.confirm_button);
        if (this.k.F0()) {
            this.v.setEnabled(true);
        } else {
            this.v.setEnabled(false);
        }
        this.v.setTag("CONFIRM_BUTTON_TAG");
        this.v.setOnClickListener(new a());
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag("CANCEL_BUTTON_TAG");
        button.setOnClickListener(new b());
        return inflate;
    }

    @Override // defpackage.ue
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.j);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.k);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.m);
        Month month = this.n.j;
        if (month != null) {
            bVar.c = Long.valueOf(month.k);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.o);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.p);
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.q) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.u);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.u, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new sm4(requireDialog(), rect));
        }
        h();
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onStop() {
        this.l.f.clear();
        super.onStop();
    }
}
