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
    public List<String> GetRentalAgreementSerialNumbers() {
        List<String> serialNumbers = new ArrayList<>();
        
        rentalAgreementLibrary.forEach((key, value) -> {
            serialNumbers.add(key);
        });

        return serialNumbers;
    }
}
