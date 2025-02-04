package com.company.risk;

import java.math.BigDecimal;

public class TheftRiskType implements RiskType {
    private static final BigDecimal SUM_INSURED_THRESHOLD = new BigDecimal("15");
    private static final BigDecimal DEFAULT_COEFFICIENT = new BigDecimal("0.11");
    private static final BigDecimal COEFFICIENT = new BigDecimal("0.05");

    @Override
    public BigDecimal getCoefficient(BigDecimal sumInsured) {
        return sumInsured.compareTo(SUM_INSURED_THRESHOLD) >= 0 ? COEFFICIENT : DEFAULT_COEFFICIENT;
    }
}
