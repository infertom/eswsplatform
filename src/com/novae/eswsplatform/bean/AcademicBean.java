package com.novae.eswsplatform.bean;




/**
 * AcademicBean entity. @author MyEclipse Persistence Tools
 */
/**国内外学术组织任职情况
 * @author kinslayer
 *
 */
public class AcademicBean  implements java.io.Serializable {


    // Fields    

     private Integer primaryId;
     private Integer declarerId;
     private String job;


    // Constructors

    /** default constructor */
    public AcademicBean() {
    }

	/** minimal constructor */
    public AcademicBean(Integer declarerId) {
        this.declarerId = declarerId;
    }
    
    /** full constructor */
    public AcademicBean(Integer declarerId, String job) {
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
    
    /**获取申报者ID
     * @return 申报者ID
     */
    public Integer getDeclarerId() {
        return this.declarerId;
    }
    
    public void setDeclarerId(Integer declarerId) {
        this.declarerId = declarerId;
    }
    
    /**获取任职情况
     * @return 任职情况
     */
    public String getJob() {
        return this.job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }
   








}