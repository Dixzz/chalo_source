package defpackage;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

/* renamed from: bd1  reason: default package */
/* compiled from: Utils */
public class bd1 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EditText f412a;
    public final /* synthetic */ Context b;

    public bd1(EditText editText, Context context) {
        this.f412a = editText;
        this.b = context;
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        this.f412a.requestFocus();
        ((InputMethodManager) this.b.getSystemService("input_method")).hideSoftInputFromWindow(this.f412a.getWindowToken(), 0);
        return true;
    }
}
