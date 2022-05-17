package ru.job4j.tracker.search;

import org.junit.Test;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PhoneDictionaryTest {

    @Test
    public void testWenPetorInPerson() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void testWenBorisInPersons() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phones.add(new Person("Boris", "Pokidov", "4755505", "Tambov"));
        phones.add(new Person("Ivan", "Ivanov", "139950", "Tagil"));
        ArrayList<Person> persons = phones.find("55");
        assertThat(persons.get(0).getName(), is("Boris"));
    }

    @Test
    public void testWenNotFound() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Voronej");
        assertThat(persons.size(), is(0));
    }
}