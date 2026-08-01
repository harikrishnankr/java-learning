package com.tutorials.advanced.designpatterns.behavioral;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The invoker keeps a history of executed commands purely because they're
 * objects, not direct method calls — undo() just pops the last one and
 * calls its undo(), with no knowledge of what kind of command it was.
 */
public class RemoteControl {
    private final Deque<Command> history = new ArrayDeque<>();

    public void submit(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLast() {
        if (!history.isEmpty()) {
            history.pop().undo();
        }
    }
}
