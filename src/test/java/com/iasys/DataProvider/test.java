package com.iasys.DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Arrays;

public class test {

    @Test(dataProvider = "dp1")
    public void TestGoogle(String[] s) throws Exception {
        // Print the array contents using Arrays.toString()
        System.out.println(Arrays.toString(s)); // This prints the contents of the array as a readable string
        
        System.out.println(">>>>>>");
    }

    @DataProvider
    public String[][] dp1() {
        String[][] data = new String[][] {
            {"hyr","123","852","abcd"},
            {"pqr","456"},
            {"xyz","789","123654"}
        };
        return data;
    }
}