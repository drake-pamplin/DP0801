package src.service;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import src.utils.Constants;

public class HelpServiceTest {
    HelpService helpService;
    
    @Before
    public void Setup() {
        helpService = new HelpService();
    }

    @Test
    public void HelpService_CommandListIsRetrieved() {
        String commandList = String.format(
            Constants.fieldCommandsListBase,
            Constants.commandTools,
            Constants.commandRent,
            Constants.commandRentals,
            Constants.commandLookup,
            Constants.commandQuit
        );

        String returnedList = helpService.getCommandList();

        assertEquals(commandList, returnedList);
    }
}
