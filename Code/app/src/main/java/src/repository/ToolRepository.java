package src.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import src.VO.Tool;
import src.utils.Constants;

public class ToolRepository {
    public ToolRepository() {
        toolLibrary = new HashMap<>();
        for (int toolIndex = 0; toolIndex < Constants.toolBrands.size(); toolIndex++) {
            Tool newTool = new Tool(
                Constants.toolChargeHoliday.get(toolIndex),
                Constants.toolChargeWeekend.get(toolIndex),
                Constants.toolCodes.get(toolIndex),
                Constants.toolDailyCharges.get(toolIndex),
                Constants.toolTypes.get(toolIndex),
                Constants.toolBrands.get(toolIndex)
            );
            toolLibrary.put(newTool.getToolCode(), newTool);
        }
    }
    
    private Map<String, Tool> toolLibrary;
    
    public Tool GetToolByCode(String toolCode) throws NullPointerException {
        Tool tool = toolLibrary.get(toolCode);

        return tool;
    }

    public List<Tool> GetTools() {
        List<Tool> tools = new ArrayList<>(toolLibrary.values());
        return tools;
    }
}
