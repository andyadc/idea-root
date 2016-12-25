package com.idea.quickstart.entity;

import com.idea.quickstart.common.entity.BaseEntity;

import java.util.Date;

public class AuthUser extends BaseEntity {

    /**
     * 删除标记
     */
    public static final byte DELETED = 1;
    /**
     * 锁定状态
     */
    public static final byte STATUS_BLOCKED = 0;

    private String identity;

    private String account;

    private String password;

    private String salt;

    private String authType;

    private String nickname;

    private String realname;

    private String accessToken;

    private Date accessTokenExpireTime;

    private String phone;

    private String email;

    private Byte status;

    private Byte deleteFlag;

    private Date expireTime;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType == null ? null : authType.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public Date getAccessTokenExpireTime() {
        return accessTokenExpireTime;
    }

    public void setAccessTokenExpireTime(Date accessTokenExpireTime) {
        this.accessTokenExpireTime = accessTokenExpireTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String getCredentialsSalt() {
        return account + salt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AuthUser{");
        sb.append("account='").append(account).append('\'');
        sb.append(", identity='").append(identity).append('\'');
        sb.append(", authType='").append(authType).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", realname='").append(realname).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", status=").append(status);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append('}');
        return sb.toString();
    }
}