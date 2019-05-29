package es.covalco.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.List;

/*
  Activity Persona:
  Introduim les dades d'una persona i al registrar-les les mostrem en una altra activity
 */
public class PersonaActivity extends AppCompatActivity {

  private Spinner spinnerProvincia;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_persona);

    addListenerOnSpinnerItemSelection();
  }

  /*
    Afegim el listener en el spinner de la provincia de la persona
   */
  public void addListenerOnSpinnerItemSelection() {
    spinnerProvincia = (Spinner) findViewById(R.id.spinnerProvincia);
    spinnerProvincia.setOnItemSelectedListener(new CustomOnItemSelectedListener());
  }

  /*
  Mètode OnClick del botó Registrar
  Recopilo les dades de la pantalla i les envio a la segona activity on les mostraré
   */
  public void onClickRegistrar(View view) {
    Persona persona;

    Toast.makeText(getApplicationContext(),
                  "Alta registrada",
                   Toast.LENGTH_LONG).show();
    // Creo el Intent
    Intent intentBundle = new Intent(PersonaActivity.this,
                                     Persona2Activity.class);
    // Creo el bundle i li poso els camps de la pantalla que vull enviar a la següent activity
    //Bundle bundle = new Bundle();
    // Nom Persona
    String nom = ((EditText) findViewById(R.id.NombreText)).getText().toString();
    //bundle.putString("nom", nom);
    // EMail
    String eMail = ((EditText) findViewById(R.id.emailTest)).getText().toString();
    //bundle.putString("email", eMail);
    // Password
    String password = ((EditText) findViewById(R.id.passwordTest)).getText().toString();
    //bundle.putString("password", password);
    // Provincia
    String provincia = ((Spinner) findViewById(R.id.spinnerProvincia)).getSelectedItem().toString();
    //bundle.putString("provincia", provincia);
    // Sexe
    RadioGroup radioGroup = findViewById(R.id.radioGroupSexe);
    int radioButtonId = radioGroup.getCheckedRadioButtonId();
    View radioButtonSexe = radioGroup.findViewById(radioButtonId);
    int idx = radioGroup.indexOfChild(radioButtonSexe);
    RadioButton rbSexe = (RadioButton) radioGroup.getChildAt(idx);
    String sexe = rbSexe.getText().toString();
    //bundle.putString("sexe", sexe);
    // Aficions
    StringBuilder txtAficions = new StringBuilder();
    List<CheckBox> llistaChecksAficions = new ArrayList<CheckBox>();
    llistaChecksAficions.add((CheckBox) findViewById(R.id.checkBoxMotor));
    llistaChecksAficions.add((CheckBox) findViewById(R.id.checkBoxCinema));
    llistaChecksAficions.add((CheckBox) findViewById(R.id.checkBoxViatjar));
    for (CheckBox afi : llistaChecksAficions) {
      if (afi.isChecked()) {
        txtAficions.append(afi.getText().toString() + ", ");
      }
    }
    //bundle.putString("aficions", txtAficions.toString());
    // Data Naixement
    String dataNaixement = ((EditText) findViewById(R.id.textDataNaixament)).getText().toString();
    //bundle.putString("dataNaixement", dataNaixement);
    //
    persona = new Persona(nom,
                          eMail,
                          password,
                          provincia,
                          sexe,
                          txtAficions.toString(),
                          dataNaixement);
    //
    // Afegeixo el bundle al intent
    //intentBundle.putExtras(bundle);
    // Afegeixo el objecte Persona serialitzat directament al intent
    intentBundle.putExtra("persona", persona);
    // Crido la PersonaActivity2
    startActivity(intentBundle);
  }
  /*
    Botó enviar EMail
    Crida a la aplicació de mail x defecte de Android en el dispositiu
    amb la acció d'enviar un mail. Normalment si tens diferents clients de mail
    et demana que triis amb quin vols fer l'acció.
   */
  public void onClick_btnMail(View view) {
    Intent messageIntent = new Intent(Intent.ACTION_SEND);

    // Recupero el email introduit en la pantalla
    String eMail = ((EditText) findViewById(R.id.emailTest)).getText().toString();
    if (eMail == null) {
      eMail = "appmyApplication@yourappwebsite.com";
    }
    String aEMailList[] = { eMail, "mcasals@covalco.es" };
    String subject = "Prova d'enviament de mail des de l'app MyApplication";
    String message = "Prova";
    messageIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEMailList);
    messageIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
    messageIntent.setType("plain/text");

    messageIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);

    startActivity(messageIntent);
  }
}
