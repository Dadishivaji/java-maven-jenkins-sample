package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void generatedPageContainsTitleAndFeatures() {
        String html = App.page();
        assertTrue(html.contains("CloudDesk"));
        assertTrue(html.contains("Java + Maven + Jenkins"));
        assertTrue(html.contains("HTML & CSS"));
    }
}
