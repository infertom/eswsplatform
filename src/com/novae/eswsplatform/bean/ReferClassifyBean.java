package com.novae.eswsplatform.bean;




/**
 * ReferClassifyBean entity. @author MyEclipse Persistence Tools
 */

/**推荐单位大类分类
 * @author kinslayer 推荐单位大类分类
 *
 */
public class ReferClassifyBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String name;


    // Constructors

    /** default constructor */
    public ReferClassifyBean() {
    }

    
    /** full constructor */
    public ReferClassifyBean(String name) {
        this.name = name;
    }

   
    // Property accessors

    /**id
     * @return id
     */
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    /**大类名称
     * @return 大类名称
     */
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   








}