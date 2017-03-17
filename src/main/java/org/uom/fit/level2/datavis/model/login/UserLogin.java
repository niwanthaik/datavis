package org.uom.fit.level2.datavis.model.login;

import javax.persistence.Entity;

/**
 * Created by asiri on 3/15/17.
 */
public class UserLogin {
    private String userName;
    private String password;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the passWord
     */
    public String getPassWord() {
        return password;
    }

    /**
     * @param password the passWord to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
