package com.ozlemkorpe.basiclistviewexample;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Listemizde kullanacağımız ögeler için bir array oluşturuyoruz.
    private String[] renkler =
            {"Kırmızı", "Mavi", "Sarı", "Siyah","Turuncu",
                    "Mor", "Yeşil", "Beyaz", "Gri", "Kahverengi", "Pembe", "Lila", "Ela", "Turkuaz"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /*Java dosyamızda listemiz adında bir listview tanımlıyoruz ve findViewById(R.id.listView1)
       * ifadesiyle bunu layoutta eklediğimiz listview nesnesiyle eşitliyoruz
       */

        ListView listemiz=(ListView) findViewById(R.id.listView1);

        //renkler array ögelerini ArrayAdapter yardımıyla simple_list_item_1 şeklinde listeliyoruz.

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, renkler);


        // setAdapter(veriAdaptoru) kullanarak listemizi oluşturduğumuz adaptörle birleştiriyoruz.
        listemiz.setAdapter(veriAdaptoru);

        /* Bu aşamaya kadar kullandığımız kısım bir listview görüntüsü için yeterliydi. Bundan sonraki kısımda
        * liste ögelerine tıklandığında bir pop up açılmasını sağlayacağız. Bunun için listemiz üzerine
        * OnItemClickListener ekliyoruz.*/

        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
        // Pop up oluşturmak için diyalog oluşturucu tanımlıyoruz.
                AlertDialog.Builder diyalogOlusturucu =
                        new AlertDialog.Builder(MainActivity.this);
        //Diyalog oluşturucumuzda  butonları ve isimlendirmelerini ayarlıyoruz.

                diyalogOlusturucu.setMessage(renkler[position])
                        .setCancelable(false)
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                        //Tamam butonuna tıklandığında diyalogun kapanmasını sağlıyoruz.
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                diyalogOlusturucu.create().show();

            }
        });

    }
}
