package patterns.builder;

import java.time.LocalDateTime;

public class BuilderExampleTest {

    public static void main(String[] args) {

        Policy policy = Policy.builder()
                .id("1")
                .timestamp(LocalDateTime.now())
                .policyholder(PolicyHolder.builder()
                        .name("Pri")
                        .telephone("1234")
                        .policyHolderType(PolicyHolderType.PRIMARY)
                        .email("test@mail.com")
                        .build())
                .build();

        System.out.println(policy);
    }
}
