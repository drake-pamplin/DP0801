package src.exception;

import lombok.Getter;

public class InvalidArgException extends Exception {
    public InvalidArgException(String errorMessage, String field, String issue) {
        super(errorMessage);
        this.field = field;
        this.issue = issue;
    }

    @Getter
    private String field;

    @Getter
    private String issue;
}
