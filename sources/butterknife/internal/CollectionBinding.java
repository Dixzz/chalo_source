package butterknife.internal;

public final class CollectionBinding implements Binding {
    private final Kind kind;
    private final String name;
    private final boolean required;
    private final String type;

    public enum Kind {
        ARRAY,
        LIST
    }

    public CollectionBinding(String str, String str2, Kind kind2, boolean z) {
        this.name = str;
        this.type = str2;
        this.kind = kind2;
        this.required = z;
    }

    @Override // butterknife.internal.Binding
    public String getDescription() {
        return hj1.a0(hj1.i0("field '"), this.name, "'");
    }

    public Kind getKind() {
        return this.kind;
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
