package com.aymen.essai;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class List_fichier extends AppCompatActivity implements View.OnClickListener {

    Button b_ajouter, b_afficher;
    RadioButton r_f, r_m;
    EditText nom, prenom, age;
    ListView list_view;
    LireEcrireJson js = new LireEcrireJson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fichier);

        b_ajouter = findViewById(R.id.b_ajouter);
        b_afficher = findViewById(R.id.b_afficher);

        r_f = findViewById(R.id.r_f);
        r_m = findViewById(R.id.r_m);

        nom = findViewById(R.id.t_nom);
        prenom = findViewById(R.id.t_prenom);
        age = findViewById(R.id.t_age);

        list_view = findViewById(R.id.list_v);
        b_ajouter.setOnClickListener(this);
        b_afficher.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        js.filename = "Monfichier.txt";
        if (v.getId() == b_ajouter.getId()) {
             Contact c = new Contact();
            // c.setNom(nom.getText().toString());
            // c.setPrenom(prenom.getText().toString());
            // c.setAge(Integer.parseInt(age.getText().toString()));
            // if (r_f.isChecked()) {
                // c.setSexe("Feminin");
            // } else {
                // c.setSexe("Masculin");
            // }
            // js.Ecriredonne(this, c.toString());

//            fichier json
            js.filename = "autrefile.json";

            JSONObject nouveau_c = new JSONObject();
            try {
                nouveau_c.put("nom", c.getNom());
                nouveau_c.put("prenom", c.getPrenom());
                nouveau_c.put("age", c.getAge());
                nouveau_c.put("sexe", c.getSexe());
                js.Ecriredonne(this,nouveau_c.toString());
                Toast.makeText(getApplicationContext(), "Le contact a bien ete ajouter", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Log.e("Erreur ", "Ne peux pas etre ajouter");
            }

        }
        if (v.getId() == b_afficher.getId()) {
            js.filename = "autrefile.json";
            String donne = "[" + js.Liredonne(this) + "]";
            donne = donne.replace(",]","]");
            Log.e("affichager -->",donne);
            try {
                ArrayAdapter<String> array ;
                JSONArray jsonArr = new JSONArray(donne);
                JSONObject obContact = new JSONObject();
                String[] contacts = new String[jsonArr.length()];
                for (int i = 0; i < jsonArr.length(); i++) {
                    obContact = jsonArr.getJSONObject(i);
                    contacts[i] = "nom : " + obContact.get("nom").toString() +
                            " prenom : " + obContact.get("prenom").toString()+
                            "\nsexe : "+obContact.get("sexe").toString()+
                    " age : "+obContact.get("age").toString();
                }
                array = new ArrayAdapter<>(list_view.getContext(), R.layout.activity_ligne, R.id.text_view,contacts);

                list_view.setAdapter(array);
            } catch (Exception e) {

            }
        }
    }
}
