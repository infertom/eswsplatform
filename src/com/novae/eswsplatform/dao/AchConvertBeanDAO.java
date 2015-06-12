package com.novae.eswsplatform.dao;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.AchConvertBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * AchConvertBean entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .AchConvertBean
 * @author MyEclipse Persistence Tools
 */
public class AchConvertBeanDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AchConvertBeanDAO.class);
	// property constants
	public static final String DECLARER_ID = "declarerId";
	public static final String DETAILS = "details";

	public void save(AchConvertBean transientInstance) {
		log.debug("saving AchConvertBean instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.save(transientInstance);
			transaction.commit();
			session.close();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AchConvertBean persistentInstance) {
		log.debug("deleting AchConvertBean instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(persistentInstance);
			transaction.commit();
			session.close();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AchConvertBean findById(java.lang.Integer id) {
		log.debug("getting AchConvertBean instance with id: " + id);
		try {
			AchConvertBean instance = (AchConvertBean) getSession().get(
					"com.novae.eswsplatform.bean.AchConvertBean", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AchConvertBean instance) {
		log.debug("finding AchConvertBean instance by example");
		try {
			List results = getSession().createCriteria("com.novae.eswsplatform.bean.AchConvertBean")
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
		log.debug("finding AchConvertBean instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AchConvertBean as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDeclarerId(Object declarerId) {
		return findByProperty(DECLARER_ID, declarerId);
	}

	public List findByDetails(Object details) {
		return findByProperty(DETAILS, details);
	}

	public List findAll() {
		log.debug("finding all AchConvertBean instances");
		try {
			String queryString = "from AchConvertBean";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AchConvertBean merge(AchConvertBean detachedInstance) {
		log.debug("merging AchConvertBean instance");
		try {
			AchConvertBean result = (AchConvertBean) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AchConvertBean instance) {
		log.debug("attaching dirty AchConvertBean instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(instance);
			transaction.commit();
			session.close();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AchConvertBean instance) {
		log.debug("attaching clean AchConvertBean instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}