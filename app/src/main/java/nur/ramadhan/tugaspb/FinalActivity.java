package nur.ramadhan.tugaspb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        String nama = getIntent().getStringExtra("nama");
        String tgl_lahir = getIntent().getStringExtra("tgl");

    //mengubah data tgl lahir yang didapat dari mainactivity(string) menjadi bentuk date
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        Date tanggal_lahir = null;
        try { tanggal_lahir = sdf.parse(tgl_lahir);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    //menghitung umur
        Calendar tl = Calendar.getInstance();
        tl.setTime(tanggal_lahir);
        Calendar now = Calendar.getInstance();
        int tahun = now.get(Calendar.YEAR) - tl.get(Calendar.YEAR);
        int bulan = now.get(Calendar.MONTH) - tl.get(Calendar.MONTH);
        int hari = now.get(Calendar.DAY_OF_MONTH) - tl.get(Calendar.DAY_OF_MONTH);
        if (bulan < 0 || (bulan == 0 && hari < 0)) {
            tahun--;
        };

        TextView textViewNama = findViewById(R.id.tvnama);
        textViewNama.setText("Nama : " + nama);

        TextView textViewUmur = findViewById(R.id.tvumur);
        textViewUmur.setText("Umur : " + tahun + " Tahun, " + Math.abs(bulan) + " Bulan, " + Math.abs(hari) + " Hari.");
    }
}