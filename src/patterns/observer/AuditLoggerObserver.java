package patterns.observer;

import patterns.builder.Policy;

public class AuditLoggerObserver implements PolicyObserver{
    @Override
    public void notify(Policy policy, String event) {
        System.out.println("Audit Logger: " + event + " for policy " + policy);
    }
}
