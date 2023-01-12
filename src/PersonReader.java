import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javax.swing.JFileChooser;

public class PersonReader
{
    public static void main(String[] args) throws IOException
    {
        JFileChooser chooser = new JFileChooser();
        File fileSelected;
        String person;
        String sFormat;
        ArrayList<String> personList = new ArrayList<>();

        String idString;
        String firstName;
        String lastName;
        String inputTitle;
        int yearOfBirth;

        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);

        BufferedReader reader;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {

            fileSelected = chooser.getSelectedFile();
            Path file = fileSelected.toPath();

            InputStream in = new BufferedInputStream(Files.newInputStream(file, StandardOpenOption.CREATE));
            reader = new BufferedReader(new InputStreamReader(in));

            String[] fields;
            while (reader.ready())
            {
                person = reader.readLine();
                personList.add(person);
            }
            sFormat = String.format("%3s%15s%13s%9s%7s", "ID#", "Firstname", "Lastname", "Title", "YOB");
            System.out.println(sFormat);

            sFormat = String.format("%48s", "================================================");
            System.out.println(sFormat);

            for (String list : personList)
            {
                fields = list.split(",");

                if (fields.length == 5)
                {
                    idString = fields[0].trim();
                    firstName = fields[1].trim();
                    lastName = fields[2].trim();
                    inputTitle = fields[3].trim();
                    yearOfBirth = Integer.parseInt(fields[4].trim());
                    sFormat = String.format("%3s%12s%13s%9s%7d", idString, firstName, lastName, inputTitle, yearOfBirth);
                    System.out.println(sFormat);

                }
                else
                {
                    System.out.println("Found a record that may be corrupt: ");
                    System.out.println(list);

                }
            }
            reader.close();
        }
    }
}

