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
@ListenerClass(method = {@ListenerMethod(name = "doClick", parameters = {"android.view.View"})}, setter = "setOnClickListener", targetType = ButterKnifeProcessor.VIEW_TYPE, type = "butterknife.internal.DebouncingOnClickListener")
public @interface OnClick {
    int[] value() default {-1};
}
