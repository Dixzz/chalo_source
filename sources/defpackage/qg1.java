package defpackage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/* renamed from: qg1  reason: default package */
/* compiled from: LocationPromptDialogFragment */
public class qg1 extends DialogFragment {
    public static final String f = qg1.class.getName();

    /* renamed from: qg1$a */
    /* compiled from: LocationPromptDialogFragment */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public EnumC0048a f2942a;

        /* renamed from: qg1$a$a  reason: collision with other inner class name */
        /* compiled from: LocationPromptDialogFragment */
        public enum EnumC0048a {
            POSITIVE,
            NEGATIVE,
            DISMISSED
        }

        public a(EnumC0048a aVar) {
            this.f2942a = aVar;
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        AlertDialog.Builder message = new AlertDialog.Builder(getActivity()).setTitle("Enable Location").setMessage(arguments.getString("location_prompt:message", "Please turn your GPS on to view nearby stops"));
        if (arguments.getBoolean("location_prompt:positiveButton", false)) {
            message.setPositiveButton("Settings", new og1(this));
        }
        if (arguments.getBoolean("location_prompt:negativeButton", false)) {
            message.setNegativeButton("Ignore", new pg1(this));
        }
        AlertDialog create = message.create();
        create.setCanceledOnTouchOutside(false);
        return create;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        jz5.b().g(new a(a.EnumC0048a.DISMISSED));
        super.onDismiss(dialogInterface);
    }
}
