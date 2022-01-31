package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.urbanairship.messagecenter.MessageActivity;
import com.urbanairship.messagecenter.R;
import defpackage.fv5;
import java.util.ArrayList;
import java.util.List;

/* renamed from: zu5  reason: default package */
/* compiled from: MessageCenterFragment */
public class zu5 extends Fragment {
    public static final /* synthetic */ int n = 0;
    public dk5<wu5> f;
    public fv5 g;
    public boolean h;
    public boolean i;
    public String j;
    public int k = -1;
    public String l;
    public final vu5 m = new a();

    /* renamed from: zu5$a */
    /* compiled from: MessageCenterFragment */
    public class a implements vu5 {
        public a() {
        }

        @Override // defpackage.vu5
        public void a() {
            zu5 zu5 = zu5.this;
            int i = zu5.n;
            zu5.f();
        }
    }

    /* renamed from: zu5$b */
    /* compiled from: MessageCenterFragment */
    public class b implements fv5.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bundle f4216a;

        public b(zu5 zu5, Bundle bundle) {
            this.f4216a = bundle;
        }

        @Override // defpackage.fv5.d
        public void a(AbsListView absListView) {
            absListView.onRestoreInstanceState(this.f4216a.getParcelable("listView"));
        }
    }

    /* renamed from: zu5$c */
    /* compiled from: MessageCenterFragment */
    public static class c extends Fragment {
        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            Context context = layoutInflater.getContext();
            View inflate = layoutInflater.inflate(R.layout.ua_fragment_no_message_selected, viewGroup, false);
            View findViewById = inflate.findViewById(16908292);
            if (findViewById instanceof TextView) {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.MessageCenter, R.attr.messageCenterStyle, R.style.MessageCenter);
                TextView textView = (TextView) findViewById;
                hd3.r(layoutInflater.getContext(), textView, obtainStyledAttributes.getResourceId(R.styleable.MessageCenter_messageNotSelectedTextAppearance, 0));
                textView.setText(obtainStyledAttributes.getString(R.styleable.MessageCenter_messageNotSelectedText));
                obtainStyledAttributes.recycle();
            }
            return inflate;
        }
    }

    public final void d(View view) {
        if (c() != null && !this.i) {
            this.i = true;
            int i2 = R.id.message_list_container;
            if (view.findViewById(i2) != null) {
                this.g = new fv5();
                ke keVar = new ke(getChildFragmentManager());
                keVar.g(i2, this.g, "messageList");
                keVar.d();
                if (view.findViewById(R.id.message_container) != null) {
                    this.h = true;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.container);
                    TypedArray obtainStyledAttributes = c().getTheme().obtainStyledAttributes(null, R.styleable.MessageCenter, R.attr.messageCenterStyle, R.style.MessageCenter);
                    int i3 = R.styleable.MessageCenter_messageCenterDividerColor;
                    if (obtainStyledAttributes.hasValue(i3)) {
                        linearLayout.getDividerDrawable().setTint(obtainStyledAttributes.getColor(i3, -16777216));
                        linearLayout.getDividerDrawable().setTintMode(PorterDuff.Mode.SRC);
                    }
                    obtainStyledAttributes.recycle();
                    String str = this.j;
                    if (str != null) {
                        this.g.g(str);
                    }
                } else {
                    this.h = false;
                }
                fv5 fv5 = this.g;
                av5 av5 = new av5(this, fv5);
                AbsListView absListView = fv5.g;
                if (absListView != null) {
                    av5.a(absListView);
                } else {
                    fv5.m.add(av5);
                }
            } else {
                throw new RuntimeException("Content must have a place holder view whose id attribute is 'R.id.message_list_container'");
            }
        }
    }

    public void e(String str) {
        Fragment fragment;
        if (getContext() != null) {
            wu5 d = yu5.j().g.d(str);
            if (d == null) {
                this.k = -1;
            } else {
                this.k = ((ArrayList) yu5.j().g.e(this.f)).indexOf(d);
            }
            this.j = str;
            if (this.g != null) {
                if (this.h) {
                    String str2 = str == null ? "EMPTY_MESSAGE" : str;
                    if (getChildFragmentManager().I(str2) == null) {
                        if (str == null) {
                            fragment = new c();
                        } else {
                            fragment = new cv5();
                            Bundle bundle = new Bundle();
                            bundle.putString("messageReporting", str);
                            fragment.setArguments(bundle);
                        }
                        ke keVar = new ke(getChildFragmentManager());
                        keVar.g(R.id.message_container, fragment, str2);
                        keVar.d();
                        this.g.g(str);
                    }
                } else if (str != null) {
                    Context context = getContext();
                    Intent data = new Intent().setPackage(context.getPackageName()).addFlags(805306368).setData(Uri.fromParts("message", str, null));
                    data.setAction("com.urbanairship.VIEW_RICH_PUSH_MESSAGE");
                    if (data.resolveActivity(context.getPackageManager()) == null) {
                        data.setClass(context, MessageActivity.class);
                    }
                    context.startActivity(data);
                }
            }
        }
    }

    public final void f() {
        wu5 d = yu5.j().g.d(this.j);
        List<wu5> e = yu5.j().g.e(this.f);
        if (this.h && this.k != -1) {
            ArrayList arrayList = (ArrayList) e;
            if (!arrayList.contains(d)) {
                if (arrayList.size() == 0) {
                    this.j = null;
                    this.k = -1;
                } else {
                    int min = Math.min(arrayList.size() - 1, this.k);
                    this.k = min;
                    this.j = ((wu5) arrayList.get(min)).j;
                }
                if (this.h) {
                    e(this.j);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.k = bundle.getInt("currentMessagePosition", -1);
            this.j = bundle.getString("currentMessageId", null);
            this.l = bundle.getString("pendingMessageId", null);
        } else if (getArguments() != null) {
            this.l = getArguments().getString("messageReporting");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ua_fragment_mc, viewGroup, false);
        d(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.i = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        qu5 qu5 = yu5.j().g;
        qu5.f2993a.remove(this.m);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.h) {
            qu5 qu5 = yu5.j().g;
            qu5.f2993a.add(this.m);
        }
        f();
        String str = this.l;
        if (str != null) {
            e(str);
            this.l = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        AbsListView absListView;
        bundle.putString("currentMessageId", this.j);
        bundle.putInt("currentMessagePosition", this.k);
        bundle.putString("pendingMessageId", this.l);
        fv5 fv5 = this.g;
        if (!(fv5 == null || (absListView = fv5.g) == null)) {
            bundle.putParcelable("listView", absListView.onSaveInstanceState());
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        d(view);
        fv5 fv5 = this.g;
        fv5.l = this.f;
        if (fv5.e() != null) {
            fv5.h();
        }
        if (bundle != null && bundle.containsKey("listView")) {
            fv5 fv52 = this.g;
            b bVar = new b(this, bundle);
            AbsListView absListView = fv52.g;
            if (absListView != null) {
                absListView.onRestoreInstanceState(bundle.getParcelable("listView"));
            } else {
                fv52.m.add(bVar);
            }
        }
    }
}
