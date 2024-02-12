package com.mowitnow.mower.main;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MowItNowApplication {

	public static List<String> listResultats;
	public static Helper helper;

	public static void main(String... args) throws ExceptionMower, IOException {
		if (args.length == 1) {
			File file = new File(args[0]);
			listResultats = Helper.runProcessLawnmower(file);
		} else {
			throw new IllegalArgumentException();
		}
	}

	

}
