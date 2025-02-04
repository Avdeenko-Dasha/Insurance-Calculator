package com.company.test;

import com.company.*;
import com.company.risk.FireRiskType;
import com.company.risk.TheftRiskType;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PremiumCalculatorTest {
    PremiumCalculator premiumCalculator = new PremiumCalculator();
    final double DELTA = 0.01;
    @Test
    public void calculate() {
        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(new PolicySubObject("test1", new BigDecimal(500.0), new FireRiskType()));
        policySubObjects.add(new PolicySubObject("test2", new BigDecimal(102.51), new TheftRiskType()));

        List<PolicyObject> policyObjects = new ArrayList<>();
        policyObjects.add(new PolicyObject("test", policySubObjects));

        Policy policy = new Policy("TEST", Status.REGISTERED, policyObjects);

        BigDecimal actual = premiumCalculator.calculate(policy);

        assertEquals(17.125, actual.doubleValue() , DELTA);
    }
}