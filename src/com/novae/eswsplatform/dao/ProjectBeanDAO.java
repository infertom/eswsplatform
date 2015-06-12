package com.novae.eswsplatform.dao;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.ProjectBean;


/**
 	* A data access object (DAO) providing persistence and search support for ProjectBean entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ProjectBean
  * @author MyEclipse Persistence Tools 
 */
public class ProjectBeanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ProjectBeanDAO.class);
		//property constants
	public static final String DECLARER_ID = "declarerId";
	public static final String NAME = "name";
	public static final String UNIT = "unit";
	public static final String DETAILS = "details";
	public static final String BENEFIT = "benefit";



    
    public void save(ProjectBean transientInstance) {
        log.debug("saving ProjectBean instance");
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
    
	public void delete(ProjectBean persistentInstance) {
        log.debug("deleting ProjectBean instance");
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
    
    public ProjectBean findById( java.lang.Integer id) {
        log.debug("getting ProjectBean instance with id: " + id);
        try {
            ProjectBean instance = (ProjectBean) getSession()
                    .get("com.novae.eswsplatform.bean.ProjectBean", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ProjectBean instance) {
        log.debug("finding ProjectBean instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.novae.eswsplatform.bean.ProjectBean")
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
      log.debug("finding ProjectBean instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProjectBean as model where model." 
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
	
	public List findByDetails(Object details
	) {
		return findByProperty(DETAILS, details
		);
	}
	
	public List findByBenefit(Object benefit
	) {
		return findByProperty(BENEFIT, benefit
		);
	}
	

	public List findAll() {
		log.debug("finding all ProjectBean instances");
		try {
			String queryString = "from ProjectBean";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ProjectBean merge(ProjectBean detachedInstance) {
        log.debug("merging ProjectBean instance");
        try {
            ProjectBean result = (ProjectBean) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ProjectBean instance) {
        log.debug("attaching dirty ProjectBean instance");
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
    
    public void attachClean(ProjectBean instance) {
        log.debug("attaching clean ProjectBean instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}