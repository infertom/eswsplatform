package com.novae.eswsplatform.dao;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.ReferClassifyBean;


/**
 	* A data access object (DAO) providing persistence and search support for ReferClassifyBean entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ReferClassifyBean
  * @author MyEclipse Persistence Tools 
 */
public class ReferClassifyBeanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ReferClassifyBeanDAO.class);
		//property constants
	public static final String NAME = "name";



    
    public void save(ReferClassifyBean transientInstance) {
        log.debug("saving ReferClassifyBean instance");
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
    
	public void delete(ReferClassifyBean persistentInstance) {
        log.debug("deleting ReferClassifyBean instance");
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
    
    public ReferClassifyBean findById( java.lang.Integer id) {
        log.debug("getting ReferClassifyBean instance with id: " + id);
        try {
            ReferClassifyBean instance = (ReferClassifyBean) getSession()
                    .get("com.novae.eswsplatform.bean.ReferClassifyBean", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ReferClassifyBean instance) {
        log.debug("finding ReferClassifyBean instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.novae.eswsplatform.bean.ReferClassifyBean")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding ReferClassifyBean instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ReferClassifyBean as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	

	public List findAll() {
		log.debug("finding all ReferClassifyBean instances");
		try {
			String queryString = "from ReferClassifyBean";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ReferClassifyBean merge(ReferClassifyBean detachedInstance) {
        log.debug("merging ReferClassifyBean instance");
        try {
            ReferClassifyBean result = (ReferClassifyBean) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ReferClassifyBean instance) {
        log.debug("attaching dirty ReferClassifyBean instance");
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
    
    public void attachClean(ReferClassifyBean instance) {
        log.debug("attaching clean ReferClassifyBean instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}