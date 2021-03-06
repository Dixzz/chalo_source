package com.freshchat.consumer.sdk.ui;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.q;

public class MediaSeekBar extends SeekBar {
    private Boolean hf = Boolean.TRUE;
    public Activity hg;

    public MediaSeekBar(Context context) {
        super(context);
    }

    public MediaSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(final View view, final MediaPlayer mediaPlayer) {
        new Thread() {
            /* class com.freshchat.consumer.sdk.ui.MediaSeekBar.AnonymousClass1 */

            public void run() {
                try {
                    MediaSeekBar.this.hf = Boolean.TRUE;
                    MediaSeekBar.this.setMax(mediaPlayer.getDuration());
                    MediaSeekBar.this.hg.runOnUiThread(new Runnable() {
                        /* class com.freshchat.consumer.sdk.ui.MediaSeekBar.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            MediaSeekBar.this.setThumbOffset(1);
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            ((ImageView) view).setImageResource(aq.j(MediaSeekBar.this.hg, R.attr.freshchatStopIcon));
                        }
                    });
                    while (MediaSeekBar.this.hf.booleanValue() && mediaPlayer.isPlaying()) {
                        try {
                            MediaSeekBar.this.setProgress(mediaPlayer.getCurrentPosition());
                        } catch (Exception e) {
                            q.a(e);
                        }
                        Thread.sleep(100);
                    }
                    MediaSeekBar.this.setProgress(0);
                    MediaSeekBar.this.hg.runOnUiThread(new Runnable() {
                        /* class com.freshchat.consumer.sdk.ui.MediaSeekBar.AnonymousClass1.AnonymousClass2 */

                        public void run() {
                            MediaSeekBar.this.setThumbOffset(9999);
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            ((ImageView) view).setImageResource(aq.j(MediaSeekBar.this.hg, R.attr.freshchatPlayIcon));
                        }
                    });
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }.start();
    }

    public void dZ() {
        this.hf = Boolean.FALSE;
    }
}
