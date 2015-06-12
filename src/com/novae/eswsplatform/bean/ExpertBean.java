package com.novae.eswsplatform.bean;




/**
 * ExpertBean entity. @author MyEclipse Persistence Tools
 */

/**评审专家
 * @author kinslayer
 *
 */
public class ExpertBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String account;
     private String name;
     private String password;
     private Integer subGroup;
     private Integer role;
     private Boolean submit;


    // Constructors

    /** default constructor */
    public ExpertBean() {
    }

    
    /** full constructor */
    public ExpertBean(String account, String name, String password, Integer subGroup, Integer role, Boolean submit) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.subGroup = subGroup;
        this.role = role;
        this.submit = submit;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    /**账号
     * @return 账号
     */
    public String getAccount() {
        return this.account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }

    /**专家姓名
     * @return 专家姓名
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

    /**所属学科组id
     * @return 所属学科组id
     */
    public Integer getSubGroup() {
        return this.subGroup;
    }
    
    public void setSubGroup(Integer subGroup) {
        this.subGroup = subGroup;
    }

    /**角色
     * @return 角色
     */
    public Integer getRole() {
        return this.role;
    }
    
    public void setRole(Integer role) {
        this.role = role;
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