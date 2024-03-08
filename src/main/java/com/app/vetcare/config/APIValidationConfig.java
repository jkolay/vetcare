package com.app.vetcare.config;

public class APIValidationConfig {

    public static final String AGENT_ID_NOT_NULL = "Agent Id can not be blank";
    public static final String EMAIL_NOT_NULL = "Email can not be blank";
    public static final String MOBILE_NOT_NULL = "mobile number can not be blank";
    public static final String PASSWORD_NOT_NULL = "password can not be blank";
    public static final String ROLE_NOT_NULL = "Role can not be blank";

    public static final String INVALID_USER_ROLE = "invalid user role. Role can be either Admin or Agent";
    public static final String INVALID_NAME = "Agent Name Not Valid";
    public static final String INVALID_ADDRES = "Agent address is invalid";
    public static final String INVALID_PHONEMUMBER = "Agent phone number is not valid";
    public static final String INVALID_EMAIL = "Agent email is not valid";
    public static final String INVALID_ADHAR = "Agent adhar is not valid";
    public static final String PET_TYPE_NOT_VALID = "Pet type not valid";
    public static final String BREED_NOT_VALID = "Breed is not valid";
    public static final String OWNER_NAME_NOT_VALID = "Owner name can not be blank and should have only alphabets";
    public static final String OWNER_PHONE_NUMBER_NOT_VALID = "Owner phone number can not be blank. 10 digits are mandatory in phone number";
}
