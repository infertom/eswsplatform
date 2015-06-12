package com.novae.eswsplatform.bean;




/**
 * TreatiseBean entity. @author MyEclipse Persistence Tools
 */
/**论文和专著
 * @author kinslayer 论文和专著
 *
 */
public class TreatiseBean  implements java.io.Serializable {


    // Fields    

     private Integer primaryId;
     private Integer declarerId;
     private String details;


    // Constructors

    /** default constructor */
    public TreatiseBean() {
    }

	/** minimal constructor */
    public TreatiseBean(Integer declarerId) {
        this.declarerId = declarerId;
    }
    
    /** full constructor */
    public TreatiseBean(Integer declarerId, String details) {
        this.declarerId = declarerId;
        this.details = details;
    }

   
    // Property accessors

    public Integer getPrimaryId() {
        return this.primaryId;
    }
    
    public void setPrimaryId(Integer primaryId) {
        this.primaryId = primaryId;
    }
    /**申报者ID
     * @return 申报者ID
     */
    public Integer getDeclarerId() {
        return this.declarerId;
    }
    
    public void setDeclarerId(Integer declarerId) {
        this.declarerId = declarerId;
    }

    /**论文和专著情况
     * @return 论文和专著情况
     */
    public String getDetails() {
        return this.details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
   






}