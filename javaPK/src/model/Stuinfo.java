package model;

/**
 * Stuinfo entity. @author MyEclipse Persistence Tools
 */
public class Stuinfo extends AbstractStuinfo implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Stuinfo() {
	}

	/** minimal constructor */
	public Stuinfo(Integer enrollnum) {
		super(enrollnum);
	}

	/** full constructor */
	public Stuinfo(Integer enrollnum, String stuname, String sex, Integer id,
			String class_, String school, String tel) {
		super(enrollnum, stuname, sex, id, class_, school, tel);
	}

}
