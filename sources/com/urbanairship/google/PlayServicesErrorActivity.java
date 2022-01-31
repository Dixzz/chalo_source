package com.urbanairship.google;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.appindexing.Indexable;
import com.urbanairship.UAirship;

public class PlayServicesErrorActivity extends ve {

    public static class a extends ue {
        @Override // defpackage.ue
        public void onCancel(DialogInterface dialogInterface) {
            super.onCancel(dialogInterface);
            if (c() != null) {
                c().finish();
            }
        }

        @Override // defpackage.ue
        public Dialog onCreateDialog(Bundle bundle) {
            int i = getArguments() != null ? getArguments().getInt("dialog_error") : 0;
            Object obj = q22.c;
            return q22.d.d(c(), i, Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL, null);
        }
    }

    public final void d0() {
        yj5.f("Checking Google Play services.", new Object[0]);
        int L1 = hd3.L1(this);
        if (L1 == 0) {
            yj5.a("Google Play services available!", new Object[0]);
            finish();
            return;
        }
        Object obj = q22.c;
        q22 q22 = q22.d;
        if (u22.isUserRecoverableError(L1)) {
            yj5.a("Google Play services recoverable error: %s", Integer.valueOf(L1));
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putInt("dialog_error", L1);
            aVar.setArguments(bundle);
            aVar.show(getSupportFragmentManager(), "error_dialog");
            return;
        }
        yj5.c("Unrecoverable Google Play services error: %s", Integer.valueOf(L1));
        finish();
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1000) {
            return;
        }
        if (i2 == -1) {
            yj5.a("Google Play services resolution received result ok.", new Object[0]);
            d0();
            return;
        }
        yj5.a("Google Play services resolution canceled.", new Object[0]);
        finish();
    }

    @Override // defpackage.ve
    public void onStart() {
        super.onStart();
        if (getSupportFragmentManager().I("error_dialog") == null) {
            d0();
        }
    }

    @Override // defpackage.ve
    public void onStop() {
        super.onStop();
        if (isFinishing() && hd3.L1(this) == 0 && UAirship.l().i.p()) {
            UAirship.l().j.s();
        }
    }
}
