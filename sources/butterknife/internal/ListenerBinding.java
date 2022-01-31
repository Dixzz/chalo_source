package butterknife.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ListenerBinding implements Binding {
    private final String name;
    private final List<Parameter> parameters;
    private final boolean required;

    public ListenerBinding(String str, List<Parameter> list, boolean z) {
        this.name = str;
        this.parameters = Collections.unmodifiableList(new ArrayList(list));
        this.required = z;
    }

    @Override // butterknife.internal.Binding
    public String getDescription() {
        return hj1.a0(hj1.i0("method '"), this.name, "'");
    }

    public String getName() {
        return this.name;
    }

    public List<Parameter> getParameters() {
        return this.parameters;
    }

    public boolean isRequired() {
        return this.required;
    }
}
