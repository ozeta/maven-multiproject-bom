package dev.oz;

import org.junit.Test;

public class AppTest
{
    @Test
    public void test()
    {
        String[] arr = { "", "" };

        dev.oz.App.main(arr);
        System.out.println("node C!");
    }
}
