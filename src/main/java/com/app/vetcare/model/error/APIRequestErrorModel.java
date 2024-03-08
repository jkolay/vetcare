package com.app.vetcare.model.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIRequestErrorModel {

    public APIRequestErrorModel(Map<String, String> errorDescription, String code, ErrorSeverityLevelCodeType severityLevel, UUID traceId) {
        this.errorDescription = errorDescription;
        this.code = code;
        this.severityLevel = severityLevel;
        this.traceId = traceId;
    }

    private Map<String,String> errorDescription;
    private String code;
    private ErrorSeverityLevelCodeType severityLevel;
    private UUID traceId;

    private String errorMessage;

    public APIRequestErrorModel(String message, String invalidInput, ErrorSeverityLevelCodeType error, UUID uuid) {

        this.errorMessage = message;
        this.code = code;
        this.severityLevel = severityLevel;
        this.traceId = traceId;
    }
}
