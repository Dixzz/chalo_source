package com.google.firebase.appindexing.builders;

import com.google.firebase.appindexing.Indexable;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class Indexables {
    private Indexables() {
    }

    public static AggregateRatingBuilder aggregateRatingBuilder() {
        return new AggregateRatingBuilder();
    }

    public static AlarmBuilder alarmBuilder() {
        return new AlarmBuilder();
    }

    public static AlarmInstanceBuilder alarmInstanceBuilder() {
        return new AlarmInstanceBuilder();
    }

    public static AudiobookBuilder audiobookBuilder() {
        return new AudiobookBuilder();
    }

    public static BookBuilder bookBuilder() {
        return new BookBuilder();
    }

    public static ConversationBuilder conversationBuilder() {
        return new ConversationBuilder();
    }

    public static DigitalDocumentBuilder digitalDocumentBuilder() {
        return new DigitalDocumentBuilder();
    }

    public static DigitalDocumentPermissionBuilder digitalDocumentPermissionBuilder() {
        return new DigitalDocumentPermissionBuilder();
    }

    public static MessageBuilder emailMessageBuilder() {
        return new MessageBuilder("EmailMessage");
    }

    public static GeoShapeBuilder geoShapeBuilder() {
        return new GeoShapeBuilder();
    }

    public static LocalBusinessBuilder localBusinessBuilder() {
        return new LocalBusinessBuilder();
    }

    public static MessageBuilder messageBuilder() {
        return new MessageBuilder();
    }

    public static MusicAlbumBuilder musicAlbumBuilder() {
        return new MusicAlbumBuilder();
    }

    public static MusicGroupBuilder musicGroupBuilder() {
        return new MusicGroupBuilder();
    }

    public static MusicPlaylistBuilder musicPlaylistBuilder() {
        return new MusicPlaylistBuilder();
    }

    public static MusicRecordingBuilder musicRecordingBuilder() {
        return new MusicRecordingBuilder();
    }

    public static Indexable newSimple(String str, String str2) {
        Objects.requireNonNull(str, "null reference");
        Objects.requireNonNull(str2, "null reference");
        return ((Indexable.Builder) ((Indexable.Builder) new Indexable.Builder().setUrl(str2)).setName(str)).build();
    }

    public static DigitalDocumentBuilder noteDigitalDocumentBuilder() {
        return new DigitalDocumentBuilder("NoteDigitalDocument");
    }

    public static PersonBuilder personBuilder() {
        return new PersonBuilder();
    }

    public static PlaceBuilder placeBuilder() {
        return new PlaceBuilder();
    }

    public static PostalAddressBuilder postalAddressBuilder() {
        return new PostalAddressBuilder();
    }

    public static DigitalDocumentBuilder presentationDigitalDocumentBuilder() {
        return new DigitalDocumentBuilder("PresentationDigitalDocument");
    }

    public static ReservationBuilder reservationBuilder() {
        return new ReservationBuilder();
    }

    public static LocalBusinessBuilder restaurantBuilder() {
        return new LocalBusinessBuilder("Restaurant");
    }

    public static DigitalDocumentBuilder spreadsheetDigitalDocumentBuilder() {
        return new DigitalDocumentBuilder("SpreadsheetDigitalDocument");
    }

    public static StickerBuilder stickerBuilder() {
        return new StickerBuilder();
    }

    public static StickerPackBuilder stickerPackBuilder() {
        return new StickerPackBuilder();
    }

    public static StopwatchBuilder stopwatchBuilder() {
        return new StopwatchBuilder();
    }

    public static StopwatchLapBuilder stopwatchLapBuilder() {
        return new StopwatchLapBuilder();
    }

    public static DigitalDocumentBuilder textDigitalDocumentBuilder() {
        return new DigitalDocumentBuilder("TextDigitalDocument");
    }

    public static TimerBuilder timerBuilder() {
        return new TimerBuilder();
    }
}
