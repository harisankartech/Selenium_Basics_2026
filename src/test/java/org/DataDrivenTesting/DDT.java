package org.DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DDT {

    @DataProvider
    public Object[][] testdata(){
        return  new Object[][]{

                 new Object[]{"hari","allianz"},
                 new Object[]{"vikki","ibm"},
                 new Object[]{"naveen","ibs"}
        };

    };

    @Test(dataProvider = "getData",dataProviderClass = ExcelUtil.class)
   public void DataDrivenTest(String name,String company){

        System.out.println("name is"+ name+" "+ " and company is "+company);

   }
}
