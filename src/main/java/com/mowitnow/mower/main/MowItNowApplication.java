package com.mowitnow.mower.main;

import com.mowitnow.mower.model.Params;
import com.mowitnow.mower.parser.ParserMower;
import com.mowitnow.mower.processing.FormatLine;
import com.mowitnow.mower.processing.ProcessingMower;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MowItNowApplication {

    public static List<String> listResults;
    private static Integer nbMower = 0;

    public static void main(String... args) throws ExceptionMower, IOException {
        if (args.length == 1) {
            File file = new File(args[0]);
            listResults = runProcessLawnmower(file);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> runProcessLawnmower(File file) throws ExceptionMower, IOException {
        if (!file.isFile()) {
            throw new ExceptionMower(Params.NON_EXISTENT_FILE_ERROR);
        } else {
            ParserMower parser = new ParserMower();
            try (Scanner scanner = new Scanner(file)) {
                processFirstLine(parser, scanner);
                return processNextLines(parser, scanner);
            }
        }
    }

    public static void processFirstLine(ParserMower parser, Scanner scanner) throws ExceptionMower {
        if (scanner.hasNext()) {
            parser.setLawn(scanner.nextLine());
        }
        if (!scanner.hasNext()) {
            throw new ExceptionMower(Params.INCORRECT_DATA_ERROR);
        }
    }

    public static List<String> processNextLines(ParserMower parser, Scanner scanner) throws ExceptionMower {
        List<String> listPositions = new ArrayList<>();
        while (scanner.hasNext()) {
            parser.setMower(scanner.nextLine());
            if (scanner.hasNext()) {
                parser.setInstructions(scanner.nextLine());
                listPositions.add(parseAndLaunchProcessing(parser));
            } else {
                throw new ExceptionMower(Params.INCORRECT_DATA_ERROR);
            }
        }
        return listPositions;
    }

    public static String parseAndLaunchProcessing(ParserMower parser) throws ExceptionMower {
        if (!parser.executeParse()) {
            throw new ExceptionMower(Params.INCORRECT_DATA_ERROR);
        } else {
            if (nbMower <= 0)
                System.out.println("\nThe coordinates which correspond to the upper right corner of the lawn are as follows: " + parser.getLawn());

            nbMower++;

            ProcessingMower processing = new ProcessingMower();
            processing.setLawn(FormatLine.formatLineLawn(parser.getLawn()));
            System.out.println("\nI am the mower with the number : " + nbMower);
            processing.setPositionMower(FormatLine.formatLineMower(parser.getMower()));
            System.out.println("My initial position is as follows : " + parser.getMower());
            processing.setListInstruction(FormatLine.formatLineInstruction(parser.getInstructions()));
            System.out.println("I will move like this : " + parser.getInstructions());
            processing.executeInstructions();
            System.out.println("After executing the instructions above, I am at the position : " + processing + "\n");
            return processing.toString();
        }
    }
}
