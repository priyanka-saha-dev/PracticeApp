package patterns.builder;

import patterns.observer.PolicyObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Policy {

    private final String id;
    private LocalDateTime timestamp;
    private final PolicyHolder policyholder;

    private final List<PolicyObserver> policyObservers = new ArrayList<>(); /* Observer Pattern Changes */

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

    /* Observer Pattern Changes */
    public void addObserver(PolicyObserver policyObserver) {
        this.policyObservers.add(policyObserver);
    }

    public void notifyObserver(String event) {
        this.policyObservers.forEach(o -> o.notify(this, event));
    }

    //Trigger Event
    public void trigger(LocalDateTime timestamp, String event) {
        this.timestamp = timestamp;
        notifyObserver(event);
    }
    /* Observer Pattern Changes */

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

