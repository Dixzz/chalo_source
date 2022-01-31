package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.activity.PictureAttachmentActivity;
import com.freshchat.consumer.sdk.beans.UnsupportedFragmentConfig;
import com.freshchat.consumer.sdk.beans.fragment.AudioFragment;
import com.freshchat.consumer.sdk.beans.fragment.ButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.CollectionFragment;
import com.freshchat.consumer.sdk.beans.fragment.ImageFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.TextFragment;
import com.freshchat.consumer.sdk.k.e;
import com.freshchat.consumer.sdk.util.DeepLinkUtils;
import java.util.Iterator;
import java.util.List;

public class ak {
    private final Context context;
    private final LayoutInflater cr;
    private ViewGroup iA;
    private final ae iz;
    private final int rp;

    public ak(Context context2) {
        this.context = context2;
        this.iz = new ae(context2);
        this.cr = LayoutInflater.from(context2);
        this.rp = aq.j(context2, R.attr.freshchatPictureMessagePlaceholderImage);
    }

    private View a(AudioFragment audioFragment) {
        View inflate = View.inflate(this.context, R.layout.freshchat_partial_message_fragment_audio, this.iA);
        View findViewById = inflate.findViewById(R.id.freshchat_message_duration);
        inflate.findViewById(R.id.freshchat_message_play);
        if (findViewById instanceof TextView) {
            ((TextView) findViewById).setText(n.s(audioFragment.getDuration()));
        }
        return inflate;
    }

    private View a(CollectionFragment collectionFragment) {
        if (collectionFragment == null) {
            return null;
        }
        boolean z = false;
        List<MessageFragment> fragments = collectionFragment.getFragments();
        if (k.a(fragments)) {
            Iterator<MessageFragment> it = fragments.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next() instanceof QuickReplyButtonFragment) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z) {
            return null;
        }
        return b(collectionFragment);
    }

    private View a(ImageFragment imageFragment, boolean z) {
        final String content = imageFragment.getContent();
        if (!URLUtil.isNetworkUrl(content)) {
            content = hj1.S("file:", content);
        }
        View inflate = this.cr.inflate(R.layout.freshchat_partial_message_fragment_image, this.iA, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.freshchat_image);
        Point b = this.iz.b(imageFragment.getWidth(), imageFragment.getHeight());
        int i = b.x;
        int i2 = b.y;
        if (z) {
            this.iz.a(imageView, b);
        }
        FreshchatImageLoaderRequest dM = new FreshchatImageLoaderRequest.a(content).a(i, i2).G(this.rp).dM();
        FreshchatImageLoader eK = af.eK();
        if (eK != null) {
            eK.load(dM, imageView);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            /* class com.freshchat.consumer.sdk.j.ak.AnonymousClass2 */

            public void onClick(View view) {
                ak.this.context.startActivity(PictureAttachmentActivity.a(ak.this.context, content));
            }
        });
        return inflate;
    }

    private View a(QuickReplyButtonFragment quickReplyButtonFragment) {
        e eVar = new e(this.context);
        eVar.b(quickReplyButtonFragment);
        return bi(eVar.hb());
    }

    private View a(TextFragment textFragment, boolean z, boolean z2) {
        return bi(cv.a(textFragment, z, z2));
    }

    private View b(MessageFragment messageFragment) {
        Integer num;
        String str;
        UnsupportedFragmentConfig.ErrorMessage errorMessage;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.freshchat_unknown_fragment, this.iA, false);
        TextView textView = (TextView) inflate.findViewById(R.id.freshchat_unknown_fragment_text);
        String str2 = null;
        if (messageFragment != null) {
            str = messageFragment.getContentType();
            num = Integer.valueOf(messageFragment.getFragmentType());
        } else {
            num = null;
            str = null;
        }
        UnsupportedFragmentConfig unsupportedFragmentConfig = ap.bD(this.context).getUnsupportedFragmentConfig();
        if (!(unsupportedFragmentConfig == null || (errorMessage = unsupportedFragmentConfig.getErrorMessage(num, str)) == null)) {
            str2 = unsupportedFragmentConfig.getDisplayableErrorMessage(errorMessage);
        }
        if (as.a(str2)) {
            textView.setText(str2);
        } else {
            textView.setText(R.string.freshchat_unknown_message_fragment);
        }
        return inflate;
    }

    private View bi(String str) {
        View inflate = this.cr.inflate(R.layout.freshchat_partial_message_fragment_text, this.iA, false);
        TextView textView = (TextView) inflate.findViewById(R.id.freshchat_text);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        Bundle bundle = new Bundle();
        bundle.putBoolean("LAUNCHED_FROM_CONVERSATION", true);
        textView.setText(DeepLinkUtils.c(this.context, str, bundle));
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.freshchat.consumer.sdk.j.ak.AnonymousClass1 */

            public boolean onLongClick(View view) {
                ((View) view.getParent()).performLongClick();
                return true;
            }
        });
        return inflate;
    }

    public View a(ViewGroup viewGroup, MessageFragment messageFragment, boolean z, boolean z2, boolean z3) {
        a(viewGroup);
        return messageFragment instanceof TextFragment ? a((TextFragment) messageFragment, z, z2) : messageFragment instanceof AudioFragment ? a((AudioFragment) messageFragment) : messageFragment instanceof ImageFragment ? a((ImageFragment) messageFragment, z3) : messageFragment instanceof ButtonFragment ? a((ButtonFragment) messageFragment) : messageFragment instanceof CollectionFragment ? a((CollectionFragment) messageFragment) : messageFragment instanceof QuickReplyButtonFragment ? a((QuickReplyButtonFragment) messageFragment) : b(messageFragment);
    }

    public View a(ButtonFragment buttonFragment) {
        String str;
        Context context2;
        int i;
        View inflate = this.cr.inflate(R.layout.freshchat_partial_message_fragment_button, this.iA, false);
        View findViewById = inflate.findViewById(R.id.freshchat_button);
        Uri b = aj.b(buttonFragment);
        if (findViewById instanceof TextView) {
            if (DeepLinkUtils.e(b)) {
                context2 = this.context;
                i = R.string.freshchat_chat_deeplink_faq;
            } else if (as.a(buttonFragment.getLabel())) {
                str = buttonFragment.getLabel();
                ((TextView) findViewById).setText(str);
            } else {
                context2 = this.context;
                i = R.string.freshchat_chat_deeplink;
            }
            str = context2.getString(i);
            ((TextView) findViewById).setText(str);
        }
        findViewById.setOnClickListener(new cs(this, b));
        return inflate;
    }

    public void a(ViewGroup viewGroup) {
        this.iA = viewGroup;
    }
}
