package com.novae.eswsplatform.bean;




/**
 * ResumeBean entity. @author MyEclipse Persistence Tools
 */
/**简历
 * @author kinslayer 简历
 *
 */
public class ResumeBean  implements java.io.Serializable {


    // Fields    

     private Integer primaryId;
     private Integer declarerId;
     private String timeFrom;
     private String timeTo;
     private String details;


    // Constructors

    /** default constructor */
    public ResumeBean() {
    }

	/** minimal constructor */
    public ResumeBean(Integer declarerId) {
        this.declarerId = declarerId;
    }
    
    /** full constructor */
    public ResumeBean(Integer declarerId, String timeFrom, String timeTo, String details) {
        this.declarerId = declarerId;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
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

    /**起年月
     * @return 起年月
     */
    public String getTimeFrom() {
        return this.timeFrom;
    }
    
    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    /**止年月
     * @return 止年月
     */
    public String getTimeTo() {
        return this.timeTo;
    }
    
    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    /**在何单位（学校）任何职（读何专业）
     * @return 在何单位（学校）任何职（读何专业）
     */
    public String getDetails() {
        return this.details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }
   



}