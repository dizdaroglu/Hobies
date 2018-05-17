package com.example.bookolik.hobies;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class paylasim extends AppCompatActivity {

    //localhost adresinizi yazın
    String ServerURL = "http://localhost.com/register.php" ;
    EditText name, email ;
    Button button;
    Spinner sp;
    String TempName, TempEmail,Tempktgr ;
    final   String[] dizi={"Teknoloji","Bilim","Eğlence","Haber","Kültür","Sanat","Dizi-Film"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paylasim);

        name = (EditText)findViewById(R.id.aciklama);
        email = (EditText)findViewById(R.id.link);
        button = (Button)findViewById(R.id.paylas_btn);

         sp= (Spinner) findViewById(R.id.spinner);

        ArrayAdapter <String> adapter = new ArrayAdapter <String>(paylasim.this, android.R.layout.simple_spinner_item,dizi);
        sp.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetData();
                Toast.makeText(paylasim.this, dizi[sp.getSelectedItemPosition()], Toast.LENGTH_LONG).show();

                InsertData(TempName, TempEmail,Tempktgr);

            }
        });
    }


    public void GetData(){

        TempName = name.getText().toString();

        TempEmail = email.getText().toString();

        Tempktgr=dizi[sp.getSelectedItemPosition()];
    }


    public void InsertData(final String name, final String email,final String temp_ktgr){

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String NameHolder = name ;
                String EmailHolder = email ;
                String ktgrHolder=temp_ktgr;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("name", NameHolder));
                nameValuePairs.add(new BasicNameValuePair("email", EmailHolder));
                nameValuePairs.add(new BasicNameValuePair("kategori", ktgrHolder));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(ServerURL);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse httpResponse = httpClient.execute(httpPost);

                    HttpEntity httpEntity = httpResponse.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                return "Data Inserted Successfully";
            }

            @Override
            protected void onPostExecute(String result) {

                super.onPostExecute(result);

                Toast.makeText(paylasim.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();

        sendPostReqAsyncTask.execute(name, email, temp_ktgr);
    }

}