package defpackage;

import android.app.DatePickerDialog;
import android.view.View;
import app.zophop.ui.fragments.ProfileFragment;

/* renamed from: uv0  reason: default package */
/* compiled from: ProfileFragment */
public class uv0 implements View.OnClickListener {
    public final /* synthetic */ DatePickerDialog f;

    public uv0(ProfileFragment profileFragment, DatePickerDialog datePickerDialog) {
        this.f = datePickerDialog;
    }

    public void onClick(View view) {
        this.f.show();
    }
}
