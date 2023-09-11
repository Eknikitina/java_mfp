package ru.stqa.mfp.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.*;
import ru.stqa.mfp.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter(names = "-c", description = "Contact count")
    public int count;
    @Parameter(names = "-f", description = "Target file")
    public String file;
    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format" + format);
        }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();
        File photo = new File("src/test/resources/avatar.png");
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withLastname(String.format("Lastname %s", i)).
                    withName(String.format("Name %s", i)).
                    withMiddlename(String.format("Middlename %s", i)).
                    withMobile(String.format("+%s%s", i, i)).
                    withEmail(String.format("mail%s@mail.ru", i)).
                    withGroup(String.format("test1 %s", i)).
                    withHome(String.format("+%s%s%s", i, i, i)).
                    withWork(String.format("+%s%s%s%s", i, i, i, i)).
                    withNickname(String.format("nickname %s", i)).
                    withTitle(String.format("Title %s", i)).
                    withCompany(String.format("Company %s", i)).
                    withAddress(String.format("address %s", i)).
                    withFax(String.format("+%s", i)).
                    withEmail2(String.format("email2 %s", i)).
                    withEmail3(String.format("email3 %s", i)).
                    withHomepage(String.format("homepage %s", i)).
                    withPhoto(photo));
        }
        return contacts;
    }
}
