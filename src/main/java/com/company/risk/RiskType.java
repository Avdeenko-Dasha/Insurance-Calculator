package com.company.risk;

import java.math.BigDecimal;

public interface RiskType {
    BigDecimal getCoefficient(BigDecimal sumInsured);
}
