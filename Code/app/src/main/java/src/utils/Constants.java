package src.utils;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final String commandHelp = "help";
    public static final String commandLookup = "lookup";
    public static final String commandRent = "rent";
    public static final String commandRentals = "rentals";
    public static final String commandQuit = "quit";
    public static final String commandTools = "tools";

    public static final String exceptionMessageInvalidArg = "Field %s has no definition for value \"%s\"";
    public static final String exceptionMessageInvalidArgGeneric = "Argument invalid.";
    public static final String exceptionMessageInvalidDiscountPercent = "Discount percent must be 0-100.";
    public static final String exceptionMessageInvalidRentalDaysQuantity = "Rental days must be greater than 0.";
    public static final String exceptionMessageInvalidStringWords = "Input must have no spaces.";
    public static final String exceptionMessageInvalidToolCodeLength = "Tool code must be four characters.";
    public static final String exceptionMessageInvalidNumber = "Input must be a number.";
    public static final String exceptionMessageInvalidString = "Input must be a string.";

    public static final String fieldCommandsListBase = "Enter \"%s\" for a list of tools.\n" +
        "Enter \"%s\" to rent a tool.\n" +
        "Enter \"%s\" for a list of rental serial numbers.\n" +
        "Enter \"%s\" to find a particular rental agreement.\n" +
        "Enter \"%s\" to quit the application.";
    public static final String fieldDiscountPercent = "Discount Percent";
    public static final String fieldRentalDays = "Rental Days";
    public static final String fieldSerialNumber = "Serial Number";
    public static final String fieldToolCode = "Tool Code";

    public static final String messageHelpHint = "Enter \"%s\" for a list of commands.";
    public static final String messageRentalAgreementsEmpty = "No rental agreements have been made.";
    public static final String messageRentalAgreementSuccess = "Rental agreement created successfully! Serial number: %s";

    public static final String promptDiscountPercent = "Please enter the discount percent as a whole number (i.e. 15): ";
    public static final String promptRentalDays = "Please enter the number of rental days as a whole number (i.e. 4): ";
    public static final String promptSerialNumber = "Please enter the serial number of the rental agreement you wish to view: ";
    public static final String promptToolCode = "Please enter the tool code as a four digit string (i.e. CHNS): ";
    
    public static final String testValue = "test";

    public static List<Boolean> toolChargeHoliday = Arrays.asList(new Boolean[] {
        true,
        false,
        false,
        false
    });
    public static List<Boolean> toolChargeWeekend = Arrays.asList(new Boolean[] {
        false,
        true,
        false,
        false
    });
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
    public static List<Float> toolDailyCharges = Arrays.asList(new Float[] {
        1.49f,
        1.99f,
        2.99f,
        2.99f
    });
    public static List<String> toolTypes = Arrays.asList(new String[] {
        "Chainsaw",
        "Ladder",
        "Jackhammer",
        "Jackhammer"
    });
}
