package com.aymen.essai;


import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;


public class LireEcrireJson {

    public String filename="";

    // la methode pour ecrire dans le fichier
    public void Ecriredonne(Context context, String texte) {
        try {
            //
            FileWriter file = new FileWriter(context.getFilesDir().getPath() + "/" + filename);
            file.append(texte);
            //file.write(texte);
            file.flush();
            file.close();

        } catch (IOException e) {
            Log.e("Erreur","Error in writting file"+ e.getMessage());
            e.printStackTrace();
        }
    }

    public String Liredonne(Context context) {
        try {
            File f = new File(context.getFilesDir().getPath() + "/" + filename);
            FileInputStream is = new FileInputStream(f);
            int size = is.available();
            byte[] donne = new byte[size];
            is.read(donne);
            is.close();
            return new String(donne);
        } catch (IOException e) {
            Log.e("TAG","Error in reading : "+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
