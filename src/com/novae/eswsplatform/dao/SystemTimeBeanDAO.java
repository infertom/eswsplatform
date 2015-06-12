package com.novae.eswsplatform.dao;
// default package

import com.novae.eswsplatform.bean.SystemTimeBean;
import com.novae.eswsplatform.dao.BaseHibernateDAO;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for SystemTimeBean entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .SystemTimeBean
  * @author MyEclipse Persistence Tools 
 */
public class SystemTimeBeanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SystemTimeBeanDAO.class);
		//property constants



    
    public void save(SystemTimeBean transientInstance) {
        log.debug("saving SystemTimeBean instance");
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
    
	public void delete(SystemTimeBean persistentInstance) {
        log.debug("deleting SystemTimeBean instance");
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
    
    public SystemTimeBean findById( java.lang.Integer id) {
        log.debug("getting SystemTimeBean instance with id: " + id);
        try {
            SystemTimeBean instance = (SystemTimeBean) getSession()
                    .get("com.novae.eswsplatform.bean.SystemTimeBean", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SystemTimeBean instance) {
        log.debug("finding SystemTimeBean instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.novae.eswsplatform.bean.SystemTimeBean")
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
      log.debug("finding SystemTimeBean instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SystemTimeBean as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all SystemTimeBean instances");
		try {
			String queryString = "from SystemTimeBean";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public SystemTimeBean merge(SystemTimeBean detachedInstance) {
        log.debug("merging SystemTimeBean instance");
        try {
            SystemTimeBean result = (SystemTimeBean) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SystemTimeBean instance) {
        log.debug("attaching dirty SystemTimeBean instance");
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
    
    public void attachClean(SystemTimeBean instance) {
        log.debug("attaching clean SystemTimeBean instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}