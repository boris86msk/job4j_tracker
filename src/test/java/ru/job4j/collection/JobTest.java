package ru.job4j.collection;

import org.junit.Test;

import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

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
    public void whenCompatoEqualNameByPriorityDown() {
        Comparator<Job> cmpName = new JobDescByName().thenComparing(new JobDescByPriorityDown());
        int rsl = cmpName.compare(
                new Job("Alyaska", 1),
                new Job("Alyaska", 0)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatoEqualPriorityByNameDown() {
        Comparator<Job> cmpName = new JobDescByPriority().thenComparing(new JobDescByNameDown());
        int rsl = cmpName.compare(
                new Job("Borisoglebsk", 1),
                new Job("Armavir", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatoPriorityUp() {
        Comparator<Job> cmpPrior = new JobDescByPriority();
        int rsl = cmpPrior.compare(
                new Job("Borisoglebsk", 1),
                new Job("Armavir", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatoNameUp() {
        Comparator<Job> cmpPrior = new JobDescByName();
        int rsl = cmpPrior.compare(
                new Job("Alisa", 1),
                new Job("Lisa", 2)
        );
        assertThat(rsl, greaterThan(0));
    }
}