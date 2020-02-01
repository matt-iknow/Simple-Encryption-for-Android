package secretswamp.simpleencryption.com.tabian.tabfragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;
import java.security.KeyPair;
import secretswamp.simpleencryption.pgp.PGPUtils;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private Button btnTEST;
    private String publicKey;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(secretswamp.simpleencryption.R.layout.tab1,container,false);
        btnTEST = (Button) view.findViewById(secretswamp.simpleencryption.R.id.btnTEST);


        btnTEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "TESTING BUTTON CLICK 1",Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }

    public void generateNewKeys() {
        SharedPreferences pref = getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        KeyPair kp = PGPUtils.generateKeyPair();
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("pub-key", kp.getPublic().toString());
        editor.putString("priv-key", kp.getPublic().toString());

        publicKey = pref.getString("priv-key", null);

    }
}