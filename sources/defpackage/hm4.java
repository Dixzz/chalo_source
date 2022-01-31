package defpackage;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import java.util.Iterator;

/* renamed from: hm4  reason: default package */
/* compiled from: MaterialTextInputPicker */
public final class hm4<S> extends mm4<S> {
    public int g;
    public DateSelector<S> h;
    public CalendarConstraints i;

    /* renamed from: hm4$a */
    /* compiled from: MaterialTextInputPicker */
    public class a extends lm4<S> {
        public a() {
        }

        @Override // defpackage.lm4
        public void a() {
            Iterator<lm4<S>> it = hm4.this.f.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }

        @Override // defpackage.lm4
        public void b(S s) {
            Iterator<lm4<S>> it = hm4.this.f.iterator();
            while (it.hasNext()) {
                it.next().b(s);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.g = bundle.getInt("THEME_RES_ID_KEY");
        this.h = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.i = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.h.m0(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.g)), viewGroup, bundle, this.i, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.g);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.h);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.i);
    }
}
