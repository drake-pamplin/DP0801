package src.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import src.VO.RentalAgreement;
import src.VO.Tool;
import src.exception.InvalidArgException;
import src.repository.RentalRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.GregorianCalendar;

public class RentalServiceTest {
    RentalService rentalService;

    @Mock
    RentalRepository mockedRentalRepository;

    @Mock
    ToolService mockedToolService;
    
    @Before
    public void Setup() {
        mockedRentalRepository = mock(RentalRepository.class);
        mockedToolService = mock(ToolService.class);
    }

    @Test
    public void RentalService_PromptTestOne() throws InvalidArgException {
        rentalService = new RentalService(mockedRentalRepository, mockedToolService);
        InvalidArgException thrown = assertThrows(InvalidArgException.class,
        () -> rentalService.GenerateRentalAgreement(
            new GregorianCalendar(2015, 8, 3, 12, 55).getTime(),
            101, 
            5, 
            "JAKR"),
        "Expected InvalidArgException");
        assertTrue(thrown.getIssue().contains("Discount percent"));
    }

    @Test
    public void RentalService_PromptTestTwo() throws InvalidArgException {
        when(mockedToolService.GetToolByCode(anyString())).thenReturn(CreateLADW());
        doNothing().when(mockedRentalRepository).AddRentalAgreement(any());
        rentalService = new RentalService(mockedRentalRepository, mockedToolService);
        RentalAgreement returnedAgreement = rentalService.GenerateRentalAgreement(
            new GregorianCalendar(2020, 6, 2, 12, 55).getTime(),
            10, 
            3, 
            "LADW"
        );

        RentalAgreement testAgreement = CreatePromptTwoAgreement();

        assertEquals(testAgreement.getRentalAgreementChargeDays(), returnedAgreement.getRentalAgreementChargeDays());
        assertEquals(testAgreement.getRentalAgreementCheckoutDate(), returnedAgreement.getRentalAgreementCheckoutDate());
        assertEquals(testAgreement.getRentalAgreementDailyRentalCharge(), returnedAgreement.getRentalAgreementDailyRentalCharge());
        assertEquals(testAgreement.getRentalAgreementDiscountAmount(), returnedAgreement.getRentalAgreementDiscountAmount());
        assertEquals(testAgreement.getRentalAgreementDiscountPercent(), returnedAgreement.getRentalAgreementDiscountPercent());
        assertEquals(testAgreement.getRentalAgreementDueDate(), returnedAgreement.getRentalAgreementDueDate());
        assertEquals(testAgreement.getRentalAgreementFinalCharge(), returnedAgreement.getRentalAgreementFinalCharge());
        assertEquals(testAgreement.getRentalAgreementPreDiscountCharge(), returnedAgreement.getRentalAgreementPreDiscountCharge());
        assertEquals(testAgreement.getRentalAgreementRentalDays(), returnedAgreement.getRentalAgreementRentalDays());
        assertEquals(testAgreement.getRentalAgreementSerialNumber(), returnedAgreement.getRentalAgreementSerialNumber());
        assertEquals(testAgreement.getRentalAgreementToolBrand(), returnedAgreement.getRentalAgreementToolBrand());
        assertEquals(testAgreement.getRentalAgreementToolCode(), returnedAgreement.getRentalAgreementToolCode());
        assertEquals(testAgreement.getRentalAgreementToolType(), returnedAgreement.getRentalAgreementToolType());
    }

