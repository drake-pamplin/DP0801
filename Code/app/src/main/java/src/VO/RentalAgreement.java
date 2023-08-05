package src.VO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class RentalAgreement {
    @Getter
    @Setter
    private int rentalAgreementChargeDays;
    
    @Getter
    @Setter
    private Date rentalAgreementCheckoutDate;

    @Getter
    @Setter
    private float rentalAgreementDailyRentalCharge;

    @Getter
    @Setter
    private float rentalAgreementDiscountAmount;
    
    @Getter
    @Setter
    private int rentalAgreementDiscountPercent;
    
    @Getter
    @Setter
    private Date rentalAgreementDueDate;

    @Getter
    @Setter
    private float rentalAgreementFinalCharge;

    @Getter
    @Setter
    private float rentalAgreementPreDiscountCharge;
    
    @Getter
    @Setter
    private int rentalAgreementRentalDays;
    
    @Getter
    @Setter
    private String rentalAgreementSerialNumber;

    @Getter
    @Setter
    private String rentalAgreementToolBrand;
    
    @Getter
    @Setter
    private String rentalAgreementToolCode;

    @Getter
    @Setter
    private String rentalAgreementToolType;
}
