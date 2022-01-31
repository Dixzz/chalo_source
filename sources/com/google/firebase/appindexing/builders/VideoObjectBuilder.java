package com.google.firebase.appindexing.builders;

import java.util.Date;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class VideoObjectBuilder extends IndexableBuilder<VideoObjectBuilder> {
    public VideoObjectBuilder() {
        super("VideoObject");
    }

    public final VideoObjectBuilder setAuthor(PersonBuilder personBuilder) {
        return (VideoObjectBuilder) put("author", personBuilder);
    }

    public final VideoObjectBuilder setDuration(long j) {
        return (VideoObjectBuilder) put("duration", j);
    }

    public final VideoObjectBuilder setDurationWatched(long j) {
        return (VideoObjectBuilder) put("durationWatched", j);
    }

    public final VideoObjectBuilder setLocationCreated(PlaceBuilder placeBuilder) {
        return (VideoObjectBuilder) put("locationCreated", placeBuilder);
    }

    public final VideoObjectBuilder setSeriesName(String str) {
        return (VideoObjectBuilder) put("seriesName", str);
    }

    public final VideoObjectBuilder setUploadDate(Date date) {
        return (VideoObjectBuilder) put("uploadDate", date.getTime());
    }
}
