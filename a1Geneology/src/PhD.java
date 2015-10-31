//Javadoc has been checked and it describes all methods and the class.

/**An instance maintains info about the PhD of a person. */
public class PhD {
	/** NetId: cxa2. Time spent: 4 hours, 15 minutes.
	 An instance maintains info about the PhD of a person. */
	
	private String name; //Name of the person with a PhD (String of length > 0
	private int year; //Year the PhD was awarded (in the form XXXX)
	private int month; // Month the PhD was awarded (1 is January, etc.)
	private char gender; //Gender of the person with the PhD (M=male, F=female)
	private PhD firstAdvisor;//First PhD advisor of person, null if unknown
	private PhD secondAdvisor;//Second PhD advisor of person, null if unknown
					  // or if person only had one advisor. Null if 
					  // firstAdvisor is null.
	private int adviseeNum; //Number of PhD advisees this person has
	
	/**  An instance for a person with name n, gender g, PhD year y, and PhD
	month m. Its advisors are unknown, and it has no advisees.
	Precondition: n has at least 1 character, m is in 1..12, and g is 'M' for
	male or 'F' for female.*/
	PhD(String n, char g, int y, int m) {
		assert n != null && n.length() >=1;
		name = n;
		assert g == 'M' || g == 'F';
		gender = g;
		year = y;
		assert m >= 1 && m <= 12;
		month = m;
	}
	
	/**   a PhD with name n, gender g, PhD year y, PhD month m, first
	advisor adv, and no second advisor. Precondition: n has at least 1 char, 
	g is 'F' for female or 'M' for male, m is in 1..12, and adv is not null.*/
	PhD(String n, char g, int y, int m, PhD adv){
		assert n != null && n.length() >=1;
		name = n;
		assert g == 'M' || g == 'F';
		gender = g;
		year = y;
		assert m >= 1 && m <= 12;
		month = m;
		assert adv != null;
		firstAdvisor = adv;
		adv.adviseeNum++;
	}
	
	/**   a PhD with name n, gender g, PhD year y, PhD month m, first
	advisor adv1, and second advisor adv2. Precondition: n has at least 1 char,
	g is 'F' for female or 'M' for male, m is in 1..12, and adv1 and adv2 are 
	not null, and adv1 and adv2 are different.*/
	PhD(String n, char g, int y, int m, PhD adv1, PhD adv2){
		assert n != null && n.length() >=1;
		name = n;
		assert g == 'M' || g == 'F';
		gender = g;
		year = y;
		assert m >= 1 && m <= 12;
		month = m;
		assert adv1 != null && adv2 != null;
		assert adv1 != adv2;
		firstAdvisor = adv1;
		adv1.adviseeNum++;
		secondAdvisor = adv2;
		secondAdvisor.adviseeNum++;
	}
	
	// Returns the name of the PhD
	String getName() {
		return name;
	}
	
	// Returns the year when the PhD was awarded
	int getYear() {
		return year;
	}
	
	// Returns the month when the PhD was awarded
	int getMonth() {
		return month;
	}
	
	//Returns true if the candidate is a male and false if female
	boolean isMale() {
		return gender == 'M';
	}
	
	//Returns the PhD who is this PhD's first advisor (null if unknown)
	PhD getFirstAdvisor() {
		return firstAdvisor;
	}
	
	//Returns the PhD who is this PhD's second advisor (null if unknown)
	PhD getSecondAdvisor() {
		return secondAdvisor;
	}
	
	//Returns the number of advisees this PhD has
	int numAdvisees() {
		return adviseeNum;
	}
	
	/** Add p as this person's first PhD advisor.
	Precondition: this person's first advisor is unknown and p is not null. */
	public void addFirstAdvisor(PhD p){
		assert p != null && this.getFirstAdvisor() == null;
		this.firstAdvisor = p;
		p.adviseeNum++;
	}
	
	/** Add p as this person's second PhD advisor.
	Precondition: This person's first advisor is known, their second advisor
	is unknown, p is not null, and p is different from this persons first advisor. */
	public void addSecondAdvisor(PhD p){
		assert this.getFirstAdvisor() != null && this.getSecondAdvisor() 
				== null && p != null && p!= this.getFirstAdvisor();
		this.secondAdvisor = p;
		p.adviseeNum++;
	}
	
	/**Return value of "this person got their PhD after p did."
	Precondition: p is not null.*/
	public boolean isYoungerThan(PhD p){
		assert p != null;
		return (this.getYear() > p.getYear()) || (this.getYear() == 
				p.getYear() && this.getMonth() > p.getMonth());
	}
	
	/**Return value of "this person and p are intellectual siblings."
	Note: if p is null, they are not siblings.*/
	public boolean isPhDSibling(PhD p){
		assert this != p;
		return (p != null) && (this.getFirstAdvisor() == p.getFirstAdvisor() &&
				p.getFirstAdvisor() != null) || (this.getFirstAdvisor() 
				== p.getSecondAdvisor() && p.getSecondAdvisor() != null) ||
				(this.getSecondAdvisor() == p.getFirstAdvisor() && 
				p.getFirstAdvisor() != null) || (this.getSecondAdvisor() == 
				p.getSecondAdvisor() && p.getSecondAdvisor() != null);
	}
}
