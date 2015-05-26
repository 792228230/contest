package dao;

import java.util.List;

import model.Contestlist;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Contestlist entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.Contestlist
 * @author MyEclipse Persistence Tools
 */
public class ContestlistDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ContestlistDAO.class);
	// property constants
	public static final String CONTEST = "contest";

	public void save(Contestlist transientInstance) {
		log.debug("saving Contestlist instance");
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

	public void delete(Contestlist persistentInstance) {
		log.debug("deleting Contestlist instance");
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

	public Contestlist findById(java.lang.Integer id) {
		log.debug("getting Contestlist instance with id: " + id);
		try {
			Contestlist instance = (Contestlist) getSession().get(
					"dao.Contestlist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Contestlist instance) {
		log.debug("finding Contestlist instance by example");
		try {
			List results = getSession().createCriteria("dao.Contestlist")
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
		log.debug("finding Contestlist instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Contestlist as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByContest(Object contest) {
		return findByProperty(CONTEST, contest);
	}

	public List findAll() {
		log.debug("finding all Contestlist instances");
		try {
			String queryString = "from Contestlist";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Contestlist merge(Contestlist detachedInstance) {
		log.debug("merging Contestlist instance");
		try {
			Contestlist result = (Contestlist) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Contestlist instance) {
		log.debug("attaching dirty Contestlist instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Contestlist instance) {
		log.debug("attaching clean Contestlist instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}