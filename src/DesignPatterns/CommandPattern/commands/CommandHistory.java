package DesignPatterns.CommandPattern.commands;

import java.util.Stack;

public class CommandHistory {
    Stack<Command> history;

    public CommandHistory() {
        history = new Stack<>();
    }

    public void push(Command c) {
        history.push(c);
    }
    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}
