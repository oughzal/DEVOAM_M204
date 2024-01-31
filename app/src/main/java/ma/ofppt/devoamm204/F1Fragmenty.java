package ma.ofppt.devoamm204;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class F1Fragmenty extends Fragment {
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String cin = savedInstanceState.getString("cin");
        String nom = savedInstanceState.getString("nom");
        int age = savedInstanceState.getInt("age");
        afficherDetailPatient(cin,nom,age);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void afficherDetailPatient(String cin, String nom, int age) {
        String s = cin + "\n" + nom + "\n" + age;
        textView.setText(s);
    }
}
