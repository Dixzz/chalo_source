package com.freshchat.consumer.sdk.activity;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.d;
import com.freshchat.consumer.sdk.a.e;
import com.freshchat.consumer.sdk.activity.PictureAttachmentActivity;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.beans.CsatResponse;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.beans.fragment.AudioFragment;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.beans.fragment.CollectionFragment;
import com.freshchat.consumer.sdk.beans.fragment.ImageFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyDropDownFragment;
import com.freshchat.consumer.sdk.beans.fragment.TextFragment;
import com.freshchat.consumer.sdk.beans.reqres.CsatResponseRequest;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ag;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.am;
import com.freshchat.consumer.sdk.j.an;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.au;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.ax;
import com.freshchat.consumer.sdk.j.ay;
import com.freshchat.consumer.sdk.j.az;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.by;
import com.freshchat.consumer.sdk.j.cj;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.h;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.j.p;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.x;
import com.freshchat.consumer.sdk.l.c;
import com.freshchat.consumer.sdk.m.f;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.e.b;
import com.freshchat.consumer.sdk.service.e.d;
import com.freshchat.consumer.sdk.service.e.r;
import com.freshchat.consumer.sdk.service.e.t;
import com.freshchat.consumer.sdk.ui.CarouselCardView;
import com.freshchat.consumer.sdk.ui.FlowLayout;
import defpackage.e0;
import defpackage.ii;
import defpackage.jk;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConversationDetailActivity extends b implements ax, f.a {
    public static final String TAG = ConversationDetailActivity.class.getName();
    private static long aS;
    private View aA;
    private RecyclerView aB;
    private EditText aC;
    private View aD;
    private View aE;
    private View aF;
    private View aG;
    private ProgressBar aH;
    private TextView aI;
    private LinearLayoutManager aJ;
    private String aK;
    private Conversation aL;
    private List<Message> aM = new ArrayList();
    private Map<String, Participant> aN = new HashMap();
    private boolean aO;
    private d aQ;
    private String aR;
    private CountDownTimer aT;
    private e0 aU;
    private TextWatcher aV = new TextWatcher() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass19 */

        public void afterTextChanged(Editable editable) {
            boolean z = editable != null && editable.length() > 0;
            ConversationDetailActivity.this.aE.setAlpha(z ? 1.0f : 0.6f);
            ConversationDetailActivity.this.a((ConversationDetailActivity) (true ^ z));
            if (ConversationDetailActivity.this.dH()) {
                ConversationDetailActivity.this.onUserInteraction();
            }
            if (editable != null && p.aD(ConversationDetailActivity.this.getContext())) {
                i.a(ConversationDetailActivity.this.getContext(), ConversationDetailActivity.this.aC);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private DialogInterface.OnClickListener aW = new DialogInterface.OnClickListener() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass20 */

        public void onClick(DialogInterface dialogInterface, int i) {
            if (i == 0) {
                ConversationDetailActivity.this.aa();
            } else if (i == 1) {
                ConversationDetailActivity.this.Z();
            }
        }
    };
    private View.OnClickListener aX = new View.OnClickListener() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass21 */

        public void onClick(View view) {
            ConversationDetailActivity.this.Y();
            i.a(ConversationDetailActivity.this.getContext(), (View) ConversationDetailActivity.this.aC);
        }
    };
    private View.OnClickListener aY = new View.OnClickListener() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass2 */

        public void onClick(View view) {
            i.a(ConversationDetailActivity.this.getContext(), (View) ConversationDetailActivity.this.aC);
            ConversationDetailActivity.this.T();
        }
    };
    private View.OnLongClickListener aZ = new View.OnLongClickListener() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass3 */

        public boolean onLongClick(View view) {
            i.a(ConversationDetailActivity.this.getContext(), (View) ConversationDetailActivity.this.aC);
            ConversationDetailActivity.this.T();
            return true;
        }
    };
    private e aq;
    private g av;
    private ClipboardManager aw;
    private h ax;
    private View ay;
    private View az;
    private RecyclerView ba;
    private ii.a<List<Message>> bb = new ii.a<List<Message>>() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass6 */

        /* renamed from: a */
        public void onLoadFinished(li<List<Message>> liVar, List<Message> list) {
            jk.d b = ConversationDetailActivity.this.lz.b(ConversationDetailActivity.this.aM, list);
            ConversationDetailActivity.this.aM.clear();
            ConversationDetailActivity.this.aM.addAll(list);
            ConversationDetailActivity.this.aN.clear();
            com.freshchat.consumer.sdk.g.i iVar = (com.freshchat.consumer.sdk.g.i) liVar;
            List<Participant> participants = iVar.getParticipants();
            if (k.a(participants)) {
                for (Participant participant : participants) {
                    ConversationDetailActivity.this.aN.put(participant.getAlias(), participant);
                }
            }
            b.a(new r(this, ConversationDetailActivity.this.aQ));
            boolean av = ConversationDetailActivity.this.av();
            ConversationDetailActivity.this.I().x(av);
            ConversationDetailActivity.this.K();
            if (liVar instanceof com.freshchat.consumer.sdk.g.i) {
                ConversationDetailActivity.this.aO = iVar.di();
            }
            ConversationDetailActivity.this.aj();
            ConversationDetailActivity conversationDetailActivity = ConversationDetailActivity.this;
            if (av) {
                conversationDetailActivity.ap();
                ConversationDetailActivity.this.an();
                ConversationDetailActivity.this.aq();
                ConversationDetailActivity.this.as();
                ConversationDetailActivity.this.gC();
                ConversationDetailActivity.this.gS();
                bg.k(ConversationDetailActivity.this.getContext(), ConversationDetailActivity.this.channelId);
            } else {
                conversationDetailActivity.aX();
            }
            ConversationDetailActivity.this.lz.a(ConversationDetailActivity.this.channelId, ConversationDetailActivity.this.cW);
        }

        @Override // defpackage.ii.a
        public li<List<Message>> onCreateLoader(int i, Bundle bundle) {
            return new com.freshchat.consumer.sdk.g.i(ConversationDetailActivity.this.getApplicationContext(), bundle.getLong("CHANNEL_ID"));
        }

        @Override // defpackage.ii.a
        public void onLoaderReset(li<List<Message>> liVar) {
            ConversationDetailActivity.this.aM.clear();
            ConversationDetailActivity.this.aN.clear();
            ConversationDetailActivity.this.I().notifyDataSetChanged();
            ConversationDetailActivity.this.aO = false;
        }
    };
    private View.OnClickListener bc = new View.OnClickListener() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass11 */

        public void onClick(View view) {
            String obj = ConversationDetailActivity.this.aC.getText().toString();
            ConversationDetailActivity.this.aC.setText("");
            ConversationDetailActivity.this.aC.requestFocus();
            ConversationDetailActivity.this.g((ConversationDetailActivity) obj);
            ay.c(ConversationDetailActivity.this.getContext(), ConversationDetailActivity.this.aM);
        }
    };
    public View.OnClickListener bd = new e(this);
    private View bf;
    private View bg;
    private ii.a<Channel> bh = new ii.a<Channel>() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass10 */

        /* renamed from: a */
        public void onLoadFinished(li<Channel> liVar, Channel channel) {
            if (channel == null) {
                ConversationDetailActivity.this.finish();
                i.a(ConversationDetailActivity.this.getContext(), c.CHANNEL_INFO_INVALID);
            } else if (channel.isHidden()) {
                i.a(ConversationDetailActivity.this.getContext(), R.string.freshchat_channel_disabled);
                ConversationDetailActivity.this.finish();
            } else {
                ConversationDetailActivity.this.channelId = channel.getId();
                ConversationDetailActivity.this.aK = channel.getName();
                ConversationDetailActivity.this.channelType = channel.getChannelType();
                long unused = ConversationDetailActivity.aS = ConversationDetailActivity.this.channelId;
                if (ConversationDetailActivity.this.getSupportActionBar() != null) {
                    ConversationDetailActivity.this.getSupportActionBar().z(ConversationDetailActivity.this.aK);
                    ConversationDetailActivity.this.ae();
                }
                if (ConversationDetailActivity.this.ag()) {
                    ConversationDetailActivity.this.ah();
                }
                if (liVar instanceof com.freshchat.consumer.sdk.g.g) {
                    ConversationDetailActivity.this.aL = ((com.freshchat.consumer.sdk.g.g) liVar).dg();
                }
                ConversationDetailActivity.this.U();
            }
        }

        @Override // defpackage.ii.a
        public li<Channel> onCreateLoader(int i, Bundle bundle) {
            com.freshchat.consumer.sdk.g.g gVar;
            if (bundle != null) {
                ConversationDetailActivity.this.getApplicationContext();
                bundle.getBoolean("EXTRA_FORCE_CLEAN_UP_EXPIRED_CSAT");
                bundle.getLong("CHANNEL_ID");
                return gVar;
            }
            gVar = new com.freshchat.consumer.sdk.g.g(ConversationDetailActivity.this.getApplicationContext(), false);
            return gVar;
        }

        @Override // defpackage.ii.a
        public void onLoaderReset(li<Channel> liVar) {
            ConversationDetailActivity.this.channelId = 0;
            ConversationDetailActivity.this.aK = "";
            ConversationDetailActivity.this.channelType = null;
            ConversationDetailActivity.this.aL = null;
        }
    };
    private View bi;
    private com.freshchat.consumer.sdk.k.g bj;
    private View.OnClickListener bk = new View.OnClickListener() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass4 */

        public void onClick(View view) {
            i.c(view);
            ConversationDetailActivity.this.gW();
        }
    };
    private e.a bl = new e.a() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass5 */

        @Override // com.freshchat.consumer.sdk.a.e.a
        public void a(QuickReplyButtonFragment quickReplyButtonFragment, long j) {
            ConversationDetailActivity.this.ao();
            Message a2 = ConversationDetailActivity.this.lz.a(ConversationDetailActivity.this.G().bj(), quickReplyButtonFragment, ConversationDetailActivity.this.af(), ConversationDetailActivity.this.channelId, j);
            if (a2 != null) {
                ConversationDetailActivity.this.a((ConversationDetailActivity) a2);
                bg.a(ConversationDetailActivity.this.getContext(), quickReplyButtonFragment);
            }
        }
    };
    private CarouselCardView.a bn = new CarouselCardView.a() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass12 */

        @Override // com.freshchat.consumer.sdk.ui.CarouselCardView.a
        public void a(CarouselCardDefaultFragment carouselCardDefaultFragment) {
            ConversationDetailActivity.this.ao();
            Message a2 = ConversationDetailActivity.this.lz.a(ConversationDetailActivity.this.G().bj(), carouselCardDefaultFragment, ConversationDetailActivity.this.af(), ConversationDetailActivity.this.channelId, ConversationDetailActivity.this.lz.E(ConversationDetailActivity.this.aM));
            if (a2 != null) {
                ConversationDetailActivity.this.a((ConversationDetailActivity) a2);
                bg.a(ConversationDetailActivity.this.getContext(), carouselCardDefaultFragment);
            }
        }
    };
    private d.f bo = new d.f() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass15 */

        @Override // com.freshchat.consumer.sdk.a.d.f
        public void f(Message message) {
            if (message != null) {
                ConversationDetailActivity.this.lz.y(message.getId());
            }
        }
    };
    private View bp;
    private TextView bq;
    private f cT;
    public final d.g cU = new d.g() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass16 */

        @Override // com.freshchat.consumer.sdk.a.d.g
        public void a(Message message, boolean z) {
            if (aw.eS() && ConversationDetailActivity.this.J() != null && message != null) {
                String string = ConversationDetailActivity.this.getString(R.string.freshchat_message_content_copied_to_clipboard);
                String a2 = com.freshchat.consumer.sdk.service.d.c.a(ConversationDetailActivity.this.getContext(), message, z);
                if (as.a(a2)) {
                    ConversationDetailActivity.this.J().setPrimaryClip(ClipData.newPlainText(a2, a2));
                    Toast.makeText(ConversationDetailActivity.this.getContext(), string, 1).show();
                }
            }
        }
    };
    private c.b cW = new c.b() {
        /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass7 */

        @Override // com.freshchat.consumer.sdk.l.c.b
        public void hu() {
            i.c(ConversationDetailActivity.this.bp);
        }

        @Override // com.freshchat.consumer.sdk.l.c.b
        public void o(Message message) {
            String z = ConversationDetailActivity.this.lz.z(message);
            Uri w = ConversationDetailActivity.this.lz.w(message);
            if (!as.a(z) || w == null) {
                i.c(ConversationDetailActivity.this.bp);
                return;
            }
            ConversationDetailActivity.this.bq.setText(z);
            ConversationDetailActivity.this.bp.setOnClickListener(new s(this, w));
            i.b(ConversationDetailActivity.this.bp);
        }
    };
    private final cj.a cX = new t(this);
    private long channelId;
    private String channelType;
    private com.freshchat.consumer.sdk.c.e eT;
    private ConnectivityManager.NetworkCallback hE;
    private String[] lE;
    private View le;
    private View lf;
    private RemoteConfig lg;
    private com.freshchat.consumer.sdk.k.c lz;
    private int orientation;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private com.freshchat.consumer.sdk.b.e G() {
        if (this.aq == null) {
            this.aq = com.freshchat.consumer.sdk.b.e.i(getApplicationContext());
        }
        return this.aq;
    }

    public static long H() {
        return aS;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private d I() {
        if (this.aQ == null) {
            d dVar = new d(this, this.aM, this.aN, this.cU, this.cX);
            this.aQ = dVar;
            dVar.a(this.bn);
            this.aQ.a(this.bo);
        }
        return this.aQ;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ClipboardManager J() {
        if (this.aw == null && aw.eS()) {
            this.aw = (ClipboardManager) getContext().getSystemService("clipboard");
        }
        return this.aw;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void K() {
        O();
        N();
        c(getIntent());
    }

    private void L() {
        if (this.ax != null) {
            if (M()) {
                this.ax.eh();
            }
            this.ax.el();
        }
    }

    private boolean M() {
        h hVar = this.ax;
        return (hVar == null || hVar.ek() == null || !this.ax.ek().M()) ? false : true;
    }

    private void N() {
        if (ac().m(this.channelId) > 0 && at()) {
            b.b(getContext(), this.channelId, this.aL.getConversationId());
        }
    }

    private void O() {
        try {
            Set<Long> i = ac().i(this.channelId);
            String str = TAG;
            ai.d(str, "Unread marketing Ids for channel " + this.channelId + " are " + i);
            for (Long l : i) {
                long longValue = l.longValue();
                aa.g(getApplicationContext(), longValue);
                com.freshchat.consumer.sdk.h.b.a(getContext(), 0, longValue);
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    private com.freshchat.consumer.sdk.c.e P() {
        if (this.eT == null) {
            this.eT = new com.freshchat.consumer.sdk.c.e(getApplicationContext());
        }
        return this.eT;
    }

    private boolean Q() {
        return am.a(this, am.iE);
    }

    private void R() {
        if (Q()) {
            S();
            return;
        }
        this.aD.setOnClickListener(this.aY);
        this.aD.setOnLongClickListener(this.aZ);
    }

    private void S() {
        this.ax = new h(getApplicationContext(), this, this.channelId);
        setVolumeControlStream(3);
        com.freshchat.consumer.sdk.f.b bVar = new com.freshchat.consumer.sdk.f.b(this, this.ax);
        this.aH = (ProgressBar) findViewById(R.id.freshchat_conv_detail_voice_reply_progressbar);
        this.aI = (TextView) findViewById(R.id.freshchat_conv_detail_voice_reply_time_elapsed_text);
        this.aD.setOnClickListener(null);
        this.aD.setOnLongClickListener(null);
        this.aD.setOnTouchListener(bVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void T() {
        String str;
        int i;
        if (aw.fa()) {
            ai.i(TAG, "Permissions required for voice messaging has NOT been granted. Requesting permission.");
            boolean shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale("android.permission.RECORD_AUDIO");
            boolean shouldShowRequestPermissionRationale2 = shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE");
            if (shouldShowRequestPermissionRationale && shouldShowRequestPermissionRationale2) {
                i = R.string.freshchat_chat_voice_messaging_permissions_rationale;
            } else if (shouldShowRequestPermissionRationale2) {
                i = R.string.freshchat_chat_voice_messaging_write_storage_permission_rationale;
            } else if (shouldShowRequestPermissionRationale) {
                i = R.string.freshchat_chat_voice_messaging_audio_recording_permission_rationale;
            } else {
                str = "";
                i.e(getContext(), str);
                requestPermissions(am.b(getContext(), am.iE), 100);
            }
            str = getString(i);
            i.e(getContext(), str);
            requestPermissions(am.b(getContext(), am.iE), 100);
        }
    }

    private void W() {
        if (G().bn()) {
            try {
                com.freshchat.consumer.sdk.i.c.dW();
            } catch (Exception e) {
                q.a(e);
            }
        }
    }

    private void X() {
        if (G().isGallerySelectionEnabled() || G().isCameraCaptureEnabled()) {
            i.b(this.aF);
        } else {
            i.c(this.aF);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Y() {
        boolean isCameraCaptureEnabled = G().isCameraCaptureEnabled();
        boolean isGallerySelectionEnabled = G().isGallerySelectionEnabled();
        if (isCameraCaptureEnabled && isGallerySelectionEnabled) {
            ab();
        } else if (isCameraCaptureEnabled) {
            aa();
        } else if (isGallerySelectionEnabled) {
            Z();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Z() {
        Intent intent = new Intent();
        intent.setType(az.b.TYPE_IMAGE.getType());
        intent.setAction((!aw.eY() || !getResources().getBoolean(R.bool.freshchat_document_provider_enabled)) ? "android.intent.action.GET_CONTENT" : "android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 125);
    }

    private static void a(Context context, long j, long j2, boolean z, int i, String str) {
        if (j != 0 && j2 != 0) {
            new com.freshchat.consumer.sdk.c.e(context).U(Long.toString(j));
            t tVar = new t();
            CsatResponseRequest csatResponseRequest = new CsatResponseRequest();
            CsatResponse conversationId = new CsatResponse().setCsatId(j2).setIssueResolved(z).setConversationId(j);
            if (i > 0) {
                conversationId.setStars(i);
            }
            if (!as.isEmpty(str)) {
                conversationId.setResponse(str);
            }
            csatResponseRequest.setCsatResponse(conversationId);
            tVar.a(csatResponseRequest);
            com.freshchat.consumer.sdk.service.d.d.b(context, tVar);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(Uri uri, int i) {
        startActivityForResult(PictureAttachmentActivity.a(getContext(), uri, i, this.aC.getText().toString()), 127);
    }

    private void a(MenuItem menuItem, boolean z) {
        int i;
        Context context;
        if (G().bo()) {
            int a2 = aq.a(getContext(), R.attr.freshchatSpeakerIcon, false);
            if (a2 > 0) {
                menuItem.setVisible(true);
                menuItem.setIcon(a2);
                if (z) {
                    context = getContext();
                    i = R.string.freshchat_speaker_phone_on;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else {
            int a3 = aq.a(getContext(), R.attr.freshchatEarpieceIcon, false);
            if (a3 > 0) {
                menuItem.setVisible(true);
                menuItem.setIcon(a3);
                if (z) {
                    context = getContext();
                    i = R.string.freshchat_speaker_phone_off;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        i.a(context, i);
    }

    private void a(CalendarMessageMeta calendarMessageMeta, CalendarDay.TimeSlot timeSlot, int i) {
        Message a2 = this.lz.a(calendarMessageMeta, timeSlot, i, af(), this.channelId);
        if (a2 != null) {
            a(a2);
        }
    }

    /* access modifiers changed from: private */
    public void a(Csat csat, boolean z) {
        a(csat, z, 0, (String) null);
    }

    /* access modifiers changed from: private */
    public void a(Csat csat, boolean z, int i, String str) {
        a(getApplicationContext(), this.aL.getConversationId(), csat.getCsatId(), z, i, str);
        ad();
        i.e(this.aC);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(Message message) {
        if (message != null) {
            bg.l(getContext(), this.channelId);
            if (!al.aS(getContext())) {
                i.a(getContext(), R.string.freshchat_error_send_message_when_no_internet);
            }
            i.e(this.aC);
            if (!ac().b(message)) {
                i.a(getContext(), com.freshchat.consumer.sdk.b.c.MESSAGE_SENDING_FAILED);
                return;
            }
            cm.a(getContext(), message, this.channelId);
            V();
            if (com.freshchat.consumer.sdk.service.a.c.bd(getContext())) {
                com.freshchat.consumer.sdk.service.a.c.d(getContext(), message);
                b.M(getContext());
                return;
            }
            b.a(getContext(), message, new a<r>() {
                /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass18 */

                public void a(r rVar) {
                    if (rVar.isSuccess()) {
                        ConversationDetailActivity.this.aj();
                    }
                }
            });
        }
    }

    private void a(String str, int i, int i2, String str2) {
        try {
            Message h = h(str2);
            ImageFragment imageFragment = new ImageFragment();
            imageFragment.setContent(str);
            imageFragment.setContentType("image/jpeg");
            imageFragment.setHeight(i2);
            imageFragment.setWidth(i);
            h.addMessageFragment(imageFragment);
            a(h);
            f(ProductPromotionsObject.KEY_IMAGE);
        } catch (Exception e) {
            q.a(e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void a(boolean z) {
        View view;
        if (!z || !G().bn()) {
            i.b(this.aE);
            view = this.aD;
        } else {
            i.b(this.aD);
            view = this.aE;
        }
        i.c(view);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void aX() {
        ad();
        com.freshchat.consumer.sdk.b.k C = this.lz.C(this.aM);
        com.freshchat.consumer.sdk.b.k kVar = com.freshchat.consumer.sdk.b.k.NORMAL;
        if (C != kVar) {
            gC();
        }
        com.freshchat.consumer.sdk.b.k kVar2 = com.freshchat.consumer.sdk.b.k.DROP_DOWN;
        if (C != kVar2) {
            gS();
        }
        if (C == kVar) {
            gA();
        } else if (C == kVar2) {
            fS();
        } else if (C == com.freshchat.consumer.sdk.b.k.CAROUSEL) {
            ap();
        }
        if (this.lz.I(this.aM)) {
            ap();
        }
    }

    /* access modifiers changed from: private */
    public void aY() {
        I().x(false);
        aX();
        if (this.lz.C(this.aM) == com.freshchat.consumer.sdk.b.k.CAROUSEL) {
            this.aB.post(new p(this));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    @TargetApi(23)
    private void aa() {
        if (!aw.fa() || am.aX(getContext())) {
            try {
                this.aR = null;
                File aF2 = x.aF(getContext());
                Intent a2 = an.a(getContext(), aF2);
                if (a2 != null) {
                    if (!a2.hasExtra("HAS_ERRORS")) {
                        this.aR = aF2.getAbsolutePath();
                        startActivityForResult(a2, 126);
                        return;
                    }
                }
                String stringExtra = a2 != null ? a2.getStringExtra("ERROR_MESSAGE") : "";
                if (as.isEmpty(stringExtra)) {
                    stringExtra = com.freshchat.consumer.sdk.b.c.PICTURE_ATTACHMENT_FAILED.toString();
                }
                Toast.makeText(getContext(), stringExtra, 1).show();
            } catch (Exception e) {
                this.aR = null;
                ai.e("FRESHCHAT", "Exception while initiating camera capture", e);
            }
        } else {
            if (shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                Toast.makeText(this, getString(R.string.freshchat_chat_camera_permissions_rationale), 1).show();
            }
            requestPermissions(new String[]{"android.permission.CAMERA"}, 101);
        }
    }

    private void ab() {
        String[] strArr = {getString(R.string.freshchat_chat_capture_from_camera), getString(R.string.freshchat_chat_select_from_gallery)};
        e0.a m = i.m(this);
        DialogInterface.OnClickListener onClickListener = this.aW;
        AlertController.b bVar = m.f908a;
        bVar.n = strArr;
        bVar.p = onClickListener;
        m.a().show();
    }

    private g ac() {
        if (this.av == null) {
            this.av = new g(getApplicationContext());
        }
        return this.av;
    }

    private void ad() {
        if (!M()) {
            if (ag()) {
                ah();
                return;
            }
            ao();
            an();
            ar();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void ae() {
        if (this.aq.isResponseExpectationEnabled()) {
            String d = com.freshchat.consumer.sdk.j.r.d(this, this.channelId);
            if (getSupportActionBar() != null && as.a(d)) {
                getSupportActionBar().x(d);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private long af() {
        if (at()) {
            return this.aL.getConversationId();
        }
        if (!k.a(this.aM)) {
            return 0;
        }
        for (Message message : this.aM) {
            if (!(com.freshchat.consumer.sdk.service.d.c.i(message) || message.getConversationId() == 0)) {
                long conversationId = message.getConversationId();
                this.aL = new Conversation(conversationId).setChannelId(this.channelId);
                return conversationId;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean ag() {
        return Channel.CHANNEL_TYPE_AGENT_ONLY.equals(this.channelType);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void ah() {
        ap();
        an();
        ar();
        this.aJ.N1(false);
        List<Message> list = this.aM;
        if (list != null && list.size() > 0) {
            this.aB.i0(this.aM.size() - 1);
        }
    }

    private boolean ai() {
        return this.aO && k.b(this.aM) > 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void aj() {
        try {
            if (ai()) {
                b(gg().getRefreshIntervals().getActiveConvMinFetchInterval());
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    private void ak() {
        CountDownTimer countDownTimer = this.aT;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void aq() {
        i.a(getContext(), (View) this.aC);
        b(this.aA);
    }

    private void ar() {
        c(this.aA);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void as() {
        View view = this.aA;
        if (view != null) {
            View findViewById = view.findViewById(R.id.freshchat_chat_resolution_positive_btn);
            if (findViewById != null) {
                findViewById.setOnClickListener(this.bd);
            }
            View findViewById2 = this.aA.findViewById(R.id.freshchat_chat_resolution_negative_btn);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(this.bd);
            }
        }
    }

    private boolean at() {
        Conversation conversation = this.aL;
        return conversation != null && conversation.getConversationId() > 0;
    }

    private boolean au() {
        return at() && this.aL.getCsat() != null && this.aL.getCsat().getCsatId() > 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean av() {
        Csat csat = (!au() || !this.aL.hasPendingCsat()) ? null : this.aL.getCsat();
        if (csat == null) {
            return false;
        }
        boolean z = csat.getStatus() == Csat.CSatStatus.NOT_RATED;
        if (au.a(gg()) && au.a(gg(), csat)) {
            long af = af();
            P().t(af);
            bg.c(getContext(), af, this.channelId);
            z = false;
        }
        return z && !aw() && !M();
    }

    private boolean aw() {
        EditText editText = this.aC;
        return editText != null && as.a(editText.getText());
    }

    private boolean ax() {
        e0 e0Var = this.aU;
        return e0Var != null && e0Var.isShowing();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(final long j) {
        try {
            ak();
            final double activeConvFetchBackoffRatio = gg().getConversationConfig().getActiveConvFetchBackoffRatio();
            final long activeConvMaxFetchInterval = gg().getRefreshIntervals().getActiveConvMaxFetchInterval();
            AnonymousClass13 r0 = new CountDownTimer(j, j) {
                /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass13 */

                public void onFinish() {
                    if (al.aS(ConversationDetailActivity.this.getApplicationContext())) {
                        b.a(ConversationDetailActivity.this.getApplicationContext(), as.a(ConversationDetailActivity.this.G().bP()) ? 11 : 12, d.a.IMMEDIATE);
                        ai.d("FRESHCHAT", "Polling for new Messages");
                    }
                    ConversationDetailActivity.this.b((ConversationDetailActivity) Math.min((long) (((double) j) * activeConvFetchBackoffRatio), activeConvMaxFetchInterval));
                }

                public void onTick(long j) {
                }
            };
            this.aT = r0;
            r0.start();
        } catch (Exception e) {
            q.a(e);
        }
    }

    private void b(Intent intent) {
        if (intent.hasExtra("CHANNEL_ID")) {
            this.channelId = intent.getLongExtra("CHANNEL_ID", 0);
            if (intent.hasExtra("UNFETCHED_CHANNEL")) {
                finish();
                startActivity(new Intent(getContext(), ChannelListActivity.class));
            }
            if (intent.hasExtra("CHANNEL_NAME") && !as.isEmpty(intent.getStringExtra("CHANNEL_NAME"))) {
                this.aK = intent.getStringExtra("CHANNEL_NAME");
            }
            if (intent.hasExtra("CHANNEL_TYPE") && !as.isEmpty(intent.getStringExtra("CHANNEL_TYPE"))) {
                this.channelType = intent.getStringExtra("CHANNEL_TYPE");
            }
            this.lE = intent.getStringArrayExtra("INPUT_TAGS");
            return;
        }
        finish();
        i.a(this, com.freshchat.consumer.sdk.b.c.CHANNEL_ID_MISSING);
    }

    private void b(final View view) {
        runOnUiThread(new Runnable() {
            /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass14 */

            public void run() {
                View view = view;
                if (view != null && view.getVisibility() != 0) {
                    view.setVisibility(0);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        Csat csat;
        boolean z2;
        Conversation conversation = this.aL;
        if (conversation != null && (csat = conversation.getCsat()) != null && !ax()) {
            e0.a b = i.b(this, R.attr.freshchatCustomerSurveyDialog);
            View inflate = LayoutInflater.from(this).inflate(R.layout.freshchat_dialog_customer_survey, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.freshchat_custsurvey_question_text);
            RatingBar ratingBar = (RatingBar) inflate.findViewById(R.id.freshchat_custsurvey_rating_bar);
            EditText editText = (EditText) inflate.findViewById(R.id.freshchat_custsurvey_user_comment);
            if (z) {
                String string = getString(R.string.freshchat_chat_resolution_survey_question);
                if (as.isEmpty(string)) {
                    string = csat.getQuestion();
                }
                textView.setText(as.fromHtml(string));
                z2 = csat.isMobileUserCommentsAllowed();
            } else {
                textView.setText(getString(R.string.freshchat_chat_resolution_suggestions_prompt));
                z2 = true;
            }
            if (z) {
                b(ratingBar);
            } else {
                c(ratingBar);
            }
            if (z2) {
                b(editText);
            } else {
                c(editText);
            }
            b.b(R.string.freshchat_chat_rating_submit, new l(this, z, ratingBar, editText, csat, z));
            m mVar = new m(this, csat, z);
            AlertController.b bVar = b.f908a;
            bVar.l = mVar;
            bVar.q = inflate;
            this.aU = b.a();
            ratingBar.setOnRatingBarChangeListener(new n(this, z));
            this.aU.setOnShowListener(new o(this, z));
            this.aU.show();
        }
    }

    private void c() {
        this.ay = findViewById(R.id.freshchat_conv_detail_text_reply_layout);
        this.az = findViewById(R.id.freshchat_conv_detail_voice_reply_layout);
        this.aA = findViewById(R.id.freshchat_chat_resolution_confirmation_layout);
        this.aB = (RecyclerView) findViewById(R.id.freshchat_conv_detail_list);
        this.aC = (EditText) findViewById(R.id.freshchat_conv_detail_reply_text);
        this.aD = findViewById(R.id.freshchat_conv_detail_record_voice_reply_button);
        this.aE = findViewById(R.id.freshchat_conv_detail_send_reply_button);
        this.aF = findViewById(R.id.freshchat_conv_detail_attach_image);
        this.aG = findViewById(R.id.freshchat_conversation_banner_message_text);
        this.le = findViewById(R.id.freshchat_activity_conversation_detail_progressbar);
        this.lf = findViewById(R.id.freshchat_activity_conversation_detail_content);
        this.bf = findViewById(R.id.freshchat_quick_reply_container);
        this.bi = findViewById(R.id.freshchat_drop_down_input_frame);
        this.ba = (RecyclerView) findViewById(R.id.freshchat_drop_down_recycler_view);
        this.bg = findViewById(R.id.freshchat_drop_down_recycler_view_container);
        this.bp = findViewById(R.id.freshchat_conversation_meeting_banner);
        this.bq = (TextView) findViewById(R.id.freshchat_meeting_banner_date_text);
    }

    private void c(Intent intent) {
        if (intent != null) {
            try {
                long longExtra = intent.getLongExtra("MARKETING_ID", -1);
                if (intent.getBooleanExtra("NOTIFICATION_CLICKED", false)) {
                    aa.h(getApplicationContext(), longExtra);
                }
            } catch (Exception e) {
                q.a(e);
            }
        }
    }

    private void c(final Uri uri, final int i) {
        az.a(getContext(), uri, az.b.TYPE_IMAGE, new az.a() {
            /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass17 */

            @Override // com.freshchat.consumer.sdk.j.az.a
            public void a(az.c cVar) {
                int i = u.op[cVar.ordinal()];
                i.a(ConversationDetailActivity.this.getContext(), i != 1 ? i != 2 ? com.freshchat.consumer.sdk.b.c.PICTURE_ATTACHMENT_INVALID_PARAMS_ERROR : com.freshchat.consumer.sdk.b.c.PICTURE_ATTACHMENT_UNKNOWN_TYPE_ERROR : com.freshchat.consumer.sdk.b.c.PICTURE_ATTACHMENT_NON_IMAGE_URI_ERROR);
            }

            @Override // com.freshchat.consumer.sdk.j.az.a
            public void fQ() {
                ConversationDetailActivity.this.a((ConversationDetailActivity) uri, (Uri) i);
            }
        });
    }

    private void c(View view) {
        runOnUiThread(new d(this, view));
    }

    private ConnectivityManager eB() {
        try {
            return (ConnectivityManager) getSystemService("connectivity");
        } catch (Exception e) {
            q.a(e);
            return null;
        }
    }

    private void f(String str) {
    }

    private void fS() {
        QuickReplyDropDownFragment A = this.lz.A(this.aM);
        if (A != null) {
            com.freshchat.consumer.sdk.k.g gVar = new com.freshchat.consumer.sdk.k.g(this);
            this.bj = gVar;
            gVar.a(A);
            List<MessageFragment> he = this.bj.he();
            if (!k.isEmpty(he)) {
                ap();
                setDropDownHeight(getResources().getConfiguration().orientation);
                gT();
                long E = this.lz.E(this.aM);
                this.lz.x(E);
                this.ba.setAdapter(new com.freshchat.consumer.sdk.a.e(this, he, this.bl, E));
            }
        }
    }

    private boolean fT() {
        return aw.fc() && com.freshchat.consumer.sdk.j.g.ah(getContext()) >= 24;
    }

    private void fU() {
        try {
            if (fT()) {
                this.hE = new q(this);
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                ConnectivityManager eB = eB();
                if (eB != null) {
                    eB.registerNetworkCallback(builder.build(), this.hE);
                }
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    private void fV() {
        ConnectivityManager eB;
        ConnectivityManager.NetworkCallback networkCallback;
        try {
            if (fT() && (eB = eB()) != null && (networkCallback = this.hE) != null) {
                eB.unregisterNetworkCallback(networkCallback);
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void g(String str) {
        try {
            if (!as.isEmpty(str)) {
                a(h(str));
                f("text");
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    private void gA() {
        boolean z;
        CollectionFragment B = this.lz.B(this.aM);
        if (B != null) {
            FlowLayout flowLayout = (FlowLayout) findViewById(R.id.freshchat_quick_reply_flowlayout);
            flowLayout.setRtl(p.aD(getContext()));
            flowLayout.removeAllViews();
            boolean z2 = false;
            if (k.a(B.getFragments())) {
                z = false;
                for (MessageFragment messageFragment : B.getFragments()) {
                    if (messageFragment instanceof QuickReplyButtonFragment) {
                        final com.freshchat.consumer.sdk.k.e eVar = new com.freshchat.consumer.sdk.k.e(this);
                        eVar.b((QuickReplyButtonFragment) messageFragment);
                        String jL = eVar.jL();
                        if (!as.isEmpty(jL)) {
                            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.freshchat_message_chip_text, (ViewGroup) null);
                            textView.setMaxLines(2);
                            textView.setEllipsize(TextUtils.TruncateAt.END);
                            textView.setText(jL);
                            flowLayout.addView(textView);
                            textView.setOnClickListener(new View.OnClickListener() {
                                /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass8 */

                                public void onClick(View view) {
                                    ConversationDetailActivity.this.g((ConversationDetailActivity) eVar.hb());
                                }
                            });
                            z2 = true;
                        }
                    } else if (messageFragment instanceof TextFragment) {
                        z = true;
                    }
                }
            } else {
                z = false;
            }
            if (z2) {
                this.bf.setVisibility(4);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bf.getLayoutParams();
                layoutParams.height = -2;
                this.bf.setLayoutParams(layoutParams);
                if (!z) {
                    ap();
                }
                an();
                TypedValue typedValue = new TypedValue();
                getResources().getValue(R.dimen.freshchat_quick_reply_view_max_height_percentage, typedValue, true);
                final float f = typedValue.getFloat() / 100.0f;
                this.bf.post(new Runnable() {
                    /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass9 */

                    public void run() {
                        float height = (float) ConversationDetailActivity.this.findViewById(R.id.freshchat_message_container).getHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ConversationDetailActivity.this.bf.getLayoutParams();
                        float f = f;
                        layoutParams.height = ((float) ConversationDetailActivity.this.bf.getHeight()) / height > f ? (int) (height * f) : -2;
                        ConversationDetailActivity.this.bf.setLayoutParams(layoutParams);
                        ConversationDetailActivity.this.gB();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gB() {
        i.b(this.bf);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void gC() {
        i.c(this.bf);
    }

    private void ga() {
        this.lz = new com.freshchat.consumer.sdk.k.c(getContext());
    }

    private void gb() {
        x();
    }

    private void gf() {
        this.aJ = (LinearLayoutManager) this.aB.getLayoutManager();
        ad();
        this.aB.setAdapter(I());
        this.aE.setOnClickListener(this.bc);
        X();
        this.aF.setOnClickListener(this.aX);
        this.aC.addTextChangedListener(this.aV);
        this.bi.setOnClickListener(new View.OnClickListener() {
            /* class com.freshchat.consumer.sdk.activity.ConversationDetailActivity.AnonymousClass1 */

            public void onClick(View view) {
                ConversationDetailActivity.this.gV();
            }
        });
        this.bg.setOnClickListener(this.bk);
        this.ba.setLayoutManager(new LinearLayoutManager(1, false));
        a(true);
        R();
        String string = G().getString("CONFIG_CONVERSATION_BANNER_MESSAGE");
        if (as.a(string)) {
            i.b(this.aG);
            View view = this.aG;
            if (view instanceof TextView) {
                ((TextView) view).setText(string);
                return;
            }
            return;
        }
        i.c(this.aG);
    }

    private RemoteConfig gg() {
        if (this.lg == null) {
            this.lg = ap.bD(getContext());
        }
        return this.lg;
    }

    private void gv() {
        f fVar = this.cT;
        if (fVar != null) {
            fVar.dismiss();
            this.cT = null;
        }
    }

    private Message h(String str) {
        Message a2 = com.freshchat.consumer.sdk.service.d.c.a(G().bj(), str, af(), this.channelId);
        a2.setConversationId(af());
        return a2;
    }

    /* access modifiers changed from: private */
    public void n(Message message) {
        CalendarMessageMeta x = this.lz.x(message);
        f a2 = f.a(this.orientation, x, this.lz.a(x, this.aN));
        this.cT = a2;
        a2.show(getSupportFragmentManager(), "CalendarBottomSheet");
    }

    private void p() {
        try {
            if (isTaskRoot()) {
                String bT = G().bT();
                if (as.a(bT)) {
                    aa.k(getContext(), bT);
                } else {
                    startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
                }
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    private void setDropDownHeight(int i) {
        Resources resources;
        int i2;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.freshchat_drop_down_item_height);
        if (this.bj != null) {
            if (i == 2) {
                resources = getResources();
                i2 = R.integer.freshchat_drop_down_max_display_items_landscape;
            } else {
                resources = getResources();
                i2 = R.integer.freshchat_drop_down_max_display_items_portrait;
            }
            int integer = resources.getInteger(i2);
            i.b(this.ba, this.lz.a(this.bj.hf(), integer, dimensionPixelSize));
        }
    }

    private void x() {
        int i = u.ld[this.lz.gq().ordinal()];
        if (i == 1) {
            i.b(this.le);
            i.c(this.lf);
        } else if (i == 2) {
            by.gN().d(getContext(), true);
            i.c(this.le);
            i.b(this.lf);
            if (this.bi.getVisibility() == 0) {
                this.lz.z(this.aM);
            }
        } else if (i == 3) {
            al();
        }
    }

    public void U() {
        Bundle bundle = new Bundle();
        bundle.putLong("CHANNEL_ID", this.channelId);
        getSupportLoaderManager().d(0, bundle, this.bb);
    }

    public void V() {
        Bundle bundle = new Bundle();
        bundle.putLong("CHANNEL_ID", this.channelId);
        bundle.putBoolean("EXTRA_FORCE_CLEAN_UP_EXPIRED_CSAT", true);
        getSupportLoaderManager().d(0, bundle, this.bh);
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public void a(Context context, Intent intent) {
        String action = intent.getAction();
        ag.a("FRESHCHAT", intent);
        if ("com.freshchat.consumer.sdk.actions.ExpectedConversationResponseTimeUpdated".equals(action)) {
            ae();
        } else if ("com.freshchat.consumer.sdk.actions.ChannelsUpdated".equals(action) || "com.freshchat.consumer.sdk.actions.MessagesUpdated".equals(action) || "com.freshchat.consumer.sdk.actions.MessageStatusChanged".equals(action)) {
            if (!"com.freshchat.consumer.sdk.actions.MessageStatusChanged".equals(action) || ag.d(intent, "CHANNEL_ID") != this.channelId || intent.getBooleanExtra("STATUS_SUCCESS", true)) {
                V();
                if (this.aC.hasFocus()) {
                    this.aC.requestFocus();
                } else {
                    this.aB.requestFocus();
                }
            } else {
                i.a(getContext(), R.string.freshchat_message_sending_failed);
            }
        } else if ("com.freshchat.consumer.sdk.actions.JwtIdTokenStateChanged".equalsIgnoreCase(action) || "com.freshchat.consumer.sdk.actions.RemoteConfigUpdated".equalsIgnoreCase(action) || ("com.freshchat.consumer.sdk.actions.JwtModeEnabledForAccount".equalsIgnoreCase(action) && ap.aZ(getContext()) && o.bB(getContext()))) {
            gb();
        }
    }

    public void a(CalendarMessageMeta calendarMessageMeta) {
        Message a2 = this.lz.a(calendarMessageMeta, af(), this.channelId);
        if (a2 != null) {
            a(a2);
            this.lz.B(a2);
        }
    }

    @Override // com.freshchat.consumer.sdk.j.ax
    public void a(h.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.er() == null) {
                    return;
                }
                if (!as.isEmpty(aVar.er().getAbsolutePath())) {
                    Message h = h("");
                    AudioFragment audioFragment = new AudioFragment();
                    audioFragment.setContent(aVar.er().getAbsolutePath());
                    audioFragment.setContentType("audio/mpeg3");
                    audioFragment.setDuration(aVar.es());
                    h.addMessageFragment(audioFragment);
                    i.a(getContext(), (View) this.aC);
                    a(h);
                    f("audio");
                }
            } catch (Exception e) {
                q.a(e);
            }
        }
    }

    @Override // com.freshchat.consumer.sdk.activity.b
    public String[] a() {
        return new String[]{"com.freshchat.consumer.sdk.actions.JwtModeEnabledForAccount", "com.freshchat.consumer.sdk.actions.MessagesUpdated", "com.freshchat.consumer.sdk.actions.ChannelsUpdated", "com.freshchat.consumer.sdk.actions.MessageStatusChanged", "com.freshchat.consumer.sdk.actions.ExpectedConversationResponseTimeUpdated", "com.freshchat.consumer.sdk.actions.JwtIdTokenStateChanged", "com.freshchat.consumer.sdk.actions.TokenWaitTimeout", "com.freshchat.consumer.sdk.actions.RemoteConfigUpdated"};
    }

    @Override // com.freshchat.consumer.sdk.j.ax
    public void am() {
        b(this.az);
    }

    @Override // com.freshchat.consumer.sdk.j.ax
    public void an() {
        c(this.az);
    }

    @Override // com.freshchat.consumer.sdk.j.ax
    public void ao() {
        gS();
        b(this.ay);
    }

    @Override // com.freshchat.consumer.sdk.j.ax
    public void ap() {
        c(this.ay);
        i.a(getContext(), this.ay);
    }

    @Override // com.freshchat.consumer.sdk.j.ax
    public void b(int i) {
        runOnUiThread(new f(this, i));
    }

    @Override // com.freshchat.consumer.sdk.m.f.a
    public void b(CalendarMessageMeta calendarMessageMeta) {
        a(calendarMessageMeta);
    }

    @Override // com.freshchat.consumer.sdk.m.f.a
    public void b(CalendarMessageMeta calendarMessageMeta, CalendarDay.TimeSlot timeSlot, int i) {
        a(calendarMessageMeta, timeSlot, i);
    }

    @Override // com.freshchat.consumer.sdk.j.ax
    public void c(int i) {
        runOnUiThread(new h(this, i));
    }

    public void gS() {
        gU();
        gW();
        this.bj = null;
    }

    public void gT() {
        i.b(this.bi);
    }

    public void gU() {
        i.c(this.bi);
    }

    public void gV() {
        i.b(this.bg);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.freshchat_slide_up);
        loadAnimation.setDuration(300);
        this.ba.startAnimation(loadAnimation);
        this.ba.setVisibility(0);
        this.ba.bringToFront();
    }

    public void gW() {
        i.c(this.bg);
        this.ba.setVisibility(8);
    }

    @Override // com.freshchat.consumer.sdk.j.ax
    public void i(String str) {
        runOnUiThread(new i(this, str));
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 125 && i2 == -1) {
            ai.d(TAG, "onActivityResult::REQUEST_CODE_GALLERY");
            try {
                c(intent.getData(), i);
            } catch (Exception e) {
                q.a(e);
            }
        } else if (i == 126 && i2 == -1) {
            String str = TAG;
            ai.d(str, "onActivityResult::REQUEST_CODE_CAMERA");
            if (this.aR != null) {
                ai.d(str, "Found Pic From Camera : " + this.aR);
                a(Uri.parse(this.aR), i);
                this.aR = null;
            }
        } else if (i == 127 && i2 == -1) {
            this.aC.setText("");
            PictureAttachmentActivity.a aVar = new PictureAttachmentActivity.a();
            aVar.d(intent);
            a(aVar.aK(), aVar.getWidth(), aVar.getHeight(), aVar.aL());
        } else {
            String str2 = TAG;
            ai.d(str2, "onActivityResult::Request Code " + i + ", Result: " + i2);
        }
    }

    @Override // androidx.activity.ComponentActivity, com.freshchat.consumer.sdk.activity.b, com.freshchat.consumer.sdk.activity.a
    public void onBackPressed() {
        if (i.f(this.ba)) {
            gW();
            return;
        }
        W();
        p();
        super.onBackPressed();
    }

    @Override // defpackage.f0, defpackage.ve
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setDropDownHeight(configuration.orientation);
        this.orientation = configuration.orientation;
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4, defpackage.ve, com.freshchat.consumer.sdk.activity.a
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b.M(getContext());
        ga();
        b(getIntent());
        setContentView(R.layout.freshchat_activity_conversation_detail);
        e(as.isEmpty(this.aK) ? "Support" : this.aK);
        C();
        this.orientation = getResources().getConfiguration().orientation;
        c();
        gf();
        bg.a(getContext(), this.channelId, this.lE);
        fU();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.freshchat_conversation_detail, menu);
        MenuItem findItem = menu.findItem(R.id.freshchat_menu_item_toggle_speakerphone);
        if (G().bn()) {
            a(findItem, false);
            return true;
        }
        findItem.setVisible(false);
        return true;
    }

    @Override // defpackage.f0, defpackage.ve
    public void onDestroy() {
        super.onDestroy();
        ai.d(TAG, "Feedback activity is being destroyed");
        fV();
    }

    @Override // com.freshchat.consumer.sdk.activity.a
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.freshchat_menu_item_toggle_speakerphone) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (G().bo()) {
            G().h(false);
        } else {
            G().h(true);
        }
        a(menuItem, true);
        return true;
    }

    @Override // defpackage.ve, com.freshchat.consumer.sdk.activity.b
    public void onPause() {
        super.onPause();
        aS = 0;
        ak();
        try {
            if (ax()) {
                this.aU.cancel();
            }
            gv();
            L();
        } catch (Exception e) {
            q.a(e);
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.t4.b, defpackage.ve
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        String str;
        int i2;
        if (i == 100) {
            str = TAG;
            ai.i(str, "Received response for audio recording permission request.");
            if (am.a(iArr)) {
                ai.i(str, getString(R.string.freshchat_chat_voice_messaging_permissions_granted));
                S();
                return;
            }
            i2 = R.string.freshchat_chat_voice_messaging_permissions_not_granted;
        } else if (i != 101) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            return;
        } else if (am.a(iArr)) {
            ai.i(TAG, getString(R.string.freshchat_chat_camera_permissions_granted));
            aa();
            return;
        } else {
            str = TAG;
            i2 = R.string.freshchat_chat_camera_permissions_not_granted;
        }
        ai.d(this, str, getString(i2));
    }

    @Override // defpackage.ve, com.freshchat.consumer.sdk.activity.b, com.freshchat.consumer.sdk.activity.a
    public void onResume() {
        super.onResume();
        aS = this.channelId;
        try {
            b.a(getApplicationContext(), b.a.NORMAL);
            com.freshchat.consumer.sdk.j.b.a(getApplicationContext(), 4, d.a.NORMAL);
            com.freshchat.consumer.sdk.j.b.V(getApplicationContext());
            com.freshchat.consumer.sdk.j.b.L(getContext());
            com.freshchat.consumer.sdk.h.b.a(getContext(), this.channelId, 0);
        } catch (Exception e) {
            q.a(e);
        }
        gb();
        V();
    }

    @Override // defpackage.f0, defpackage.ve
    public void onStop() {
        super.onStop();
        ai.d(TAG, "Conversation Detail activity is being stopped");
    }
}
