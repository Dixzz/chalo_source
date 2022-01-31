package com.google.firebase.appindexing.builders;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public class AudiobookBuilder extends IndexableBuilder<AudiobookBuilder> {
    public AudiobookBuilder() {
        super("Audiobook");
    }

    public AudiobookBuilder setAuthor(PersonBuilder... personBuilderArr) {
        return (AudiobookBuilder) put("author", personBuilderArr);
    }

    public AudiobookBuilder setReadBy(PersonBuilder... personBuilderArr) {
        return (AudiobookBuilder) put("readBy", personBuilderArr);
    }
}
