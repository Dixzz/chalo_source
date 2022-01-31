package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.urbanairship.messagecenter.R;
import com.urbanairship.messagecenter.webkit.MessageWebView;
import defpackage.qu5;
import java.util.HashSet;

/* renamed from: cv5  reason: default package */
/* compiled from: MessageFragment */
public class cv5 extends Fragment {
    public MessageWebView f;
    public View g;
    public wu5 h;
    public View i;
    public Button j;
    public TextView k;
    public Integer l = null;
    public tj5 m;

    /* renamed from: cv5$a */
    /* compiled from: MessageFragment */
    public class a extends mv5 {
        public a() {
        }

        @Override // defpackage.fz5
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            cv5 cv5 = cv5.this;
            if (cv5.l != null) {
                cv5.g(2);
                return;
            }
            wu5 wu5 = cv5.h;
            if (wu5 != null) {
                if (wu5.r) {
                    wu5.r = false;
                    HashSet hashSet = new HashSet();
                    hashSet.add(wu5.j);
                    yu5.j().g.f(hashSet);
                }
                cv5 cv52 = cv5.this;
                MessageWebView messageWebView = cv52.f;
                if (messageWebView != null) {
                    messageWebView.animate().alpha(1.0f).setDuration(200).setListener(null);
                }
                View view = cv52.g;
                if (view != null) {
                    view.animate().alpha(0.0f).setDuration(200).setListener(null);
                }
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            wu5 wu5 = cv5.this.h;
            if (wu5 != null && str2 != null && str2.equals(wu5.l)) {
                cv5.this.l = Integer.valueOf(i);
            }
        }
    }

    /* renamed from: cv5$b */
    /* compiled from: MessageFragment */
    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            cv5 cv5 = cv5.this;
            if (cv5.f != null) {
                cv5.f();
            }
        }
    }

    /* renamed from: cv5$c */
    /* compiled from: MessageFragment */
    public class c implements qu5.c {
        public c() {
        }

        @Override // defpackage.qu5.c
        public void a(boolean z) {
            cv5.this.h = yu5.j().g.d(cv5.this.e());
            if (!z) {
                cv5.this.g(1);
                return;
            }
            wu5 wu5 = cv5.this.h;
            if (wu5 == null || wu5.c()) {
                cv5.this.g(3);
                return;
            }
            StringBuilder i0 = hj1.i0("Loading message: ");
            i0.append(cv5.this.h.j);
            yj5.f(i0.toString(), new Object[0]);
            cv5 cv5 = cv5.this;
            cv5.f.b(cv5.h);
        }
    }

    public final void d(View view) {
        if (this.f == null) {
            View findViewById = view.findViewById(16908301);
            this.g = findViewById;
            if (findViewById != null) {
                MessageWebView messageWebView = (MessageWebView) view.findViewById(16908299);
                this.f = messageWebView;
                if (messageWebView != null) {
                    this.i = view.findViewById(R.id.error);
                    this.f.setAlpha(0.0f);
                    this.f.setWebViewClient(new a());
                    this.f.getSettings().setSupportMultipleWindows(true);
                    this.f.setWebChromeClient(new ez5(c()));
                    Button button = (Button) view.findViewById(R.id.retry_button);
                    this.j = button;
                    if (button != null) {
                        button.setOnClickListener(new b());
                    }
                    this.k = (TextView) view.findViewById(R.id.error_message);
                    return;
                }
                throw new RuntimeException("Your content must have a MessageWebView whose id attribute is 'android.R.id.message'");
            }
            throw new RuntimeException("Your content must have a progress View whose id attribute is 'android.R.id.progress'");
        }
    }

    public String e() {
        if (getArguments() == null) {
            return null;
        }
        return getArguments().getString("messageReporting");
    }

    public final void f() {
        View view = this.i;
        if (view != null && view.getVisibility() == 0) {
            this.i.animate().alpha(0.0f).setDuration(200).setListener(null);
        }
        MessageWebView messageWebView = this.f;
        if (messageWebView != null) {
            messageWebView.animate().alpha(0.0f).setDuration(200).setListener(null);
        }
        View view2 = this.g;
        if (view2 != null) {
            view2.animate().alpha(1.0f).setDuration(200).setListener(null);
        }
        this.l = null;
        wu5 d = yu5.j().g.d(e());
        this.h = d;
        if (d == null) {
            yj5.a("Fetching messages.", new Object[0]);
            this.m = yu5.j().g.b(null, new c());
        } else if (d.c()) {
            g(3);
        } else {
            yj5.f("Loading message: %s", this.h.j);
            this.f.b(this.h);
        }
    }

    public void g(int i2) {
        if (this.i != null) {
            if (i2 == 1 || i2 == 2) {
                Button button = this.j;
                if (button != null) {
                    button.setVisibility(0);
                }
                TextView textView = this.k;
                if (textView != null) {
                    textView.setText(R.string.ua_mc_failed_to_load);
                }
            } else if (i2 == 3) {
                Button button2 = this.j;
                if (button2 != null) {
                    button2.setVisibility(8);
                }
                TextView textView2 = this.k;
                if (textView2 != null) {
                    textView2.setText(R.string.ua_mc_no_longer_available);
                }
            }
            if (this.i.getVisibility() == 8) {
                this.i.setAlpha(0.0f);
                this.i.setVisibility(0);
            }
            this.i.animate().alpha(1.0f).setDuration(200).setListener(null);
        }
        View view = this.g;
        if (view != null) {
            view.animate().alpha(0.0f).setDuration(200).setListener(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ua_fragment_message, viewGroup, false);
        d(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f = null;
        this.g = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        f();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        tj5 tj5 = this.m;
        if (tj5 != null) {
            tj5.cancel();
            this.m = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        d(view);
    }
}
