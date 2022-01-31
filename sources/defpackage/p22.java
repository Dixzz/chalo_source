package defpackage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;

/* renamed from: p22  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class p22 extends DialogFragment {
    public Dialog f;
    public DialogInterface.OnCancelListener g;
    public Dialog h;

    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.g;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.f;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.h == null) {
            this.h = new AlertDialog.Builder(getActivity()).create();
        }
        return this.h;
    }

    @Override // android.app.DialogFragment
    public void show(@RecentlyNonNull FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
