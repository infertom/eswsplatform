package com.novae.eswsplatform.bean;




/**
 * AchConvertBean entity. @author MyEclipse Persistence Tools
 */
/**成果转化
 * @author kinslayer
 *
 */
public class AchConvertBean  implements java.io.Serializable {


    // Fields    

     private Integer primaryId;
     private Integer declarerId;
     private String details;


    // Constructors

    /** default constructor */
    public AchConvertBean() {
    }

	/** minimal constructor */
    public AchConvertBean(Integer declarerId) {
        this.declarerId = declarerId;
    }
    
    /** full constructor */
    public AchConvertBean(Integer declarerId, String details) {
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
     * @return
     */
    public Integer getDeclarerId() {
        return this.declarerId;
    }
    
    public void setDeclarerId(Integer declarerId) {
        this.declarerId = declarerId;
    }
    /**科技成果转化、科普和科技管理情况
     * @return
     */
    public String getDetails() {
        return this.details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
   








}