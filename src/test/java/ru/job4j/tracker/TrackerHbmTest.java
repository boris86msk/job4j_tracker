package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.store.HbmTracker;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackerHbmTest {
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
}
