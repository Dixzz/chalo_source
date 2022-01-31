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
@ListenerClass(method = {@ListenerMethod(defaultReturn = "false", name = "onLongClick", parameters = {"android.view.View"}, returnType = "boolean")}, setter = "setOnLongClickListener", targetType = ButterKnifeProcessor.VIEW_TYPE, type = "android.view.View.OnLongClickListener")
public @interface OnLongClick {
    int[] value() default {-1};
}
