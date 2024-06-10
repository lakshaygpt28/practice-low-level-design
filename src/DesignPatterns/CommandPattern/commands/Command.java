package DesignPatterns.CommandPattern.commands;

import DesignPatterns.CommandPattern.editor.Editor;

public abstract class Command {
    Editor editor;
    String backup;

    Command(Editor editor) {
        this.editor = editor;
    }

    void backup() {
        backup = editor.textField.getText();
    }

    public void undo() {
        editor.textField.setText(backup);
    }
    public abstract boolean execute();

}
