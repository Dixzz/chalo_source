package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.Gender;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: mm0  reason: default package */
/* compiled from: GenderSelectDialog.kt */
public final class mm0 extends um0 {
    public static final /* synthetic */ int l = 0;
    public a i;
    public String j;
    public List<? extends Gender> k;

    /* renamed from: mm0$a */
    /* compiled from: GenderSelectDialog.kt */
    public interface a {
        void a(Gender gender);
    }

    @Override // defpackage.um0
    public void d(Bundle bundle) {
        n86.c(bundle);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("radio_options");
        n86.c(parcelableArrayList);
        n86.d(parcelableArrayList, "arguments!!.getParcelabl…<Gender>(RADIO_OPTIONS)!!");
        this.k = parcelableArrayList;
        this.h = bundle.getString("dialog_title");
        this.j = bundle.getString("current_selection");
    }

    @Override // defpackage.um0
    public void e() {
    }

    @Override // defpackage.um0
    public void f(LayoutInflater layoutInflater) {
        List<? extends Gender> list = this.k;
        if (list != null) {
            for (Gender gender : list) {
                View inflate = layoutInflater.inflate(R.layout.dialog_radio_button, (ViewGroup) null);
                Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.RadioButton");
                RadioButton radioButton = (RadioButton) inflate;
                RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-2, -2);
                layoutParams.setMargins(10, 10, 10, 10);
                radioButton.setLayoutParams(layoutParams);
                radioButton.setText(gender.name());
                radioButton.setBackground(getResources().getDrawable(R.drawable.drawer_item_selector));
                RadioGroup radioGroup = this.g;
                if (radioGroup != null) {
                    radioGroup.addView(radioButton);
                }
                if (ea6.f(gender.name(), this.j, true)) {
                    radioButton.setChecked(true);
                }
                radioButton.setOnClickListener(new dm0(this, gender));
            }
            return;
        }
        n86.l("genderList");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment, defpackage.um0
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewParent viewParent;
        n86.e(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        TextView textView = this.f;
        if (textView == null) {
            viewParent = null;
        } else {
            viewParent = textView.getParent();
        }
        Objects.requireNonNull(viewParent, "null cannot be cast to non-null type android.widget.LinearLayout");
        ((LinearLayout) viewParent).setVisibility(8);
        return onCreateView;
    }
}
