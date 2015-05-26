package dao;

import java.util.List;

import model.Stuinfo;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Stuinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.Stuinfo
 * @author MyEclipse Persistence Tools
 */
public class StuinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(StuinfoDAO.class);
	// property constants
	public static final String STUNAME = "stuname";
	public static final String SEX = "sex";
	public static final String ID = "id";
	public static final String CLASS_ = "class_";
	public static final String SCHOOL = "school";
	public static final String TEL = "tel";

	public void save(Stuinfo transientInstance) {
		log.debug("saving Stuinfo instance");
		Transaction tx = getSession().beginTransaction();
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		tx.commit();
		getSession().flush();
	}

	public void delete(Stuinfo persistentInstance) {
		log.debug("deleting Stuinfo instance");
		Transaction tx = getSession().beginTransaction();
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
		tx.commit();
		getSession().flush();
	}

	public Stuinfo findById(java.lang.Integer id) {
		log.debug("getting Stuinfo instance with id: " + id);
		try {
			Stuinfo instance = (Stuinfo) getSession().get("dao.Stuinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Stuinfo instance) {
		log.debug("finding Stuinfo instance by example");
		try {
			List results = getSession().createCriteria("dao.Stuinfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Stuinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Stuinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStuname(Object stuname) {
		return findByProperty(STUNAME, stuname);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findById(Object id) {
		return findByProperty(ID, id);
	}

	public List findByClass_(Object class_) {
		return findByProperty(CLASS_, class_);
	}

	public List findBySchool(Object school) {
		return findByProperty(SCHOOL, school);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findAll() {
		log.debug("finding all Stuinfo instances");
		try {
			String queryString = "from Stuinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Stuinfo merge(Stuinfo detachedInstance) {
		log.debug("merging Stuinfo instance");
		try {
			Stuinfo result = (Stuinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Stuinfo instance) {
		log.debug("attaching dirty Stuinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Stuinfo instance) {
		log.debug("attaching clean Stuinfo instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}