/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package src;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import src.VO.Tool;
import src.repository.ToolRepository;
import src.service.HelpService;
import src.service.RentalService;
import src.utils.Constants;

public class App {
    ToolRepository toolRepository = ToolRepository.GetInstance();

    HelpService helpService = HelpService.GetInstance();
    RentalService rentalService = RentalService.GetInstance();
    
    String outputString = "";
    
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        App app = new App();

        Scanner scanner = new Scanner(System.in);
        try {
            app.ClearScreen();

            while (true) {
                // Request a command.
                System.out.println(String.format(Constants.fieldHelpHint, Constants.commandHelp) + "\nPlease input a command to be echoed: ");
                String input = scanner.nextLine();
                app.ClearScreen();
                app.ParseInput(input);

                if (app.outputString != null && !app.outputString.isEmpty()) {
                    System.out.println(app.outputString);
                    app.outputString = "";
                }

                app.PrintBreak();
            }
        } catch (IllegalStateException | NoSuchElementException | InterruptedException | IOException e) {
            System.out.println("Input failure. Exiting application. Message: " + e.getMessage());
        }
    }

    // Clears the console when called.
    private void ClearScreen() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    
    // Parses user input and directs the command appropriately.
    private void ParseInput(String input) {
        switch (input.toLowerCase()) {
            case Constants.testValue:
                outputString += "Test output received.";
                break;
            case Constants.commandHelp:
                ProcessHelpCommand();    
            break;
            case Constants.commandQuit:  
                System.exit(0);
                break;
            case Constants.commandTools:
                ProcessToolsList();
                break;
            default:
                outputString += String.format("Input was: \"%s\".\n", input);
                break;
        }
    }

    // Adds a line break for easier visual parsing.
    private void PrintBreak() {
        System.out.println("\n");
    }

    // Process the help command.
    private void ProcessHelpCommand() {
        outputString += helpService.getCommandList();
    }
    
    // Process the list tools command.
    private void ProcessToolsList() {
        String output = "Tool Code | Tool Type | Tool Brand";
        for (Tool tool : toolRepository.GetTools()) {
            output += String.format("\n%s | %s | %s", tool.getToolCode(), tool.getToolType(), tool.getToolBrand());
        }
        
        outputString += output;
    }
}
