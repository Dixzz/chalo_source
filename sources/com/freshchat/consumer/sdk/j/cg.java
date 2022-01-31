package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.beans.fragment.ButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.SectionKey;
import com.freshchat.consumer.sdk.beans.fragment.TemplateFragment;

public class cg {
    public static String a(TemplateFragment templateFragment, SectionKey sectionKey) {
        MessageFragment b = b(templateFragment, sectionKey);
        if (b == null) {
            return null;
        }
        return b.getContent();
    }

    public static String a(TemplateFragment templateFragment, SectionKey sectionKey, String str) {
        if (templateFragment == null) {
            return str;
        }
        MessageFragment b = b(templateFragment, sectionKey);
        String str2 = null;
        if (b instanceof ButtonFragment) {
            str2 = ((ButtonFragment) b).getLabel();
        } else if (b instanceof CallbackButtonFragment) {
            str2 = ((CallbackButtonFragment) b).getLabel();
        }
        return as.isEmpty(str2) ? str : str2;
    }

    public static MessageFragment b(TemplateFragment templateFragment, SectionKey sectionKey) {
        if (templateFragment == null) {
            return null;
        }
        return templateFragment.getSingleFragmentFromSection(sectionKey);
    }
}
