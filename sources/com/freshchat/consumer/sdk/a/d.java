package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.beans.fragment.FragmentType;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.UnknownFragment;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ak;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.cf;
import com.freshchat.consumer.sdk.j.cj;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.cv;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.n;
import com.freshchat.consumer.sdk.j.p;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.k.l;
import com.freshchat.consumer.sdk.ui.CalendarEventCardView;
import com.freshchat.consumer.sdk.ui.CarouselCardView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d extends RecyclerView.e<RecyclerView.a0> {
    public static final String TAG = "com.freshchat.consumer.sdk.a.d";
    private final List<Message> aM;
    private final Map<String, Participant> aN;
    private CarouselCardView.a bn;
    private f bo;
    private final Drawable cA;
    private final Drawable cB;
    private final int cC;
    private final String cD;
    private final String cE;
    private final String cF;
    private final int cK;
    private final com.freshchat.consumer.sdk.b.e cL;
    private final int cM;
    private final int cN;
    private final boolean cO;
    private final HashMap<String, com.freshchat.consumer.sdk.i.c> cP = new HashMap<>();
    private final cj.a cX;
    private final Context context;
    private final LayoutInflater cr;
    private final ak cy;
    private final Drawable cz;
    private Boolean fM;
    private final c lZ;
    private boolean ma;
    private final int mb = cf.a.CAROUSEL.asInt();
    private final int mc = cf.a.CAROUSEL_CARD.asInt();
    private final g oq;
    private final int or = cf.a.CALENDAR_EVENT.asInt();
    private Set<Long> pU = new HashSet();
    private int pV;
    private final float qy;
    private final float qz;

    public static class a extends RecyclerView.a0 {
        private final ImageView nF;
        private final CalendarEventCardView ou;
        private final TextView ov;

        public a(View view) {
            super(view);
            this.ou = (CalendarEventCardView) view.findViewById(R.id.freshchat_calendar_event);
            this.ov = (TextView) view.findViewById(R.id.freshchat_message_time);
            this.nF = (ImageView) view.findViewById(R.id.freshchat_message_upload_status);
        }

        public void a(l lVar) {
            this.ou.setCalendarTimeSlotMessageViewModel(lVar);
        }

        public ImageView hk() {
            return this.nF;
        }

        public TextView hv() {
            return this.ov;
        }
    }

    public static class b extends RecyclerView.a0 {
        private final CarouselCardView mW;
        private final TextView no;

        public b(View view) {
            super(view);
            this.mW = (CarouselCardView) view.findViewById(R.id.freshchat_carousel_card);
            this.no = (TextView) view.findViewById(R.id.freshchat_message_time);
        }

        public CarouselCardView aZ() {
            return this.mW;
        }

        public TextView ba() {
            return this.no;
        }
    }

    public static class c extends RecyclerView.l {
        private final int np;

        public c(int i) {
            this.np = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.x xVar) {
            super.getItemOffsets(rect, view, recyclerView, xVar);
            if (rect != null) {
                rect.right = this.np;
            }
        }
    }

    /* renamed from: com.freshchat.consumer.sdk.a.d$d  reason: collision with other inner class name */
    public static class C0009d extends e {
        private final RecyclerView cG;

        public C0009d(View view) {
            super(view);
            this.cG = (RecyclerView) view.findViewById(R.id.freshchat_message_carousel_recycler_view);
        }

        public RecyclerView ay() {
            return this.cG;
        }
    }

    public static class e extends RecyclerView.a0 {
        private final RelativeLayout nA;
        private final LinearLayout nB;
        private final ImageView nC;
        private final TextView nD;
        private final TextView nE;
        private final ImageView nF;
        private final RelativeLayout nz;
        private final LinearLayout qB;
        private final View qC;
        private final View qD;

        public e(View view) {
            super(view);
            this.nz = (RelativeLayout) view.findViewById(R.id.freshchat_message_root);
            this.nA = (RelativeLayout) view.findViewById(R.id.freshchat_message_content_wrapper);
            int i = R.id.freshchat_message_fragment_wrapper;
            this.nB = (LinearLayout) view.findViewById(i);
            this.nC = (ImageView) view.findViewById(R.id.freshchat_message_avatar);
            this.nD = (TextView) view.findViewById(R.id.freshchat_message_user_name);
            this.nE = (TextView) view.findViewById(R.id.freshchat_message_time);
            this.nF = (ImageView) view.findViewById(R.id.freshchat_message_upload_status);
            this.qC = view.findViewById(R.id.freshchat_show_original_content_btn);
            View findViewById = view.findViewById(R.id.freshchat_original_message_container);
            this.qD = findViewById;
            this.qB = (LinearLayout) findViewById.findViewById(i);
        }

        public RelativeLayout bc() {
            return this.nz;
        }

        public RelativeLayout bd() {
            return this.nA;
        }

        public LinearLayout hg() {
            return this.nB;
        }

        public ImageView hh() {
            return this.nC;
        }

        public TextView hi() {
            return this.nD;
        }

        public TextView hj() {
            return this.nE;
        }

        public ImageView hk() {
            return this.nF;
        }

        public LinearLayout ip() {
            return this.qB;
        }

        public View iq() {
            return this.qC;
        }

        public View ir() {
            return this.qD;
        }
    }

    public interface f {
        void f(Message message);
    }

    public interface g {
        void a(Message message, boolean z);
    }

    public class h implements View.OnLongClickListener {
        private final Message gz;
        private final g oq;
        private final boolean qE;

        public h(Message message, g gVar, boolean z) {
            this.qE = z;
            this.gz = message;
            this.oq = gVar;
        }

        public boolean onLongClick(View view) {
            g gVar = this.oq;
            if (gVar == null) {
                return false;
            }
            gVar.a(this.gz, this.qE);
            return true;
        }
    }

    public d(Context context2, List<Message> list, Map<String, Participant> map, g gVar, cj.a aVar) {
        this.context = context2;
        this.aM = list;
        this.cr = LayoutInflater.from(context2);
        com.freshchat.consumer.sdk.b.e i = com.freshchat.consumer.sdk.b.e.i(context2.getApplicationContext());
        this.cL = i;
        this.cy = new ak(context2);
        this.aN = map;
        this.cO = i.isTeamMemberInfoVisible();
        this.cC = aq.a(context2, R.attr.freshchatTeamMemberAvatarIcon, false);
        this.cB = com.freshchat.consumer.sdk.j.g.Q(context2);
        this.lZ = new c(context2.getResources().getDimensionPixelSize(R.dimen.freshchat_category_icon_padding));
        this.pV = context2.getResources().getDimensionPixelSize(R.dimen.freshchat_translation_toggle_btn_dimension);
        this.cM = aq.j(context2, R.attr.freshchatChatBubbleLeft);
        this.cN = aq.j(context2, R.attr.freshchatChatBubbleRight);
        this.cK = (int) (((float) p.ar(context2)) * 0.2f);
        Resources resources = context2.getResources();
        this.cA = resources.getDrawable(R.drawable.freshchat_ic_message_status_sent);
        this.cz = resources.getDrawable(R.drawable.freshchat_ic_message_status_pending);
        this.cD = e(context2);
        this.cF = resources.getString(R.string.freshchat_chat_deeplink);
        this.cE = resources.getString(R.string.freshchat_chat_deeplink_faq);
        this.oq = gVar;
        this.cX = aVar;
        this.qy = (float) aq.o(context2, R.dimen.freshchat_message_view_line_spacing_extra);
        this.qz = aq.a(resources, R.dimen.freshchat_message_view_line_spacing_multiplier).getFloat();
    }

    private void a(Context context2, TextView textView, long j) {
        int i;
        if (context2 != null && textView != null) {
            if (j > 100) {
                textView.setText(n.i(context2, j));
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
        }
    }

    /* access modifiers changed from: private */
    public void a(View view, boolean z) {
        Context context2;
        int i;
        if (z) {
            context2 = this.context;
            i = R.string.freshchat_content_description_hide_original_content;
        } else {
            context2 = this.context;
            i = R.string.freshchat_content_description_show_original_content;
        }
        view.setContentDescription(context2.getString(i));
    }

    private void a(LinearLayout linearLayout, List<MessageFragment> list, boolean z, boolean z2, boolean z3) {
        linearLayout.removeAllViews();
        if (!k.isEmpty(list)) {
            for (MessageFragment messageFragment : list) {
                View a2 = this.cy.a(linearLayout, messageFragment, z, z3, z2);
                if (a2 != null) {
                    a(z2, messageFragment, a2);
                    linearLayout.addView(a2);
                }
            }
        }
    }

    private void a(e eVar) {
        if (this.fM == null) {
            this.fM = Boolean.valueOf(eVar.hh().getVisibility() == 0);
        }
    }

    private void a(e eVar, Message message) {
        boolean z;
        boolean isUserMessage = message.isUserMessage();
        boolean z2 = true;
        if (isUserMessage) {
            eVar.bc().setHorizontalGravity(8388613);
            Drawable drawable = aq.getDrawable(this.context, this.cN);
            if (drawable != null) {
                eVar.bd().setBackground(drawable);
            }
            eVar.hh().setVisibility(8);
            eVar.hi().setVisibility(8);
            eVar.hk().setVisibility(0);
            eVar.hk().setImageDrawable(g(message.getUploadState()));
            i.c(eVar.iq());
            i.a(this.context, eVar.bc(), this.cK, 0);
            i.a(this.context, eVar.hj(), R.attr.freshchatUserMessageTimeTextStyle);
            z = false;
        } else {
            boolean h2 = cv.h(this.context, message);
            eVar.bc().setHorizontalGravity(8388611);
            Drawable drawable2 = aq.getDrawable(this.context, this.cM);
            if (drawable2 != null) {
                eVar.bd().setBackground(drawable2);
            }
            Participant n = n(message.getMessageUserAlias());
            a(eVar, n);
            String firstName = (!this.cO || n == null || !as.a(n.getFirstName())) ? this.cD : n.getFirstName();
            if (as.a(firstName)) {
                eVar.hi().setVisibility(0);
                eVar.hi().setText(firstName);
            } else {
                eVar.hi().setVisibility(8);
            }
            eVar.hk().setVisibility(8);
            i.a(this.context, eVar.bc(), 0, this.cK);
            i.a(this.context, eVar.hj(), R.attr.freshchatTeamMemberMessageTimeTextStyle);
            a(eVar, message, h2);
            a(eVar.iq(), eVar.ir().getVisibility() == 0);
            z = h2;
        }
        List<MessageFragment> messageFragments = message.getMessageFragments();
        i.c(eVar.ir());
        eVar.hj().setVisibility(0);
        a(eVar.hg(), messageFragments, z, isUserMessage, true);
        if (this.pU.contains(Long.valueOf(message.getId()))) {
            a(eVar, message.getMessageFragments(), z);
        }
        View iq = eVar.iq();
        if (eVar.ir().getVisibility() != 0) {
            z2 = false;
        }
        a(iq, z2);
        a(message, eVar.hg());
        a(this.context, eVar.hj(), message.getCreatedMillis());
        b(eVar, message);
    }

    private void a(e eVar, Message message, boolean z) {
        View iq = eVar.iq();
        if (!z) {
            i.c(iq);
            return;
        }
        i.b(iq);
        if (this.pV == 0) {
            iq.post(new h(this, iq, eVar));
        } else {
            i.a(this.context, eVar.bc(), 0, this.cK - this.pV);
        }
        iq.setOnClickListener(new p(this, eVar, message, z, iq));
    }

    private void a(e eVar, Participant participant) {
        try {
            ImageView hh = eVar.hh();
            Boolean bool = this.fM;
            if (bool == null || !bool.booleanValue()) {
                hh.setVisibility(8);
                return;
            }
            hh.setVisibility(0);
            if (!this.cO || participant == null || !as.a(participant.getProfilePicUrl())) {
                int i = this.cC;
                if (i > 0) {
                    hh.setImageResource(i);
                    return;
                }
                Drawable drawable = this.cB;
                if (drawable != null) {
                    hh.setImageDrawable(drawable);
                    return;
                }
                return;
            }
            FreshchatImageLoaderRequest dM = new FreshchatImageLoaderRequest.a(participant.getProfilePicUrl()).a(hh.getWidth(), hh.getHeight()).a(FreshchatImageLoaderRequest.TransformType.CIRCULAR).dM();
            FreshchatImageLoader eK = af.eK();
            if (eK != null) {
                eK.load(dM, hh);
            }
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    /* access modifiers changed from: private */
    public void a(e eVar, List<MessageFragment> list, boolean z) {
        a(eVar.ip(), list, z, false, false);
        i.b(eVar.ir());
    }

    private void a(Message message, LinearLayout linearLayout) {
        Message.MessageType messageTypeFromIntValue = Message.MessageType.getMessageTypeFromIntValue(message.getMessageType());
        if (!message.isResponded() && cm.u(message)) {
            linearLayout.addView(cj.a(this.context, linearLayout, message, this.cX));
        } else if (messageTypeFromIntValue == Message.MessageType.MESSAGE_TYPE_CALENDER_INVITE_CANCELLED_BY_USER) {
            TextView textView = (TextView) linearLayout.findViewById(R.id.freshchat_text);
            textView.setCompoundDrawablesWithIntrinsicBounds(this.context.getResources().getDrawable(aq.j(this.context, R.attr.freshchatCalendarCancelInviteIcon)), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setCompoundDrawablePadding(aq.o(this.context, R.dimen.freshchat_calendar_cancel_invite_icon_padding));
        }
    }

    private void a(boolean z, MessageFragment messageFragment, View view) {
        TextView textView;
        int i;
        if (messageFragment.getFragmentType() == FragmentType.TEXT.asInt() || messageFragment.getFragmentType() == FragmentType.QUICK_REPLY_BUTTON.asInt()) {
            textView = (TextView) view.findViewById(R.id.freshchat_text);
            i = z ? R.attr.freshchatUserMessageTextStyle : R.attr.freshchatTeamMemberMessageTextStyle;
        } else if (messageFragment instanceof UnknownFragment) {
            textView = (TextView) view.findViewById(R.id.freshchat_unknown_fragment_text);
            i = z ? R.attr.freshchatUnsupportedUserMessageTextStyle : R.attr.freshchatUnsupportedTeamMemberMessageTextStyle;
        } else {
            textView = null;
            i = 0;
        }
        if (textView != null) {
            i.a(this.context, textView, i);
        }
    }

    private void b(e eVar, Message message) {
        h hVar = new h(message, this.oq, true);
        eVar.bc().setOnLongClickListener(hVar);
        eVar.hg().setOnLongClickListener(hVar);
    }

    private String e(Context context2) {
        return context2.getString(R.string.freshchat_default_agent_name);
    }

    private Message f(int i) {
        List<Message> list = this.aM;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.aM.get(i);
    }

    private Drawable g(int i) {
        return i == 1 ? this.cA : this.cz;
    }

    private Participant n(String str) {
        if (!as.a(str) || !k.d(this.aN)) {
            return null;
        }
        return this.aN.get(str);
    }

    public void a(f fVar) {
        this.bo = fVar;
    }

    public void a(CarouselCardView.a aVar) {
        this.bn = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return k.b(this.aM);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemViewType(int i) {
        Message f2 = f(i);
        boolean z = true;
        if (i != getItemCount() - 1) {
            z = false;
        }
        return cf.a(f2, z, this.ma).asInt();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        Context context2;
        TextView hv;
        long createdMillis;
        e eVar;
        try {
            Message message = this.aM.get(i);
            if (a0Var instanceof C0009d) {
                C0009d dVar = (C0009d) a0Var;
                List<MessageFragment> k = cf.k(message);
                if (k.a(k)) {
                    dVar.ay().setAdapter(new g(this.context, k, this.bn));
                }
                f fVar = this.bo;
                if (fVar != null) {
                    fVar.f(message);
                }
                eVar = (e) a0Var;
            } else if (a0Var instanceof e) {
                eVar = (e) a0Var;
            } else {
                if (a0Var instanceof b) {
                    b bVar = (b) a0Var;
                    CarouselCardDefaultFragment m = cf.m(message);
                    if (m != null) {
                        m.setSelected(true);
                        bVar.aZ().setData(m);
                        bVar.aZ().setUploadedStateDrawable(g(message.getUploadState()));
                    }
                    context2 = this.context;
                    hv = bVar.ba();
                    createdMillis = message.getCreatedMillis();
                } else if (a0Var instanceof a) {
                    a aVar = (a) a0Var;
                    CalendarEventFragment s = cm.s(message);
                    if (s != null) {
                        l lVar = new l(this.context);
                        lVar.b(s);
                        lVar.y(message.isUploaded());
                        lVar.br(cm.a(this.aN, message));
                        aVar.a(lVar);
                    }
                    aVar.hk().setImageDrawable(g(message.getUploadState()));
                    context2 = this.context;
                    hv = aVar.hv();
                    createdMillis = message.getCreatedMillis();
                } else {
                    return;
                }
                a(context2, hv, createdMillis);
                return;
            }
            a(eVar, message);
        } catch (Exception e2) {
            q.a(e2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == this.mb) {
            C0009d dVar = new C0009d(LayoutInflater.from(this.context).inflate(R.layout.freshchat_listitem_carousel, viewGroup, false));
            dVar.ay().setLayoutManager(new LinearLayoutManager(0, false));
            dVar.ay().f(this.lZ);
            a(dVar);
            return dVar;
        } else if (i == this.mc) {
            return new b(this.cr.inflate(R.layout.freshchat_listitem_carousel_card, viewGroup, false));
        } else {
            if (i == this.or) {
                return new a(this.cr.inflate(R.layout.freshchat_list_item_calendar_event, viewGroup, false));
            }
            e eVar = new e(LayoutInflater.from(this.context).inflate(R.layout.freshchat_listitem_message, viewGroup, false));
            a(eVar);
            return eVar;
        }
    }

    public void x(boolean z) {
        this.ma = z;
    }
}
