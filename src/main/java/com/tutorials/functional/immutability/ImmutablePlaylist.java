package com.tutorials.functional.immutability;

import java.util.ArrayList;
import java.util.List;

/**
 * `final` fields are necessary for immutability but not sufficient — a
 * `final List<String>` field still points at a list the CALLER can mutate
 * after construction unless you defensively copy it. `List.copyOf()` does
 * both jobs at once: it snapshots the input and wraps the result as
 * unmodifiable, so the same safe list can be returned directly from the
 * accessor with no further copying needed.
 */
public final class ImmutablePlaylist {
    private final String name;
    private final List<String> tracks;

    public ImmutablePlaylist(String name, List<String> tracks) {
        this.name = name;
        this.tracks = List.copyOf(tracks); // decouples from the caller's (possibly mutable) list
    }

    public String name() {
        return name;
    }

    public List<String> tracks() {
        return tracks; // already immutable — safe to hand out directly, no copy needed here
    }

    // "Mutating" an immutable object means returning a new one.
    public ImmutablePlaylist withTrack(String track) {
        List<String> updated = new ArrayList<>(tracks);
        updated.add(track);
        return new ImmutablePlaylist(name, updated);
    }
}
