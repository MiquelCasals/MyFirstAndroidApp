package es.covalco.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*
  Activity on mostrarem el contigut de les dades del registre de la persona
 */
public class Persona2Activity extends AppCompatActivity {

  /*
    OnCreate
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_persona2);

    recullDadesPersona();
  }
  /*
    recullDadesPersona:
    recullo les dades enviades en el bundle de la PersonaActivity
    i les mostro en aquesta activity
   */
  void recullDadesPersona() {
    // Recullo en intent que ha iniciat aquesta activity
    Intent intentExtras = getIntent();
    // Exemple de com recollir les variables dipositades en en bundle
    /*
    Bundle extrasBundle = intentExtras.getExtras();
    if ((extrasBundle == null) ||
        (extrasBundle.isEmpty())) {
      // Si no tenim dades passades en el bundle pleguem
      return;
    }
    if (extrasBundle.containsKey("nom")) {
      String nom = extrasBundle.getString("nom");
      ((TextView)findViewById(R.id.txtNom)).setText(nom);
    }
    if (extrasBundle.containsKey("email")) {
      String email = extrasBundle.getString("email");
      ((TextView)findViewById(R.id.txtEmail)).setText(email);
    }
    if (extrasBundle.containsKey("password")) {
      String password = extrasBundle.getString("password");
      ((TextView)findViewById(R.id.txtPassword)).setText(password);
    }
    if (extrasBundle.containsKey("provincia")) {
      String provincia = extrasBundle.getString("provincia");
      ((TextView)findViewById(R.id.txtProvincia)).setText(provincia);
    }
    if (extrasBundle.containsKey("sexe")) {
      String sexe = extrasBundle.getString("sexe");
      ((TextView)findViewById(R.id.txtSexe)).setText(sexe);
    }
    if (extrasBundle.containsKey("aficions")) {
      String aficions = extrasBundle.getString("aficions");
      ((TextView)findViewById(R.id.txtAficions)).setText(aficions);
    }
    if (extrasBundle.containsKey("dataNaixement")) {
      String dataNaixement = extrasBundle.getString("dataNaixement");
      ((TextView)findViewById(R.id.txtDataNaixement)).setText(dataNaixement);
    }
    */
    // Ho faig ara, amb un objecte serialitzat enlloc de variable a variable
    Persona persona = (Persona) intentExtras.getSerializableExtra("persona");
    if (persona != null) {
      ((TextView)findViewById(R.id.txtNom))           .setText(persona.getNom());
      ((TextView)findViewById(R.id.txtEmail))         .setText(persona.getEMail());
      ((TextView)findViewById(R.id.txtPassword))      .setText(persona.getPassword());
      ((TextView)findViewById(R.id.txtProvincia))     .setText(persona.getProvincia());
      ((TextView)findViewById(R.id.txtSexe))          .setText(persona.getSexe());
      ((TextView)findViewById(R.id.txtAficions))      .setText(persona.getAficions());
      ((TextView)findViewById(R.id.txtDataNaixement)) .setText(persona.getDataNaixement());
    }
  }
}
