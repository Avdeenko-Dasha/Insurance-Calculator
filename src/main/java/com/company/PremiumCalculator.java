package com.company;

import com.company.risk.RiskType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.math.RoundingMode;

public class PremiumCalculator {
    private final int SCALE = 2;

    public BigDecimal calculate(Policy policy) {
        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policy.getPolicyObjects().forEach(policyObject -> policySubObjects.addAll(policyObject.getPolicySubObjects()));

        Set<RiskType> riskTypes = policySubObjects.stream().map(PolicySubObject::getRiskType).collect(Collectors.toSet());
        BigDecimal premium = BigDecimal.ZERO;

        for (RiskType riskType: riskTypes) {
            BigDecimal sumInsured = BigDecimal.ZERO;

            for(PolicySubObject policySubObject : policySubObjects) {
                if (!policySubObject.getRiskType().equals(riskType)) continue;

                sumInsured = sumInsured.add(policySubObject.getSum());
            }

            premium = premium.add(sumInsured.multiply(riskType.getCoefficient(sumInsured)));
        }

        return premium.setScale(SCALE, RoundingMode.HALF_UP);
    }
}
