package com.novae.eswsplatform.dao;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.SocialJobBean;


/**
 	* A data access object (DAO) providing persistence and search support for SocialJobBean entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .SocialJobBean
  * @author MyEclipse Persistence Tools 
 */
public class SocialJobBeanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SocialJobBeanDAO.class);
		//property constants
	public static final String DECLARER_ID = "declarerId";
	public static final String JOB = "job";



    
    public void save(SocialJobBean transientInstance) {
        log.debug("saving SocialJobBean instance");
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
    
	public void delete(SocialJobBean persistentInstance) {
        log.debug("deleting SocialJobBean instance");
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
    
    public SocialJobBean findById( java.lang.Integer id) {
        log.debug("getting SocialJobBean instance with id: " + id);
        try {
            SocialJobBean instance = (SocialJobBean) getSession()
                    .get("com.novae.eswsplatform.bean.SocialJobBean", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SocialJobBean instance) {
        log.debug("finding SocialJobBean instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.novae.eswsplatform.bean.SocialJobBean")
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
      log.debug("finding SocialJobBean instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SocialJobBean as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByDeclarerId(Object declarerId
	) {
		return findByProperty(DECLARER_ID, declarerId
		);
	}
	
	public List findByJob(Object job
	) {
		return findByProperty(JOB, job
		);
	}
	

	public List findAll() {
		log.debug("finding all SocialJobBean instances");
		try {
			String queryString = "from SocialJobBean";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public SocialJobBean merge(SocialJobBean detachedInstance) {
        log.debug("merging SocialJobBean instance");
        try {
            SocialJobBean result = (SocialJobBean) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SocialJobBean instance) {
        log.debug("attaching dirty SocialJobBean instance");
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
    
    public void attachClean(SocialJobBean instance) {
        log.debug("attaching clean SocialJobBean instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}