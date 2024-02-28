package part4.exceptions;

public class InvalidUserInputException extends Exception {
    private String expectedType;

    private String fieldName;

    public InvalidUserInputException() {
    }

    public InvalidUserInputException(String message, String expectedType, String fieldName) {
        super(message);
        this.expectedType = expectedType;
        this.fieldName = fieldName;
    }

    public String getExpectedType() {
        return expectedType;
    }

    public void setExpectedType(String expectedType) {
        this.expectedType = expectedType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
