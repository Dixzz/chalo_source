package com.crashlytics.android.core;

import android.content.Context;

public class DialogStringResolver {
    private static final String PROMPT_MESSAGE_RES_NAME = "com.crashlytics.CrashSubmissionPromptMessage";
    private static final String PROMPT_TITLE_RES_NAME = "com.crashlytics.CrashSubmissionPromptTitle";
    private static final String SUBMISSION_ALWAYS_SEND_RES_NAME = "com.crashlytics.CrashSubmissionAlwaysSendTitle";
    private static final String SUBMISSION_CANCEL_RES_NAME = "com.crashlytics.CrashSubmissionCancelTitle";
    private static final String SUBMISSION_SEND_RES_NAME = "com.crashlytics.CrashSubmissionSendTitle";
    private final Context context;
    private final a26 promptData;

    public DialogStringResolver(Context context2, a26 a26) {
        this.context = context2;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private String resourceOrFallbackValue(String str, String str2) {
        return stringOrFallback(j06.g(this.context, str), str2);
    }

    private String stringOrFallback(String str, String str2) {
        return isNullOrEmpty(str) ? str2 : str;
    }

    public String getAlwaysSendButtonTitle() {
        throw null;
    }

    public String getCancelButtonTitle() {
        throw null;
    }

    public String getMessage() {
        throw null;
    }

    public String getSendButtonTitle() {
        throw null;
    }

    public String getTitle() {
        throw null;
    }
}
