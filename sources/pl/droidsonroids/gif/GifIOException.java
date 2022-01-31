package pl.droidsonroids.gif;

import java.io.IOException;

public class GifIOException extends IOException {
    public final xn6 f;
    public final String g;

    public GifIOException(int i, String str) {
        this.f = xn6.fromCode(i);
        this.g = str;
    }

    public String getMessage() {
        if (this.g == null) {
            return this.f.getFormattedDescription();
        }
        return this.f.getFormattedDescription() + ": " + this.g;
    }
}
