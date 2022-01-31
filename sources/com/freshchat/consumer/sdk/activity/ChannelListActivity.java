package com.freshchat.consumer.sdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.freshchat.consumer.sdk.ConversationOptions;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.c;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.g.h;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.c.a;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.l;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.k.b;
import com.freshchat.consumer.sdk.service.e.b;
import com.freshchat.consumer.sdk.service.e.d;
import defpackage.ii;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChannelListActivity extends b {
    public static e aq;
    private ListView P;
    private View Q;
    private b aP;
    private ProgressBar am;
    private ConversationOptions an = new ConversationOptions();
    private List<Channel> ao = new ArrayList();
    private Map<Long, Integer> ap = new HashMap();
    private c ar;
    private AdapterView.OnItemClickListener as = new AdapterView.OnItemClickListener() {
        /* class com.freshchat.consumer.sdk.activity.ChannelListActivity.AnonymousClass1 */

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ChannelListActivity.this.a((ChannelListActivity) ((Channel) ChannelListActivity.this.ao.get(i)));
        }
    };
    private ii.a<List<Channel>> at = new ii.a<List<Channel>>() {
        /* class com.freshchat.consumer.sdk.activity.ChannelListActivity.AnonymousClass2 */

        /* renamed from: a */
        public void onLoadFinished(li<List<Channel>> liVar, List<Channel> list) {
            if (k.b(list) != 1 || list.get(0) == null) {
                ChannelListActivity.this.ao.clear();
                ChannelListActivity.this.ao.addAll(list);
                if (liVar instanceof h) {
                    ChannelListActivity.this.ap.clear();
                    ChannelListActivity.this.ap.putAll(((h) liVar).iT());
                }
                ChannelListActivity.this.dH = true;
                ChannelListActivity.this.gb();
                ChannelListActivity.this.ar.notifyDataSetChanged();
                return;
            }
            ChannelListActivity.this.a((ChannelListActivity) list.get(0));
            ChannelListActivity.this.finish();
        }

        @Override // defpackage.ii.a
        public li<List<Channel>> onCreateLoader(int i, Bundle bundle) {
            h hVar;
            if (bundle != null) {
                ChannelListActivity.this.getApplicationContext();
                bundle.getBoolean("EXTRA_FORCE_CLEAN_UP_EXPIRED_CSAT");
                bundle.getStringArrayList("TAGS");
                return hVar;
            }
            hVar = new h(ChannelListActivity.this.getApplicationContext(), false);
            return hVar;
        }

        @Override // defpackage.ii.a
        public void onLoaderReset(li<List<Channel>> liVar) {
            ChannelListActivity.this.ao.clear();
            ChannelListActivity.this.ar.notifyDataSetChanged();
        }
    };
    private boolean dH = false;

    private void F() {
        Bundle bundle = new Bundle();
        if (k.a(this.an.getTags())) {
            bundle.putStringArrayList("TAGS", new ArrayList<>(this.an.getTags()));
        }
        bundle.putBoolean("EXTRA_FORCE_CLEAN_UP_EXPIRED_CSAT", true);
        getSupportLoaderManager().d(0, bundle, this.at);
    }

    private e G() {
        if (aq == null) {
            aq = e.i(getApplicationContext());
        }
        return aq;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(Channel channel) {
        if (channel != null) {
            aa.a(getContext(), this.an).c(channel);
        } else {
            i.a(this, com.freshchat.consumer.sdk.b.c.CHANNEL_INFO_NOT_AVAILABLE);
        }
    }

    private void a(a aVar) {
        int i = g.ld[aVar.ordinal()];
        if (i == 1) {
            boolean z = !al.aS(getContext());
            boolean isEmpty = as.isEmpty(G().bG());
            if (!z || !isEmpty) {
                ge();
                return;
            }
        } else if (i != 2) {
            if (i == 3) {
                al();
                return;
            }
            return;
        } else if (!k.isEmpty(this.ao)) {
            gc();
            return;
        }
        gd();
    }

    private void ga() {
        this.aP = new b(getContext());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gb() {
        a gq = this.aP.gq();
        if (gq != a.EXIT_WITH_MESSAGE && !this.dH) {
            gq = a.SHOW_PROGRESS;
        }
        a(gq);
    }

    private void gc() {
        i.c(this.am);
        i.b(this.P);
        i.c(this.Q);
    }

    private void gd() {
        i.c(this.am);
        i.c(this.P);
        i.b(this.Q);
    }

    private void ge() {
        i.b(this.am);
        i.c(this.P);
        i.c(this.Q);
    }

    private ListView getListView() {
        if (this.P == null) {
            this.P = (ListView) findViewById(R.id.freshchat_activity_channel_list_listview);
        }
        return this.P;
    }

    private void u() {
        this.Q = findViewById(R.id.freshchat_activity_channel_list_empty_view);
        this.am = (ProgressBar) findViewById(R.id.freshchat_activity_channel_list_progressbar);
        this.ar = new c(this, this.ao, this.ap);
        getListView().setAdapter((ListAdapter) this.ar);
        getListView().setOnItemClickListener(this.as);
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public void a(Context context, Intent intent) {
        String action = intent.getAction();
        if ("com.freshchat.consumer.sdk.actions.ChannelsUpdated".equalsIgnoreCase(action)) {
            F();
        } else if ("com.freshchat.consumer.sdk.actions.JwtIdTokenStateChanged".equalsIgnoreCase(action) || "com.freshchat.consumer.sdk.actions.RemoteConfigUpdated".equalsIgnoreCase(action) || ("com.freshchat.consumer.sdk.actions.JwtModeEnabledForAccount".equalsIgnoreCase(action) && ap.aZ(getContext()) && o.bB(getContext()))) {
            gb();
        }
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.JwtModeEnabledForAccount", "com.freshchat.consumer.sdk.actions.ChannelsUpdated", "com.freshchat.consumer.sdk.actions.JwtIdTokenStateChanged", "com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.RemoteConfigUpdated"};
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.freshchat.consumer.sdk.j.b.M(getContext());
        ga();
        setContentView(R.layout.freshchat_activity_channel_list);
        ConversationOptions c = l.c(getIntent().getExtras());
        this.an = c;
        e(as.a(c.getFilteredViewTitle()) ? this.an.getFilteredViewTitle() : getString(R.string.freshchat_activity_title_channel_list));
        C();
        u();
        bg.d(getContext(), getIntent().getStringArrayExtra("INPUT_TAGS"));
    }

    @Override // defpackage.ve, com.freshchat.consumer.sdk.activity.b, com.freshchat.consumer.sdk.activity.a
    public void onResume() {
        super.onResume();
        boolean isEmpty = as.isEmpty(G().bG());
        com.freshchat.consumer.sdk.j.b.a(getApplicationContext(), b.a.NORMAL);
        com.freshchat.consumer.sdk.j.b.a(getApplicationContext(), 3, d.a.NORMAL);
        com.freshchat.consumer.sdk.j.b.L(getContext());
        if (isEmpty && !al.aS(getContext())) {
            Toast.makeText(getContext(), R.string.freshchat_error_message_not_connected_to_internet, 0).show();
        }
        if (!isEmpty || !al.aS(getContext())) {
            F();
        }
        gb();
    }
}
