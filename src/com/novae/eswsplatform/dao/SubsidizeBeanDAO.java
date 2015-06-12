package com.novae.eswsplatform.dao;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.SubsidizeBean;


/**
 	* A data access object (DAO) providing persistence and search support for SubsidizeBean entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .SubsidizeBean
  * @author MyEclipse Persistence Tools 
 */
public class SubsidizeBeanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SubsidizeBeanDAO.class);
		//property constants
	public static final String DECLARER_ID = "declarerId";
	public static final String NAME = "name";
	public static final String RANKING = "ranking";
	public static final String DATE = "date";
	public static final String TERMS = "terms";
	public static final String DETAILS_PROJ = "detailsProj";



    
    public void save(SubsidizeBean transientInstance) {
        log.debug("saving SubsidizeBean instance");
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
    
	public void delete(SubsidizeBean persistentInstance) {
        log.debug("deleting SubsidizeBean instance");
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
    
    public SubsidizeBean findById( java.lang.Integer id) {
        log.debug("getting SubsidizeBean instance with id: " + id);
        try {
            SubsidizeBean instance = (SubsidizeBean) getSession()
                    .get("com.novae.eswsplatform.bean.SubsidizeBean", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(SubsidizeBean instance) {
        log.debug("finding SubsidizeBean instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.novae.eswsplatform.bean.SubsidizeBean")
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
      log.debug("finding SubsidizeBean instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SubsidizeBean as model where model." 
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
	
	public List findByRanking(Object ranking
	) {
		return findByProperty(RANKING, ranking
		);
	}
	
	public List findByDate(Object date
	) {
		return findByProperty(DATE, date
		);
	}
	
	public List findByTerms(Object terms
	) {
		return findByProperty(TERMS, terms
		);
	}
	
	public List findByDetailsProj(Object detailsProj
	) {
		return findByProperty(DETAILS_PROJ, detailsProj
		);
	}
	

	public List findAll() {
		log.debug("finding all SubsidizeBean instances");
		try {
			String queryString = "from SubsidizeBean";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public SubsidizeBean merge(SubsidizeBean detachedInstance) {
        log.debug("merging SubsidizeBean instance");
        try {
            SubsidizeBean result = (SubsidizeBean) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SubsidizeBean instance) {
        log.debug("attaching dirty SubsidizeBean instance");
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
    
    public void attachClean(SubsidizeBean instance) {
        log.debug("attaching clean SubsidizeBean instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}