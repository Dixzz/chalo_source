package butterknife;

import butterknife.internal.ButterKnifeProcessor;
import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
@ListenerClass(method = {@ListenerMethod(name = "onFocusChange", parameters = {"android.view.View", "boolean"})}, setter = "setOnFocusChangeListener", targetType = ButterKnifeProcessor.VIEW_TYPE, type = "android.view.View.OnFocusChangeListener")
public @interface OnFocusChange {
    int[] value() default {-1};
}
