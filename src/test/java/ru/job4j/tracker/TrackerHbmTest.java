package ru.job4j.tracker;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.job4j.tracker.store.HbmTracker;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @AfterEach
    public void wipeTable() {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.createQuery("DELETE Item")
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenAddNewItemAndReplaceAnotherItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item firstItem = new Item();
            Item secondItem = new Item();
            firstItem.setName("firstItem");
            secondItem.setName("secondItem");
            tracker.add(firstItem);
            int itemId = firstItem.getId();
            tracker.replace(itemId, secondItem);
            assertThat(tracker.findById(itemId).getName()).isEqualTo(secondItem.getName());
        }
    }

    @Test
    public void whenAddItemThenDeleteIt() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            tracker.add(item);
            int itemId = item.getId();
            tracker.delete(itemId);
            assertThat(tracker.findById(itemId)).isNull();
        }
    }

    @Test
    public void whenNeedFindAllItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item();
            Item item2 = new Item();
            tracker.add(item1);
            tracker.add(item2);
            List<Item> expectedList = List.of(item1, item2);
            assertThat(tracker.findAll()).isEqualTo(expectedList);
        }
    }

    @Test
    public void whenFindItemByName() throws Exception {
        try (var tracker = new HbmTracker()) {
            String name = "myName";
            Item item = new Item();
            item.setName(name);
            tracker.add(item);
            assertThat(tracker.findByName(name)).contains(item);
        }
    }

    @Test
    public void whenFindItemById() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            tracker.add(item);
            int itemId = item.getId();
            assertThat(tracker.findById(itemId)).isEqualTo(item);
        }
    }
}
