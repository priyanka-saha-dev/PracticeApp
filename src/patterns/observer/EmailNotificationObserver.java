package patterns.observer;

import patterns.builder.Policy;

public class EmailNotificationObserver implements PolicyObserver{
    @Override
    public void notify(Policy policy, String event) {
        System.out.println("Email Notification: " + event + " for policy " + policy);
    }
}
