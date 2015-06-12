package com.novae.eswsplatform.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.AcademicBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * AcademicBean entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .AcademicBean
 * @author MyEclipse Persistence Tools
 */
public class AcademicBeanDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AcademicBeanDAO.class);
	// property constants
	public static final String DECLARER_ID = "declarerId";
	public static final String JOB = "job";

	public void save(AcademicBean transientInstance) {
		log.debug("saving AcademicBean instance");
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

	public void delete(AcademicBean persistentInstance) {
		log.debug("deleting AcademicBean instance");
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

	public AcademicBean findById(java.lang.Integer id) {
		log.debug("getting AcademicBean instance with id: " + id);
		try {
			AcademicBean instance = (AcademicBean) getSession().get(
					"com.novae.eswsplatform.bean.AcademicBean", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AcademicBean instance) {
		log.debug("finding AcademicBean instance by example");
		try {
			List results = getSession().createCriteria("com.novae.eswsplatform.bean.AcademicBean")
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
		log.debug("finding AcademicBean instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AcademicBean as model where model."
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

	public List findByJob(Object job) {
		return findByProperty(JOB, job);
	}

	public List findAll() {
		log.debug("finding all AcademicBean instances");
		try {
			String queryString = "from AcademicBean";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AcademicBean merge(AcademicBean detachedInstance) {
		log.debug("merging Academi	cBean instance");
		try {
			AcademicBean result = (AcademicBean) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AcademicBean instance) {
		log.debug("attaching dirty AcademicBean instance");
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

	public void attachClean(AcademicBean instance) {
		log.debug("attaching clean AcademicBean instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.buildLockRequest(LockOptions.NONE).lock(instance);
			transaction.commit();
			session.close();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}