    @Test
    public void RentalService_PromptTestThree() throws InvalidArgException {
        when(mockedToolService.GetToolByCode(anyString())).thenReturn(CreateCHNS());
        doNothing().when(mockedRentalRepository).AddRentalAgreement(any());
        rentalService = new RentalService(mockedRentalRepository, mockedToolService);
        RentalAgreement returnedAgreement = rentalService.GenerateRentalAgreement(
            new GregorianCalendar(2015, 6, 2, 12, 55).getTime(),
            25, 
            5, 
            "CHNS"
        );

        RentalAgreement testAgreement = CreatePromptThreeAgreement();

        assertEquals(testAgreement.getRentalAgreementChargeDays(), returnedAgreement.getRentalAgreementChargeDays());
        assertEquals(testAgreement.getRentalAgreementCheckoutDate(), returnedAgreement.getRentalAgreementCheckoutDate());
        assertEquals(testAgreement.getRentalAgreementDailyRentalCharge(), returnedAgreement.getRentalAgreementDailyRentalCharge());
        assertEquals(testAgreement.getRentalAgreementDiscountAmount(), returnedAgreement.getRentalAgreementDiscountAmount());
        assertEquals(testAgreement.getRentalAgreementDiscountPercent(), returnedAgreement.getRentalAgreementDiscountPercent());
        assertEquals(testAgreement.getRentalAgreementDueDate(), returnedAgreement.getRentalAgreementDueDate());
        assertEquals(testAgreement.getRentalAgreementFinalCharge(), returnedAgreement.getRentalAgreementFinalCharge());
        assertEquals(testAgreement.getRentalAgreementPreDiscountCharge(), returnedAgreement.getRentalAgreementPreDiscountCharge());
        assertEquals(testAgreement.getRentalAgreementRentalDays(), returnedAgreement.getRentalAgreementRentalDays());
        assertEquals(testAgreement.getRentalAgreementSerialNumber(), returnedAgreement.getRentalAgreementSerialNumber());
        assertEquals(testAgreement.getRentalAgreementToolBrand(), returnedAgreement.getRentalAgreementToolBrand());
        assertEquals(testAgreement.getRentalAgreementToolCode(), returnedAgreement.getRentalAgreementToolCode());
        assertEquals(testAgreement.getRentalAgreementToolType(), returnedAgreement.getRentalAgreementToolType());
    }

    @Test
    public void RentalService_PromptTestFour() throws InvalidArgException {
        when(mockedToolService.GetToolByCode(anyString())).thenReturn(CreateJAKD());
        doNothing().when(mockedRentalRepository).AddRentalAgreement(any());
        rentalService = new RentalService(mockedRentalRepository, mockedToolService);
        RentalAgreement returnedAgreement = rentalService.GenerateRentalAgreement(
            new GregorianCalendar(2015, 8, 3, 12, 55).getTime(),
            0, 
            6, 
            "JAKD"
        );

        RentalAgreement testAgreement = CreatePromptFourAgreement();

        assertEquals(testAgreement.getRentalAgreementChargeDays(), returnedAgreement.getRentalAgreementChargeDays());
        assertEquals(testAgreement.getRentalAgreementCheckoutDate(), returnedAgreement.getRentalAgreementCheckoutDate());
        assertEquals(testAgreement.getRentalAgreementDailyRentalCharge(), returnedAgreement.getRentalAgreementDailyRentalCharge());
        assertEquals(testAgreement.getRentalAgreementDiscountAmount(), returnedAgreement.getRentalAgreementDiscountAmount());
        assertEquals(testAgreement.getRentalAgreementDiscountPercent(), returnedAgreement.getRentalAgreementDiscountPercent());
        assertEquals(testAgreement.getRentalAgreementDueDate(), returnedAgreement.getRentalAgreementDueDate());
        assertEquals(testAgreement.getRentalAgreementFinalCharge(), returnedAgreement.getRentalAgreementFinalCharge());
        assertEquals(testAgreement.getRentalAgreementPreDiscountCharge(), returnedAgreement.getRentalAgreementPreDiscountCharge());
        assertEquals(testAgreement.getRentalAgreementRentalDays(), returnedAgreement.getRentalAgreementRentalDays());
        assertEquals(testAgreement.getRentalAgreementSerialNumber(), returnedAgreement.getRentalAgreementSerialNumber());
        assertEquals(testAgreement.getRentalAgreementToolBrand(), returnedAgreement.getRentalAgreementToolBrand());
        assertEquals(testAgreement.getRentalAgreementToolCode(), returnedAgreement.getRentalAgreementToolCode());
        assertEquals(testAgreement.getRentalAgreementToolType(), returnedAgreement.getRentalAgreementToolType());
    }
    
