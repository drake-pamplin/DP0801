package src.repository;

import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import src.VO.RentalAgreement;
import static org.junit.jupiter.api.Assertions.*;

public class RentalRepositoryTest {
    RentalRepository repository;
    
    @Before
    public void Setup() {
        repository = new RentalRepository();
    }
    
    @Test
    public void RentalRepository_AgreementIsAdded() {
        RentalAgreement rentalAgreement = CreateTestRentalAgreement();
        assertDoesNotThrow(() -> repository.AddRentalAgreement(rentalAgreement));
    }

    @Test
    public void RentalRepository_AgreementIsRetrieved() {
        RentalAgreement rentalAgreement = CreateTestRentalAgreement();
        repository.AddRentalAgreement(rentalAgreement);
        RentalAgreement returnedAgreement = repository.GetRentalAgreementBySerialNumber(rentalAgreement.getRentalAgreementSerialNumber());

        assertEquals(rentalAgreement.getRentalAgreementChargeDays(), returnedAgreement.getRentalAgreementChargeDays());
        assertEquals(rentalAgreement.getRentalAgreementCheckoutDate(), returnedAgreement.getRentalAgreementCheckoutDate());
        assertEquals(rentalAgreement.getRentalAgreementDailyRentalCharge(), returnedAgreement.getRentalAgreementDailyRentalCharge());
        assertEquals(rentalAgreement.getRentalAgreementDiscountAmount(), returnedAgreement.getRentalAgreementDiscountAmount());
        assertEquals(rentalAgreement.getRentalAgreementDiscountPercent(), returnedAgreement.getRentalAgreementDiscountPercent());
        assertEquals(rentalAgreement.getRentalAgreementDueDate(), returnedAgreement.getRentalAgreementDueDate());
        assertEquals(rentalAgreement.getRentalAgreementFinalCharge(), returnedAgreement.getRentalAgreementFinalCharge());
        assertEquals(rentalAgreement.getRentalAgreementPreDiscountCharge(), returnedAgreement.getRentalAgreementPreDiscountCharge());
        assertEquals(rentalAgreement.getRentalAgreementRentalDays(), returnedAgreement.getRentalAgreementRentalDays());
        assertEquals(rentalAgreement.getRentalAgreementSerialNumber(), returnedAgreement.getRentalAgreementSerialNumber());
        assertEquals(rentalAgreement.getRentalAgreementToolBrand(), returnedAgreement.getRentalAgreementToolBrand());
        assertEquals(rentalAgreement.getRentalAgreementToolCode(), returnedAgreement.getRentalAgreementToolCode());
        assertEquals(rentalAgreement.getRentalAgreementToolType(), returnedAgreement.getRentalAgreementToolType());
    }

    @Test
    public void RentalRepository_SerialNumbersAreRetrieved() {
        RentalAgreement rentalAgreement = CreateTestRentalAgreement();
        repository.AddRentalAgreement(rentalAgreement);
        List<String> serialNumberList = repository.GetRentalAgreementSerialNumbers();

        assertEquals(1, serialNumberList.size());
        assertEquals(rentalAgreement.getRentalAgreementSerialNumber(), serialNumberList.get(0));
    }

    private RentalAgreement CreateTestRentalAgreement() {
        RentalAgreement rentalAgreement = new RentalAgreement(
            1, 
            new GregorianCalendar(2021, 6, 1).getTime(),
            1.99f, 
            0.99f, 
            10,
            new GregorianCalendar(2021, 6, 2).getTime(), 
            1.00f, 
            0.99f, 
            1, 
            "202161000", 
            "Stihl", 
            "CHNS", 
            "Ladder"
        );
        return rentalAgreement;
    }
}
