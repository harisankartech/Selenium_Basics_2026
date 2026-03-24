package org.DDT_Practice;

import org.testng.annotations.Test;

public class DDTest {

    @Test(dataProvider = "getData",dataProviderClass = ExcelUtilities.class)
    public void ddt(String uname,String password){

        System.out.println(uname+"  "+password);
    }
}
