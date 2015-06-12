package com.novae.eswsplatform.dao;


import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.ExpertBean;


/**
 	* A data access object (DAO) providing persistence and search support for ExpertBean entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .ExpertBean
  * @author MyEclipse Persistence Tools 
 */
public class ExpertBeanDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(ExpertBeanDAO.class);
		//property constants
	public static final String ACCOUNT = "account";
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String SUB_GROUP = "subGroup";
	public static final String ROLE = "role";
	public static final String SUBMIT = "submit";



    
    public void save(ExpertBean transientInstance) {
        log.debug("saving ExpertBean instance");
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
    
	public void delete(ExpertBean persistentInstance) {
        log.debug("deleting ExpertBean instance");
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
    
    public ExpertBean findById( java.lang.Integer id) {
        log.debug("getting ExpertBean instance with id: " + id);
        try {
            ExpertBean instance = (ExpertBean) getSession()
                    .get("com.novae.eswsplatform.bean.ExpertBean", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(ExpertBean instance) {
        log.debug("finding ExpertBean instance by example");
        try {
            List results = getSession()
                    .createCriteria("com.novae.eswsplatform.bean.ExpertBean")
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
      log.debug("finding ExpertBean instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ExpertBean as model where model." 
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
	
	public List findBySubGroup(Object subGroup
	) {
		return findByProperty(SUB_GROUP, subGroup
		);
	}
	
	public List findByRole(Object role
	) {
		return findByProperty(ROLE, role
		);
	}
	
	public List findBySubmit(Object submit
	) {
		return findByProperty(SUBMIT, submit
		);
	}
	

	public List findAll() {
		log.debug("finding all ExpertBean instances");
		try {
			String queryString = "from ExpertBean";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ExpertBean merge(ExpertBean detachedInstance) {
        log.debug("merging ExpertBean instance");
        try {
            ExpertBean result = (ExpertBean) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ExpertBean instance) {
        log.debug("attaching dirty ExpertBean instance");
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
    
    public void attachClean(ExpertBean instance) {
        log.debug("attaching clean ExpertBean instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}