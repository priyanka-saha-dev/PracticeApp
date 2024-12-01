package patterns.factory;

import patterns.builder.Policy;

import java.time.LocalDateTime;
import java.util.List;

public class FactoryAndBuilderExampleTest {

    public static void main(String[] args) {

        Policy policyPrimary = Policy.builder()
                .id("1")
                .timestamp(LocalDateTime.now())
                .policyholder(PrimaryPolicyHolderFactory.generate("pri", "1234", "pri@mail.com"))
                .build();

        Policy policySecondary = Policy.builder()
                .id("2")
                .timestamp(LocalDateTime.now())
                .policyholder(PrimaryPolicyHolderFactory.generate("tuhin", "243545", "tuhin@mail.com"))
                .build();

        List.of(policyPrimary, policySecondary).forEach(System.out::println);
    }
}
