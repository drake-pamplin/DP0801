package src.exception;

import lombok.Getter;

public class InvalidCommandException extends Exception {
    public InvalidCommandException(String errorMessage, String command) {
        super(errorMessage);
        this.command = command;
    }

    @Getter
    String command;
}
