package patterns.observer;

import patterns.builder.Policy;

@FunctionalInterface
public interface PolicyObserver {
    void notify(Policy policy, String event);
}
