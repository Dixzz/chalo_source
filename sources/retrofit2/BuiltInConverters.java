package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.Converter;
import retrofit2.http.Streaming;

public final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit = true;

    public static final class BufferingResponseBodyConverter implements Converter<oi6, oi6> {
        public static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        public oi6 convert(oi6 oi6) throws IOException {
            try {
                return Utils.buffer(oi6);
            } finally {
                oi6.close();
            }
        }
    }

    public static final class RequestBodyConverter implements Converter<mi6, mi6> {
        public static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        public mi6 convert(mi6 mi6) {
            return mi6;
        }
    }

    public static final class StreamingResponseBodyConverter implements Converter<oi6, oi6> {
        public static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        public oi6 convert(oi6 oi6) {
            return oi6;
        }
    }

    public static final class ToStringConverter implements Converter<Object, String> {
        public static final ToStringConverter INSTANCE = new ToStringConverter();

        @Override // retrofit2.Converter
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    public static final class UnitResponseBodyConverter implements Converter<oi6, s56> {
        public static final UnitResponseBodyConverter INSTANCE = new UnitResponseBodyConverter();

        public s56 convert(oi6 oi6) {
            oi6.close();
            return s56.f3190a;
        }
    }

    public static final class VoidResponseBodyConverter implements Converter<oi6, Void> {
        public static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        public Void convert(oi6 oi6) {
            oi6.close();
            return null;
        }
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public Converter<?, mi6> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (mi6.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public Converter<oi6, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == oi6.class) {
            if (Utils.isAnnotationPresent(annotationArr, Streaming.class)) {
                return StreamingResponseBodyConverter.INSTANCE;
            }
            return BufferingResponseBodyConverter.INSTANCE;
        } else if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        } else {
            if (!this.checkForKotlinUnit || type != s56.class) {
                return null;
            }
            try {
                return UnitResponseBodyConverter.INSTANCE;
            } catch (NoClassDefFoundError unused) {
                this.checkForKotlinUnit = false;
                return null;
            }
        }
    }
}
