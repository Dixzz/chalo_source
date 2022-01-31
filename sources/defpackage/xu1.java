package defpackage;

import android.util.JsonReader;
import android.util.JsonToken;
import com.google.auto.value.AutoValue;
import java.io.IOException;
import java.io.Reader;

@AutoValue
/* renamed from: xu1  reason: default package */
/* compiled from: LogResponse */
public abstract class xu1 {
    public static xu1 a(Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (!jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    return new ru1(Long.parseLong(jsonReader.nextString()));
                } else {
                    ru1 ru1 = new ru1(jsonReader.nextLong());
                    jsonReader.close();
                    return ru1;
                }
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    public abstract long b();
}
