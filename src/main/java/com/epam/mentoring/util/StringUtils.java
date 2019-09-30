package com.epam.mentoring.util;

import org.apache.commons.lang3.RandomStringUtils;

public class StringUtils {

     public static String generateRandomFolderName(){
         return "testFolder" + RandomStringUtils.randomAlphabetic(5,15);
     }
}
