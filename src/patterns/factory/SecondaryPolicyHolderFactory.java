package patterns.factory;

import patterns.builder.PolicyHolder;
import patterns.builder.PolicyHolderType;

public class SecondaryPolicyHolderFactory {

    public static PolicyHolder generate(String name, String telephone, String email) {
        return PolicyHolder.builder()
                .name(name)
                .telephone(telephone)
                .policyHolderType(PolicyHolderType.SECONDARY)
                .email(email)
                .build();
    }

}
