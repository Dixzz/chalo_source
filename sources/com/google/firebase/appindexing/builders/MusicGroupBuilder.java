package com.google.firebase.appindexing.builders;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class MusicGroupBuilder extends IndexableBuilder<MusicGroupBuilder> {
    public MusicGroupBuilder() {
        super("MusicGroup");
    }

    public final MusicGroupBuilder setAlbum(MusicAlbumBuilder... musicAlbumBuilderArr) {
        return (MusicGroupBuilder) put("album", musicAlbumBuilderArr);
    }

    public final MusicGroupBuilder setGenre(String str) {
        return (MusicGroupBuilder) put("genre", str);
    }

    public final MusicGroupBuilder setTrack(MusicRecordingBuilder... musicRecordingBuilderArr) {
        return (MusicGroupBuilder) put("track", musicRecordingBuilderArr);
    }
}
