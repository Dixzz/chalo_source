package app.zophop.pubsub.eventbus.events;

import app.zophop.models.CardInfo;
import java.util.List;

public class CardInfoFetchEvent {
    public List<CardInfo> cardsList;
    public ad1 responseType;

    public List<CardInfo> getCardsList() {
        return this.cardsList;
    }

    public ad1 getResponseType() {
        return this.responseType;
    }

    public void setCardsList(List<CardInfo> list) {
        this.cardsList = list;
    }

    public void setResponseType(ad1 ad1) {
        this.responseType = ad1;
    }
}
