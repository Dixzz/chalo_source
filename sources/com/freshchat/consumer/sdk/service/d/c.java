package com.freshchat.consumer.sdk.service.d;

import android.content.Context;
import android.text.Html;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.fragment.ButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.beans.fragment.CarouselFragment;
import com.freshchat.consumer.sdk.beans.fragment.CollectionFragment;
import com.freshchat.consumer.sdk.beans.fragment.FragmentType;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyDropDownFragment;
import com.freshchat.consumer.sdk.beans.fragment.SectionKey;
import com.freshchat.consumer.sdk.beans.fragment.TextFragment;
import com.freshchat.consumer.sdk.beans.fragment.UnknownFragment;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.cg;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.cv;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.k.e;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class c {
    public static Message a(String str, MessageFragment messageFragment, long j, long j2) {
        return a(str, messageFragment, Message.MessageType.MESSAGE_TYPE_NORMAL, j, j2, -1);
    }

    private static Message a(String str, MessageFragment messageFragment, long j, long j2, Message.ReplyTo replyTo, Message.MessageType messageType) {
        String str2;
        StringBuilder sb;
        long fE = com.freshchat.consumer.sdk.j.b.c.fE();
        if (as.isEmpty(str)) {
            sb = new StringBuilder();
            str2 = "user_";
        } else {
            sb = hj1.i0(str);
            str2 = "_";
        }
        sb.append(str2);
        sb.append(Long.toString(fE));
        String sb2 = sb.toString();
        Message message = new Message();
        message.setAlias(sb2);
        message.setConversationId(j);
        message.setMessageUserAlias(str);
        message.setChannelId(j2);
        message.setMessageType(messageType.getIntValue());
        if (messageFragment != null) {
            message.addMessageFragment(messageFragment);
        }
        if (replyTo != null) {
            message.setReplyTo(replyTo);
        }
        message.setRead(true);
        message.setCreatedMillis(fE);
        return message;
    }

    public static Message a(String str, MessageFragment messageFragment, Message.MessageType messageType, long j, long j2, long j3) {
        Message.ReplyTo replyTo;
        if (j3 > 0) {
            replyTo = new Message.ReplyTo();
            replyTo.setOriginalMessageId(j3);
        } else {
            replyTo = null;
        }
        return a(str, messageFragment, j, j2, replyTo, messageType);
    }

    public static Message a(String str, String str2, long j, long j2) {
        TextFragment textFragment;
        if (as.a(str2)) {
            textFragment = new TextFragment();
            textFragment.setContent(str2);
            textFragment.setContentType("text/html");
        } else {
            textFragment = null;
        }
        return a(str, textFragment, j, j2);
    }

    public static String a(Context context, Message message, boolean z) {
        String a2;
        boolean h = z ? cv.h(context, message) : false;
        List<MessageFragment> messageFragments = message.getMessageFragments();
        StringBuilder sb = new StringBuilder();
        if (k.a(messageFragments)) {
            for (MessageFragment messageFragment : messageFragments) {
                if (messageFragment.getFragmentType() == FragmentType.TEXT.asInt()) {
                    String a3 = cv.a(messageFragment, h, z);
                    if (as.a(a3)) {
                        a2 = Html.fromHtml(a3).toString();
                    }
                } else if (messageFragment.getFragmentType() == FragmentType.TEMPLATE.asInt()) {
                    if (messageFragment instanceof CarouselCardDefaultFragment) {
                        a2 = cg.a((CarouselCardDefaultFragment) messageFragment, SectionKey.CAROUSEL_CARD_TITLE);
                        if (!as.a(a2)) {
                        }
                    }
                } else if (!(messageFragment.getFragmentType() == FragmentType.BUTTON.asInt() || messageFragment.getFragmentType() == FragmentType.IMAGE.asInt() || messageFragment.getFragmentType() == FragmentType.AUDIO.asInt())) {
                    messageFragment.getFragmentType();
                    FragmentType.VIDEO.asInt();
                }
                sb.append(a2);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static Message b(JSONObject jSONObject) {
        return (Message) new ab().fromJson(jSONObject.toString(), Message.class);
    }

    public static String f(Context context, Message message) {
        boolean z;
        boolean z2;
        String str = "";
        if (message == null) {
            return str;
        }
        boolean u = cm.u(message);
        List<MessageFragment> replyFragments = message.getReplyFragments();
        List<MessageFragment> messageFragments = message.getMessageFragments();
        if (k.a(replyFragments)) {
            z = false;
            for (MessageFragment messageFragment : replyFragments) {
                if (messageFragment instanceof QuickReplyDropDownFragment) {
                    if (!message.isUserMessage()) {
                        z = true;
                    }
                } else if (messageFragment instanceof CarouselFragment) {
                    StringBuilder i0 = hj1.i0("&#128280; ");
                    i0.append(context.getString(R.string.freshchat_carousel_default_preview_text));
                    return i0.toString();
                }
            }
        } else {
            z = false;
        }
        boolean h = cv.h(context, message);
        if (!k.a(messageFragments)) {
            return str;
        }
        Iterator<MessageFragment> it = messageFragments.iterator();
        String str2 = null;
        String str3 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            MessageFragment next = it.next();
            if (!(next instanceof UnknownFragment)) {
                if (next.getFragmentType() != FragmentType.TEXT.asInt()) {
                    if (next.getFragmentType() == FragmentType.IMAGE.asInt()) {
                        z3 = true;
                    } else if (next.getFragmentType() == FragmentType.AUDIO.asInt()) {
                        z4 = true;
                    } else if (next.getFragmentType() == FragmentType.VIDEO.asInt()) {
                        z5 = true;
                    } else if (next.getFragmentType() != FragmentType.BUTTON.asInt()) {
                        if (next.getFragmentType() == FragmentType.COLLECTION.asInt()) {
                            CollectionFragment collectionFragment = (CollectionFragment) next;
                            if (k.a(collectionFragment.getFragments())) {
                                Iterator<MessageFragment> it2 = collectionFragment.getFragments().iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        if (!(it2.next() instanceof QuickReplyButtonFragment)) {
                                            break;
                                        }
                                    } else {
                                        z2 = true;
                                        break;
                                    }
                                }
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                            }
                        } else if (next.getFragmentType() != FragmentType.QUICK_REPLY_BUTTON.asInt()) {
                            if (next.getFragmentType() != FragmentType.TEMPLATE.asInt()) {
                                if (next.getFragmentType() == FragmentType.CALENDAR_EVENT.asInt() && message.isUserMessage()) {
                                    str2 = context.getString(R.string.freshchat_calendar_invite_awaiting_confirmation);
                                    break;
                                }
                            } else if (next instanceof CarouselCardDefaultFragment) {
                                str2 = cg.a((CarouselCardDefaultFragment) next, SectionKey.CAROUSEL_CARD_TITLE);
                            }
                        } else if (next instanceof QuickReplyButtonFragment) {
                            e eVar = new e(context);
                            eVar.b((QuickReplyButtonFragment) next);
                            str2 = eVar.hb();
                        }
                    } else if (as.isEmpty(str3)) {
                        str3 = as.b(((ButtonFragment) next).getLabel(), 40);
                    }
                } else if (as.isEmpty(str2)) {
                    str2 = as.b(cv.a(next, h, true), 100);
                }
            }
            z6 = true;
        }
        if (u) {
            str = "&#128197; ";
        }
        if (z3) {
            str = hj1.S(str, "&#128247; ");
        }
        if (z4) {
            str = hj1.S(str, "&#127908; Voice Message ");
        }
        if (z5) {
            str = hj1.S(str, "&#127909; ");
        }
        if (z) {
            str = hj1.S(str, "&#128315; ");
        }
        if (as.a(str3)) {
            str = hj1.S(str, str3);
        }
        if (as.a(str2)) {
            str = hj1.S(str, str2);
        }
        return (!as.isEmpty(str) || !z6) ? str : hj1.S(str, "&#10071;");
    }

    public static boolean i(Message message) {
        return (message == null || message.getAlias() == null || !message.getAlias().endsWith("_welcome_message")) ? false : true;
    }
}
