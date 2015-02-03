/**
 * Word class is a container that allows for tracking
 * the number of occurence's of a generic String.  
 * @author matt forsyth
 */
public class Word {
	
	private String word;

	private int wordCount = 0;
	
	/**
	 * @return contents of word
	 */
	public String getWord() {
		return word;
	}
	/**
	 * @param String word
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * @return int wordCount
	 */
	public int getWordCount() {
		return wordCount;
	}

	/**
	 * increments wordCount by 1
	 */
	public void incWordCount() {
		wordCount++;
	}
}
