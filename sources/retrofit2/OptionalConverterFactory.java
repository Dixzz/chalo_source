package retrofit2;

import j$.util.Optional;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.Converter;

@IgnoreJRERequirement
public final class OptionalConverterFactory extends Converter.Factory {
    public static final Converter.Factory INSTANCE = new OptionalConverterFactory();

    @IgnoreJRERequirement
    public static final class OptionalConverter<T> implements Converter<oi6, Optional<T>> {
        public final Converter<oi6, T> delegate;

        public OptionalConverter(Converter<oi6, T> converter) {
            this.delegate = converter;
        }

        public Optional<T> convert(oi6 oi6) throws IOException {
            return Optional.ofNullable(this.delegate.convert(oi6));
        }
    }

    @Override // retrofit2.Converter.Factory
    @Nullable
    public Converter<oi6, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Converter.Factory.getRawType(type) != Optional.class) {
            return null;
        }
        return new OptionalConverter(retrofit.responseBodyConverter(Converter.Factory.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
