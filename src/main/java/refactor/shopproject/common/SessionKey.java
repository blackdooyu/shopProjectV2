package refactor.shopproject.common;

public enum SessionKey {

    MEMBER("member"),
    ;

    private final String value;

    SessionKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
