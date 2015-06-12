package com.novae.eswsplatform.bean;




/**
 * DeclarerBean entity. @author MyEclipse Persistence Tools
 */
/**申报者基本信息表
 * @author kinslayer
 *
 */
public class DeclarerBean  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String account;
     private String name;
     private String password;
     private String workUnit;
     private Integer subject;
     private String idNum;
     private boolean sex;
     private String nation;
     private String eduBg;
     private String degree;
     private String party;
     private String birthDay;
     private String birthPlace;
     private String proJob;
     private String exeJob;
     private String telPerNum;
     private String telWorkNum;
     private String EMail;
     private String telHomeNum;
     private String photoPer;
     private String unitName;
     private String addrWork;
     private String addrHome;
     private String postcode;
     private String photoIdCard;
     private Integer groupId;
     private Integer refer;
     private String referReason;
     private boolean referRes;
     private Integer preJugdeCnt;
     private boolean preJugdeRes;
     private boolean fiJugdeRes;
     private boolean submit;


    // Constructors

    /** default constructor */
    public DeclarerBean() {
    }

    
    /** full constructor */
    public DeclarerBean(String account, String name, String password, String workUnit, Integer subject, String idNum, boolean sex, String nation, String eduBg, String degree, String party, String birthDay, String birthPlace, String proJob, String exeJob, String telPerNum, String telWorkNum, String EMail, String telHomeNum, String photoPer, String unitName, String addrWork, String addrHome, String postcode, String photoIdCard, Integer groupId, Integer refer, String referReason, boolean referRes, Integer preJugdeCnt, boolean preJugdeRes, boolean fiJugdeRes, boolean submit) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.workUnit = workUnit;
        this.subject = subject;
        this.idNum = idNum;
        this.sex = sex;
        this.nation = nation;
        this.eduBg = eduBg;
        this.degree = degree;
        this.party = party;
        this.birthDay = birthDay;
        this.birthPlace = birthPlace;
        this.proJob = proJob;
        this.exeJob = exeJob;
        this.telPerNum = telPerNum;
        this.telWorkNum = telWorkNum;
        this.EMail = EMail;
        this.telHomeNum = telHomeNum;
        this.photoPer = photoPer;
        this.unitName = unitName;
        this.addrWork = addrWork;
        this.addrHome = addrHome;
        this.postcode = postcode;
        this.photoIdCard = photoIdCard;
        this.groupId = groupId;
        this.refer = refer;
        this.referReason = referReason;
        this.referRes = referRes;
        this.preJugdeCnt = preJugdeCnt;
        this.preJugdeRes = preJugdeRes;
        this.fiJugdeRes = fiJugdeRes;
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
    /**姓名
     * @return 姓名
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
    /**工作单位
     * @return 工作单位
     */
    public String getWorkUnit() {
        return this.workUnit;
    }
    
    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }
    /**学科类别
     * @return 学科类别
     */
    public Integer getSubject() {
        return this.subject;
    }
    
    public void setSubject(Integer subject) {
        this.subject = subject;
    }
    /**身份证号码
     * @return 身份证号码
     */
    public String getIdNum() {
        return this.idNum;
    }
    
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }
    /**性别
     * @return 性别
     */
    public boolean getSex() {
        return this.sex;
    }
    
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    /**民族
     * @return 民族
     */
    public String getNation() {
        return this.nation;
    }
    
    public void setNation(String nation) {
        this.nation = nation;
    }
    /**学历
     * @return 学历
     */
    public String getEduBg() {
        return this.eduBg;
    }
    
    public void setEduBg(String eduBg) {
        this.eduBg = eduBg;
    }
    /**学位
     * @return 学位
     */
    public String getDegree() {
        return this.degree;
    }
    
    public void setDegree(String degree) {
        this.degree = degree;
    }
    /**党派
     * @return 党派
     */
    public String getParty() {
        return this.party;
    }
    
    public void setParty(String party) {
        this.party = party;
    }
    /**出生日期
     * @return 出生日期
     */
    public String getBirthDay() {
        return this.birthDay;
    }
    
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
    /**出生地
     * @return 出生地
     */
    public String getBirthPlace() {
        return this.birthPlace;
    }
    
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
    /**专业技术职务
     * @return 专业技术职务
     */
    public String getProJob() {
        return this.proJob;
    }
    
    public void setProJob(String proJob) {
        this.proJob = proJob;
    }
    /**行政职务
     * @return 行政职务
     */
    public String getExeJob() {
        return this.exeJob;
    }
    
    public void setExeJob(String exeJob) {
        this.exeJob = exeJob;
    }
    /**手 机 号 码
     * @return 手 机 号 码
     */
    public String getTelPerNum() {
        return this.telPerNum;
    }
    
    public void setTelPerNum(String telPerNum) {
        this.telPerNum = telPerNum;
    }
    /**单位电话
     * @return 单位电话
     */
    public String getTelWorkNum() {
        return this.telWorkNum;
    }
    
    public void setTelWorkNum(String telWorkNum) {
        this.telWorkNum = telWorkNum;
    }
    /**E-mail
     * @return E-mail
     */
    public String getEMail() {
        return this.EMail;
    }
    
    public void setEMail(String EMail) {
        this.EMail = EMail;
    }
    /**住宅电话
     * @return 住宅电话
     */
    public String getTelHomeNum() {
        return this.telHomeNum;
    }
    
    public void setTelHomeNum(String telHomeNum) {
        this.telHomeNum = telHomeNum;
    }
    /**本人照片
     * @return 本人照片
     */
    public String getPhotoPer() {
        return this.photoPer;
    }
    
    public void setPhotoPer(String photoPer) {
        this.photoPer = photoPer;
    }
    /**单位名称
     * @return 单位名称
     */
    public String getUnitName() {
        return this.unitName;
    }
    
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    /**单位地址
     * @return 单位地址
     */
    public String getAddrWork() {
        return this.addrWork;
    }
    
    public void setAddrWork(String addrWork) {
        this.addrWork = addrWork;
    }
    /**家庭地址
     * @return 家庭地址
     */
    public String getAddrHome() {
        return this.addrHome;
    }
    
    public void setAddrHome(String addrHome) {
        this.addrHome = addrHome;
    }
    /**邮编
     * @return 邮编
     */
    public String getPostcode() {
        return this.postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    /**身份证复印件
     * @return身份证复印件
     */
    public String getPhotoIdCard() {
        return this.photoIdCard;
    }
    
    public void setPhotoIdCard(String photoIdCard) {
        this.photoIdCard = photoIdCard;
    }
    /**所属学科组id
     * @return 所属学科组id
     */
    public Integer getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    /**推荐单位id
     * @return 推荐单位id
     */
    public Integer getRefer() {
        return this.refer;
    }
    
    public void setRefer(Integer refer) {
        this.refer = refer;
    }
    /**推荐理由
     * @return 推荐理由
     */
    public String getReferReason() {
        return this.referReason;
    }
    
    public void setReferReason(String referReason) {
        this.referReason = referReason;
    }
    /**推荐单位推荐结果
     * @return 推荐单位推荐结果
     */
    public boolean getReferRes() {
        return this.referRes;
    }
    
    public void setReferRes(boolean referRes) {
        this.referRes = referRes;
    }
    /**初评投票数
     * @return 初评投票数
     */
    public Integer getPreJugdeCnt() {
        return this.preJugdeCnt;
    }
    
    public void setPreJugdeCnt(Integer preJugdeCnt) {
        this.preJugdeCnt = preJugdeCnt;
    }
    /**初评结果
     * @return 初评结果
     */
    public boolean getPreJugdeRes() {
        return this.preJugdeRes;
    }
    
    public void setPreJugdeRes(boolean preJugdeRes) {
        this.preJugdeRes = preJugdeRes;
    }
    /**终评结果
     * @return 终评结果
     */
    public boolean getFiJugdeRes() {
        return this.fiJugdeRes;
    }
    
    public void setFiJugdeRes(boolean fiJugdeRes) {
        this.fiJugdeRes = fiJugdeRes;
    }
    /** 是否提交
     * @return 是否提交
     */
    public boolean getSubmit() {
        return this.submit;
    }
    
    public void setSubmit(boolean submit) {
        this.submit = submit;
    }
   








}