package defpackage;

import defpackage.zg;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: qh  reason: default package */
/* compiled from: OnLifecycleEvent */
public @interface qh {
    zg.a value();
}
