package io.github.trankieu.izcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: + Funktion in txtFunktion hinzufügen
    // TODO: + Mareial Design
    private double result;
    private String operation = "=";
    private boolean anfang = true;
    private boolean komma = false;

    private StringBuilder funkString = new StringBuilder("");
    private StringBuilder display = new StringBuilder("");
    private TextView txtFunktion, txtErgebnis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFunktion = (TextView) findViewById(R.id.txt_func);

        txtErgebnis = (TextView) findViewById(R.id.txt_ergebnis);
        //can set maxlength

    }

    public void onBtnKlick(final View v) {
        switch (v.getId()) {
            case R.id.btn_null:
                insert("0");
                break;
            case R.id.btn_1:
                insert("1");
                break;
            case R.id.btn_2:
                insert("2");
                break;
            case R.id.btn_3:
                insert("3");
                break;
            case R.id.btn_4:
                insert("4");
                break;
            case R.id.btn_5:
                insert("5");
                break;
            case R.id.btn_6:
                insert("6");
                break;
            case R.id.btn_7:
                insert("7");
                break;
            case R.id.btn_8:
                insert("8");
                break;
            case R.id.btn_9:
                insert("9");
                break;
            case R.id.btn_komma:
                if (!komma) {
                    insert(".");
                    komma = true;
                }
                break;
            case R.id.btn_leer:
                //xoa phan hien hanh
                txtErgebnis.setText("0");

                //Daten Löschen
                dataClear();
                break;
            case R.id.btn_anfang:
                txtFunktion.setText("");
                txtErgebnis.setText("0");
                dataClear();
                //  result = 0;
                break;
            // Operation
            case R.id.btn_minus:
                if(display.indexOf("-") == 0){
                    display.deleteCharAt(0);
                } else {
                    display.insert(0,"-");
                }

                txtErgebnis.setText(display.toString());

                break;
            case R.id.btn_add:
                if (!anfang) {
                    izCalculator(Double.parseDouble(display.toString()));
                    dataClear();
                }
                operation = "+";

                break;
            case R.id.btn_sub:
                if (!anfang) {
                    izCalculator(Double.parseDouble(display.toString()));
                    dataClear();
                }

                operation = "-";

                break;
            case R.id.btn_mul:
                if (!anfang) {
                    izCalculator(Double.parseDouble(display.toString()));
                    dataClear();
                }

                operation = "*";

                break;
            case R.id.btn_div:
                if (!anfang) {
                    izCalculator(Double.parseDouble(display.toString()));
                    dataClear();
                }

                operation = "/";

                break;
            case R.id.btn_result:
                if (!anfang) {
                    izCalculator(Double.parseDouble(display.toString()));
                    dataClear();
                }
                operation = "=";
                break;
        }
    }

    private void insert(final String ziffe) {

        if (anfang) {
            anfang = false;
            txtErgebnis.setText("0");
        }
        if (display.toString().equals("0") && (!ziffe.equals("."))) {
            display.setLength(0);
        }


        display.append(ziffe);
        txtErgebnis.setText(display.toString());

    }

    private void izCalculator(double zahl) {
        switch (operation) {
            case "+":
                result += zahl;
                break;
            case "-":
                result -= zahl;
                break;
            case "*":
                result *= zahl;
                break;
            case "/":
                result /= zahl;
                break;
            case "=":
                result = zahl;
                break;
            default:
        }
        if (Double.isInfinite(result)) {
            dataClear();
            result = 0;
            txtErgebnis.setText("FEHLER");
        } else {
            txtErgebnis.setText(String.valueOf(result));
        }

    }

    /**
     * Daten wieder setzen
     */
    private void dataClear() {
        komma = false;
        anfang = true;
        display.setLength(0);
    }
}
