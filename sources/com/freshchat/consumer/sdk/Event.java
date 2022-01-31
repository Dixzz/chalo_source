package com.freshchat.consumer.sdk;

import android.os.Bundle;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.q;
import java.util.HashMap;
import java.util.Map;

public class Event {
    private EventName eventName;
    private Map<Property, Object> properties;

    public enum EventName {
        FCEventFAQCategoryListOpen("FCEventFAQCategoryListOpen"),
        FCEventFAQListOpen("FCEventFAQListOpen"),
        FCEventFAQOpen("FCEventFAQOpen"),
        FCEventFAQSearch("FCEventFAQSearch"),
        FCEventFAQVote("FCEventFAQVote"),
        FCEventChannelListOpen("FCEventChannelListOpen"),
        FCEventMessageSent("FCEventMessageSent"),
        FCEventConversationOpen("FCEventConversationOpen"),
        FCEventCsatOpen("FCEventCsatOpen"),
        FCEventCsatSubmit("FCEventCsatSubmit"),
        FCEventCsatExpiry("FCEventCsatExpiry"),
        FCEventLinkTap("FCEventLinkTap"),
        FCEventScreenView("FCEventScreenView"),
        FCEventMessageReceive("FCEventMessageReceive"),
        FCEventNotificationReceive("FCEventNotificationReceive"),
        FCEventIdTokenStatusChange("FCEventIdTokenStatusChange"),
        FCEventDropDownShow("FCEventDropDownShow"),
        FCEventDropDownOptionSelect("FCEventDropDownOptionSelect"),
        FCEventCarouselShow("FCEventCarouselShow"),
        FCEventCarouselOptionSelect("FCEventCarouselOptionSelect"),
        FCEventCarouselOptionView("FCEventCarouselOptionView"),
        FCEventCalendarFindTimeSlotClick("FCEventCalendarFindTimeSlotClick"),
        FCEventCalendarInviteCancel("FCEventCalendarInviteCancel"),
        FCEventCalendarNoTimeSlotFound("FCEventCalendarNoTimeSlotFound"),
        FCEventCalendarBookingSuccess("FCEventCalendarBookingSuccess"),
        FCEventCalendarBookingRetry("FCEventCalendarBookingRetry"),
        FCEventCalendarBookingFailure("FCEventCalendarBookingFailure"),
        FCEventShowOriginalClick("FCEventShowOriginalClick"),
        FCEventHideOriginalClick("FCEventHideOriginalClick");
        
        public static Map<String, EventName> eventNameMap = new HashMap();
        public String name;

        /* access modifiers changed from: public */
        static {
            try {
                EventName[] values = values();
                for (int i = 0; i < 29; i++) {
                    EventName eventName = values[i];
                    eventNameMap.put(eventName.name, eventName);
                }
            } catch (Exception e) {
                q.a(e);
            }
        }

        private EventName(String str) {
            this.name = str;
        }

        public static EventName get(Bundle bundle) {
            if (bundle == null || !bundle.containsKey("event_name")) {
                return null;
            }
            return eventNameMap.get(bundle.getString("event_name"));
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }

    public enum Property {
        FCPropertyInputTags("FCPropertyInputTags"),
        FCPropertyFAQCategoryID("FCPropertyFAQCategoryID"),
        FCPropertyFAQCategoryName("FCPropertyFAQCategoryName"),
        FCPropertyFAQID("FCPropertyFAQID"),
        FCPropertyFAQTitle("FCPropertyFAQTitle"),
        FCPropertySearchKey("FCPropertySearchKey"),
        FCPropertySearchFAQCount("FCPropertySearchFAQCount"),
        FCPropertyIsRelevant("FCPropertyIsRelevant"),
        FCPropertyIsHelpful("FCPropertyIsHelpful"),
        FCPropertyChannelID("FCPropertyChannelID"),
        FCPropertyConversationID("FCPropertyConversationID"),
        FCPropertyChannelName("FCPropertyChannelName"),
        FCPropertyResolutionStatus("FCPropertyResolutionStatus"),
        FCPropertyRating("FCPropertyRating"),
        FCPropertyComment("FCPropertyComment"),
        FCPropertyURL("FCPropertyURL"),
        FCPropertyOption("FCPropertyOption"),
        FCPropertyInviteId("FCPropertyInviteId");
        
        public static Map<String, Property> eventPropertyMap = new HashMap();
        private String name;

        /* access modifiers changed from: public */
        static {
            try {
                Property[] values = values();
                for (int i = 0; i < 18; i++) {
                    Property property = values[i];
                    eventPropertyMap.put(property.name, property);
                }
            } catch (Exception e) {
                q.a(e);
            }
        }

        private Property(String str) {
            this.name = str;
        }

        public static Property get(String str) {
            if (as.isEmpty(str)) {
                return null;
            }
            return eventPropertyMap.get(str);
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }

    public EventName getEventName() {
        return this.eventName;
    }

    public Map<Property, Object> getProperties() {
        return this.properties;
    }

    public void setEventName(EventName eventName2) {
        this.eventName = eventName2;
    }

    public void setProperties(Map<Property, Object> map) {
        this.properties = map;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Event{eventName=");
        i0.append(this.eventName);
        i0.append(", properties=");
        i0.append(this.properties);
        i0.append('}');
        return i0.toString();
    }
}
