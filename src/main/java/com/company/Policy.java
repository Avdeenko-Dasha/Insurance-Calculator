package com.company;

import java.util.List;

public class Policy {
    private String number;
    private Status status;
    private List<PolicyObject> policyObjects;

    public Policy(String number, Status status, List<PolicyObject> policyObjects) {
        this.number = number;
        this.status = status;
        this.policyObjects = policyObjects;
    }

    public String getNumber() {
        return number;
    }

    public Status getStatus() {
        return status;
    }

    public List<PolicyObject> getPolicyObjects() {
        return policyObjects;
    }
}
