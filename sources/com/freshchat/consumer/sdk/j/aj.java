package com.freshchat.consumer.sdk.j;

import android.net.Uri;
import com.freshchat.consumer.sdk.beans.fragment.ButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.FragmentType;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;

public class aj {
    public static boolean a(MessageFragment messageFragment) {
        int fragmentType = messageFragment.getFragmentType();
        return fragmentType == FragmentType.AUDIO.asInt() || fragmentType == FragmentType.IMAGE.asInt();
    }

    public static Uri b(ButtonFragment buttonFragment) {
        try {
            String androidUri = buttonFragment.getAndroidUri();
            if (as.isEmpty(androidUri) && as.a(buttonFragment.getContent())) {
                androidUri = buttonFragment.getContent();
            }
            if (as.a(androidUri)) {
                return Uri.parse(androidUri);
            }
            return null;
        } catch (Exception e) {
            q.a(e);
            return null;
        }
    }
}
