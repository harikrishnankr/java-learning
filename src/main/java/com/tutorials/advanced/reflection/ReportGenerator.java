package com.tutorials.advanced.reflection;

public class ReportGenerator {
    @Loggable("summary")
    public String generateSummary() {
        return "summary report";
    }

    @Loggable
    public String generateDetail() {
        return "detail report";
    }

    // Not annotated — ReflectionUtils.invokeLoggable() must skip this one.
    public String internalHelper() {
        return "not logged";
    }
}
