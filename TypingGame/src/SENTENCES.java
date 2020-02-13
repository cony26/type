
public enum SENTENCES {
	SENTENCE1("i am a student"),
	SENTENCE2("orange"),
	SENTENCE3("ColleagueTextField"),
	SENTENCE4("ColllagueButton"),
	SENTENCE5("what a fuck!!");
	
	
	private String name;
	private SENTENCES(String name) {
		this.name = name;
	}
	public String getValue() {
		return this.name;
	}
	
}
