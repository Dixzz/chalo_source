package defpackage;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import defpackage.ut;

/* renamed from: ap0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ap0 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ eu0 f;

    public /* synthetic */ ap0(eu0 eu0) {
        this.f = eu0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        eu0 eu0 = this.f;
        n86.e(eu0, "this$0");
        ut.a valueOf = ut.a.valueOf(adapterView.getAdapter().getItem(i).toString());
        SharedPreferences.Editor edit = eu0.f.getSharedPreferences("ENV_CHANGE_STORE_KEY", 0).edit();
        edit.putString("ENV", valueOf.name());
        edit.commit();
        xt.f3961a.l().put("env", "true");
        eu0.dismiss();
        throw new RuntimeException("");
    }
}
