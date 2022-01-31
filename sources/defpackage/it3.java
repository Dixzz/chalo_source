package defpackage;

import defpackage.bu3;
import defpackage.it3;
import defpackage.kt3;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/* renamed from: it3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class it3<MessageType extends it3<MessageType, BuilderType>, BuilderType extends kt3<MessageType, BuilderType>> implements cw3 {
    public int zza = 0;

    public static <T> void f(Iterable<T> iterable, List<? super T> list) {
        Charset charset = tu3.f3407a;
        Objects.requireNonNull(iterable);
        if (iterable instanceof jv3) {
            List<?> zzb = ((jv3) iterable).zzb();
            jv3 jv3 = (jv3) list;
            int size = list.size();
            for (Object obj : zzb) {
                if (obj == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(jv3.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    int size2 = jv3.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            jv3.remove(size2);
                        } else {
                            throw new NullPointerException(sb2);
                        }
                    }
                } else if (obj instanceof qt3) {
                    jv3.M((qt3) obj);
                } else {
                    jv3.add((String) obj);
                }
            }
        } else if (iterable instanceof lw3) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size3 = list.size();
            for (T t : iterable) {
                if (t == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 >= size3) {
                            list.remove(size4);
                        } else {
                            throw new NullPointerException(sb4);
                        }
                    }
                } else {
                    list.add(t);
                }
            }
        }
    }

    @Override // defpackage.cw3
    public final qt3 e() {
        ru3 ru3 = (ru3) this;
        try {
            int a2 = ru3.a();
            qt3 qt3 = qt3.g;
            byte[] bArr = new byte[a2];
            Logger logger = bu3.b;
            bu3.b bVar = new bu3.b(bArr, a2);
            ru3.b(bVar);
            if (bVar.a() == 0) {
                return new wt3(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 62 + 10);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] h() {
        ru3 ru3 = (ru3) this;
        try {
            int a2 = ru3.a();
            byte[] bArr = new byte[a2];
            Logger logger = bu3.b;
            bu3.b bVar = new bu3.b(bArr, a2);
            ru3.b(bVar);
            if (bVar.a() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(10 + name.length() + 62);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public int i() {
        throw new UnsupportedOperationException();
    }

    public void j(int i) {
        throw new UnsupportedOperationException();
    }
}
