package defpackage;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import com.rabbitmq.client.AMQP;
import com.trillbit.datasdk.core.CWrapper;
import java.util.Objects;

/* renamed from: lg5  reason: default package */
/* compiled from: Player */
public class lg5 {

    /* renamed from: a  reason: collision with root package name */
    public int f2216a;
    public final AudioManager b;
    public final Context c;
    public final b d = new b(this);
    public final mg5 e;
    public final bg5 f;
    public AudioTrack g;
    public CWrapper h;

    /* renamed from: lg5$a */
    /* compiled from: Player */
    public class a implements AudioTrack.OnPlaybackPositionUpdateListener {
        public a() {
        }

        public void onMarkerReached(AudioTrack audioTrack) {
            lg5 lg5 = lg5.this;
            bg5 bg5 = lg5.f;
            Objects.requireNonNull(lg5);
            bg5.a("Player", "Playing Completed.");
            lg5.this.c();
            lg5.this.e.b(AMQP.REPLY_SUCCESS);
        }

        public void onPeriodicNotification(AudioTrack audioTrack) {
        }
    }

    /* renamed from: lg5$b */
    /* compiled from: Player */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2218a = false;

        public b(lg5 lg5) {
        }

        public void a() {
            this.f2218a = !this.f2218a;
        }
    }

    static {
        System.loadLibrary("native-lib");
    }

    public lg5(Context context, CWrapper cWrapper, mg5 mg5, bg5 bg5, int i) {
        this.c = context;
        this.b = (AudioManager) context.getSystemService("audio");
        this.e = mg5;
        this.h = cWrapper;
        this.f = bg5;
        this.f2216a = i;
    }

    public final void a(float[] fArr) {
        if (this.d.f2218a) {
            int length = fArr.length;
            this.g = new AudioTrack(3, this.f2216a, 4, 4, fArr.length * 4, 0);
            this.e.a(AMQP.REPLY_SUCCESS);
            this.g.write(fArr, 0, length, 1);
            this.g.setNotificationMarkerPosition(length);
            this.g.getSampleRate();
            this.g.setPlaybackPositionUpdateListener(new a());
            bg5 bg5 = this.f;
            StringBuilder i0 = hj1.i0("Playing Started, Samples Length -> ");
            i0.append(fArr.length);
            bg5.a("Player", i0.toString());
            this.g.play();
        }
    }

    public final void b(double d2) {
        this.b.setStreamVolume(3, (int) (((double) this.b.getStreamMaxVolume(3)) * d2), 0);
        bg5 bg5 = this.f;
        if (bg5 != null) {
            bg5.a("Player", "Setting volume to " + d2);
        }
    }

    public void c() {
        if (this.d.f2218a) {
            this.g.stop();
            this.g.release();
            this.g = null;
            this.d.a();
        }
    }
}
