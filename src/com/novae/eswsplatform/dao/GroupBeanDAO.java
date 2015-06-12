package com.novae.eswsplatform.dao;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.GroupBean;


/**
 	* A data access object (DAO) providing persistence and search support for GroupBean entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .GroupBean
  * @author MyEclipse Persistence Tools 
 */
public class GroupBeanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(GroupBeanDAO.class);
		//property constants
	public static final String ACCOUNT = "account";
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String QUOTA = "quota";
	public static final String SUBMIT = "submit";



    
    public void save(GroupBean transientInstance) {
        log.debug("saving GroupBean instance");
        try {
        	Session session = getSession();
			Transaction transaction = session.beginTransaction();
            session.save(transientInstance);
			transaction.commit();
			session.close();
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(GroupBean persistentInstance) {
        log.debug("deleting GroupBean instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public GroupBean findById( java.lang.Integer id) {
        log.debug("getting GroupBean instance with id: " + id);
        try {
            GroupBean instance = (GroupBean) getSession()
                    .get("com.novae.eswsplatform.bean.GroupBean", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(GroupBean instance) {
        log.debug("finding GroupBean instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.novae.eswsplatform.bean.GroupBean")
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
      log.debug("finding GroupBean instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from GroupBean as model where model." 
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
	
	public List findBySubmit(Object submit
	) {
		return findByProperty(SUBMIT, submit
		);
	}
	

	public List findAll() {
		log.debug("finding all GroupBean instances");
		try {
			String queryString = "from GroupBean";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public GroupBean merge(GroupBean detachedInstance) {
        log.debug("merging GroupBean instance");
        try {
            GroupBean result = (GroupBean) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(GroupBean instance) {
        log.debug("attaching dirty GroupBean instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(GroupBean instance) {
        log.debug("attaching clean GroupBean instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}