package com.dudy.entity;

/**
 * Class used in showing the result of operation
 */
public class Statement {
    public static final String NAME = "STATEMENT";
    public static final String CONFIRMATION = "confirmation";
    public static final String WARNING = "warning";
    public static final String ERROR = "error";

    private String message;
    private String styleClass;

    public Statement(String message, String styleClass) {
        this.message = message;
        this.styleClass = styleClass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

}
