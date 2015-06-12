package com.novae.eswsplatform.dao;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.ResumeBean;


/**
 	* A data access object (DAO) providing persistence and search support for ResumeBean entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ResumeBean
  * @author MyEclipse Persistence Tools 
 */
public class ResumeBeanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ResumeBeanDAO.class);
		//property constants
	public static final String DECLARER_ID = "declarerId";
	public static final String TIME_FROM = "timeFrom";
	public static final String TIME_TO = "timeTo";
	public static final String DETAILS = "details";



    
    public void save(ResumeBean transientInstance) {
        log.debug("saving ResumeBean instance");
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
    
	public void delete(ResumeBean persistentInstance) {
        log.debug("deleting ResumeBean instance");
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
    
    public ResumeBean findById( java.lang.Integer id) {
        log.debug("getting ResumeBean instance with id: " + id);
        try {
            ResumeBean instance = (ResumeBean) getSession()
                    .get("com.novae.eswsplatform.bean.ResumeBean", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ResumeBean instance) {
        log.debug("finding ResumeBean instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.novae.eswsplatform.bean.ResumeBean")
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
      log.debug("finding ResumeBean instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ResumeBean as model where model." 
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
	
	public List findByTimeFrom(Object timeFrom
	) {
		return findByProperty(TIME_FROM, timeFrom
		);
	}
	
	public List findByTimeTo(Object timeTo
	) {
		return findByProperty(TIME_TO, timeTo
		);
	}
	
	public List findByDetails(Object details
	) {
		return findByProperty(DETAILS, details
		);
	}
	

	public List findAll() {
		log.debug("finding all ResumeBean instances");
		try {
			String queryString = "from ResumeBean";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ResumeBean merge(ResumeBean detachedInstance) {
        log.debug("merging ResumeBean instance");
        try {
            ResumeBean result = (ResumeBean) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ResumeBean instance) {
        log.debug("attaching dirty ResumeBean instance");
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
    
    public void attachClean(ResumeBean instance) {
        log.debug("attaching clean ResumeBean instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}