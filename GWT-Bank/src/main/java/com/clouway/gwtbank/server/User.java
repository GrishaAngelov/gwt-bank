package com.clouway.gwtbank.server;

import com.clouway.gwtbank.validation.CheckNotStartWithDigit;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class User {

    private Long id;
    private Long version = 1L;

    @NotNull
    @Size(min = 4, message = "Username must be at least 4 symbols")
    @CheckNotStartWithDigit(message = "Username must not start with digit")
    private String username;

    @NotNull
    @Size(min = 4, message = "Password must be at least 4 symbols")
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!password.equals(user.password)) return false;
        if (!username.equals(user.username)) return false;
        if (!version.equals(user.version)) return false;

        return true;
    }
}
