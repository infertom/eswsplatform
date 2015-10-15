package com.novae.eswsplatform.dao;
// default package

import com.novae.eswsplatform.bean.SubjectBean;
import com.novae.eswsplatform.dao.BaseHibernateDAO;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * SubjectBean entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .SubjectBean
 * @author MyEclipse Persistence Tools
 */
public class SubjectBeanDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SubjectBeanDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String GROUP_ID = "groupId";

	public void save(SubjectBean transientInstance) {
		log.debug("saving SubjectBean instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			getSession().save(transientInstance);
			transaction.commit();
			session.close();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SubjectBean persistentInstance) {
		log.debug("deleting SubjectBean instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			getSession().delete(persistentInstance);
			transaction.commit();
			session.close();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SubjectBean findById(java.lang.Integer id) {
		log.debug("getting SubjectBean instance with id: " + id);
		try {
			SubjectBean instance = (SubjectBean) getSession().get(
					"com.novae.eswsplatform.bean.SubjectBean", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SubjectBean instance) {
		log.debug("finding SubjectBean instance by example");
		try {
			List results = getSession().createCriteria("com.novae.eswsplatform.bean.SubjectBean")
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
		log.debug("finding SubjectBean instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from SubjectBean as model where model."
					+ propertyName + "= ?0";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter("0", value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByGroupId(Object groupId) {
		return findByProperty(GROUP_ID, groupId);
	}

	public List findAll() {
		log.debug("finding all SubjectBean instances");
		try {
			String queryString = "from SubjectBean";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SubjectBean merge(SubjectBean detachedInstance) {
		log.debug("merging SubjectBean instance");
		try {
			SubjectBean result = (SubjectBean) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SubjectBean instance) {
		log.debug("attaching dirty SubjectBean instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			getSession().saveOrUpdate(instance);
			transaction.commit();
			session.close();
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SubjectBean instance) {
		log.debug("attaching clean SubjectBean instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}