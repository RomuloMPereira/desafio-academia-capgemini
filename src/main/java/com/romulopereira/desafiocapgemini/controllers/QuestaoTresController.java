package com.romulopereira.desafiocapgemini.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.romulopereira.desafiocapgemini.models.Word;

@RestController
@RequestMapping(value = "/questao3")
public class QuestaoTresController {

	@PostMapping
	public ResponseEntity<Integer> countAnagrams(@RequestBody Word word) {
		String input = new String(word.getInput());
		char[] array = input.toCharArray();
		int arrayLength = input.length();
		Integer result = 0;
		
		for (int i = 0; i < arrayLength - 1; i++) {
			for(int j = 1; i+j < arrayLength; j++) {
				if (array[i] == array[i+j]) {
					result += 1;
				}
			}
			/*Resolução estática para percorrer o array de caracteres 
			 * e verificar a combinação entre os elementos
			 * 
			 * if (array[i] == array[i+1]) {
				result += 1;
			}
			if(array[i] == array[i+2]) {
				result += 1;
			}*/
		}
		
		int w = 2;
		for (int i = 0; i <= arrayLength - w; i++) {
			for (int j = 1; j <= arrayLength / 2; j++) {
				for (w = 1 + j; w <= arrayLength; w++) {
					if(input.substring(i, (i+j)).contains(input.substring(i+w-j, i+w))) {
						result += 1;
					}
				}
			}
		}
		
		/*Resolução estática para percorrer as substrings e compará-las
		 * for (int i = 0; i < arrayLength - 2; i++) {
				if(input.substring(i, i+1).contains(input.substring(i+1, i+2))) {
					result += 1;
				}
				if(input.substring(i, i+1).contains(input.substring(i+2, i+3))) {
					result += 1;
				}
				if(input.substring(i, i+1).contains(input.substring(i+3, i+4))) {
					result += 1;
				}
			}
			for (int i = 0; i < arrayLength - 3; i++) {
				if(input.substring(i, i+2).contains(input.substring(i+1, i+3))) {
					result += 1;
				}
				if(input.substring(i, i+2).contains(input.substring(i+2, i+4))) {
					result += 1;
				}
				if(input.substring(i, i+2).contains(input.substring(i+3, i+5))) {
					result += 1;
				}
			}
		} */
		return ResponseEntity.ok().body(result);
	}
}
