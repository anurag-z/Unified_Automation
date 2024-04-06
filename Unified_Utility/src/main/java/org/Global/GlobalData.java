package org.Global;

import java.util.Properties;

public class GlobalData {


    public static final String Listeners= System.getProperty("Listeners","org.Listeners.SuiteListeners");
    public static final String group= System.getProperty("group","");
    public static final String packg= System.getProperty("package","");
    public static final String Type= System.getProperty("Type","classes");
    public static final String platform= System.getProperty("platform","api");
    public static final String ENV = System.getProperty("env", "Qa");
    public static final String execution = System.getProperty("execution", "local");
    public static Properties envConfig;




    public static final class grouping{

        public static final String login= "login";
    }


}

