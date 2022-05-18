package au.com.rainmore.input.cli;

import au.com.rainmore.actions.Action;
import au.com.rainmore.actions.Report;
import au.com.rainmore.domains.Robot;
import au.com.rainmore.input.StringToActionConvertor;

import java.util.Optional;
import java.util.Scanner;

public class CommandLine {

    private final Scanner scanner;

    private final StringToActionConvertor convertor;

    public CommandLine(Scanner scanner, StringToActionConvertor convertor) {
        this.scanner = scanner;
        this.convertor = convertor;
    }

    public void run(Robot robot) {
        boolean running = true;
        while (running) {
            processInputAction(robot);
        }
    }

    private void processInputAction(Robot robot) {
        String inputAction = scanner.nextLine();
        Optional<Action> action = Optional.ofNullable(convertor.convert(inputAction));
        if (action.isPresent()) {
            robot.act(action.get());

            if (action.get() instanceof Report) {
                quit();
            }
            else {
                processInputAction(robot);
            }
        }
    }

    private void quit() {
        scanner.close();
        System.exit(0);
    }

}
