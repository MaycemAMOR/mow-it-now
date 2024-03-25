package com.mowitnow.mower.main;


import com.mowitnow.mower.model.Params;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MowItNowApplicationTests {

    static final String Files_PATH = "./src/test/resources/";

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    public static void listFiles(String phase) {

        File dir = new File(Files_PATH);
        File[] fileList = dir.listFiles();
        assert fileList != null;
        Arrays.stream(fileList).toList().forEach(MowItNowApplicationTests::show);

        System.out.printf("Files found during the phase %s : %s \n", phase, Arrays.asList(fileList));
    }

    private static void show(File x) {
        System.out.format("File name: %s%n", x.getName());
    }

    @BeforeClass
    public static void beforeClass() {
        listFiles("BeforeClass");
    }

    @Test(expected = IllegalArgumentException.class)
    public void main_error_args() throws ExceptionMower, IOException {
        MowItNowApplication.main("1", "2");
    }

    @Test
    public void main_error_non_existent_file() throws ExceptionMower, IOException {
        expectedEx.expect(ExceptionMower.class);
        expectedEx.expectMessage(Params.NON_EXISTENT_FILE_ERROR);
        MowItNowApplication.main("file nonexistent");
    }

    @Test
    public void main_error_first_line() throws ExceptionMower, IOException {
        expectedEx.expect(ExceptionMower.class);
        expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
        MowItNowApplication.main(Files_PATH + "file_line_1.txt");
    }

    @Test
    public void main_error_second_line() throws ExceptionMower, IOException {
        expectedEx.expect(ExceptionMower.class);
        expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
        MowItNowApplication.main(Files_PATH + "file_line_2.txt");
    }

    @Test
    public void main_error_non_existent_line() throws ExceptionMower, IOException {
        expectedEx.expect(ExceptionMower.class);
        expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
        MowItNowApplication.main(Files_PATH + "file_missing_line.txt");
    }

    @Test
    public void main_file_error_empty_file() throws ExceptionMower, IOException {
        expectedEx.expect(ExceptionMower.class);
        expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
        MowItNowApplication.main(Files_PATH + "file_empty.txt");
    }

    @Test
    public void main_file_error_incorrect_data() throws ExceptionMower, IOException {
        expectedEx.expect(ExceptionMower.class);
        expectedEx.expectMessage(Params.INCORRECT_DATA_ERROR);
        MowItNowApplication.main(Files_PATH + "file_incorrect_data.txt");
    }

    @Test
    public void main_file_with_correct_data() throws ExceptionMower, IOException {
        MowItNowApplication.main(Files_PATH + "file_correct_data.txt");
        assertThat(MowItNowApplication.listResults, is(notNullValue()));
        assertThat(MowItNowApplication.listResults.getFirst().contains("1 3 N"), is(true));
        assertThat(MowItNowApplication.listResults.getLast().contains("5 1 E"), is(true));
    }

}
