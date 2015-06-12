package com.novae.eswsplatform.bean;




/**
 * ProjectBean entity. @author MyEclipse Persistence Tools
 */
/**工程技术项目
 * @author kinslayer 工程技术项目
 *
 */
public class ProjectBean  implements java.io.Serializable {


    // Fields    

     private Integer primaryId;
     private Integer declarerId;
     private String name;
     private String unit;
     private String details;
     private Integer benefit;


    // Constructors

    /** default constructor */
    public ProjectBean() {
    }

	/** minimal constructor */
    public ProjectBean(Integer declarerId) {
        this.declarerId = declarerId;
    }
    
    /** full constructor */
    public ProjectBean(Integer declarerId, String name, String unit, String details, Integer benefit) {
        this.declarerId = declarerId;
        this.name = name;
        this.unit = unit;
        this.details = details;
        this.benefit = benefit;
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
    /**项目名称
     * @return 项目名称
     */
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    /**项目委托单位
     * @return 项目委托单位
     */
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**本人参与情况 
     * @return 本人参与情况
     */
    public String getDetails() {
        return this.details;
    }
    
    public void setDetails(String details) {
        this.details = details;
    }

    /**经济效益（万元）
     * @return 经济效益（万元）
     */
    public Integer getBenefit() {
        return this.benefit;
    }
    
    public void setBenefit(Integer benefit) {
        this.benefit = benefit;
    }




}