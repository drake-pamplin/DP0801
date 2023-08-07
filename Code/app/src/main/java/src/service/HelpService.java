package src.service;

import lombok.Getter;
import src.utils.Constants;

public class HelpService {
    private static HelpService instance = null;
    public static HelpService GetInstance() {
        if (instance == null) {
            instance = new HelpService();
        }
        return instance;
    }

    private HelpService() {
        commandList = String.format(
            Constants.fieldCommandsListBase,
            Constants.commandTools,
            Constants.commandRent,
            Constants.commandRentals,
            Constants.commandLookup,
            Constants.commandQuit
        );
    }

    @Getter
    private String commandList;
}
