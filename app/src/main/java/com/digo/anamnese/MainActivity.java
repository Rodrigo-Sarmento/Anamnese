package com.digo.anamnese;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etNome;
    private EditText etIdade;

    private TextView teResultado;

    private Button btEnviar;

    private RadioButton rbMasculino;
    private RadioButton rbFeminino;


    private RadioButton rbMaisDe60;

    private RadioButton rbAsVezesPalpita;
    private RadioButton rbAsVezesPeito;

    private RadioButton rbSemprePernas;
    private RadioButton rbDe20a40;

    private CheckBox cbCaminhar;
    private CheckBox cbLevantar;

    private CheckBox cbPai;
    private CheckBox cbMae;
    private CheckBox cbAvo;


    private CheckBox cbCoracao;
    private CheckBox cbPressaoAlta;
    private CheckBox cbMuscular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.etNome);
        etIdade = findViewById(R.id.etIdade);
        teResultado = findViewById(R.id.teResultado);
        btEnviar = findViewById(R.id.btEnviar);
        rbAsVezesPeito = findViewById(R.id.rbAsVezesPeito);
        rbFeminino = findViewById(R.id.rbFeminino);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbMaisDe60 = findViewById(R.id.rbMaisDe60);
        rbDe20a40 = findViewById(R.id.rbDe20a40);
        rbAsVezesPalpita = findViewById(R.id.rbAsVezesPalpita);
        rbSemprePernas = findViewById(R.id.rbSemprePernas);
        cbCaminhar = findViewById(R.id.cbCaminhar);
        cbLevantar = findViewById(R.id.cbLevantar);
        cbAvo = findViewById(R.id.cbAvo);
        cbMae = findViewById(R.id.cbMae);
        cbPai = findViewById(R.id.cbPai);
        cbCoracao = findViewById(R.id.cbCoracao);
        cbPressaoAlta = findViewById(R.id.cbPressaoAlta);
        cbMuscular = findViewById(R.id.cbMuscular);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btEnviarOnClick();
            }
        });
    }
    private void btEnviarOnClick(){
        if (etNome.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"Campo do Nome precisa ser preenchido",
                    Toast.LENGTH_LONG).show();
            etNome.requestFocus();
            return;
        }
        if (etIdade.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),"CAMPO DE IDADE DEVE SER PREENCHIDO" ,
                    Toast.LENGTH_LONG).show();
            etIdade.requestFocus();
            return;
        }

        int idade = Integer.parseInt(etIdade.getText().toString());

        if(rbMasculino.isChecked() || rbFeminino.isChecked()){
            if(idade > 45 && rbMaisDe60.isChecked() && cbLevantar.isChecked()){
                if(cbMae.isChecked() || cbPai.isChecked()){
                    if(cbCoracao.isChecked() && cbPressaoAlta.isChecked()){
                        if(rbAsVezesPeito.isChecked() || rbAsVezesPalpita.isChecked()){
                            teResultado.setText("precisa com urgência ser atendido por um cardiologista!");
                        }
                    }
                }
            }else if(idade <= 45 && rbDe20a40.isChecked() && cbCaminhar.isChecked() && cbAvo.isChecked() && (cbCoracao.isChecked()==false) && cbMuscular.isChecked() && rbSemprePernas.isChecked()){
                teResultado.setText("Você não apresenta no momento nenhuma queixa que possa ser encaminhado a alguma especialidade médica!");
            }
        }
    }
}