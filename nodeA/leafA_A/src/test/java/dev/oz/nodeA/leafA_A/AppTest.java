package dev.oz.nodeA.leafA_A;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AppTest
{
    @Test
    public void test()
    {
        System.out.println(App.getNode());
        assertNotNull(App.getNode());
    }
}
