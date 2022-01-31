package com.rabbitmq.client;

import java.io.IOException;

public interface BlockedListener {
    void handleBlocked(String str) throws IOException;

    void handleUnblocked() throws IOException;
}
