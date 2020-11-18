package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    void testShouldHaveExpectedToString(){
        Item item = new Item("foo", 1, 1);
        assertEquals("foo, 1, 1", item.toString());
    }
}
