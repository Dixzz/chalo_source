package com.google.firebase.appindexing.builders;

import java.util.Date;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class DigitalDocumentBuilder extends IndexableBuilder<DigitalDocumentBuilder> {
    public DigitalDocumentBuilder() {
        super("DigitalDocument");
    }

    public final DigitalDocumentBuilder setAuthor(PersonBuilder... personBuilderArr) {
        return (DigitalDocumentBuilder) put("author", personBuilderArr);
    }

    public final DigitalDocumentBuilder setDateCreated(Date date) {
        return (DigitalDocumentBuilder) put("dateCreated", date.getTime());
    }

    public final DigitalDocumentBuilder setDateModified(Date date) {
        return (DigitalDocumentBuilder) put("dateModified", date.getTime());
    }

    public final DigitalDocumentBuilder setHasDigitalDocumentPermission(DigitalDocumentPermissionBuilder... digitalDocumentPermissionBuilderArr) {
        return (DigitalDocumentBuilder) put("hasDigitalDocumentPermission", digitalDocumentPermissionBuilderArr);
    }

    public final DigitalDocumentBuilder setText(String str) {
        return (DigitalDocumentBuilder) put("text", str);
    }

    public DigitalDocumentBuilder(String str) {
        super(str);
    }
}
