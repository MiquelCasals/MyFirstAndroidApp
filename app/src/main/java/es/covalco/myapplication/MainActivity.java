package es.covalco.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.graphics.Color;
// Podem fer imports de classes, cosa que en .NET no podíem fer havien de ser namespaces.

public class MainActivity extends AppCompatActivity {

  // Definim els controls de la nostra pantalla
  private EditText txtNum1;
  private EditText txtNum2;
  private Button btnAdd;
  private Button btnSubstract;
  private Button btnMultiply;
  private Button btnDivide;
  String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Pear"};


  @Override
  /*
    Es equivalent al OnLoad de Windows Forms
    Aquí assignem els valors de les variables dels controls de la activity
   */
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //
    // Configurem la funcionalitat del control AutoCompleteView
    // Creem una instancia del ArrayAdapter que conté la llista de fruita
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                                            android.R.layout.select_dialog_item,
                                                            fruits);
    // Getting the instance of AutoCompleteTextView
    AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
    actv.setThreshold(1);     //will start working from first character
    actv.setAdapter(adapter); //setting the adapter data into the AutoCompleteTextView
    actv.setTextColor(Color.RED);
    // Obtenim els diferents controls del layout
    txtNum1       = (EditText)findViewById(R.id.txtNum1);
    txtNum2       = (EditText)findViewById(R.id.txtNum2);
    btnAdd        = (Button)findViewById(R.id.btnAdd);
    btnSubstract  = (Button)findViewById(R.id.btnSubstract);
    btnMultiply   = (Button)findViewById(R.id.btnMultiply);
    btnDivide     = (Button)findViewById(R.id.btnDivide);
  }

  /*
  Mètode OnClick del botó btnAdd
   */
  public void onClickAdd(View view) {
    int num1    = Integer.parseInt(txtNum1.getText().toString());
    int num2    = Integer.parseInt(txtNum2.getText().toString());
    ICalculator iCalculator = new Calculator(num1, num2);
    int result  = iCalculator.add();
    Toast.makeText(getApplicationContext(),
                  "The result of add is " + result,
                  Toast.LENGTH_LONG).show();
  }
  /*
  Mètode OnClick del botó btnSubstract
   */
  public void onClickSubstract(View view) {
    int num1    = Integer.parseInt(txtNum1.getText().toString());
    int num2    = Integer.parseInt(txtNum2.getText().toString());
    ICalculator iCalculator = new Calculator(num1, num2);
    int result  = iCalculator.substract();
    Toast.makeText(getApplicationContext(),
              "The result of substract is " + result,
                   Toast.LENGTH_LONG).show();
  }
  /*
  Mètode OnClick del botó btnMultiply
   */
  public void onClickMultiply(View view) {
    int num1    = Integer.parseInt(txtNum1.getText().toString());
    int num2    = Integer.parseInt(txtNum2.getText().toString());
    ICalculator iCalculator = new Calculator(num1, num2);
    int result  = iCalculator.multiply();
    Toast.makeText(getApplicationContext(),
                  "The result of multiply is " + result,
                  Toast.LENGTH_LONG).show();
  }
  /*
  Mètode OnClick del botó btnDivide
   */
  public void onClickDivide(View view) {
    int num1    = Integer.parseInt(txtNum1.getText().toString());
    int num2    = Integer.parseInt(txtNum2.getText().toString());
    ICalculator iCalculator = new Calculator(num1, num2);
    int result  = iCalculator.divide();
    Toast.makeText(getApplicationContext(),
                  "The result of divide is " + result,
                   Toast.LENGTH_LONG).show();
  }
}
