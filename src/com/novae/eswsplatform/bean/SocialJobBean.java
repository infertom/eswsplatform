package com.novae.eswsplatform.bean;
// default package



/**
 * SocialJobBean entity. @author MyEclipse Persistence Tools
 */
/**社会职务
 * @author kinslayer 社会职务
 *
 */
public class SocialJobBean  implements java.io.Serializable {


    // Fields    

     private Integer primaryId;
     private Integer declarerId;
     private String job;


    // Constructors

    /** default constructor */
    public SocialJobBean() {
    }

	/** minimal constructor */
    public SocialJobBean(Integer declarerId) {
        this.declarerId = declarerId;
    }
    
    /** full constructor */
    public SocialJobBean(Integer declarerId, String job) {
        this.declarerId = declarerId;
        this.job = job;
    }

   
    // Property accessors

    public Integer getPrimaryId() {
        return this.primaryId;
    }
    
    public void setPrimaryId(Integer primaryId) {
        this.primaryId = primaryId;
    }
    /**申报者id
     * @return 申报者id
     */
    public Integer getDeclarerId() {
        return this.declarerId;
    }
    
    public void setDeclarerId(Integer declarerId) {
        this.declarerId = declarerId;
    }

    /**职务
     * @return 职务
     */
    public String getJob() {
        return this.job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }






}