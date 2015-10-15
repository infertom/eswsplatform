package com.novae.eswsplatform.bean;
// default package



/**
 * SubjectBean entity. @author MyEclipse Persistence Tools
 */

public class SubjectBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;
     private Integer groupId;


    // Constructors

    /** default constructor */
    public SubjectBean() {
    }

	/** minimal constructor */
    public SubjectBean(String name) {
        this.name = name;
    }
    
    /** full constructor */
    public SubjectBean(String name, Integer groupId) {
        this.name = name;
        this.groupId = groupId;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
   








}