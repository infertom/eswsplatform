package com.novae.eswsplatform.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.novae.eswsplatform.bean.DeclarerBean;

/**
 * A data access object (DAO) providing persistence and search support for
 * DeclarerBean entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .DeclarerBean
 * @author MyEclipse Persistence Tools
 */
public class DeclarerBeanDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DeclarerBeanDAO.class);
	// property constants
	public static final String ACCOUNT = "account";
	public static final String NAME = "name";
	public static final String PASSWORD = "password";
	public static final String WORK_UNIT = "workUnit";
	public static final String SUBJECT = "subject";
	public static final String ID_NUM = "idNum";
	public static final String SEX = "sex";
	public static final String NATION = "nation";
	public static final String EDU_BG = "eduBg";
	public static final String DEGREE = "degree";
	public static final String PARTY = "party";
	public static final String BIRTH_DAY = "birthDay";
	public static final String BIRTH_PLACE = "birthPlace";
	public static final String PRO_JOB = "proJob";
	public static final String EXE_JOB = "exeJob";
	public static final String TEL_PER_NUM = "telPerNum";
	public static final String TEL_WORK_NUM = "telWorkNum";
	public static final String _EMAIL = "EMail";
	public static final String TEL_HOME_NUM = "telHomeNum";
	public static final String PHOTO_PER = "photoPer";
	public static final String UNIT_NAME = "unitName";
	public static final String ADDR_WORK = "addrWork";
	public static final String ADDR_HOME = "addrHome";
	public static final String POSTCODE = "postcode";
	public static final String PHOTO_ID_CARD = "photoIdCard";
	public static final String GROUP_ID = "groupId";
	public static final String REFER = "refer";
	public static final String REFER_REASON = "referReason";
	public static final String REFER_RES = "referRes";
	public static final String PRE_JUGDE_CNT = "preJugdeCnt";
	public static final String PRE_JUGDE_RES = "preJugdeRes";
	public static final String FI_JUGDE_RES = "fiJugdeRes";
	public static final String SUBMIT = "submit";

	public void save(DeclarerBean transientInstance) {
		log.debug("saving DeclarerBean instance");
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

	public void delete(DeclarerBean persistentInstance) {
		log.debug("deleting DeclarerBean instance");
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

	public DeclarerBean findById(java.lang.Integer id) {
		log.debug("getting DeclarerBean instance with id: " + id);
		try {
			DeclarerBean instance = (DeclarerBean) getSession().get(
					"com.novae.eswsplatform.bean.DeclarerBean", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(DeclarerBean instance) {
		log.debug("finding DeclarerBean instance by example");
		try {
			List results = getSession().createCriteria("com.novae.eswsplatform.bean.DeclarerBean")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding DeclarerBean instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from DeclarerBean as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAccount(Object account) {
		return findByProperty(ACCOUNT, account);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByWorkUnit(Object workUnit) {
		return findByProperty(WORK_UNIT, workUnit);
	}

	public List findBySubject(Object subject) {
		return findByProperty(SUBJECT, subject);
	}

	public List findByIdNum(Object idNum) {
		return findByProperty(ID_NUM, idNum);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByNation(Object nation) {
		return findByProperty(NATION, nation);
	}

	public List findByEduBg(Object eduBg) {
		return findByProperty(EDU_BG, eduBg);
	}

	public List findByDegree(Object degree) {
		return findByProperty(DEGREE, degree);
	}

	public List findByParty(Object party) {
		return findByProperty(PARTY, party);
	}

	public List findByBirthDay(Object birthDay) {
		return findByProperty(BIRTH_DAY, birthDay);
	}

	public List findByBirthPlace(Object birthPlace) {
		return findByProperty(BIRTH_PLACE, birthPlace);
	}

	public List findByProJob(Object proJob) {
		return findByProperty(PRO_JOB, proJob);
	}

	public List findByExeJob(Object exeJob) {
		return findByProperty(EXE_JOB, exeJob);
	}

	public List findByTelPerNum(Object telPerNum) {
		return findByProperty(TEL_PER_NUM, telPerNum);
	}

	public List findByTelWorkNum(Object telWorkNum) {
		return findByProperty(TEL_WORK_NUM, telWorkNum);
	}

	public List findByEMail(Object EMail) {
		return findByProperty(_EMAIL, EMail);
	}

	public List findByTelHomeNum(Object telHomeNum) {
		return findByProperty(TEL_HOME_NUM, telHomeNum);
	}

	public List findByPhotoPer(Object photoPer) {
		return findByProperty(PHOTO_PER, photoPer);
	}

	public List findByUnitName(Object unitName) {
		return findByProperty(UNIT_NAME, unitName);
	}

	public List findByAddrWork(Object addrWork) {
		return findByProperty(ADDR_WORK, addrWork);
	}

	public List findByAddrHome(Object addrHome) {
		return findByProperty(ADDR_HOME, addrHome);
	}

	public List findByPostcode(Object postcode) {
		return findByProperty(POSTCODE, postcode);
	}

	public List findByPhotoIdCard(Object photoIdCard) {
		return findByProperty(PHOTO_ID_CARD, photoIdCard);
	}

	public List findByGroupId(Object groupId) {
		return findByProperty(GROUP_ID, groupId);
	}

	public List findByRefer(Object refer) {
		return findByProperty(REFER, refer);
	}

	public List findByReferReason(Object referReason) {
		return findByProperty(REFER_REASON, referReason);
	}

	public List findByReferRes(Object referRes) {
		return findByProperty(REFER_RES, referRes);
	}

	public List findByPreJugdeCnt(Object preJugdeCnt) {
		return findByProperty(PRE_JUGDE_CNT, preJugdeCnt);
	}

	public List findByPreJugdeRes(Object preJugdeRes) {
		return findByProperty(PRE_JUGDE_RES, preJugdeRes);
	}

	public List findByFiJugdeRes(Object fiJugdeRes) {
		return findByProperty(FI_JUGDE_RES, fiJugdeRes);
	}

	public List findBySubmit(Object submit) {
		return findByProperty(SUBMIT, submit);
	}

	public List findAll() {
		log.debug("finding all DeclarerBean instances");
		try {
			String queryString = "from DeclarerBean";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public DeclarerBean merge(DeclarerBean detachedInstance) {
		log.debug("merging DeclarerBean instance");
		try {
			DeclarerBean result = (DeclarerBean) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(DeclarerBean instance) {
		log.debug("attaching dirty DeclarerBean instance");
		try {
			Session session = getSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(instance);
			transaction.commit();
			session.close();
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(DeclarerBean instance) {
		log.debug("attaching clean DeclarerBean instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}