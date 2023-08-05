package src.repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.VO.RentalAgreement;
import src.exception.InvalidArgException;
import src.utils.Constants;

public class RentalRepository {
    // Only one rental repository is allowed at one time.
    private static RentalRepository instance = null;
    public static RentalRepository GetInstance() {
        if (instance == null) {
            instance = new RentalRepository();
        }
        return instance;
    }

    private RentalRepository() {
        rentalAgreementLibrary = new HashMap<>();
    }

    private Map<String, RentalAgreement> rentalAgreementLibrary;

    // Generates new rental agreement and returns the serial number.
    public String CreateNewRentalAgreement(
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

        rentalAgreementLibrary.put(rentalAgreementSerialNumber, rentalAgreement);
        
        return rentalAgreementSerialNumber;
    }

    // Get a rental agreement by serial number.
    public RentalAgreement GetRentalAgreementBySerialNumber(String serialNumber) throws InvalidArgException {
        RentalAgreement rentalAgreement = null;

        try {
            rentalAgreement = rentalAgreementLibrary.get(serialNumber);
        } catch (NullPointerException e) {
            String errorMessage = String.format(Constants.exceptionMessageInvalidArg, Constants.fieldSerialNumber, serialNumber);
            throw new InvalidArgException(e.getMessage(), Constants.fieldSerialNumber, errorMessage);
        }

        return rentalAgreement;
    }

    // Get list of all rental agreement serial numbers.
    public List<String> GetRentalAgreements() {
        List<String> serialNumbers = new ArrayList<>();
        
        rentalAgreementLibrary.forEach((key, value) -> {
            serialNumbers.add(key);
        });

        return serialNumbers;
    }
}
