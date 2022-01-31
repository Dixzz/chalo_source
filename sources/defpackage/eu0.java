package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import app.zophop.R;
import defpackage.ut;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

/* renamed from: eu0  reason: default package */
/* compiled from: EnvironmentDialogFragment.kt */
public final class eu0 extends ue {
    public final Context f;

    public eu0(Context context) {
        n86.e(context, "_context");
        this.f = context;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n86.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.environment_dialog, viewGroup, true);
        n86.d(inflate, "view");
        String arrays = Arrays.toString(ut.a.values());
        n86.d(arrays, "java.util.Arrays.toString(this)");
        n86.e("^.|.$", "pattern");
        Pattern compile = Pattern.compile("^.|.$");
        n86.d(compile, "Pattern.compile(pattern)");
        n86.e(compile, "nativePattern");
        n86.e(arrays, "input");
        n86.e("", "replacement");
        String replaceAll = compile.matcher(arrays).replaceAll("");
        n86.d(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        Object[] array = ea6.B(replaceAll, new String[]{", "}, false, 0, 6).toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f, (int) R.layout.environment_list_view, (String[]) array);
        ListView listView = (ListView) inflate.findViewById(R.id.environment_dialog_list);
        listView.setAdapter((ListAdapter) arrayAdapter);
        listView.setOnItemClickListener(new ap0(this));
        return inflate;
    }
}
