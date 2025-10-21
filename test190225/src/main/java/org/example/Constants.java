package org.example;

public class Constants {
    private final String driverName = "D:\\WORK\\AT\\WebDriver\\chrome137\\chromedriver.exe";
    private static final String username = "q29125@dunkos.xyz";
    private static final String password = "Password123";
    private static final String badUsername = "q29125@dunkos.xyz123";
    private static final String badPassword = "Password123123";
    private static final String baseUrl = "https://dev-trading.incomex.org/login.html";

    /*private Constants(){
        this.password = "Password123";
        this.baseUrl = "https://dev-trading.incomex.org/login.html";
    }*/

    // Геттеры и сеттеры

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getBadUsername() {
        return badUsername;
    }

    public static String getBadPassword() {
        return badPassword;
    }

    public static String getUrl() {
        return baseUrl;
    }


    /*public void setUsername(String username) {
        this.username = username;
    }*/
}
