package dev.oz.leafC;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AppTest
{
    @Test
    public void test()
    {
        System.out.println("node B: " + dev.oz.leafB.App.getNode());
        System.out.println(App.getNode());
        assertNotNull(App.getNode());
    }
}
