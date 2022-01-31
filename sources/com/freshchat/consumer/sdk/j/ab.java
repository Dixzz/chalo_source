package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.beans.fragment.AudioFragment;
import com.freshchat.consumer.sdk.beans.fragment.ButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment;
import com.freshchat.consumer.sdk.beans.fragment.CallbackButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.CollectionFragment;
import com.freshchat.consumer.sdk.beans.fragment.FragmentType;
import com.freshchat.consumer.sdk.beans.fragment.ImageFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.beans.fragment.TemplateType;
import com.freshchat.consumer.sdk.beans.fragment.TextFragment;
import com.freshchat.consumer.sdk.beans.fragment.UnknownFragment;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;

public class ab {
    private static ab qu;
    private static ab qv;
    private final Gson hK;

    public static class a implements ExclusionStrategy {
        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipClass(Class<?> cls) {
            return cls.getAnnotation(b.class) != null;
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return fieldAttributes.getAnnotation(b.class) != null;
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
    }

    public static class d implements ExclusionStrategy {
        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipClass(Class<?> cls) {
            return cls.getAnnotation(c.class) != null;
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return fieldAttributes.getAnnotation(c.class) != null;
        }
    }

    @Deprecated
    public ab() {
        this(new ExclusionStrategy[0]);
    }

    @Deprecated
    public ab(ExclusionStrategy... exclusionStrategyArr) {
        com.freshchat.consumer.sdk.d.b a2 = com.freshchat.consumer.sdk.d.b.a(MessageFragment.class, "fragmentType");
        a2.b(TextFragment.class, String.valueOf(FragmentType.TEXT.asInt()));
        a2.b(AudioFragment.class, String.valueOf(FragmentType.AUDIO.asInt()));
        a2.b(ImageFragment.class, String.valueOf(FragmentType.IMAGE.asInt()));
        a2.b(ButtonFragment.class, String.valueOf(FragmentType.BUTTON.asInt()));
        a2.b(CollectionFragment.class, String.valueOf(FragmentType.COLLECTION.asInt()));
        a2.b(QuickReplyButtonFragment.class, String.valueOf(FragmentType.QUICK_REPLY_BUTTON.asInt()));
        a2.b(CallbackButtonFragment.class, String.valueOf(FragmentType.CALLBACK_BUTTON.asInt()));
        a2.b(CalendarEventFragment.class, String.valueOf(FragmentType.CALENDAR_EVENT.asInt()));
        a2.b(UnknownFragment.class);
        com.freshchat.consumer.sdk.d.b<T>.C0010b w = a2.w(String.valueOf(FragmentType.TEMPLATE.asInt()), "templateType");
        TemplateType[] values = TemplateType.values();
        for (int i = 0; i < 3; i++) {
            TemplateType templateType = values[i];
            w.a(templateType.asString(), templateType.getClz());
        }
        w.gY();
        GsonBuilder registerTypeAdapterFactory = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").registerTypeAdapterFactory(a2);
        if (exclusionStrategyArr != null) {
            registerTypeAdapterFactory.setExclusionStrategies(exclusionStrategyArr);
        }
        this.hK = registerTypeAdapterFactory.create();
    }

    public static ab in() {
        if (qu == null) {
            synchronized (ab.class) {
                if (qu == null) {
                    qu = new ab();
                }
            }
        }
        return qu;
    }

    public static ab io() {
        if (qv == null) {
            synchronized (ab.class) {
                if (qv == null) {
                    qv = new ab(new d());
                }
            }
        }
        return qv;
    }

    public <T> T fromJson(String str, Class<T> cls) {
        return (T) this.hK.fromJson(str, (Class) cls);
    }

    public <T> T fromJson(String str, Type type) {
        return (T) this.hK.fromJson(str, type);
    }

    public String toJson(Object obj) {
        return this.hK.toJson(obj);
    }

    public String toJson(Object obj, Type type) {
        return this.hK.toJson(obj, type);
    }
}
