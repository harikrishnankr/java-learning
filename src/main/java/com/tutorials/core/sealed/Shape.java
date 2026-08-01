package com.tutorials.core.sealed;

// `permits` closes the hierarchy: only Circle, Square, and Triangle may ever
// implement Shape. That closed set is what lets the compiler prove a switch
// over Shape is exhaustive without needing a `default` branch.
public sealed interface Shape permits Circle, Square, Triangle {
}
