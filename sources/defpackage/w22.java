package defpackage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import androidx.fragment.app.FragmentManager;

/* renamed from: w22  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class w22 extends ue {
    public Dialog f;
    public DialogInterface.OnCancelListener g;
    public Dialog h;

    @Override // defpackage.ue
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.g;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // defpackage.ue
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.h == null) {
            this.h = new AlertDialog.Builder(c()).create();
        }
        return this.h;
    }

    @Override // defpackage.ue
    public void show(@RecentlyNonNull FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
