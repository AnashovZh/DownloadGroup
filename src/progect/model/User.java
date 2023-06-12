package progect.model;

public class User {

    private String email="admin@gmail.com";
    private String password="admin123";


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void uppDatePassword(String email,String newPassword){
        try{
            if (newPassword.length()<8){
                throw new MyException("Parol 8 den kem emes boluusu kerek");
            }
   if (email.equalsIgnoreCase(getEmail())){
       setPassword(newPassword);
   }
    }catch (MyException m){
            System.err.println(m.getMessage());
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}