    @Test
    public void RentalService_PromptTestFive() throws InvalidArgException {
        when(mockedToolService.GetToolByCode(anyString())).thenReturn(CreateJAKR());
        doNothing().when(mockedRentalRepository).AddRentalAgreement(any());
        rentalService = new RentalService(mockedRentalRepository, mockedToolService);
        RentalAgreement returnedAgreement = rentalService.GenerateRentalAgreement(
            new GregorianCalendar(2015, 6, 2, 12, 55).getTime(),
            0, 
            9, 
            "JAKR"
        );

        RentalAgreement testAgreement = CreatePromptFiveAgreement();

        assertEquals(testAgreement.getRentalAgreementChargeDays(), returnedAgreement.getRentalAgreementChargeDays());
        assertEquals(testAgreement.getRentalAgreementCheckoutDate(), returnedAgreement.getRentalAgreementCheckoutDate());
        assertEquals(testAgreement.getRentalAgreementDailyRentalCharge(), returnedAgreement.getRentalAgreementDailyRentalCharge());
        assertEquals(testAgreement.getRentalAgreementDiscountAmount(), returnedAgreement.getRentalAgreementDiscountAmount());
        assertEquals(testAgreement.getRentalAgreementDiscountPercent(), returnedAgreement.getRentalAgreementDiscountPercent());
        assertEquals(testAgreement.getRentalAgreementDueDate(), returnedAgreement.getRentalAgreementDueDate());
        assertEquals(testAgreement.getRentalAgreementFinalCharge(), returnedAgreement.getRentalAgreementFinalCharge());
        assertEquals(testAgreement.getRentalAgreementPreDiscountCharge(), returnedAgreement.getRentalAgreementPreDiscountCharge());
        assertEquals(testAgreement.getRentalAgreementRentalDays(), returnedAgreement.getRentalAgreementRentalDays());
        assertEquals(testAgreement.getRentalAgreementSerialNumber(), returnedAgreement.getRentalAgreementSerialNumber());
        assertEquals(testAgreement.getRentalAgreementToolBrand(), returnedAgreement.getRentalAgreementToolBrand());
        assertEquals(testAgreement.getRentalAgreementToolCode(), returnedAgreement.getRentalAgreementToolCode());
        assertEquals(testAgreement.getRentalAgreementToolType(), returnedAgreement.getRentalAgreementToolType());
    }

    @Test
    public void RentalService_PromptTestSix() throws InvalidArgException {
        when(mockedToolService.GetToolByCode(anyString())).thenReturn(CreateJAKR());
        doNothing().when(mockedRentalRepository).AddRentalAgreement(any());
        rentalService = new RentalService(mockedRentalRepository, mockedToolService);
        RentalAgreement returnedAgreement = rentalService.GenerateRentalAgreement(
            new GregorianCalendar(2020, 6, 2, 12, 55).getTime(),
            50, 
            4, 
            "JAKR"
        );

        RentalAgreement testAgreement = CreatePromptSixAgreement();

        assertEquals(testAgreement.getRentalAgreementChargeDays(), returnedAgreement.getRentalAgreementChargeDays());
        assertEquals(testAgreement.getRentalAgreementCheckoutDate(), returnedAgreement.getRentalAgreementCheckoutDate());
        assertEquals(testAgreement.getRentalAgreementDailyRentalCharge(), returnedAgreement.getRentalAgreementDailyRentalCharge());
        assertEquals(testAgreement.getRentalAgreementDiscountAmount(), returnedAgreement.getRentalAgreementDiscountAmount());
        assertEquals(testAgreement.getRentalAgreementDiscountPercent(), returnedAgreement.getRentalAgreementDiscountPercent());
        assertEquals(testAgreement.getRentalAgreementDueDate(), returnedAgreement.getRentalAgreementDueDate());
        assertEquals(testAgreement.getRentalAgreementFinalCharge(), returnedAgreement.getRentalAgreementFinalCharge());
        assertEquals(testAgreement.getRentalAgreementPreDiscountCharge(), returnedAgreement.getRentalAgreementPreDiscountCharge());
        assertEquals(testAgreement.getRentalAgreementRentalDays(), returnedAgreement.getRentalAgreementRentalDays());
        assertEquals(testAgreement.getRentalAgreementSerialNumber(), returnedAgreement.getRentalAgreementSerialNumber());
        assertEquals(testAgreement.getRentalAgreementToolBrand(), returnedAgreement.getRentalAgreementToolBrand());
        assertEquals(testAgreement.getRentalAgreementToolCode(), returnedAgreement.getRentalAgreementToolCode());
        assertEquals(testAgreement.getRentalAgreementToolType(), returnedAgreement.getRentalAgreementToolType());
    }

    @Test
    public void RentalService_NoRentalDaysThrowsException() {
        rentalService = new RentalService(mockedRentalRepository, mockedToolService);
        InvalidArgException thrown = assertThrows(InvalidArgException.class,
        () -> rentalService.GenerateRentalAgreement(
            new GregorianCalendar(2015, 8, 3, 12, 55).getTime(),
            0, 
            0, 
            "JAKR"),
        "Expected InvalidArgException");
        assertTrue(thrown.getIssue().contains("Rental days"));
    }

