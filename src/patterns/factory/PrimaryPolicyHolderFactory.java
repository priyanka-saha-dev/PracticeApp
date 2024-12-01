package patterns.factory;

import patterns.builder.PolicyHolder;
import patterns.builder.PolicyHolderType;

public class PrimaryPolicyHolderFactory {

    public static PolicyHolder generate(String name, String telephone, String email) {
        return PolicyHolder.builder()
                .name(name)
                .telephone(telephone)
                .policyHolderType(PolicyHolderType.PRIMARY)
                .email(email)
                .build();
    }

}
