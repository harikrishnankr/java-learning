package com.tutorials.core.objectcontracts;

import java.util.Objects;

/**
 * A cautionary example, not a recommendation: this class's hashCode() is
 * derived from a MUTABLE field. Put an instance in a HashSet, mutate that
 * field, and the set can no longer find it — the object is still there,
 * just filed under a bucket its new hash code no longer maps to. Lesson:
 * hash-based collection keys must be immutable (see Employee for the fix).
 */
public final class MutableTag {
    private String label;

    public MutableTag(String label) {
        this.label = label;
    }

    public void relabel(String newLabel) {
        this.label = newLabel;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MutableTag other && Objects.equals(label, other.label);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(label);
    }
}