    @Test
    public void RentalService_InvalidToolCodeThrowsException() throws InvalidArgException {
        when(mockedToolService.GetToolByCode(anyString())).thenThrow(InvalidArgException.class);
        rentalService = new RentalService(mockedRentalRepository, mockedToolService);
        InvalidArgException thrown = assertThrows(InvalidArgException.class,
        () -> rentalService.GenerateRentalAgreement(
            new GregorianCalendar(2015, 8, 3, 12, 55).getTime(),
            0, 
            5, 
            "Bad tool code"),
        "Expected InvalidArgException");
        assertTrue(thrown.getIssue().contains("Tool Code"));
    }

    private Tool CreateCHNS() {
        Tool tool = new Tool(
            true,
            false,
            "CHNS", 
            1.49f, 
            "Chainsaw", 
            "Stihl"
        );

        return tool;
    }

    private Tool CreateLADW() {
        Tool tool = new Tool(
            false,
            true,
            "LADW", 
            1.99f, 
            "Ladder", 
            "Werner"
        );

        return tool;
    }

    private Tool CreateJAKD() {
        Tool tool = new Tool(
            false,
            false,
            "JAKD", 
            2.99f, 
            "Jackhammer", 
            "DeWalt"
        );

        return tool;
    }
    
    private Tool CreateJAKR() {
        Tool tool = new Tool(
            false,
            false,
            "JAKR", 
            2.99f, 
            "Jackhammer", 
            "Ridgid"
        );

        return tool;
    }

    private RentalAgreement CreatePromptTwoAgreement() {
        RentalAgreement rentalAgreement = new RentalAgreement(
            2,
            new GregorianCalendar(2020, 6, 2, 12, 55).getTime(), 
            1.99f,
            0.40f,
            10, 
            new GregorianCalendar(2020, 6, 5, 12, 55).getTime(), 
            3.58f, 
            3.98f, 
            3, 
            "20207212550", 
            "Werner", 
            "LADW", 
            "Ladder"
        );
        return rentalAgreement;
    }

    private RentalAgreement CreatePromptThreeAgreement() {
        RentalAgreement rentalAgreement = new RentalAgreement(
            3,
            new GregorianCalendar(2015, 6, 2, 12, 55).getTime(), 
            1.49f,
            1.12f,
            25, 
            new GregorianCalendar(2015, 6, 7, 12, 55).getTime(), 
            3.35f, 
            4.47f, 
            5, 
            "20157212550", 
            "Stihl", 
            "CHNS", 
            "Chainsaw"
        );
        return rentalAgreement;
    }

    private RentalAgreement CreatePromptFourAgreement() {
        RentalAgreement rentalAgreement = new RentalAgreement(
            3,
            new GregorianCalendar(2015, 8, 3, 12, 55).getTime(), 
            2.99f,
            0.00f,
            0, 
            new GregorianCalendar(2015, 8, 9, 12, 55).getTime(), 
            8.97f, 
            8.97f, 
            6, 
            "20159312550", 
            "DeWalt", 
            "JAKD", 
            "Jackhammer"
        );
        return rentalAgreement;
    }

    private RentalAgreement CreatePromptFiveAgreement() {
        RentalAgreement rentalAgreement = new RentalAgreement(
            5,
            new GregorianCalendar(2015, 6, 2, 12, 55).getTime(), 
            2.99f,
            0.00f,
            0, 
            new GregorianCalendar(2015, 6, 11, 12, 55).getTime(), 
            14.95f, 
            14.95f, 
            9, 
            "20157212550", 
            "Ridgid", 
            "JAKR", 
            "Jackhammer"
        );
        return rentalAgreement;
    }

    private RentalAgreement CreatePromptSixAgreement() {
        RentalAgreement rentalAgreement = new RentalAgreement(
            1,
            new GregorianCalendar(2020, 6, 2, 12, 55).getTime(), 
            2.99f,
            1.50f,
            50, 
            new GregorianCalendar(2020, 6, 6, 12, 55).getTime(), 
            1.49f, 
            2.99f, 
            4, 
            "20207212550", 
            "Ridgid", 
            "JAKR", 
            "Jackhammer"
        );
        return rentalAgreement;
    }
}
