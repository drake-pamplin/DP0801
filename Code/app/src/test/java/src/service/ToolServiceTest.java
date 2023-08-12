package src.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import src.VO.Tool;
import src.exception.InvalidArgException;
import src.repository.ToolRepository;

public class ToolServiceTest {
    @Mock
    ToolRepository mockedToolRepository;

    @Before
    public void Setup() {
        mockedToolRepository = mock(ToolRepository.class);
    }

    @Test
    public void ToolService_ToolRetrievedByCode() throws InvalidArgException {
        when(mockedToolRepository.GetToolByCode(anyString())).thenReturn(CreateCHNS());
        ToolService toolService = new ToolService(mockedToolRepository);
        Tool tool = toolService.GetToolByCode("CHNS");

        assertEquals(true, tool.getToolChargeHoliday());
        assertEquals(false, tool.getToolChargeWeekend());
        assertEquals("CHNS", tool.getToolCode());
        assertEquals(1.49f, tool.getToolDailyCharge());
        assertEquals("Chainsaw", tool.getToolType());
        assertEquals("Stihl", tool.getToolBrand());
    }

    @Test 
    public void ToolService_InvalidToolCodeThrowsException() {
        when(mockedToolRepository.GetToolByCode(anyString())).thenReturn(null);
        ToolService toolService = new ToolService(mockedToolRepository);
        InvalidArgException thrown = assertThrows(
            InvalidArgException.class,
            () -> toolService.GetToolByCode("CHNS"),
            "Expected InvalidArgException"
        );
        assertTrue(thrown.getIssue().contains("Tool Code"));
    }

    @Test
    public void ToolService_ToolListIsRetrieved() {
        when(mockedToolRepository.GetTools()).thenReturn(CreateListOfTools());
        ToolService toolService = new ToolService(mockedToolRepository);
        List<Tool> returnedList = toolService.GetTools();
        assertEquals(1, returnedList.size());
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

    private List<Tool> CreateListOfTools() {
        Tool tool = CreateCHNS();
        List<Tool> toolList = Arrays.asList(new Tool[] { tool });
        return toolList;
    }
}
