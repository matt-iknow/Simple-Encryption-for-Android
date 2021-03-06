package secretswamp.simpleencryption;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import secretswamp.simpleencryption.Crypt.CryptUtils;
import secretswamp.simpleencryption.Crypt.KeyStore;
import secretswamp.simpleencryption.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class EncryptMessageFragment extends Fragment {
    private static final String TAG = "encrypt";

    private Button btnTEST;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(secretswamp.simpleencryption.R.layout.tab3,container,false);
        btnTEST = (Button) view.findViewById(secretswamp.simpleencryption.R.id.btnTEST3);

        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bruh();
            }
        });

        return view;
    }

    public void bruh() {
        Toast.makeText(getActivity(), "Encrypting...", Toast.LENGTH_SHORT).show();
        String messageToEncrypt;
        String recipientPublicKey;
        KeyStore keys = KeyStore.getKeyStoreInstance();
        keys.loadKeys(getContext());
        try {
            messageToEncrypt = ((EditText) (getView().findViewById(R.id.userinputtext))).getText().toString();
            recipientPublicKey = ((EditText) (getView().findViewById(R.id.pubkeytext))).getText().toString();
        } catch (NullPointerException e) {
            return;
        }
        if(messageToEncrypt.length() != 0 && recipientPublicKey.length() != 0){
            Toast.makeText(getActivity(), "Encrypting...",Toast.LENGTH_SHORT).show();
            String encMessage = CryptUtils.encryptMessage(messageToEncrypt, CryptUtils.decodePublicKeyFromBase64(recipientPublicKey));
            Toast.makeText(getActivity(), "Encryption complete.",Toast.LENGTH_SHORT).show();
            ((EditText)getView().findViewById(R.id.outputtext)).setText(encMessage);
        }else{
            Toast.makeText(getActivity(), "Please include key and data.",Toast.LENGTH_SHORT).show();
        }

    }
}