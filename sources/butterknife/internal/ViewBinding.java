package butterknife.internal;

public final class ViewBinding implements Binding {
    private final String name;
    private final boolean required;
    private final String type;

    public ViewBinding(String str, String str2, boolean z) {
        this.name = str;
        this.type = str2;
        this.required = z;
    }

    @Override // butterknife.internal.Binding
    public String getDescription() {
        return hj1.a0(hj1.i0("field '"), this.name, "'");
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public boolean isRequired() {
        return this.required;
    }
}
