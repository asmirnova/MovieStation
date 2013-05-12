package com.movie.pers.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Aloren
 */
public class User implements Serializable {
    
    private static final String STANDART_PIC_URL = "/resources/images/nopic.gif";

    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Date birthday;
    private String phoneNumber;
    private List<Movie> favorites = Collections.<Movie>emptyList();
    private String picUrl;

    public User() {
    }

    public User(String firstName, String lastName, String username, String password, String email) {
        this(null, firstName, lastName, username, password, email, null, null);
    }

    public User(Integer id, String firstName, String lastName, String username, String password, String email) {
        this(id, firstName, lastName, username, password, email, null, null);
    }

    public User(String firstName, String lastName, String username, String password, String email, Date birthday, String phoneNumber, String picUrl) {
        this(null, firstName, lastName, username, password, email, birthday, phoneNumber, picUrl);
    }

    public User(Integer id, String firstName, String lastName, String username, String password, String email, Date birthday, String phoneNumber) {
        this(id, firstName, lastName, username, password, email, birthday, phoneNumber, STANDART_PIC_URL);
    }

    public User(Integer id, String firstName, String lastName, String username, String password, String email, Date birthday, String phoneNumber, String picUrl) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.picUrl = picUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Movie> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Movie> favorites) {
        this.favorites = favorites;
    }

    public String getPicUrl() {
        if(StringUtils.isEmpty(picUrl)){
            return STANDART_PIC_URL;
        }
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", username=" + username
                + ", password=" + password
                + ", email=" + email
                + ", birthday=" + birthday
                + ", phoneNumber=" + phoneNumber
                + ", favorites=" + favorites + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        hash = 83 * hash + Objects.hashCode(this.firstName);
        hash = 83 * hash + Objects.hashCode(this.lastName);
        hash = 83 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
}
