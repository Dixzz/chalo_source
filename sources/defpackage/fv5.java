package defpackage;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.urbanairship.messagecenter.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: fv5  reason: default package */
/* compiled from: MessageListFragment */
public class fv5 extends Fragment {
    public static final /* synthetic */ int p = 0;
    public SwipeRefreshLayout f;
    public AbsListView g;
    public qu5 h;
    public jv5 i;
    public tj5 j;
    public String k;
    public dk5<wu5> l;
    public final List<d> m = new ArrayList();
    public int n = R.drawable.ua_ic_image_placeholder;
    public final vu5 o = new a();

    /* renamed from: fv5$a */
    /* compiled from: MessageListFragment */
    public class a implements vu5 {
        public a() {
        }

        @Override // defpackage.vu5
        public void a() {
            fv5 fv5 = fv5.this;
            int i = fv5.p;
            fv5.h();
        }
    }

    /* renamed from: fv5$b */
    /* compiled from: MessageListFragment */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            wu5 f2 = fv5.this.f(i);
            if (f2 != null) {
                yu5.j().k(f2.j);
            }
        }
    }

    /* renamed from: fv5$c */
    /* compiled from: MessageListFragment */
    public class c implements SwipeRefreshLayout.h {
        public c() {
        }
    }

    /* renamed from: fv5$d */
    /* compiled from: MessageListFragment */
    public interface d {
        void a(AbsListView absListView);
    }

    public final void d(View view) {
        if (getContext() != null && this.g == null) {
            if (view instanceof AbsListView) {
                this.g = (AbsListView) view;
            } else {
                this.g = (AbsListView) view.findViewById(16908298);
            }
            if (this.g != null) {
                if (e() != null) {
                    this.g.setAdapter((ListAdapter) e());
                }
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);
                this.f = swipeRefreshLayout;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setOnRefreshListener(new c());
                }
                View findViewById = view.findViewById(16908292);
                TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(null, R.styleable.MessageCenter, R.attr.messageCenterStyle, R.style.MessageCenter);
                if (findViewById instanceof TextView) {
                    TextView textView = (TextView) findViewById;
                    hd3.r(getContext(), textView, obtainStyledAttributes.getResourceId(R.styleable.MessageCenter_messageCenterEmptyMessageTextAppearance, -1));
                    textView.setText(obtainStyledAttributes.getString(R.styleable.MessageCenter_messageCenterEmptyMessageText));
                }
                AbsListView absListView = this.g;
                if (absListView instanceof ListView) {
                    ListView listView = (ListView) absListView;
                    int i2 = R.styleable.MessageCenter_messageCenterDividerColor;
                    if (obtainStyledAttributes.hasValue(i2) && listView.getDivider() != null) {
                        listView.getDivider().setTint(obtainStyledAttributes.getColor(i2, -16777216));
                        listView.getDivider().setTintMode(PorterDuff.Mode.SRC);
                    }
                }
                this.n = obtainStyledAttributes.getResourceId(R.styleable.MessageCenter_messageCenterItemIconPlaceholder, this.n);
                obtainStyledAttributes.recycle();
                return;
            }
            throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        }
    }

    public jv5 e() {
        if (this.i == null) {
            if (getContext() == null) {
                return null;
            }
            this.i = new hv5(this, getContext(), R.layout.ua_item_mc);
        }
        return this.i;
    }

    public wu5 f(int i2) {
        jv5 jv5 = this.i;
        if (jv5 == null || jv5.getCount() <= i2) {
            return null;
        }
        return (wu5) this.i.getItem(i2);
    }

    public void g(String str) {
        String str2 = this.k;
        if (str2 != null || str != null) {
            if (str2 == null || !str2.equals(str)) {
                this.k = str;
                if (e() != null) {
                    e().notifyDataSetChanged();
                }
            }
        }
    }

    public final void h() {
        if (e() != null) {
            jv5 e = e();
            List<wu5> e2 = this.h.e(this.l);
            synchronized (e.f) {
                e.f.clear();
                e.f.addAll(e2);
            }
            e.notifyDataSetChanged();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = yu5.j().g;
        h();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ua_fragment_message_list, viewGroup, false);
        d(inflate);
        AbsListView absListView = this.g;
        if (absListView == null) {
            return inflate;
        }
        absListView.setOnItemClickListener(new b());
        View findViewById = inflate.findViewById(16908292);
        if (findViewById != null) {
            this.g.setEmptyView(findViewById);
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.m.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.g.setChoiceMode(0);
        this.g = null;
        this.f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        qu5 qu5 = this.h;
        qu5.f2993a.remove(this.o);
        tj5 tj5 = this.j;
        if (tj5 != null) {
            tj5.cancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        qu5 qu5 = this.h;
        qu5.f2993a.add(this.o);
        h();
        this.h.b(null, null);
        AbsListView absListView = this.g;
        if (absListView != null) {
            absListView.invalidate();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        d(view);
        Iterator it = new ArrayList(this.m).iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(this.g);
        }
        this.m.clear();
    }
}
