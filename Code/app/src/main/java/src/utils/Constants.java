package src.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String commandQuit = "quit";
    public static final String commandTools = "tools";

    public static final String exceptionMessageInvalidArg = "Field %s has no definition for value \"%s\"";

    public static final String fieldToolCode = "Tool Code";
    
    public static final String testValue = "test";

    public static List<String> toolBrands = Arrays.asList(new String[] {
        "Stihl",
        "Werner",
        "DeWalt",
        "Ridgid"
    });
    public static List<String> toolCodes = Arrays.asList(new String[] {
        "CHNS",
        "LADW",
        "JAKD",
        "JAKR"
    });
    public static List<String> toolTypes = Arrays.asList(new String[] {
        "Chainsaw",
        "Ladder",
        "Jackhammer",
        "Jackhammer"
    });
}
