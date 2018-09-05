package com.online.data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Administrator {
    @Override
    public String toString() {
        return "Administrator{" +
                "administratorid='" + administratorid + '\'' +
                ", administratorpasswd='" + administratorpasswd + '\'' +
                '}';
    }

    private String administratorid;
    private String administratorpasswd;

    @Id
    @Column(name = "administratorid")
    public String getAdministratorid() {
        return administratorid;
    }

    public void setAdministratorid(String administratorid) {
        this.administratorid = administratorid;
    }

    @Basic
    @Column(name = "administratorpasswd")
    public String getAdministratorpasswd() {
        return administratorpasswd;
    }

    public void setAdministratorpasswd(String administratorpasswd) {
        this.administratorpasswd = administratorpasswd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return Objects.equals(administratorid, that.administratorid) &&
                Objects.equals(administratorpasswd, that.administratorpasswd);
    }

    @Override
    public int hashCode() {

        return Objects.hash(administratorid, administratorpasswd);
    }
}
