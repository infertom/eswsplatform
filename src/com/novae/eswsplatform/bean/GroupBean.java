package com.novae.eswsplatform.bean;




/**
 * GroupBean entity. @author MyEclipse Persistence Tools
 */

/**学科组
 * @author kinslayer
 *
 */
public class GroupBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String account;
     private String name;
     private String password;
     private Integer quota;
     private Boolean submit;


    // Constructors

    /** default constructor */
    public GroupBean() {
    }

    
    /** full constructor */
    public GroupBean(String account, String name, String password, Integer quota, Boolean submit) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.quota = quota;
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

    /**登陆账号
     * @return 登陆账号
     */
    public String getAccount() {
        return this.account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }

    /**学科组名称
     * @return 学科组名称
     */
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    /**登陆密码
     * @return 登陆密码
     */
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    /**分配名额 
     * @return 分配名额
     */
    public Integer getQuota() {
        return this.quota;
    }
    
    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    /**是否提交
     * @return 是否提交
     */
    public Boolean getSubmit() {
        return this.submit;
    }
    
    public void setSubmit(Boolean submit) {
        this.submit = submit;
    }
   








}