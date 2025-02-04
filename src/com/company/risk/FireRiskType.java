package com.company.risk;

import java.math.BigDecimal;

public class FireRiskType implements RiskType {
    final String name = "FIRE";

    @Override
    public BigDecimal getCoefficient(BigDecimal sumInsured) {
        if (sumInsured.compareTo(new BigDecimal(100.0)) >= 1) return new BigDecimal(0.024);
        else return new BigDecimal(0.014);
    }
}
