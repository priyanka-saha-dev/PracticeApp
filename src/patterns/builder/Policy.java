package patterns.builder;

import java.time.LocalDateTime;

public class Policy {

    private final String id;
    private final LocalDateTime timestamp;

    private final PolicyHolder policyholder;

    private Policy(PolicyBuilder builder) {
        this.id = builder.id;
        this.timestamp = builder.timestamp;
        this.policyholder = builder.policyholder;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public PolicyHolder getPolicyholder() {
        return policyholder;
    }

    public static PolicyBuilder builder() {
        return new PolicyBuilder();
    }


    public static class PolicyBuilder {

        private String id;
        private LocalDateTime timestamp;
        private PolicyHolder policyholder;

        public PolicyBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PolicyBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public PolicyBuilder policyholder(PolicyHolder policyholder) {
            this.policyholder = policyholder;
            return this;
        }

        public Policy build() {
            return new Policy(this);
        }
    }

    @Override
    public String toString() {
        return "Policy{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", policyholder=" + policyholder +
                '}';
    }
}

