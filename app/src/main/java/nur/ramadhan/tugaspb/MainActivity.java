package nur.ramadhan.tugaspb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText etnama;
    private EditText etTl;
    private ImageButton btnTL;
    private Button btnnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = findViewById(R.id.etnama);
        etTl = findViewById(R.id.etTL);
        btnTL = findViewById(R.id.btnTL);
        btnnext = findViewById(R.id.btnnext);

        btnTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar kalender = Calendar.getInstance();
                int iyear = kalender.get(Calendar.YEAR);
                int imonth = kalender.get(Calendar.MONTH);
                int idayOfMonth = kalender.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog pilih = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                kalender.set(year, monthOfYear, dayOfMonth);
                                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
                                etTl.setText(dateFormat.format(kalender.getTime()));
                            }
                        }, iyear, imonth, idayOfMonth);
                pilih.show();
            }
        }
        );

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etnama.getText().toString();
                String tanggalLahir = etTl.getText().toString();

                // Jika ada kolom yang tidak terisi
                if (nama.isEmpty() || tanggalLahir.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pastikan Anda Mengisi Semua Kolom!", Toast.LENGTH_LONG).show();
                } else {
                //Melanjutkan ke FinalActivity
                    Intent intent = new Intent(MainActivity.this, FinalActivity.class);
                    intent.putExtra("nama", nama);
                    intent.putExtra("tgl", tanggalLahir);
                    startActivity(intent);
                }
            }
        }
        );
    }
}