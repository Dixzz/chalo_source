package com.rabbitmq.client;

import java.util.Date;
import java.util.Map;

public interface BasicProperties {
    String getAppId();

    String getContentEncoding();

    String getContentType();

    String getCorrelationId();

    Integer getDeliveryMode();

    String getExpiration();

    Map<String, Object> getHeaders();

    String getMessageId();

    Integer getPriority();

    String getReplyTo();

    Date getTimestamp();

    String getType();

    String getUserId();
}
