package org.TestngCreation;


import org.apache.commons.io.FileUtils;
import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.Global.*;

import static org.Global.GlobalData.*;

public class TestngXmlCreation {

    public static  final String tested= System.getProperty("tested","");

    public void createfile(String suitsename,String type,String listeners,String testname,String groups,String typeoftest) throws Exception {

        XmlSuite suite = new XmlSuite();
        suite.setName(suitsename);

        List<String> ls = Arrays.asList(listeners);
        suite.setListeners(ls);

        XmlTest test = new XmlTest (suite);
        test.setName ("_Instance_"+1);
        test.setPreserveOrder(Boolean.valueOf("false"));
        test.setThreadCount(3);

        switch (type) {
            case "classes":
                this.classes(typeoftest,test);
                break;

            case "package":
                this.packages(typeoftest,test,groups);
                break;


        }
      /*  XmlClass testClass = new XmlClass();
            testClass.setName ("temp");
        test.setXmlClasses (Arrays.asList (new XmlClass[] { testClass}));*/

        // Add groups to test
        // XmlGroups groups = new XmlGroups();
        //  String[] groups= {"asdas","as"};
  /*  if(!(groups.isEmpty()))
    {
        String[] g = groups.split(",");
        test.setIncludedGroups(new ArrayList<>(Arrays.asList(g)));
    }
        pckg.split(",");
        List<XmlPackage> packages;
        packages = new ArrayList<>();
        for (String temp : pckg.split(":"))
        {
            packages.add(new XmlPackage(temp));
        }
     //packages.add(new XmlPackage("testing" + ".*"));
        test.setPackages(packages);*/
        TestNG testNG = new TestNG();
        testNG.setTestSuites(createTestSuiteXML(suite,System.getProperty("user.dir")+"\\src\\EappTestNG.xml"));
        testNG.run();

    }
    private List<String>  createTestSuiteXML(XmlSuite suite,String createTestNGPath) throws Exception
    {
        List<String> suites = new ArrayList<String>();

        File f = FileUtils.getFile(createTestNGPath);
        if(f.exists())
            f.delete();
        f.createNewFile();
        FileUtils.writeByteArrayToFile(f, suite.toXml().getBytes());
        suites.add(f.getPath());

        return suites;
    }



    public void classes(String clas,XmlTest test)
    {
        String[] clasarray= clas.split(":");
        XmlClass testClass = new XmlClass();
        for ( String classname: clasarray)
        {
            testClass.setName("org."+classname);
        }

        //   testClass.setName ("temp");
        test.setXmlClasses (Arrays.asList (new XmlClass[] { testClass}));


    }

    public void packages(String pckg,XmlTest test,String groups)
    {

        if(!(groups.isEmpty()))
        {
            String[] g = groups.split(",");
            test.setIncludedGroups(new ArrayList<>(Arrays.asList(g)));
        }
        pckg.split(",");
        List<XmlPackage> packages;
        packages = new ArrayList<>();
        for (String temp : pckg.split(":"))
        {
            packages.add(new XmlPackage(temp));
        }

        test.setPackages(packages);
    }



    public static void main(String[] args) throws Exception {
        TestngXmlCreation txc= new TestngXmlCreation();
        System.out.println(packg);
        // txc.createfile("Tests",Type,Listeners,"",group,packg);
      //    txc.createfile("Tests","package",Listeners,"",group,"org.Testcases");


    }

}
