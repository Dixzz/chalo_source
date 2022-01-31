package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import defpackage.sl;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {
    public int f = 0;
    public final HashMap<Integer, String> g = new HashMap<>();
    public final RemoteCallbackList<rl> h = new a();
    public final sl.a i = new b();

    public class a extends RemoteCallbackList<rl> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.os.IInterface, java.lang.Object] */
        @Override // android.os.RemoteCallbackList
        public void onCallbackDied(rl rlVar, Object obj) {
            MultiInstanceInvalidationService.this.g.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    public class b extends sl.a {
        public b() {
        }

        @Override // defpackage.sl
        public void B3(rl rlVar, int i) {
            synchronized (MultiInstanceInvalidationService.this.h) {
                MultiInstanceInvalidationService.this.h.unregister(rlVar);
                MultiInstanceInvalidationService.this.g.remove(Integer.valueOf(i));
            }
        }

        public void C(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.h) {
                String str = MultiInstanceInvalidationService.this.g.get(Integer.valueOf(i));
                if (str != null) {
                    int beginBroadcast = MultiInstanceInvalidationService.this.h.beginBroadcast();
                    for (int i2 = 0; i2 < beginBroadcast; i2++) {
                        try {
                            int intValue = ((Integer) MultiInstanceInvalidationService.this.h.getBroadcastCookie(i2)).intValue();
                            String str2 = MultiInstanceInvalidationService.this.g.get(Integer.valueOf(intValue));
                            if (i != intValue && str.equals(str2)) {
                                try {
                                    MultiInstanceInvalidationService.this.h.getBroadcastItem(i2).r0(strArr);
                                } catch (RemoteException unused) {
                                }
                            }
                        } catch (Throwable th) {
                            MultiInstanceInvalidationService.this.h.finishBroadcast();
                            throw th;
                        }
                    }
                    MultiInstanceInvalidationService.this.h.finishBroadcast();
                }
            }
        }

        public int F(rl rlVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.h) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.f + 1;
                multiInstanceInvalidationService.f = i;
                if (multiInstanceInvalidationService.h.register(rlVar, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.g.put(Integer.valueOf(i), str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f--;
                return 0;
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.i;
    }
}
