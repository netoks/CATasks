package lt.netoks;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Gediminas", 40, "gediminas@netoks.lt");

        ObjectMapper om = new ObjectMapper();
        om.enable(SerializationFeature.INDENT_OUTPUT);

        om.writeValue(new File("rezultatas.json"), person);

        Person newPerson = om.readValue(new File("rezultatas.json"), Person.class);

        System.out.println(newPerson);
    }
}