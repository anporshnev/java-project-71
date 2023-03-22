package hexlet.code;

public class DifferenceValue {
    private final String status;
    private final Object value1;
    private Object value2;

    public DifferenceValue(String status, Object value1) {
        this.status = status;
        this.value1 = value1;
    }

    public DifferenceValue(String status, Object value1, Object value2) {
        this.status = status;
        this.value1 = value1;
        this.value2 = value2;
    }

    public Object getValue2() {
        return value2;
    }

    public Object getValue1() {
        return value1;
    }

    public String getStatus() {
        return status;
    }

    public String toString() {
        return "status: %s, value1: %s, value2: %s"
                .formatted(getStatus(), getValue1(), getValue2() == null ? getValue2() : "-");
    }
}
