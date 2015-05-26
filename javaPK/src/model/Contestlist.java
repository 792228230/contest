package model;

/**
 * Contestlist entity. @author MyEclipse Persistence Tools
 */
public class Contestlist extends AbstractContestlist implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Contestlist() {
	}

	/** minimal constructor */
	public Contestlist(Integer id) {
		super(id);
	}

	/** full constructor */
	public Contestlist(Integer id, String contest) {
		super(id, contest);
	}

}
