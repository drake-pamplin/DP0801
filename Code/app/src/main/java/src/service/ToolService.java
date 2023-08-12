package src.service;

import java.util.List;

import src.VO.Tool;
import src.exception.InvalidArgException;
import src.repository.ToolRepository;
import src.utils.Constants;

public class ToolService {
    public ToolService(ToolRepository toolRepository) {
        this.toolRepository = toolRepository;
    }

    private ToolRepository toolRepository;

    public Tool GetToolByCode(String toolCode) throws InvalidArgException {
        Tool tool = null;
        tool = toolRepository.GetToolByCode(toolCode);

        if (tool == null) {
            String errorMessage = String.format(Constants.exceptionMessageInvalidArg, Constants.fieldToolCode, toolCode);
            throw new InvalidArgException(Constants.exceptionMessageInvalidArgGeneric, Constants.fieldToolCode, errorMessage);
        }
        
        return tool;
    }

    public List<Tool> GetTools() {
        return toolRepository.GetTools();
    }
}
