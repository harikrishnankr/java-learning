package com.tutorials.functional.immutability;

import java.time.Instant;

/**
 * Every field here is a genuinely immutable type (String, Instant), so
 * `final` alone is enough — no defensive copying needed. Compare to
 * ImmutablePlaylist, whose List field needed List.copyOf() precisely
 * because java.util.List implementations are mutable by default.
 */
public final class AuditRecord {
    private final String actor;
    private final String action;
    private final Instant occurredAt;

    public AuditRecord(String actor, String action, Instant occurredAt) {
        this.actor = actor;
        this.action = action;
        this.occurredAt = occurredAt;
    }

    public String actor() {
        return actor;
    }

    public String action() {
        return action;
    }

    public Instant occurredAt() {
        return occurredAt; // Instant is immutable — safe to return as-is
    }
}
