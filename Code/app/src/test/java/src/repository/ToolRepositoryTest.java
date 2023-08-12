package src.repository;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import src.VO.Tool;

public class ToolRepositoryTest {
    ToolRepository toolRepository;
    
    @Before
    public void Setup() {
        toolRepository = new ToolRepository();
    }

    @Test
    public void ToolRepository_ToolIsRetrievedByCode() {
        Tool chainsaw = toolRepository.GetToolByCode("CHNS");

        assertEquals(true, chainsaw.getToolChargeHoliday());
        assertEquals(false, chainsaw.getToolChargeWeekend());
        assertEquals("CHNS", chainsaw.getToolCode());
        assertEquals(1.49f, chainsaw.getToolDailyCharge());
        assertEquals("Chainsaw", chainsaw.getToolType());
        assertEquals("Stihl", chainsaw.getToolBrand());
    }

    @Test
    public void ToolRepository_ToolListIsRetrieved() {
        List<Tool> toolList = toolRepository.GetTools();

        assertEquals(4, toolList.size());
    }
}
