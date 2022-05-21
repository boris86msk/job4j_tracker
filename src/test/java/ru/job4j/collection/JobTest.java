package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.job.Job;
import ru.job4j.collection.job.JobDescByName;
import ru.job4j.collection.job.JobDescByPriority;
import ru.job4j.collection.job.JobDescByPriorityDown;

import java.util.*;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameUp() {
        Comparator<Job> cmpName = new JobDescByPriorityDown();
        List<Job> jobs = Arrays.asList(
                new Job("Aska", 0),
                new Job("Coock", 2),
                new Job("Booch", 1)

        );
        System.out.println(jobs);
        Collections.sort(jobs, cmpName);
        System.out.println(jobs);
    }
}