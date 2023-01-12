import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alex Balogh
 */
public class PersonGenerator {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        String idString;
        String firstName;
        String lastName;
        String inputTitle;
        int yearOfBirth;
        String yearOfBirthST;
        String stringPerson;
        boolean doContinue;
        ArrayList<String> PersonList = new ArrayList<>();

        do
        {
            idString = SafeInput.getNonZeroLenString(in, "Enter Id");
            firstName = SafeInput.getNonZeroLenString(in, "Input first name");
            lastName = SafeInput.getNonZeroLenString(in, "Input last name");
            inputTitle = SafeInput.getNonZeroLenString(in, "Input title");
            yearOfBirth = SafeInput.getInt(in, "Input year of birth");

            yearOfBirthST = Integer.toString(yearOfBirth);

            stringPerson = String.join(", ", idString, firstName, lastName, inputTitle, yearOfBirthST);

            PersonList.add(stringPerson);

            doContinue = SafeInput.getYNConfirm(in, "Do you want to continue");

            System.out.println(PersonList);
            System.out.println(doContinue);

        } while (doContinue);

        String fileName;
        fileName = SafeInput.getNonZeroLenString(in, "What do you want the file to be called");
        FileWriter writer = new FileWriter(fileName + ".txt");

        for (String i : PersonList)
        {
            writer.write(i);
            writer.write("\n");
        }
        writer.close();
    }
}
