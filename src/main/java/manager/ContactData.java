package manager;

import model.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactData {

    @DataProvider
    public Iterator<Object[]> regData() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/AddContactData.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User()
                    .withName(split[0])
                    .withLastname(split[1])
                    .withPhone(split[2])
                    .withEmail(split[3])
                    .withAdress(split[4])
                    .withNote(split[5])});
            line = reader.readLine();
        }
        return list.iterator();
    }


}
