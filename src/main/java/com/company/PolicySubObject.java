package com.company;

import com.company.risk.RiskType;

import java.math.BigDecimal;

public class PolicySubObject {
    private String name;
    private BigDecimal sum;
    private RiskType riskType;

    public PolicySubObject(String name, BigDecimal sum, RiskType riskType) {
        this.name = name;
        this.sum = sum;
        this.riskType = riskType;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public RiskType getRiskType() {
        return riskType;
    }
}
