package defpackage;

import androidx.viewpager2.adapter.FragmentStateAdapter;

/* renamed from: vo  reason: default package */
/* compiled from: FragmentStateAdapter */
public class vo implements Runnable {
    public final /* synthetic */ FragmentStateAdapter f;

    public vo(FragmentStateAdapter fragmentStateAdapter) {
        this.f = fragmentStateAdapter;
    }

    public void run() {
        FragmentStateAdapter fragmentStateAdapter = this.f;
        fragmentStateAdapter.l = false;
        fragmentStateAdapter.f();
    }
}
