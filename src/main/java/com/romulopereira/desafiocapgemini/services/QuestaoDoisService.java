package com.romulopereira.desafiocapgemini.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class QuestaoDoisService {

	public Integer informMissingCharacters(String input) {
		Integer inputLength = input.length();
		Integer missingChar = 0;
		Integer minimalChar = 6;
		
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
            Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                          '*', '(', ')', '-', '+'));
    
        for (char i : input.toCharArray())
        {
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }
        
        if (!hasLower) {missingChar =+ 1;} else minimalChar = minimalChar -1;
        if (!hasUpper) {missingChar =+ 1;} else minimalChar = minimalChar -1;
        if (!hasDigit) {missingChar =+ 1;} else minimalChar = minimalChar -1;
        if (!specialChar) {missingChar =+ 1;} else minimalChar = minimalChar -1;
        if (inputLength < 6) return minimalChar =+ (6 - inputLength);
        return missingChar;
	}
}
