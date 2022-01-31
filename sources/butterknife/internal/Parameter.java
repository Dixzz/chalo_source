package butterknife.internal;

public final class Parameter {
    public static final Parameter[] NONE = new Parameter[0];
    private final int listenerPosition;
    private final String type;

    public Parameter(int i, String str) {
        this.listenerPosition = i;
        this.type = str;
    }

    public int getListenerPosition() {
        return this.listenerPosition;
    }

    public String getType() {
        return this.type;
    }
}
