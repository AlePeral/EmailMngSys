package emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLenght = 10;
    private String department;
    private int mailboxCapacity = 50;
    private String email;
    private String alternativeEmail;


    //Contructor. Parametros nombre y apellido
    public Email(){
        this.firstName = setFirstName();
        this.lastName = setLastName();


        //Llamamos el metodo sobre el departamento al que desea llamar y lo regresa
        this.department = setDepartment();

        //Llamamos al metodo que nos regresa una contraseña aleatoria
        this.password = randomPassword(defaultPasswordLenght);
        System.out.println("Your password is: "+this.password);

        // Generar el email
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+ ".youtube.com";
    }

    private  String setFirstName(){
        System.out.println("Enter first name: ");
        Scanner scanner = new Scanner(System.in);
        this.firstName = scanner.nextLine();


        return this.firstName;
    }

    private String setLastName(){
        System.out.println("Enter last name: ");
        Scanner scanner = new Scanner(System.in);
        this.lastName = scanner.nextLine();

        return this.lastName;
    }

    private String setDepartment(){
        System.out.print("New worker: "+ firstName+" "+ lastName+ ". \nDEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none \nEnter department code: ");
        Scanner scanner = new Scanner(System.in);
        int deparmentChoice = scanner.nextInt();
        if(deparmentChoice == 1){
            return "sales";
        } else if (deparmentChoice == 2) {
            return "dev";
        } else if (deparmentChoice == 3) {
            return "acct";
        }else {
            return "";
        }
    }

    //RamondonPassword genera una contraseña aleatoria
    //String passwordSet son los caracteres que se pueden utilizar para generarla
    // en cada iteracion del bucle se crea un numero int aleatorio y se multp x el largo de psswrd set.

    private String randomPassword(int lenght){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYS123456789!@#$%";
        char [] password = new char [lenght];
        for(int i = 0; i<lenght; i++){
            int randValue =(int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randValue);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public void setAlternativeEmail(String altEmail){
        this.alternativeEmail = altEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }


    // estos metodos acceden a las propiedades. Encapsulación
    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternativeEmail(){
        return alternativeEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display name: "+firstName + " " + lastName + "\nCompany email: "+ email + "\nMailbox capacity: "+mailboxCapacity+ "mb";
    }

}
