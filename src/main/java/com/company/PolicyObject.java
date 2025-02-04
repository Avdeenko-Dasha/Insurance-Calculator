package com.company;

import java.util.List;

public class PolicyObject {
    private String name;
    private List<PolicySubObject> policySubObjects;

    public PolicyObject(String name, List<PolicySubObject> policySubObjects) {
        this.name = name;
        this.policySubObjects = policySubObjects;
    }

    public String getName() {
        return name;
    }

    public List<PolicySubObject> getPolicySubObjects() {
        return policySubObjects;
    }
}
