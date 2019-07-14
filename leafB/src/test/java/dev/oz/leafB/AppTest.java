package dev.oz.leafB;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AppTest
{
    @Test
    public void test()
    {
        System.out.println(App.getNode());
        assertNotNull(App.getNode());
    }
}
