package patterns.builder;

public enum PolicyHolderType {

    PRIMARY(10), SECONDARY(11);

    private Integer code;

    PolicyHolderType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "PolicyHolderType{" +
                "code=" + code +
                '}';
    }
}
