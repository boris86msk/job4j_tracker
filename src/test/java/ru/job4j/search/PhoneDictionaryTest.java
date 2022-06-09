package ru.job4j.search;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PhoneDictionaryTest {

    @Test
    public void testWenPetorInPerson() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void testWenBorisInPersons() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Boris", "Pokidov", "4755505", "Tambov"));
        phones.add(new Person("Ivan", "Ivanov", "139950", "Tagil"));
        var persons = phones.find("55");
        assertThat(persons.get(0).getName(), is("Boris"));
    }

    @Test
    public void testWenNotFound() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Voronej");
        assertThat(persons.size(), is(0));
    }
}