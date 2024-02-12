package com.mowitnow.mower.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mowitnow.mower.entites.Params;
import com.mowitnow.mower.parser.ParserMower;
import com.mowitnow.mower.processing.FormatLine;
import com.mowitnow.mower.processing.ProcessingMower;

public class Helper {

	public static List<String> runProcessLawnmower(File fichier) throws ExceptionMower, IOException {
		if (!fichier.isFile()) {
			throw new ExceptionMower(Params.NON_EXISTENT_FILE_ERROR);
		} else {
			ParserMower parser = new ParserMower();
			Scanner scanner = new Scanner(fichier);
			try {
				processFirstLine(parser, scanner);
				return processNextLines(parser, scanner);
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
	}

	public static void processFirstLine(ParserMower parser, Scanner scanner) throws ExceptionMower {
		if (scanner.hasNext()) {
			parser.setPelouse(scanner.nextLine());
		}
		if (!scanner.hasNext()) {
			throw new ExceptionMower(Params.INCORRECT_DATA_ERROR);
		}
	}

	public static List<String> processNextLines(ParserMower parser, Scanner scanner) throws ExceptionMower {
		List<String> listePositions = new ArrayList<String>();
		while (scanner.hasNext()) {
			parser.setTondeuse(scanner.nextLine());

			if (scanner.hasNext()) {
				parser.setInstructions(scanner.nextLine());
				listePositions.add(parseAndLaunchProcessing(parser));
			} else {
				throw new ExceptionMower(Params.INCORRECT_DATA_ERROR);
			}
		}
		return listePositions;
	}

	public static String parseAndLaunchProcessing(ParserMower parser) throws ExceptionMower {
		if (!parser.executeParse()) {
			throw new ExceptionMower(Params.INCORRECT_DATA_ERROR);
		} else {
			ProcessingMower processing = new ProcessingMower();
			processing.setLawn(FormatLine.formatLineLawn(parser.getPelouse()));
			processing.setPositionMower(FormatLine.formatLineMower(parser.getTondeuse()));
			processing.setListeInstruction(FormatLine.formatLineInstruction(parser.getInstructions()));
			processing.executeInstructions();
			System.out.println(processing);
			return processing.toString();
		}
	}

}
