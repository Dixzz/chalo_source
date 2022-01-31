package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import com.rabbitmq.client.StringRpcServer;
import defpackage.fi6;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import retrofit2.Converter;

public final class GsonRequestBodyConverter<T> implements Converter<T, mi6> {
    private static final fi6 MEDIA_TYPE = fi6.a.a("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName(StringRpcServer.STRING_ENCODING);
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    static {
        fi6.a aVar = fi6.f;
    }

    public GsonRequestBodyConverter(Gson gson2, TypeAdapter<T> typeAdapter) {
        this.gson = gson2;
        this.adapter = typeAdapter;
    }

    @Override // retrofit2.Converter
    public mi6 convert(T t) throws IOException {
        vm6 vm6 = new vm6();
        JsonWriter newJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(new wm6(vm6), UTF_8));
        this.adapter.write(newJsonWriter, t);
        newJsonWriter.close();
        return mi6.create(MEDIA_TYPE, vm6.v0());
    }
}
