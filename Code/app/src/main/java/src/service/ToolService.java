package src.service;

import src.VO.Tool;

public class ToolService {
    private static ToolService instance = null;
    public static ToolService GetInstance() {
        if (instance == null) {
            instance = new ToolService();
        }
        return instance;
    }

    private ToolService() {

    }

    public Tool GetToolByCode(String toolCode) {
        return null;
    }
}
