package com.freshchat.consumer.sdk.beans;

import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import java.util.HashMap;
import java.util.List;

public class UnsupportedFragmentConfig {
    private boolean displayErrorCodes;
    private String errorCodePlaceholder;
    private List<FragmentErrorMessage> errorMessageByTypes;
    private HashMap<Integer, FragmentErrorMessage> errorMessageByTypesMap = null;
    private ErrorMessage globalErrorMessage;

    public class ErrorMessage {
        private String contentType;
        private long errorCode;
        private String errorMessage;

        public ErrorMessage() {
        }

        public String getContentType() {
            return this.contentType;
        }

        public long getErrorCode() {
            return this.errorCode;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }
    }

    public class FragmentErrorMessage {
        private ErrorMessage defaultErrorMessage;
        private HashMap<String, ErrorMessage> errorMessageMap = null;
        private List<ErrorMessage> errorMessages;
        private int fragmentType;

        public FragmentErrorMessage() {
        }

        public HashMap<String, ErrorMessage> getErrorMessageMap() {
            if (k.d(this.errorMessageMap)) {
                return this.errorMessageMap;
            }
            this.errorMessageMap = new HashMap<>();
            if (k.a(this.errorMessages)) {
                for (ErrorMessage errorMessage : this.errorMessages) {
                    this.errorMessageMap.put(errorMessage.getContentType(), errorMessage);
                }
            }
            return this.errorMessageMap;
        }
    }

    public String getDisplayableErrorMessage(ErrorMessage errorMessage) {
        if (errorMessage == null) {
            return null;
        }
        String errorMessage2 = errorMessage.getErrorMessage();
        if (!this.displayErrorCodes || !as.a(this.errorCodePlaceholder)) {
            return errorMessage2;
        }
        StringBuilder k0 = hj1.k0(errorMessage2, "\n");
        k0.append(this.errorCodePlaceholder.replace("%d", String.valueOf(errorMessage.getErrorCode())));
        return k0.toString();
    }

    public ErrorMessage getErrorMessage(Integer num, String str) {
        ErrorMessage errorMessage;
        FragmentErrorMessage fragmentErrorMessage = getErrorMessageByTypesMap().get(num);
        if (fragmentErrorMessage != null) {
            errorMessage = fragmentErrorMessage.getErrorMessageMap().get(str);
            if (errorMessage == null || as.isEmpty(errorMessage.getErrorMessage())) {
                errorMessage = fragmentErrorMessage.defaultErrorMessage;
            }
        } else {
            errorMessage = null;
        }
        return (errorMessage == null || as.isEmpty(errorMessage.getErrorMessage())) ? this.globalErrorMessage : errorMessage;
    }

    public HashMap<Integer, FragmentErrorMessage> getErrorMessageByTypesMap() {
        if (k.d(this.errorMessageByTypesMap)) {
            return this.errorMessageByTypesMap;
        }
        this.errorMessageByTypesMap = new HashMap<>();
        if (k.isEmpty(this.errorMessageByTypes)) {
            return this.errorMessageByTypesMap;
        }
        for (FragmentErrorMessage fragmentErrorMessage : this.errorMessageByTypes) {
            this.errorMessageByTypesMap.put(Integer.valueOf(fragmentErrorMessage.fragmentType), fragmentErrorMessage);
        }
        return this.errorMessageByTypesMap;
    }

    public ErrorMessage getGlobalErrorMessage() {
        return this.globalErrorMessage;
    }
}
