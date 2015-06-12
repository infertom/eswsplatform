package com.novae.eswsplatform.dao;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.ReferBean;


/**
 	* A data access object (DAO) providing persistence and search support for ReferBean entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ReferBean
  * @author MyEclipse Persistence Tools 
 */
public class ReferBeanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ReferBeanDAO.class);
		//property constants
	public static final String ACCOUNT = "account";
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String QUOTA = "quota";
	public static final String CLASSIFY_ID = "classifyId";
	public static final String SUBMIT = "submit";



    
    public void save(ReferBean transientInstance) {
        log.debug("saving ReferBean instance");
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
    
	public void delete(ReferBean persistentInstance) {
        log.debug("deleting ReferBean instance");
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
    
    public ReferBean findById( java.lang.Integer id) {
        log.debug("getting ReferBean instance with id: " + id);
        try {
            ReferBean instance = (ReferBean) getSession()
                    .get("com.novae.eswsplatform.bean.ReferBean", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ReferBean instance) {
        log.debug("finding ReferBean instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.novae.eswsplatform.bean.ReferBean")
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
      log.debug("finding ReferBean instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ReferBean as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByAccount(Object account
	) {
		return findByProperty(ACCOUNT, account
		);
	}
	
	public List findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List findByQuota(Object quota
	) {
		return findByProperty(QUOTA, quota
		);
	}
	
	public List findByClassifyId(Object classifyId
	) {
		return findByProperty(CLASSIFY_ID, classifyId
		);
	}
	
	public List findBySubmit(Object submit
	) {
		return findByProperty(SUBMIT, submit
		);
	}
	

	public List findAll() {
		log.debug("finding all ReferBean instances");
		try {
			String queryString = "from ReferBean";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ReferBean merge(ReferBean detachedInstance) {
        log.debug("merging ReferBean instance");
        try {
            ReferBean result = (ReferBean) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ReferBean instance) {
        log.debug("attaching dirty ReferBean instance");
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
    
    public void attachClean(ReferBean instance) {
        log.debug("attaching clean ReferBean instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}