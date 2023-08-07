package src.service;

import src.VO.RentalAgreement;

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

    public String GenerateRentalAgreement() {
        return "";
    }
    
    public RentalAgreement GetRentalAgreementBySerialNumber() {
        return null;
    }
    
    public String GetRentalAgreementsList() {
        return "";
    }
}
