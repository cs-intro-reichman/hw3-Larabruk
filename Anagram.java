/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		String processedStr1 = preProcess(str1);
		String processedStr2 = preProcess(str2);
		String newProcessedStr1 = "";
		String newProcessedStr2 = "";
		for(int i = 0; i < processedStr1.length(); i++){
			if(processedStr1.charAt(i) != ' '){
				newProcessedStr1 += processedStr1.charAt(i);
			}
		}
		for(int i = 0; i < processedStr2.length(); i++){
			if(processedStr2.charAt(i) != ' '){
				newProcessedStr2 += processedStr2.charAt(i);
			}
		}
			if(newProcessedStr1.length() != newProcessedStr2.length()){
				return false;
			}
		for(int i = 0; i < newProcessedStr1.length(); i++){
			char char1 = newProcessedStr1.charAt(i);
			int count1 = 0;
			int count2 = 0;
		for(int j = 0; j < newProcessedStr1.length(); j++){
			if(newProcessedStr1.charAt(j) == char1){
				count1++;
			}
		}
		for(int j = 0; j < newProcessedStr2.length(); j++){
			if(newProcessedStr2.charAt(j) == char1){
				count2++;
			}
		}
		if(count1 != count2){
			return false;
		}
		}
		return true;
	}
	 
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String result = "";
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				result += str.charAt(i);
			} else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				result += ((char)(str.charAt(i) + 32));
			} else if(str.charAt(i) == ' '){
				result += str.charAt(i);
			}
		}
		return result;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newAnagram = "";
		String availableChars = str;
		while(availableChars.length() > 0){
			int randomIndex = (int) (Math.random() * availableChars.length());
			char selectedChar = availableChars.charAt(randomIndex);
			
		newAnagram += selectedChar;
		availableChars = availableChars.substring(0, randomIndex) + availableChars.substring(randomIndex + 1);
	}
	return newAnagram;
}
}
