package typing_app.com.cony;

public enum SENTENCES {
	SENTENCE1("i am a student"),
	SENTENCE2("orange"),
	SENTENCE3("ColleagueTextField"),
	SENTENCE4("ColleagueButton"),
	SENTENCE5("what a fuck"),
	SENTENCE6("Craft Boss"),
	SENTENCE7("python programming"),
	SENTENCE8("smart phone");
	
	private String name;
	private SENTENCES(String name) {
		this.name = name;
	}
	public String getValue() {
		return this.name;
	}
	
}
