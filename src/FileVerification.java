import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;

import java.util.Scanner;

public class FileVerification{
    public static void main(String args[]) throws Exception {
        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generate the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Getting the privatekey from the key pair
        PrivateKey privKey = pair.getPrivate();

        //Creating a Signature object
        Signature sign = Signature.getInstance("SHA256withDSA");

        //Initialize the signature
        sign.initSign(privKey);
        byte[] bytes = "msg".getBytes();

        //Adding data to the signature
        sign.update(bytes);

        //Calculating the signature
        byte[] signature = sign.sign();

        //Accepting file from user
        // pass the path to the file as a parameter
        //added a text file to the mentioned location
        File file = new File("C:\\Users\\ASUS\\Downloads\\ssdtext.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());

        //Printing the signature
        System.out.println("Digital signature for given file: "+new String(signature, "UTF8"));

        //Verifying the signature
        //Initializing the signature
        sign.initVerify(pair.getPublic());

        //Adding data to the signature
        sign.update(bytes);

        //Verifying the signature
        boolean bool = sign.verify(signature);

        //Displaying the result
        System.out.println("Signature verified: "+bool);
    }
}