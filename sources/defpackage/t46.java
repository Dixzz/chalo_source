package defpackage;

import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.HashMap;
import java.util.Map;

/* renamed from: t46  reason: default package */
/* compiled from: Parser */
public class t46 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3308a = String.valueOf(Integer.MAX_VALUE).length();
    public static final Map<String, Integer> b;
    public static final Map<Integer, String> c = new HashMap();
    public static s46<String> d = new s46<>("error", "parser error");
    public static d56 e;

    /* renamed from: t46$a */
    /* compiled from: Parser */
    public static class a extends HashMap<String, Integer> implements j$.util.Map {
        public a() {
            put("open", 0);
            put("close", 1);
            put("ping", 2);
            put("pong", 3);
            put("message", 4);
            put("upgrade", 5);
            put("noop", 6);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
            return Map.CC.$default$compute(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
            return Map.CC.$default$computeIfAbsent(this, obj, function);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
            return Map.CC.$default$computeIfPresent(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ void forEach(BiConsumer biConsumer) {
            Map.CC.$default$forEach(this, biConsumer);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Map, j$.util.Map, java.util.HashMap
        public /* synthetic */ Integer getOrDefault(Object obj, Integer num) {
            return Map.CC.$default$getOrDefault(this, obj, num);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
            return Map.CC.$default$merge(this, obj, obj2, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Map, j$.util.Map, java.util.HashMap
        public /* synthetic */ Integer putIfAbsent(String str, Integer num) {
            return Map.CC.$default$putIfAbsent(this, str, num);
        }

        @Override // j$.util.Map
        public /* synthetic */ boolean remove(Object obj, Object obj2) {
            return Map.CC.$default$remove(this, obj, obj2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Map, j$.util.Map, java.util.HashMap
        public /* synthetic */ Integer replace(String str, Integer num) {
            return Map.CC.$default$replace(this, str, num);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // java.util.Map, j$.util.Map, java.util.HashMap
        public /* synthetic */ boolean replace(String str, Integer num, Integer num2) {
            return Map.CC.$default$replace(this, str, num, num2);
        }

        @Override // j$.util.Map
        public /* synthetic */ void replaceAll(BiFunction biFunction) {
            Map.CC.$default$replaceAll(this, biFunction);
        }
    }

    /* renamed from: t46$b */
    /* compiled from: Parser */
    public interface b<T> {
        void a(T t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: java.util.Map<java.lang.Integer, java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    static {
        a aVar = new a();
        b = aVar;
        for (Map.Entry entry : aVar.entrySet()) {
            c.put(entry.getValue(), entry.getKey());
        }
        d56 d56 = new d56();
        e = d56;
        d56.f791a = false;
    }

    public static s46<String> a(String str, boolean z) {
        int i;
        if (str == null) {
            return d;
        }
        try {
            i = Character.getNumericValue(str.charAt(0));
        } catch (IndexOutOfBoundsException unused) {
            i = -1;
        }
        if (z) {
            try {
                str = hd3.d0(str, e);
            } catch (e56 unused2) {
                return d;
            }
        }
        if (i >= 0) {
            java.util.Map<Integer, String> map = c;
            if (i < map.size()) {
                if (str.length() > 1) {
                    return new s46<>(map.get(Integer.valueOf(i)), str.substring(1));
                }
                return new s46<>(map.get(Integer.valueOf(i)));
            }
        }
        return d;
    }

    public static s46<byte[]> b(byte[] bArr) {
        byte b2 = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 1, bArr2, 0, length);
        return new s46<>(c.get(Integer.valueOf(b2)), bArr2);
    }

    public static void c(s46 s46, boolean z, b bVar) throws e56 {
        String str;
        T t = s46.b;
        if (t instanceof byte[]) {
            byte[] bArr = (byte[]) t;
            byte[] bArr2 = new byte[(bArr.length + 1)];
            bArr2[0] = b.get(s46.f3185a).byteValue();
            System.arraycopy(bArr, 0, bArr2, 1, bArr.length);
            bVar.a(bArr2);
            return;
        }
        String valueOf = String.valueOf(b.get(s46.f3185a));
        if (s46.b != null) {
            StringBuilder i0 = hj1.i0(valueOf);
            String valueOf2 = String.valueOf(s46.b);
            if (z) {
                boolean z2 = e.f791a;
                int[] e3 = hd3.e3(valueOf2);
                int length = e3.length;
                StringBuilder sb = new StringBuilder();
                int i = -1;
                while (true) {
                    i++;
                    if (i >= length) {
                        break;
                    }
                    int i2 = e3[i];
                    StringBuilder sb2 = new StringBuilder();
                    if ((i2 & -128) == 0) {
                        sb2.append(Character.toChars(i2));
                        str = sb2.toString();
                    } else {
                        if ((i2 & -2048) == 0) {
                            sb2.append(Character.toChars(((i2 >> 6) & 31) | 192));
                        } else if ((-65536 & i2) == 0) {
                            if (!hd3.G(i2, z2)) {
                                i2 = 65533;
                            }
                            sb2.append(Character.toChars(((i2 >> 12) & 15) | 224));
                            sb2.append(hd3.U(i2, 6));
                        } else if ((-2097152 & i2) == 0) {
                            sb2.append(Character.toChars(((i2 >> 18) & 7) | 240));
                            sb2.append(hd3.U(i2, 12));
                            sb2.append(hd3.U(i2, 6));
                        }
                        sb2.append(Character.toChars((i2 & 63) | 128));
                        str = sb2.toString();
                    }
                    sb.append(str);
                }
                valueOf2 = sb.toString();
            }
            i0.append(valueOf2);
            valueOf = i0.toString();
        }
        bVar.a(valueOf);
    }
}
