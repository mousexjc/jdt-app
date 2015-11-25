package cn.chinajdt.bussiness.sys.model;

import java.io.Serializable;
import java.util.Date;

public class Sysuser implements Serializable {
    private String sysuserid;

    private String username;

    private String password;

    private Date createtime;

    private Integer status;

    private Integer isdelete;

    private String realname;

    private String mobile;

    private String email;

    private String qq;

    private String weixin;

    private Integer sex;

    private String remark;

    private Date regdate;

    private Integer auditstatus;

    private Integer usertype;

    private String address;

    private String image;

    private Date birthday;

    private String identifyid;

    private String bussnumber;

    private Integer emailverify;

    private Integer realnameverify;

    public String getSysuserid() {
        return sysuserid;
    }

    public void setSysuserid(String sysuserid) {
        this.sysuserid = sysuserid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public Integer getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(Integer auditstatus) {
        this.auditstatus = auditstatus;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdentifyid() {
        return identifyid;
    }

    public void setIdentifyid(String identifyid) {
        this.identifyid = identifyid == null ? null : identifyid.trim();
    }

    public String getBussnumber() {
        return bussnumber;
    }

    public void setBussnumber(String bussnumber) {
        this.bussnumber = bussnumber == null ? null : bussnumber.trim();
    }

    public Integer getEmailverify() {
        return emailverify;
    }

    public void setEmailverify(Integer emailverify) {
        this.emailverify = emailverify;
    }

    public Integer getRealnameverify() {
        return realnameverify;
    }

    public void setRealnameverify(Integer realnameverify) {
        this.realnameverify = realnameverify;
    }
}