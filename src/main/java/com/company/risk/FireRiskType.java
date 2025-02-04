package com.company.risk;

import java.math.BigDecimal;

public class FireRiskType implements RiskType {
    private static final BigDecimal SUM_INSURED_THRESHOLD = new BigDecimal("100");
    private static final BigDecimal DEFAULT_COEFFICIENT = new BigDecimal("0.014");
    private static final BigDecimal COEFFICIENT = new BigDecimal("0.024");

    @Override
    public BigDecimal getCoefficient(BigDecimal sumInsured) {
        return sumInsured.compareTo(SUM_INSURED_THRESHOLD) > 0 ? COEFFICIENT : DEFAULT_COEFFICIENT;
    }
}
