package com.novae.eswsplatform.bean;




/**
 * ReferBean entity. @author MyEclipse Persistence Tools
 */
/**推荐单位
 * @author kinslayer
 *
 */
public class ReferBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String account;
     private String name;
     private String password;
     private Integer quota;
     private Integer classifyId;
     private boolean submit;


    // Constructors

    /** default constructor */
    public ReferBean() {
    }

	/** minimal constructor */
    public ReferBean(Integer classifyId) {
        this.classifyId = classifyId;
    }
    
    /** full constructor */
    public ReferBean(String account, String name, String password, Integer quota, Integer classifyId, boolean submit) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.quota = quota;
        this.classifyId = classifyId;
        this.submit = submit;
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
    /**推荐单位账号
     * @return 推荐单位账号
     */
    public String getAccount() {
        return this.account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
    /**推荐单位名称
     * @return 推荐单位名称
     */
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    /**密码
     * @return 密码
     */
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    /**推荐单位名额
     * @return 推荐单位名额
     */
    public Integer getQuota() {
        return this.quota;
    }
    
    public void setQuota(Integer quota) {
        this.quota = quota;
    }
    /**推荐单位分类ID
     * @return 推荐单位分类ID
     */
    public Integer getClassifyId() {
        return this.classifyId;
    }
    
    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }
    /**是否提交
     * @return 是否提交
     */
    public boolean getSubmit() {
        return this.submit;
    }
    
    public void setSubmit(boolean submit) {
        this.submit = submit;
    }
   








}