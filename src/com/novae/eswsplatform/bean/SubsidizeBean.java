package com.novae.eswsplatform.bean;




/**
 * SubsidizeBean entity. @author MyEclipse Persistence Tools
 */
/**基金资助
 * @author kinslayer 基金资助
 *
 */
public class SubsidizeBean  implements java.io.Serializable {


    // Fields    

     private Integer primaryId;
     private Integer declarerId;
     private String name;
     private Integer ranking;
     private String date;
     private String terms;
     private String detailsProj;


    // Constructors

    /** default constructor */
    public SubsidizeBean() {
    }

	/** minimal constructor */
    public SubsidizeBean(Integer declarerId) {
        this.declarerId = declarerId;
    }
    
    /** full constructor */
    public SubsidizeBean(Integer declarerId, String name, Integer ranking, String date, String terms, String detailsProj) {
        this.declarerId = declarerId;
        this.name = name;
        this.ranking = ranking;
        this.date = date;
        this.terms = terms;
        this.detailsProj = detailsProj;
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

    /**获基金资助项目名称
     * @return 获基金资助项目名称
     */
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    /**基金名次
     * @return 基金名次
     */
    public Integer getRanking() {
        return this.ranking;
    }
    
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    /**资助时间
     * @return 资助时间
     */
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    /**资助方式
     * @return 资助方式
     */
    public String getTerms() {
        return this.terms;
    }
    
    public void setTerms(String terms) {
        this.terms = terms;
    }

    /**目前项目完成情况
     * @return 目前项目完成情况
     */
    public String getDetailsProj() {
        return this.detailsProj;
    }
    
    public void setDetailsProj(String detailsProj) {
        this.detailsProj = detailsProj;
    }
   







}