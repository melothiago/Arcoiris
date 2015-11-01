package com.example.thiago.arcoiris;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class ArcoirisActivity extends AppCompatActivity {

    private SeekBar corVermelho;
    private SeekBar corVerde;
    private SeekBar corAzul;
    private TextView corSelecionada;
    private TextView barraCor;
    private String [] hexCor = {"00", "00", "00"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcoiris);

        corVermelho = (SeekBar) findViewById(R.id.corVermelho);
        corVermelho.setOnSeekBarChangeListener(new EventoSeek((byte)0));
        corVerde = (SeekBar) findViewById(R.id.corVerde);
        corVerde.setOnSeekBarChangeListener(new EventoSeek((byte)1));
        corAzul = (SeekBar) findViewById(R.id.corAzul);
        corAzul.setOnSeekBarChangeListener(new EventoSeek((byte)2));
        corSelecionada = (TextView) findViewById(R.id.corSelecionada);
        barraCor = (TextView) findViewById(R.id.barraCor);
        mudarCor();
    }

    private class EventoSeek implements SeekBar.OnSeekBarChangeListener {
        private byte cor;

        public EventoSeek(byte cor) {
            this.cor = cor;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            acertarCor(progress, cor);
        }

    }

    private void acertarCor(int p, byte cor) {
        String c = Integer.toHexString(p);
        hexCor[cor] = (c.length() == 2?"":"0") + c;
        mudarCor();
    }

    private void mudarCor() {
        corSelecionada.setText("#" + hexCor[0] + hexCor[1] + hexCor[2]);
        barraCor.setBackgroundColor(Color.parseColor("#" + hexCor[0] + hexCor[1] + hexCor[2]));
    }
}