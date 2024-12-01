package patterns.builder;

public class PolicyHolder {

    private final String name;
    private final String email;
    private final String telephone;

    private final PolicyHolderType policyHolderType;

    private PolicyHolder(PolicyHolderBuilder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.telephone = builder.telephone;
        this.policyHolderType = builder.policyHolderType;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public PolicyHolderType getPolicyHolderType() {
        return policyHolderType;
    }

    public static PolicyHolderBuilder builder() {
        return new PolicyHolderBuilder();
    }

    public static class PolicyHolderBuilder {

        private String name;
        private String email;
        private String telephone;
        private PolicyHolderType policyHolderType;

        public PolicyHolderBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PolicyHolderBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PolicyHolderBuilder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public PolicyHolderBuilder policyHolderType(PolicyHolderType policyHolderType) {
            this.policyHolderType = policyHolderType;
            return this;
        }


        public PolicyHolder build() {
            return new PolicyHolder(this);
        }

    }

    @Override
    public String toString() {
        return "PolicyHolder{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", policyHolderType='" + policyHolderType + '\'' +
                '}';
    }
}

