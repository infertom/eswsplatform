package com.novae.eswsplatform.bean;




/**
 * AwardBean entity. @author MyEclipse Persistence Tools
 */
/**科技奖励和荣誉称号
 * @author kinslayer
 *
 */
public class AwardBean  implements java.io.Serializable {


    // Fields    

     private Integer primaryId;
     private Integer declarerId;
     private String name;
     private String unit;
     private String date;
     private Integer total;
     private Integer ranking;


    // Constructors

    /** default constructor */
    public AwardBean() {
    }

	/** minimal constructor */
    public AwardBean(Integer declarerId) {
        this.declarerId = declarerId;
    }
    
    /** full constructor */
    public AwardBean(Integer declarerId, String name, String unit, String date, Integer total, Integer ranking) {
        this.declarerId = declarerId;
        this.name = name;
        this.unit = unit;
        this.date = date;
        this.total = total;
        this.ranking = ranking;
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
    /**奖励或荣誉名称
     * @return 奖励或荣誉名称
     */
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**授奖单位
     * @return 授奖单位
     */
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    /**授奖日期
     * @return 授奖日期
     */
    public String getDate() {
        return this.date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    /**获奖总人数
     * @return 获奖总人数
     */
    public Integer getTotal() {
        return this.total;
    }
    
    public void setTotal(Integer total) {
        this.total = total;
    }
    /**本人排名
     * @return 本人排名
     */
    public Integer getRanking() {
        return this.ranking;
    }
    
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
   








}