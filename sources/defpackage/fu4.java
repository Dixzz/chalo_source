package defpackage;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* renamed from: fu4  reason: default package */
public final class fu4 {
    public static final nv4 b = new nv4("VerifySliceTaskHandler");

    /* renamed from: a  reason: collision with root package name */
    public final bs4 f1172a;

    public fu4(bs4 bs4) {
        this.f1172a = bs4;
    }

    public final void a(eu4 eu4) {
        File k = this.f1172a.k(eu4.b, eu4.c, eu4.d, eu4.e);
        if (k.exists()) {
            try {
                File q = this.f1172a.q(eu4.b, eu4.c, eu4.d, eu4.e);
                if (q.exists()) {
                    try {
                        if (mt4.a(du4.a(k, q)).equals(eu4.f)) {
                            b.b(4, "Verification of slice %s of pack %s successful.", new Object[]{eu4.e, eu4.b});
                            File l = this.f1172a.l(eu4.b, eu4.c, eu4.d, eu4.e);
                            if (!l.exists()) {
                                l.mkdirs();
                            }
                            if (!k.renameTo(l)) {
                                throw new os4(String.format("Failed to move slice %s after verification.", eu4.e), eu4.f1171a);
                            }
                            return;
                        }
                        throw new os4(String.format("Verification failed for slice %s.", eu4.e), eu4.f1171a);
                    } catch (NoSuchAlgorithmException e) {
                        throw new os4("SHA256 algorithm not supported.", e, eu4.f1171a);
                    } catch (IOException e2) {
                        throw new os4(String.format("Could not digest file during verification for slice %s.", eu4.e), e2, eu4.f1171a);
                    }
                } else {
                    throw new os4(String.format("Cannot find metadata files for slice %s.", eu4.e), eu4.f1171a);
                }
            } catch (IOException e3) {
                throw new os4(String.format("Could not reconstruct slice archive during verification for slice %s.", eu4.e), e3, eu4.f1171a);
            }
        } else {
            throw new os4(String.format("Cannot find unverified files for slice %s.", eu4.e), eu4.f1171a);
        }
    }
}
