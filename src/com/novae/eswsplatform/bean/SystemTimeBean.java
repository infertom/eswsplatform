package com.novae.eswsplatform.bean;
// default package

import java.sql.Timestamp;


/**
 * SystemTimeBean entity. @author MyEclipse Persistence Tools
 */
/**开放时间
 * @author kinslayer 开放时间
 *
 */
public class SystemTimeBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Timestamp openTime;
     private Timestamp closeTime;


    // Constructors

    /** default constructor */
    public SystemTimeBean() {
    }

    
    /** full constructor */
    public SystemTimeBean(Timestamp openTime, Timestamp closeTime) {
        this.openTime = openTime;
        this.closeTime = closeTime;
    }

   
    // Property accessors
    /**角色
     * @return 角色
     */
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    /**开放时间
     * @return 开放时间
     */
    public Timestamp getOpenTime() {
        return this.openTime;
    }
    
    public void setOpenTime(Timestamp openTime) {
        this.openTime = openTime;
    }
    /**关闭时间
     * @return 关闭时间
     */
    public Timestamp getCloseTime() {
        return this.closeTime;
    }
    
    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }
   








}