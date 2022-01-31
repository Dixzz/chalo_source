package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import android.os.Bundle;
import android.webkit.URLUtil;
import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.b.a;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.User;
import com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment;
import com.freshchat.consumer.sdk.beans.fragment.FragmentType;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.reqres.UploadImageResponse;
import com.freshchat.consumer.sdk.c.f;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aj;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.a.c;
import com.freshchat.consumer.sdk.service.e.d;
import com.freshchat.consumer.sdk.service.e.q;
import com.freshchat.consumer.sdk.service.e.r;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class p extends a<q, r> {
    private void a(long j, String str) {
        Bundle bundle = new Bundle();
        bundle.putLong("CHANNEL_ID", j);
        bundle.putString("MESSAGE_ALIAS", str);
        a.a(getContext(), "com.freshchat.consumer.sdk.actions.MessageStatusChanged", bundle);
    }

    private void a(Message message, Message message2, String str) {
        CalendarEventFragment s = cm.s(message2);
        if (s != null) {
            message.getMessageFragments().set(0, s);
            if (!as.a(str)) {
                return;
            }
            if (cm.a(s)) {
                bg.M(getContext(), str);
            } else if (cm.y(message2)) {
                bg.N(getContext(), str);
            } else {
                bg.O(getContext(), str);
            }
        }
    }

    private r.a b(q qVar) {
        if (!c(qVar)) {
            return r.a.Failed;
        }
        Context context = getContext();
        Message dL = qVar.dL();
        e i = e.i(context);
        if (!i.bl()) {
            ai.w("FRESHCHAT", "Cannot proceed because the user was not created. Backlog created for message");
            b.a(context, (User) null, true);
            c.d(getContext(), dL);
            return r.a.UserNotCreated;
        } else if (!al.aS(context)) {
            c.d(getContext(), dL);
            return r.a.NoInternet;
        } else if (c(getContext(), dL)) {
            g(dL);
            return r.a.Failed;
        } else if (e(dL)) {
            return r.a.Failed;
        } else {
            g gVar = new g(context);
            try {
                dL.setRead(true);
                Message h = h(dL);
                if (as.isEmpty(h.getMessageUserAlias())) {
                    h.setMessageUserAlias(i.bj());
                }
                Message d = new com.freshchat.consumer.sdk.e.a(context).d(h);
                ai.d("FRESHCHAT", "Message created " + d.getAlias());
                h.setUploadState(1);
                h.setCreatedMillis(d.getCreatedMillis());
                h.setReplyTo(d.getReplyTo());
                h.setId(d.getId());
                String t = cm.t(h);
                h.setInternalMeta(d.getInternalMeta());
                a(h, d, t);
                gVar.b(h);
                if (h.getConversationId() == 0) {
                    aa.a(context, h.getChannelId(), d.getConversationId(), 7, d.a.IMMEDIATE, false);
                }
                fO();
                ai.d("FRESHCHAT", "Saved conversation to DB " + d.getConversationId());
                return r.a.Success;
            } catch (DeletedException e) {
                com.freshchat.consumer.sdk.j.q.a(e);
                return r.a.Failed;
            } catch (Exception e2) {
                a(dL.getChannelId(), dL.getAlias());
                com.freshchat.consumer.sdk.j.q.a(e2);
                c.d(getContext(), dL);
                ai.d("FRESHCHAT", "Failed to send message !");
                return r.a.Failed;
            }
        }
    }

    private static boolean c(Context context, Message message) {
        Message X;
        InputStream inputStream = null;
        try {
            List<MessageFragment> messageFragments = message.getMessageFragments();
            int b = k.b(messageFragments);
            for (int i = 0; i < b; i++) {
                MessageFragment messageFragment = messageFragments.get(i);
                if (aj.a(messageFragment)) {
                    String content = messageFragment.getContent();
                    if (as.a(content)) {
                        inputStream = ad.aE(content);
                    }
                    if (inputStream == null) {
                        ad.a(inputStream);
                        return true;
                    }
                    ad.a(inputStream);
                }
            }
            String alias = message.getAlias();
            boolean z = c.f(context, alias) && (X = new g(context).X(alias)) != null && X.isUploaded();
            ad.a(inputStream);
            return z;
        } catch (Exception e) {
            com.freshchat.consumer.sdk.j.q.a(e);
            ad.a(null);
            return false;
        } catch (Throwable th) {
            ad.a(null);
            throw th;
        }
    }

    private boolean e(Message message) {
        boolean z = false;
        if (!o.bB(getContext())) {
            return false;
        }
        if (o.bz(getContext()) != JwtTokenStatus.TOKEN_VALID) {
            z = true;
        }
        if (z) {
            c.d(getContext(), message);
        }
        return z;
    }

    private void fO() {
        a.f(getContext());
    }

    private void g(Message message) {
        StringBuilder i0 = hj1.i0("Deleting backlog ");
        i0.append(message.getAlias());
        ai.d("FRESHCHAT", i0.toString());
        aa.l(getContext(), message.getAlias());
    }

    private Message h(Message message) throws DeletedException {
        f fVar = new f(getContext());
        ArrayList arrayList = new ArrayList(message.getMessageFragments());
        int b = k.b(arrayList);
        for (int i = 0; i < b; i++) {
            MessageFragment messageFragment = (MessageFragment) arrayList.get(i);
            boolean isNetworkUrl = URLUtil.isNetworkUrl(messageFragment.getContent());
            if (aj.a(messageFragment) && !isNetworkUrl) {
                if (messageFragment.getFragmentType() != FragmentType.AUDIO.asInt() && messageFragment.getFragmentType() == FragmentType.IMAGE.asInt()) {
                    UploadImageResponse a2 = new com.freshchat.consumer.sdk.e.a(getContext()).a(messageFragment, i);
                    fVar.b(a2.getImage(), message.getAlias(), i, 1);
                    messageFragment = a2.getImage();
                }
                arrayList.set(i, messageFragment);
            }
        }
        message.setMessageFragments(arrayList);
        return message;
    }

    /* renamed from: a */
    public r b(q qVar) {
        r.a b = b(qVar);
        return new r(b == r.a.Success, b);
    }

    public boolean c(q qVar) {
        return w.ay(getContext()) && w.aA(getContext());
    }
}
