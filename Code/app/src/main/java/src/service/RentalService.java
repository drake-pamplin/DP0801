package src.service;

import java.util.Calendar;
import java.util.Date;

import src.VO.RentalAgreement;
import src.VO.Tool;

public class RentalService {
    private static RentalService instance = null;
    public static RentalService GetInstance() {
        if (instance == null) {
            instance = new RentalService();
        }
        return instance;
    }

    private RentalService() {

    }

    private ToolService toolService = ToolService.GetInstance();

    // Generates new rental agreement and returns the serial number.
    private RentalAgreement CreateNewRentalAgreement(
        int rentalAgreementChargeDays,
        Date rentalAgreementCheckoutDate,
        float rentalAgreementDailyRentalCharge,
        float rentalAgreementDiscountAmount,
        int rentalAgreementDiscountPercent,
        Date rentalAgreementDueDate,
        float rentalAgreementFinalCharge,
        float rentalAgreementPreDiscountCharge,
        int rentalAgreementRentalDays,
        String rentalAgreementToolBrand,
        String rentalAgreementToolCode,
        String rentalAgreementToolType
    ) {
        // Generate unique serial number based on time.
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(rentalAgreementCheckoutDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        String rentalAgreementSerialNumber = String.format("%s%s%s%s%s%s",
            year, month, day, hour, minute, second
        );
        
        RentalAgreement rentalAgreement = new RentalAgreement(
            rentalAgreementChargeDays,
            rentalAgreementCheckoutDate,
            rentalAgreementDailyRentalCharge,
            rentalAgreementDiscountAmount,
            rentalAgreementDiscountPercent,
            rentalAgreementDueDate,
            rentalAgreementFinalCharge,
            rentalAgreementPreDiscountCharge,
            rentalAgreementRentalDays,
            rentalAgreementSerialNumber,
            rentalAgreementToolBrand,
            rentalAgreementToolCode,
            rentalAgreementToolType
        );
        
        return rentalAgreement;
    }

    // Method to generate a new rental agreement.
    public String GenerateRentalAgreement(
        Date rentalAgreementCheckoutDate,
        int rentalAgreementDiscountPercent,
        int rentalAgreementRentalDays,
        String rentalAgreementToolCode
    ) {
        // Retrieved from tool.
        Tool tool = toolService.GetToolByCode(rentalAgreementToolCode);
        String rentalAgreementToolBrand = tool.getToolBrand();
        String rentalAgreementToolType = tool.getToolType();
        float rentalAgreementDailyRentalCharge = tool.getToolDailyCharge();
        
        // Subtract non-chargeable days from total day count.
        // Determine number of chargeable days in the rental duration.
        int rentalAgreementChargeDays;

        // Calucated from pre-discount charge * discount percent.
        // float rentalAgreementDiscountAmount;

        // Calculated from checkout date and rental days.
        // Date rentalAgreementDueDate;

        // Calculated from pre-discount charge - discount charge.
        // float rentalAgreementFinalCharge;

        // Calculated from number of charge days * the daily charge.
        // float rentalAgreementPreDiscountCharge;

        // Generated when creating the rental agreement.
        // String rentalAgreementSerialNumber;
        
        return "";
    }
    
    public RentalAgreement GetRentalAgreementBySerialNumber() {
        return null;
    }
    
    public String GetRentalAgreementsList() {
        return "";
    }
}
