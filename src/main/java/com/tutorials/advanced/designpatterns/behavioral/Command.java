package com.tutorials.advanced.designpatterns.behavioral;

// Command: turns "a request" into an object, so it can be queued, logged,
// or — as in RemoteControl — undone, instead of being just a direct method call.
public interface Command {
    void execute();

    void undo();
}
