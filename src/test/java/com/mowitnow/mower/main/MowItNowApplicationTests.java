package com.mowitnow.mower.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.mowitnow.mower.entites.Params;
import com.mowitnow.mower.main.ExceptionMower;
import com.mowitnow.mower.main.MowItNowApplication;

public class MowItNowApplicationTests {

	static final String CHEMIN_FICHIER = "./src/test/resources/";

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	public static void listFiles(String phase) {

		File dir = new File(CHEMIN_FICHIER);
		File[] liste = dir.listFiles();
		for (File item : liste) {
			if (item.isFile()) {
				System.out.format("Nom du fichier: %s%n", item.getName());
			} else if (item.isDirectory()) {
				System.out.format("Nom du répertoir: %s%n", item.getName());
			}
		}

		System.out.printf("Fichiers trouvés durant la phase %s : %s \n", phase, Arrays.asList(liste));
	}

	@Before
	public void setUp() {
		listFiles("Before");
	}

	@After
	public void tearDown() {
		listFiles("After");
	}

	@BeforeClass
	public static void beforeClass() {
		listFiles("BeforeClass");
	}

	@AfterClass
	public static void afterClass() {
		listFiles("AfterClass");
	}

	@Test(expected = IllegalArgumentException.class)
	public void main_error_args() throws ExceptionMower, IOException {
		MowItNowApplication.main("1", "2");
	}

	@Test
	public void main_error_non_existent_file() throws ExceptionMower, IOException {
		expectedEx.expect(ExceptionMower.class);
		expectedEx.expectMessage(Params.NON_EXISTENT_FILE_ERROR);
		MowItNowApplication.main("filenonexistent");
	}

	@Test
	public void main_error_first_line() throws ExceptionMower, IOException {
		expectedEx.expect(ExceptionMower.class);
		expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
		MowItNowApplication.main(CHEMIN_FICHIER + "file_line_1.txt");
	}

	@Test
	public void main_error_second_line() throws ExceptionMower, IOException {
		expectedEx.expect(ExceptionMower.class);
		expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
		MowItNowApplication.main(CHEMIN_FICHIER + "file_line_2.txt");
	}

	@Test
	public void main_error_non_existent_line() throws ExceptionMower, IOException {
		expectedEx.expect(ExceptionMower.class);
		expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
		MowItNowApplication.main(CHEMIN_FICHIER + "file_missing_line.txt");

	}

	@Test
	public void main_fichier_erreur_fichier_vide() throws ExceptionMower, IOException {
		expectedEx.expect(ExceptionMower.class);
		expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
		MowItNowApplication.main(CHEMIN_FICHIER + "file_empty.txt");

	}

	@Test
	public void main_fichier_erreur_fichier_xebia_ko() throws ExceptionMower, IOException {
		expectedEx.expect(ExceptionMower.class);
		expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
		MowItNowApplication.main(CHEMIN_FICHIER + "file_xebia_ko.txt");
	}

	@Test
	public void main_fichier_erreur_fichier_xebia() throws ExceptionMower, IOException {
		MowItNowApplication.main(CHEMIN_FICHIER + "file_xebia.txt");
		assertThat(MowItNowApplication.listResultats).isNotNull();
		assertThat(MowItNowApplication.listResultats).hasSize(2).contains("1 3 N").contains("5 1 E");

	}

}
