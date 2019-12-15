package com.androstock.newsapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class form_lapor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_lapor);
    }

    public void kirimLapor(View view) {

            //Find the user's name
            EditText namaField = (EditText) findViewById(R.id.nama_field);
            String nama = namaField.getText().toString();

            EditText emailField = (EditText) findViewById(R.id.email_field);
            String email = emailField.getText().toString();

            EditText laporanField = (EditText) findViewById(R.id.laporan_field);
            String laporan = laporanField.getText().toString();

            EditText judulField = (EditText) findViewById(R.id.judul_field);
            String judul = judulField.getText().toString();

            EditText sumberField = (EditText) findViewById(R.id.sumber_field);
            String sumber = sumberField.getText().toString();

            String reportMessage = createReportSummary(nama, email, laporan, judul, sumber);
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto: anti@hoax.com")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, "Laporan hoax berita " + sumber);
            intent.putExtra(Intent.EXTRA_TEXT, reportMessage);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

    }

    private String createReportSummary(String nama, String email, String laporan, String judul, String sumber){
        String reportMessage = "Nama : " + nama;
        reportMessage += "\nEmail : " + email;
        reportMessage += "\nJudul : " + judul;
        reportMessage += "\nSumber : " + sumber;
        reportMessage += "\nLaporan : " + laporan;
        reportMessage += "\n" + getString(R.string.thank_you);
        return reportMessage;
    }
}
