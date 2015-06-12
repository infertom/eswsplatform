package com.novae.eswsplatform.dao;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.AwardBean;


/**
 	* A data access object (DAO) providing persistence and search support for AwardBean entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .AwardBean
  * @author MyEclipse Persistence Tools 
 */
public class AwardBeanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AwardBeanDAO.class);
		//property constants
	public static final String DECLARER_ID = "declarerId";
	public static final String NAME = "name";
	public static final String UNIT = "unit";
	public static final String DATE = "date";
	public static final String TOTAL = "total";
	public static final String RANKING = "ranking";



    
    public void save(AwardBean transientInstance) {
        log.debug("saving AwardBean instance");
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
    
	public void delete(AwardBean persistentInstance) {
        log.debug("deleting AwardBean instance");
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
    
    public AwardBean findById( java.lang.Integer id) {
        log.debug("getting AwardBean instance with id: " + id);
        try {
            AwardBean instance = (AwardBean) getSession()
                    .get("com.novae.eswsplatform.bean.AwardBean", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(AwardBean instance) {
        log.debug("finding AwardBean instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.novae.eswsplatform.bean.AwardBean")
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
      log.debug("finding AwardBean instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AwardBean as model where model." 
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
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByUnit(Object unit
	) {
		return findByProperty(UNIT, unit
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByTotal(Object total
	) {
		return findByProperty(TOTAL, total
		);
	}
	
	public List findByRanking(Object ranking
	) {
		return findByProperty(RANKING, ranking
		);
	}
	

	public List findAll() {
		log.debug("finding all AwardBean instances");
		try {
			String queryString = "from AwardBean";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AwardBean merge(AwardBean detachedInstance) {
        log.debug("merging AwardBean instance");
        try {
            AwardBean result = (AwardBean) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AwardBean instance) {
        log.debug("attaching dirty AwardBean instance");
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
    
    public void attachClean(AwardBean instance) {
        log.debug("attaching clean AwardBean instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}