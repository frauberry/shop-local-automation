package website.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestData {

    public static String generateEmail() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmssddMMyyyy"));
        return "olga" + timestamp + "@yopmail.com";
    }
}
