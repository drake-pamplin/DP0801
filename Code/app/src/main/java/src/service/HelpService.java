package src.service;

import lombok.Getter;
import src.utils.Constants;

public class HelpService {
    public HelpService() {
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
