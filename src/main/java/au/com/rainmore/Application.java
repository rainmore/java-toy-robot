package au.com.rainmore;

import au.com.rainmore.domains.Robot;
import au.com.rainmore.domains.Table;
import au.com.rainmore.input.StringToActionConvertor;
import au.com.rainmore.input.cli.CommandLine;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Table table = Table.of(5);
        Robot robot = Robot.of(table);

        CommandLine commandLine = new CommandLine(new Scanner(System.in), new StringToActionConvertor());
        commandLine.run(robot);
    }

}
