package src.service;

import src.VO.Tool;
import src.exception.InvalidArgException;
import src.repository.ToolRepository;
import src.utils.Constants;

public class ToolService {
    private static ToolService instance = null;
    public static ToolService GetInstance() {
        if (instance == null) {
            instance = new ToolService();
        }
        return instance;
    }

    private ToolService() {
        toolRepository = ToolRepository.GetInstance();
    }

    private ToolRepository toolRepository;

    public Tool GetToolByCode(String toolCode) throws InvalidArgException {
        Tool tool = null;

        try {
            toolRepository.GetToolByCode(toolCode);
        } catch (NullPointerException e) {
            String errorMessage = String.format(Constants.exceptionMessageInvalidArg, Constants.fieldToolCode, toolCode);
            throw new InvalidArgException(e.getMessage(), Constants.fieldToolCode, errorMessage);
        }
        
        return tool;
    }
}
