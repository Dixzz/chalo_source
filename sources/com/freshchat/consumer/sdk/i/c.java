package com.freshchat.consumer.sdk.i;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.x;
import com.freshchat.consumer.sdk.ui.MediaSeekBar;
import java.io.File;

public class c implements Runnable {
    public static final String TAG = c.class.getName();
    public static volatile MediaPlayer gY;
    private final e cL;
    private final Context context;
    private final TelephonyManager gZ;
    private final Message gz;
    private final Activity ha;
    private final View hb;
    private final MediaSeekBar hc;
    public SeekBar.OnSeekBarChangeListener hd;

    public static final boolean dU() {
        try {
            if (gY != null) {
                return gY.isPlaying();
            }
            return false;
        } catch (Exception e) {
            q.a(e);
            return false;
        }
    }

    private void dV() {
        if (gY == null) {
            synchronized (c.class) {
                if (gY == null) {
                    gY = new MediaPlayer();
                }
            }
            return;
        }
        try {
            synchronized (c.class) {
                if (gY.isPlaying()) {
                    gY.stop();
                }
                gY.reset();
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    public static synchronized void dW() {
        synchronized (c.class) {
            if (gY != null && gY.isPlaying()) {
                try {
                    gY.stop();
                    try {
                        gY.reset();
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Exception e2) {
                    q.a(e2);
                    try {
                        gY.reset();
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Throwable th) {
                    try {
                        gY.reset();
                    } catch (Exception e4) {
                        q.a(e4);
                    }
                    throw th;
                }
            }
        }
        q.a(e);
    }

    private void dX() {
        this.ha.runOnUiThread(new Runnable() {
            /* class com.freshchat.consumer.sdk.i.c.AnonymousClass4 */

            public void run() {
                c.this.hc.setVisibility(4);
            }
        });
    }

    private void dY() {
        this.ha.runOnUiThread(new Runnable() {
            /* class com.freshchat.consumer.sdk.i.c.AnonymousClass5 */

            public void run() {
                c.this.hc.setVisibility(0);
            }
        });
    }

    private void r(int i) {
        if (i == 0) {
            while (b.aq(this.gz.getAlias()) == 0) {
                try {
                    dX();
                    Thread.sleep(1000);
                } catch (Exception e) {
                    q.a(e);
                    return;
                }
            }
        }
    }

    public void a(Integer... numArr) {
        try {
            TelephonyManager telephonyManager = this.gZ;
            if (telephonyManager != null && telephonyManager.getCallState() == 1) {
                gY.stop();
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    public void run() {
        String str;
        Boolean bool = Boolean.FALSE;
        try {
            synchronized (c.class) {
                long currentTimeMillis = System.currentTimeMillis();
                dV();
                long currentTimeMillis2 = System.currentTimeMillis();
                str = TAG;
                ai.d(str, "Media init " + (currentTimeMillis2 - currentTimeMillis) + " ms");
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            try {
                this.hc.setOnSeekBarChangeListener(this.hd);
                int progress = this.hc.getProgress();
                gY.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    /* class com.freshchat.consumer.sdk.i.c.AnonymousClass1 */

                    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        q.a(new RuntimeException(hj1.L("Media player error w: ", i, " e: ", i2)));
                        return false;
                    }
                });
                File b = x.b(this.context, this.gz);
                boolean exists = b.exists();
                ai.d(str, "Audio file received for playing " + b.getAbsolutePath());
                ai.d(str, "Does the media player's file exist ? " + exists);
                long currentTimeMillis4 = System.currentTimeMillis();
                ai.d(str, "Pre-file check " + (currentTimeMillis4 - currentTimeMillis3) + " ms");
                int aq = b.aq(this.gz.getAlias());
                if (!exists) {
                    dX();
                } else {
                    r(aq);
                }
                long currentTimeMillis5 = System.currentTimeMillis();
                ai.d(str, "Post-file check " + (currentTimeMillis5 - currentTimeMillis4) + " ms");
                dY();
                synchronized (c.class) {
                    try {
                        int i = this.cL.bo() ? 3 : 0;
                        gY.reset();
                        gY.setAudioStreamType(i);
                        gY.setDataSource(b.getAbsolutePath());
                        gY.prepare();
                        this.hc.setMax(gY.getDuration());
                        this.ha.runOnUiThread(new Runnable() {
                            /* class com.freshchat.consumer.sdk.i.c.AnonymousClass2 */

                            public void run() {
                                c.this.hc.setThumbOffset(1);
                            }
                        });
                        ((AudioManager) this.context.getSystemService("audio")).requestAudioFocus(null, 3, 2);
                        gY.start();
                        gY.seekTo(progress);
                        long currentTimeMillis6 = System.currentTimeMillis();
                        ai.d(str, "File-play " + (currentTimeMillis6 - currentTimeMillis5) + " ms");
                    } catch (Exception e) {
                        boolean delete = b.delete();
                        String str2 = TAG;
                        ai.d(str2, "Was audio file deleted ? " + delete);
                        q.a(e);
                        throw e;
                    }
                }
                try {
                    if (gY.isPlaying()) {
                        com.freshchat.consumer.sdk.j.b.c.kq = this.gz.getAlias();
                        this.hc.a(this.hb, gY);
                    }
                    while (gY.isPlaying()) {
                        a(Integer.valueOf(gY.getCurrentPosition()));
                    }
                } catch (Exception e2) {
                    q.a(e2);
                }
                a(0);
                try {
                    ((AudioManager) this.ha.getSystemService("audio")).abandonAudioFocus(null);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Exception e4) {
                q.a(e4);
                try {
                    ((AudioManager) this.ha.getSystemService("audio")).abandonAudioFocus(null);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } finally {
                this.hb.setTag(bool);
                this.hc.dZ();
                com.freshchat.consumer.sdk.j.b.c.kq = null;
                this.ha.runOnUiThread(new Runnable() {
                    /* class com.freshchat.consumer.sdk.i.c.AnonymousClass3 */

                    public void run() {
                        ((ImageView) c.this.hb).setImageResource(aq.j(c.this.context, R.attr.freshchatPlayIcon));
                        c.this.hc.setThumbOffset(9999);
                    }
                });
            }
        } catch (Exception e6) {
            q.a(e6);
            try {
                ((AudioManager) this.ha.getSystemService("audio")).abandonAudioFocus(null);
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                ((AudioManager) this.ha.getSystemService("audio")).abandonAudioFocus(null);
            } catch (Exception e8) {
                e8.printStackTrace();
            }
            throw th;
        }
    }
}
