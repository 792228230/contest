package model;

/**
 * AbstractStuinfo entity provides the base persistence definition of the
 * Stuinfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStuinfo implements java.io.Serializable {

	// Fields

	private Integer enrollnum;
	private String stuname;
	private String sex;
	private Integer id;
	private String class_;
	private String school;
	private String tel;

	// Constructors

	/** default constructor */
	public AbstractStuinfo() {
	}

	/** minimal constructor */
	public AbstractStuinfo(Integer enrollnum) {
		this.enrollnum = enrollnum;
	}

	/** full constructor */
	public AbstractStuinfo(Integer enrollnum, String stuname, String sex,
			Integer id, String class_, String school, String tel) {
		this.enrollnum = enrollnum;
		this.stuname = stuname;
		this.sex = sex;
		this.id = id;
		this.class_ = class_;
		this.school = school;
		this.tel = tel;
	}

	// Property accessors

	public Integer getEnrollnum() {
		return this.enrollnum;
	}

	public void setEnrollnum(Integer enrollnum) {
		this.enrollnum = enrollnum;
	}

	public String getStuname() {
		return this.stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}