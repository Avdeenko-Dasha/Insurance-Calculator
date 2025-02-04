package com.company;

import com.company.risk.FireRiskType;
import com.company.risk.TheftRiskType;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PremiumCalculatorTest {
    PremiumCalculator premiumCalculator = new PremiumCalculator();
    PolicyCreator policyCreator = new PolicyCreator();

    @Test
    public void calculate() {
        PolicySubObject policySubObject1 = policyCreator.createPolicySubObject("test1", "500.0", new FireRiskType());
        PolicySubObject policySubObject2 = policyCreator.createPolicySubObject("test2", "102.51", new TheftRiskType());

        PolicyObject policyObject = policyCreator.createPolicyObject("test", policySubObject1, policySubObject2);

        Policy policy = policyCreator.createPolicy("TEST", Status.REGISTERED, policyObject);
        BigDecimal actual = premiumCalculator.calculate(policy);

        assertEquals(new BigDecimal("17.13"), actual);

        policySubObject1 = policyCreator.createPolicySubObject("test1", "100.00", new FireRiskType());
        policySubObject2 = policyCreator.createPolicySubObject("test2", "8.00", new TheftRiskType());

        policyObject = policyCreator.createPolicyObject("test", policySubObject1, policySubObject2);

        policy = policyCreator.createPolicy("TEST", Status.APPROVED, policyObject);
        actual = premiumCalculator.calculate(policy);

        assertEquals(new BigDecimal("2.28"), actual);
    }

}