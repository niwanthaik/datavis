package org.uom.fit.level2.datavis.model.login;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String email;

    private String password;

    private String country;

/*    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Roler> roles;*/

    private String userType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {return userName;}

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassiword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {this.userType = userType;}

  /* public Set<Roler> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roler> roles) {
        this.roles = roles;
    }*/

}
