package rest.request;

import java.util.List;

/**
 * Задание2
 * [{
 * "login":"name",
 * "password":"passw0rd"
 * },
 * {
 * "login":"name2",
 * "password":"passw0rd2"
 * }]
 */

public class Task_2 {
    private List<InnerClass> auth;

    public static class InnerClass {
        private String login;
        private String password;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public InnerClass() {
        }
    }
}

