package model;

/**
 * AbstractContestlist entity provides the base persistence definition of the
 * Contestlist entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractContestlist implements java.io.Serializable {

	// Fields

	private Integer id;
	private String contest;

	// Constructors

	/** default constructor */
	public AbstractContestlist() {
	}

	/** minimal constructor */
	public AbstractContestlist(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractContestlist(Integer id, String contest) {
		this.id = id;
		this.contest = contest;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContest() {
		return this.contest;
	}

	public void setContest(String contest) {
		this.contest = contest;
	}

}