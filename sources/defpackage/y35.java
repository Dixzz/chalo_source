package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import com.google.zxing.client.android.R;
import java.io.Closeable;
import java.io.IOException;

/* renamed from: y35  reason: default package */
/* compiled from: BeepManager */
public final class y35 implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, Closeable {
    public static final String j = y35.class.getSimpleName();
    public final Activity f;
    public MediaPlayer g;
    public boolean h;
    public boolean i = true;

    public y35(Activity activity) {
        this.f = activity;
        this.g = null;
        c();
    }

    /* JADX INFO: finally extract failed */
    public final MediaPlayer a(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        try {
            AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(R.raw.zxing_beep);
            try {
                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                return mediaPlayer;
            } catch (Throwable th) {
                openRawResourceFd.close();
                throw th;
            }
        } catch (IOException unused) {
            mediaPlayer.release();
            return null;
        }
    }

    public synchronized void c() {
        boolean z = this.i;
        Activity activity = this.f;
        if (z && ((AudioManager) activity.getSystemService("audio")).getRingerMode() != 2) {
            z = false;
        }
        this.h = z;
        if (z && this.g == null) {
            this.f.setVolumeControlStream(3);
            this.g = a(this.f);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        MediaPlayer mediaPlayer = this.g;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.g = null;
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.seekTo(0);
    }

    public synchronized boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        if (i2 == 100) {
            this.f.finish();
        } else {
            mediaPlayer.release();
            this.g = null;
            c();
        }
        return true;
    }
}
