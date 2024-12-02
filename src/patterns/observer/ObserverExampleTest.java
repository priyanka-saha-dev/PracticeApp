package patterns.observer;

import patterns.builder.Policy;
import patterns.factory.PrimaryPolicyHolderFactory;

import java.time.LocalDateTime;
import java.util.List;

public class ObserverExampleTest {

    public static void main(String[] args) {

        Policy policyPrimary = Policy.builder()
                .id("1")
                .timestamp(LocalDateTime.now())
                .policyholder(PrimaryPolicyHolderFactory.generate("pri", "1234", "pri@mail.com"))
                .build();

        policyPrimary.addObserver(new AuditLoggerObserver());
        policyPrimary.addObserver(new EmailNotificationObserver());

        List.of(policyPrimary).forEach(System.out::println);

        policyPrimary.trigger(LocalDateTime.now().plusYears(2), "Timestamp updated");


    }
}
