package data;

import model.request.SignUpRequestBodyPOST;

public class SignUpDataFactory {

    private SignUpRequestBodyPOST request;

    public SignUpDataFactory(SignUpRequestBodyPOST requestBody){
        request = requestBody;
    }

    public SignUpDataFactory setEmail(String value){
        request.setEmail(value);
        return this;
    }

    public SignUpDataFactory setPassword(String value){
        request.setPassword(value);
        return this;
    }

    public SignUpDataFactory setFirstName(String value){
        request.setFirstName(value);
        return this;
    }

    public SignUpDataFactory setLastName(String value){
        request.setLastName(value);
        return this;
    }

    public SignUpDataFactory setUsername(String value){
        request.setUsername(value);
        return this;
    }

    public SignUpDataFactory setDateOfBirth(String value){
        request.setDateOfBirth(value);
        return this;
    }

    public SignUpRequestBodyPOST createRequest(){
        return request;
    }

}
