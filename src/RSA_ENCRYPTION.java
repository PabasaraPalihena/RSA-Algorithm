import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Scanner;
import javax.crypto.Cipher;

public class RSA_ENCRYPTION {
    public static void main(String args[]) throws Exception{
        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generating the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Creating a Cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        //Initializing a Cipher object
        cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());

        Scanner sc = new Scanner(System.in);

        //Adding data to the cipher

        System.out.print("Enter the value : ");
        String inputValue = sc.next();
        byte[] input = inputValue.getBytes();
        cipher.update(input);

        //encrypting the data
        byte[] cipherText = cipher.doFinal();
        System.out.println("Encrypted data : " + new String(cipherText,"UTF8"));

    }
}
//import javax.crypto.Cipher;
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import javax.crypto.spec.GCMParameterSpec;
//import java.util.Base64;
//import java.util.Scanner;
//
//public class RSA_ENCRYPTION {
//    private SecretKey key;
//    private final int KEY_SIZE = 128;
//    private final int DATA_LENGTH = 128;
//    private Cipher encryptionCipher;
//
//    //create the encryption key
//    public void init() throws Exception {
//        KeyGenerator keyGenerator = KeyGenerator.getInstance("RSA");
//        //initialize the size of the key
//        keyGenerator.init(KEY_SIZE);
//        key = keyGenerator.generateKey();
//    }
//
//    //pass the data to encryption
//    public String encrypt(String data) throws Exception {
//        byte[] dataInBytes = data.getBytes();
//        encryptionCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
//        byte[] encryptedBytes = encryptionCipher.doFinal(dataInBytes);
//        return encode(encryptedBytes);
//    }
//
//    //decrypt the data
//    public String decrypt(String encryptedData) throws Exception {
//        byte[] dataInBytes = decode(encryptedData);
//        Cipher decryptionCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//        GCMParameterSpec spec = new GCMParameterSpec(DATA_LENGTH, encryptionCipher.getIV());
//        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
//        byte[] decryptedBytes = decryptionCipher.doFinal(dataInBytes);
//        return new String(decryptedBytes);
//    }
//
//    private String encode(byte[] data) {
//        return Base64.getEncoder().encodeToString(data);
//    }
//
//    private byte[] decode(String data) {
//        return Base64.getDecoder().decode(data);
//    }
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        try {
//
//            System.out.println();
//            System.out.print("Enter the value : ");
//            String inputValue = sc.next();
//
//            RSA_ENCRYPTION rsa_encryption = new RSA_ENCRYPTION();
//            rsa_encryption.init();
//
//            String encryptedData = rsa_encryption.encrypt(inputValue);
//
//            String decryptedData = rsa_encryption.decrypt(encryptedData);
//
//            System.out.println("Encrypted Data : " + encryptedData);
//            System.out.println("Decrypted Data : " + decryptedData);
//        } catch (Exception ignored) {
//        }
//    }
//}
//
//
