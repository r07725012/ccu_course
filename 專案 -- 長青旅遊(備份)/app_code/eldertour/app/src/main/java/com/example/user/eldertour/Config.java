package com.example.user.eldertour;

/**
 * Created by user on 2017/2/18.
 */

public class Config {

    //Address of our scripts of the CRUD
    public static final String URL_Login="http://140.123.175.102:8080/eldertour/login.php ";
    public static final String URL_BECOME_MEMBER="http://140.123.175.102:8080/eldertour/becomeMember.php";
    public static final String URL_UPDATE_MEMBER="http://140.123.175.102:8080/eldertour/updateMember.php";
    public static final String URL_ALL_SUIT="https://chiayi.itour.org.tw:8090/api2/WebInfo/getTravelTourInfoByRange.php";
//    public static final String URL_GET_EMP = "http://140.123.175.102:8080/androidtest/getEmp.php?id=";
//    public static final String URL_UPDATE_EMP = "http://140.123.175.102:8080/androidtest/updateEmp.php";


    //Keys that will be used to send the request to php scripts
    public static final String KEY_MEMBER_ACCOUNT = "account"; // $_POST['account'] use the name
    public static final String KEY_MEMBER_PASSWORD = "password";
    public static final String KEY_MEMBER_NAME = "name";
    public static final String KEY_MEMBER_SEX = "sex";
    public static final String KEY_MEMBER_PHONE = "phone";
    public static final String KEY_MEMBER_EMAIL = "email";
    public static final String KEY_MEMBER_LOGIN = "login";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_SUIT_NAME = "suit_name";
    public static final String TAG_SUIT_PICTURE = "suit_pic";

    public static final String TAG_ACCOUNT = "account";
    public static final String TAG_PASSWORD = "password";

    //employee id to pass with intent
    //public static final String EMP_ID = "emp_id";
}
