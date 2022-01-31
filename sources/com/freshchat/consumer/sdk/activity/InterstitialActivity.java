package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.freshchat.consumer.sdk.ConversationOptions;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.g.a;
import com.freshchat.consumer.sdk.g.e;
import com.freshchat.consumer.sdk.g.h;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.l;
import com.freshchat.consumer.sdk.j.m;
import com.freshchat.consumer.sdk.j.u;
import com.freshchat.consumer.sdk.j.v;
import com.freshchat.consumer.sdk.j.y;
import defpackage.ii;
import java.util.ArrayList;
import java.util.List;

public class InterstitialActivity extends b {
    private ConversationOptions an = new ConversationOptions();
    public ii.a<List<String>> bM = new ii.a<List<String>>() {
        /* class com.freshchat.consumer.sdk.activity.InterstitialActivity.AnonymousClass1 */

        /* renamed from: a */
        public void onLoadFinished(li<List<String>> liVar, List<String> list) {
            InterstitialActivity.this.a((InterstitialActivity) list);
        }

        @Override // defpackage.ii.a
        public li<List<String>> onCreateLoader(int i, Bundle bundle) {
            if (bundle == null || !bundle.containsKey("TAGS")) {
                return null;
            }
            return new e(InterstitialActivity.this.getApplicationContext(), bundle.getStringArrayList("TAGS"));
        }

        @Override // defpackage.ii.a
        public void onLoaderReset(li<List<String>> liVar) {
        }
    };
    public ii.a<List<String>> bN = new ii.a<List<String>>() {
        /* class com.freshchat.consumer.sdk.activity.InterstitialActivity.AnonymousClass2 */

        /* renamed from: a */
        public void onLoadFinished(li<List<String>> liVar, List<String> list) {
            InterstitialActivity.this.b((InterstitialActivity) list);
        }

        @Override // defpackage.ii.a
        public li<List<String>> onCreateLoader(int i, Bundle bundle) {
            if (bundle == null || !bundle.containsKey("TAGS")) {
                return null;
            }
            return new a(InterstitialActivity.this.getApplicationContext(), bundle.getStringArrayList("TAGS"));
        }

        @Override // defpackage.ii.a
        public void onLoaderReset(li<List<String>> liVar) {
        }
    };
    public ii.a<List<Channel>> bO = new ii.a<List<Channel>>() {
        /* class com.freshchat.consumer.sdk.activity.InterstitialActivity.AnonymousClass3 */

        /* renamed from: a */
        public void onLoadFinished(li<List<Channel>> liVar, List<Channel> list) {
            InterstitialActivity.this.c(list);
        }

        @Override // defpackage.ii.a
        public li<List<Channel>> onCreateLoader(int i, Bundle bundle) {
            if (bundle == null || !bundle.containsKey("TAGS")) {
                return null;
            }
            return new h(InterstitialActivity.this.getApplicationContext(), false, bundle.getStringArrayList("TAGS"));
        }

        @Override // defpackage.ii.a
        public void onLoaderReset(li<List<Channel>> liVar) {
        }
    };
    private FaqOptions g = new FaqOptions();
    private boolean qM = false;
    private boolean qN;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(List<String> list) {
        r().w(list);
        finish();
    }

    private void aC() {
        if (!this.qM) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().f();
            }
            RelativeLayout relativeLayout = new RelativeLayout(this);
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            ProgressBar progressBar = new ProgressBar(this);
            progressBar.setIndeterminate(true);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(13, -1);
            relativeLayout.addView(progressBar, layoutParams2);
            setContentView(relativeLayout, layoutParams);
            this.qM = true;
        }
    }

    private void aD() {
        ii supportLoaderManager;
        ii.a<List<String>> aVar;
        if (k.isEmpty(this.g.getTags())) {
            r().eu();
        } else if (y.cp(getContext())) {
            r().iY();
        } else {
            ArrayList<String> arrayList = new ArrayList<>(this.g.getTags());
            aC();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("TAGS", arrayList);
            if (this.g.getFilterType() == FaqOptions.FilterType.ARTICLE) {
                supportLoaderManager = getSupportLoaderManager();
                aVar = this.bN;
            } else if (this.g.getFilterType() == FaqOptions.FilterType.CATEGORY) {
                supportLoaderManager = getSupportLoaderManager();
                aVar = this.bM;
            } else {
                return;
            }
            supportLoaderManager.d(0, bundle, aVar);
            return;
        }
        finish();
    }

    private void aE() {
        if (k.isEmpty(this.an.getTags())) {
            aF().eu();
            finish();
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(this.an.getTags());
        aC();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("TAGS", arrayList);
        getSupportLoaderManager().d(0, bundle, this.bO);
    }

    private m aF() {
        return aa.a(this, this.an);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(List<String> list) {
        r().x(list);
        finish();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(List<Channel> list) {
        aF().u(list);
        finish();
    }

    private v r() {
        return aa.a(this, this.g);
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public void a(Context context, Intent intent) {
        if (as.o(intent.getAction(), "com.freshchat.consumer.sdk.actions.RemoteConfigUpdated") && this.g != null) {
            aD();
        }
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public String[] a() {
        return this.qN ? new String[]{"com.freshchat.consumer.sdk.actions.RemoteConfigUpdated"} : new String[0];
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle extras = getIntent().getExtras();
        if (FaqOptions.class.getSimpleName().equals(extras.getString("OPTIONS_TYPE"))) {
            this.g = u.d(getIntent().getExtras());
            boolean z = !ap.aZ(this);
            this.qN = z;
            if (z) {
                b.L(getContext());
                aC();
                return;
            }
            aD();
        } else if (ConversationOptions.class.getSimpleName().equals(extras.getString("OPTIONS_TYPE"))) {
            this.an = l.c(getIntent().getExtras());
            aE();
        }
    }
}
