package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.Job;
import ru.job4j.collection.JobDescByName;
import ru.job4j.collection.JobDescByPriority;

import java.util.Comparator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 5),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));

    }
}