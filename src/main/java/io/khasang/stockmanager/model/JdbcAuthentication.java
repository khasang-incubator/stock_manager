package io.khasang.stockmanager.model;

public class JdbcAuthentication {

    public String getSqlByUsernameQuery() {
        return "select username,password, enabled from users where username=?";
    }

    public String getSqlByUsernameRoleQuery() {
        return "select u.username, r.role_name " +
                "from user_roles ur " +
                "join users u on u.user_id = ur.user_id and u.username = ?  " +
                "join role r on r.role_id = ur.role_id";
    }

}
