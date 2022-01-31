package com.google.firebase.perf.util;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLWrapper {
    private final URL mURL;

    public URLWrapper(URL url) {
        this.mURL = url;
    }

    public URLConnection openConnection() throws IOException {
        return this.mURL.openConnection();
    }

    public String toString() {
        return this.mURL.toString();
    }
}
