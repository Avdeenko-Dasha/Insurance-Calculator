package com.company;

import com.company.risk.RiskType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PolicyCreator {

    public Policy createPolicy (String number, Status status, PolicyObject ... objects) {
        return new Policy(
                number,
                status,
                Arrays.stream(objects).collect(Collectors.toList())
        );
    }

    public PolicyObject createPolicyObject(String name, PolicySubObject ... objects){
        return new PolicyObject(
                name,
                Arrays.stream(objects).collect(Collectors.toList())
        );
    }

    public PolicySubObject createPolicySubObject(String name, String sum, RiskType riskType){
        return new PolicySubObject(
                name,
                new BigDecimal(sum),
                riskType
        );
    }
}
