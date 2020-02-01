package secretswamp.simpleencryption;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.security.KeyPair;

import secretswamp.simpleencryption.pgp.PGPUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bruh();
    }

    private void bruh() {
        String data = "dshfasdfsdlfs";
        KeyPair aliceKeyPair = PGPUtils.generateUserKeyPair();
        KeyPair bobKeyPair = PGPUtils.generateUserKeyPair();

        // Sending a message from alice to bob:

        System.out.println("The message before alice encrypts is: \n" + data);

        String encryptedMessage = PGPUtils.encryptMessage(data, bobKeyPair.getPublic());
        System.out.println("The encrypted message in transit is: \n" + encryptedMessage);

        String decryptedMessage = PGPUtils.decryptMessage(encryptedMessage, bobKeyPair.getPrivate());
        System.out.println("The message after bob decrypts is: \n" + decryptedMessage);
    }
}
