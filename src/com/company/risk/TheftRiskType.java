package com.company.risk;

import com.company.risk.RiskType;

import java.math.BigDecimal;

public class TheftRiskType implements RiskType {
    final String name = "THEFT";

    @Override
    public BigDecimal getCoefficient(BigDecimal sumInsured) {
        if (sumInsured.compareTo(new BigDecimal(15.0)) >= 0) return new BigDecimal(0.05);
        else return new BigDecimal(0.11);
    }
}
