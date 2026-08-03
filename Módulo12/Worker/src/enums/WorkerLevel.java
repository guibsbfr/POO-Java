package enums;

public enum WorkerLevel {
    JUNIOR(0),
    MID_LEVEL(1),
    SENIOR(2);

    private final int code;

    WorkerLevel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
