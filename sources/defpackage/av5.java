package defpackage;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import defpackage.fv5;

/* renamed from: av5  reason: default package */
/* compiled from: MessageCenterFragment */
public class av5 implements fv5.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fv5 f337a;
    public final /* synthetic */ zu5 b;

    /* renamed from: av5$a */
    /* compiled from: MessageCenterFragment */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            wu5 f2 = av5.this.f337a.f(i);
            if (f2 != null) {
                av5.this.b.e(f2.j);
            }
        }
    }

    public av5(zu5 zu5, fv5 fv5) {
        this.b = zu5;
        this.f337a = fv5;
    }

    @Override // defpackage.fv5.d
    public void a(AbsListView absListView) {
        absListView.setOnItemClickListener(new a());
        absListView.setMultiChoiceModeListener(new lu5(this.f337a));
        absListView.setChoiceMode(3);
        absListView.setSaveEnabled(false);
    }
}
