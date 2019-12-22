package com.bieganski.ox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TravisTest {
    @Test
    public void testFailThisTest(){
        Assert.fail("Fail this test. Travis will merge this?");
    }
}
