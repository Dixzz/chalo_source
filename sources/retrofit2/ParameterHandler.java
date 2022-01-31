package retrofit2;

import defpackage.gi6;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class ParameterHandler<T> {

    public static final class Body<T> extends ParameterHandler<T> {
        private final Converter<T, mi6> converter;
        private final Method method;
        private final int p;

        public Body(Method method2, int i, Converter<T, mi6> converter2) {
            this.method = method2;
            this.p = i;
            this.converter = converter2;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable T t) {
            if (t != null) {
                try {
                    requestBuilder.setBody(this.converter.convert(t));
                } catch (IOException e) {
                    Method method2 = this.method;
                    int i = this.p;
                    throw Utils.parameterError(method2, e, i, "Unable to convert " + ((Object) t) + " to RequestBody", new Object[0]);
                }
            } else {
                throw Utils.parameterError(this.method, this.p, "Body parameter value must not be null.", new Object[0]);
            }
        }
    }

    public static final class Field<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Field(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            String convert;
            if (t != null && (convert = this.valueConverter.convert(t)) != null) {
                requestBuilder.addFormField(this.name, convert, this.encoded);
            }
        }
    }

    public static final class FieldMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        public FieldMap(Method method2, int i, Converter<T, String> converter, boolean z) {
            this.method = method2;
            this.p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.valueConverter.convert(value);
                            if (convert != null) {
                                requestBuilder.addFormField(key, convert, this.encoded);
                            } else {
                                Method method2 = this.method;
                                int i = this.p;
                                throw Utils.parameterError(method2, i, "Field map value '" + ((Object) value) + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            throw Utils.parameterError(this.method, this.p, hj1.T("Field map contained null value for key '", key, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Field map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Field map was null.", new Object[0]);
        }
    }

    public static final class Header<T> extends ParameterHandler<T> {
        private final String name;
        private final Converter<T, String> valueConverter;

        public Header(String str, Converter<T, String> converter) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            String convert;
            if (t != null && (convert = this.valueConverter.convert(t)) != null) {
                requestBuilder.addHeader(this.name, convert);
            }
        }
    }

    public static final class HeaderMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        public HeaderMap(Method method2, int i, Converter<T, String> converter) {
            this.method = method2;
            this.p = i;
            this.valueConverter = converter;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            requestBuilder.addHeader(key, this.valueConverter.convert(value));
                        } else {
                            throw Utils.parameterError(this.method, this.p, hj1.T("Header map contained null value for key '", key, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Header map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Header map was null.", new Object[0]);
        }
    }

    public static final class Headers extends ParameterHandler<ci6> {
        private final Method method;
        private final int p;

        public Headers(Method method2, int i) {
            this.method = method2;
            this.p = i;
        }

        public void apply(RequestBuilder requestBuilder, @Nullable ci6 ci6) {
            if (ci6 != null) {
                requestBuilder.addHeaders(ci6);
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Headers parameter must not be null.", new Object[0]);
        }
    }

    public static final class Part<T> extends ParameterHandler<T> {
        private final Converter<T, mi6> converter;
        private final ci6 headers;
        private final Method method;
        private final int p;

        public Part(Method method2, int i, ci6 ci6, Converter<T, mi6> converter2) {
            this.method = method2;
            this.p = i;
            this.headers = ci6;
            this.converter = converter2;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable T t) {
            if (t != null) {
                try {
                    requestBuilder.addPart(this.headers, this.converter.convert(t));
                } catch (IOException e) {
                    Method method2 = this.method;
                    int i = this.p;
                    throw Utils.parameterError(method2, i, "Unable to convert " + ((Object) t) + " to RequestBody", e);
                }
            }
        }
    }

    public static final class PartMap<T> extends ParameterHandler<Map<String, T>> {
        private final Method method;
        private final int p;
        private final String transferEncoding;
        private final Converter<T, mi6> valueConverter;

        public PartMap(Method method2, int i, Converter<T, mi6> converter, String str) {
            this.method = method2;
            this.p = i;
            this.valueConverter = converter;
            this.transferEncoding = str;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            requestBuilder.addPart(ci6.g.c("Content-Disposition", hj1.T("form-data; name=\"", key, "\""), "Content-Transfer-Encoding", this.transferEncoding), this.valueConverter.convert(value));
                        } else {
                            throw Utils.parameterError(this.method, this.p, hj1.T("Part map contained null value for key '", key, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Part map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Part map was null.", new Object[0]);
        }
    }

    public static final class Path<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Method method;
        private final String name;
        private final int p;
        private final Converter<T, String> valueConverter;

        public Path(Method method2, int i, String str, Converter<T, String> converter, boolean z) {
            this.method = method2;
            this.p = i;
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            if (t != null) {
                requestBuilder.addPathParam(this.name, this.valueConverter.convert(t), this.encoded);
                return;
            }
            throw Utils.parameterError(this.method, this.p, hj1.a0(hj1.i0("Path parameter \""), this.name, "\" value must not be null."), new Object[0]);
        }
    }

    public static final class Query<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final String name;
        private final Converter<T, String> valueConverter;

        public Query(String str, Converter<T, String> converter, boolean z) {
            this.name = (String) Utils.checkNotNull(str, "name == null");
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            String convert;
            if (t != null && (convert = this.valueConverter.convert(t)) != null) {
                requestBuilder.addQueryParam(this.name, convert, this.encoded);
            }
        }
    }

    public static final class QueryMap<T> extends ParameterHandler<Map<String, T>> {
        private final boolean encoded;
        private final Method method;
        private final int p;
        private final Converter<T, String> valueConverter;

        public QueryMap(Method method2, int i, Converter<T, String> converter, boolean z) {
            this.method = method2;
            this.p = i;
            this.valueConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
            apply(requestBuilder, (Map) ((Map) obj));
        }

        public void apply(RequestBuilder requestBuilder, @Nullable Map<String, T> map) throws IOException {
            if (map != null) {
                for (Map.Entry<String, T> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (key != null) {
                        T value = entry.getValue();
                        if (value != null) {
                            String convert = this.valueConverter.convert(value);
                            if (convert != null) {
                                requestBuilder.addQueryParam(key, convert, this.encoded);
                            } else {
                                Method method2 = this.method;
                                int i = this.p;
                                throw Utils.parameterError(method2, i, "Query map value '" + ((Object) value) + "' converted to null by " + this.valueConverter.getClass().getName() + " for key '" + key + "'.", new Object[0]);
                            }
                        } else {
                            throw Utils.parameterError(this.method, this.p, hj1.T("Query map contained null value for key '", key, "'."), new Object[0]);
                        }
                    } else {
                        throw Utils.parameterError(this.method, this.p, "Query map contained null key.", new Object[0]);
                    }
                }
                return;
            }
            throw Utils.parameterError(this.method, this.p, "Query map was null", new Object[0]);
        }
    }

    public static final class QueryName<T> extends ParameterHandler<T> {
        private final boolean encoded;
        private final Converter<T, String> nameConverter;

        public QueryName(Converter<T, String> converter, boolean z) {
            this.nameConverter = converter;
            this.encoded = z;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException {
            if (t != null) {
                requestBuilder.addQueryParam(this.nameConverter.convert(t), null, this.encoded);
            }
        }
    }

    public static final class RawPart extends ParameterHandler<gi6.c> {
        public static final RawPart INSTANCE = new RawPart();

        private RawPart() {
        }

        public void apply(RequestBuilder requestBuilder, @Nullable gi6.c cVar) {
            if (cVar != null) {
                requestBuilder.addPart(cVar);
            }
        }
    }

    public static final class RelativeUrl extends ParameterHandler<Object> {
        private final Method method;
        private final int p;

        public RelativeUrl(Method method2, int i) {
            this.method = method2;
            this.p = i;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable Object obj) {
            if (obj != null) {
                requestBuilder.setRelativeUrl(obj);
                return;
            }
            throw Utils.parameterError(this.method, this.p, "@Url parameter is null.", new Object[0]);
        }
    }

    public static final class Tag<T> extends ParameterHandler<T> {
        public final Class<T> cls;

        public Tag(Class<T> cls2) {
            this.cls = cls2;
        }

        @Override // retrofit2.ParameterHandler
        public void apply(RequestBuilder requestBuilder, @Nullable T t) {
            requestBuilder.addTag(this.cls, t);
        }
    }

    public abstract void apply(RequestBuilder requestBuilder, @Nullable T t) throws IOException;

    public final ParameterHandler<Object> array() {
        return new ParameterHandler<Object>() {
            /* class retrofit2.ParameterHandler.AnonymousClass2 */

            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: retrofit2.ParameterHandler */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // retrofit2.ParameterHandler
            public void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        ParameterHandler.this.apply(requestBuilder, Array.get(obj, i));
                    }
                }
            }
        };
    }

    public final ParameterHandler<Iterable<T>> iterable() {
        return new ParameterHandler<Iterable<T>>() {
            /* class retrofit2.ParameterHandler.AnonymousClass1 */

            @Override // retrofit2.ParameterHandler
            public /* bridge */ /* synthetic */ void apply(RequestBuilder requestBuilder, @Nullable Object obj) throws IOException {
                apply(requestBuilder, (Iterable) ((Iterable) obj));
            }

            public void apply(RequestBuilder requestBuilder, @Nullable Iterable<T> iterable) throws IOException {
                if (iterable != null) {
                    for (T t : iterable) {
                        ParameterHandler.this.apply(requestBuilder, t);
                    }
                }
            }
        };
    }
}
