package com.example.bookolik.hobies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
public class liste_eglence extends AppCompatActivity {

    ListView SubjectListView;
    ProgressBar progressBarSubject;
    String ServerURL = "http://localhost.com/Subjects_eglence.php";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_liste);

        SubjectListView = (ListView)findViewById(R.id.listview1);

        progressBarSubject = (ProgressBar)findViewById(R.id.progressBar);

        new GetHttpResponse(liste_eglence.this).execute();
    }

    private class GetHttpResponse extends AsyncTask<Void, Void, Void>
    {
        public Context context;

        String ResultHolder;
        String eleman;
        List<subjects> subjectsList;

        public GetHttpResponse(Context context)
        {
            this.context = context;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
            HttpServicesClass httpServiceObject = new HttpServicesClass(ServerURL);
            try
            {
                httpServiceObject.ExecutePostRequest();

                if(httpServiceObject.getResponseCode() == 200)
                {
                    ResultHolder = httpServiceObject.getResponse();

                    if(ResultHolder != null)
                    {
                        JSONArray jsonArray = null;

                        try {
                            jsonArray = new JSONArray(ResultHolder);

                            JSONObject jsonObject;

                            subjects subjects;

                            subjectsList = new ArrayList<subjects>();

                            for(int i=0; i<jsonArray.length(); i++)
                            {
                                subjects = new subjects();

                                jsonObject = jsonArray.getJSONObject(i);

                                subjects.id = jsonObject.getString("id");
                                subjects.aciklama = jsonObject.getString("aciklama");
                                subjects.link = jsonObject.getString("link");
                                subjectsList.add(subjects);
                            }
                        }
                        catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                else
                {
                    Toast.makeText(context, httpServiceObject.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)

        {
            progressBarSubject.setVisibility(View.GONE);

            SubjectListView.setVisibility(View.VISIBLE);

            if(subjectsList != null)
            {
                ListAdapterClass adapter = new ListAdapterClass(subjectsList, context);

                SubjectListView.setAdapter(adapter);


                SubjectListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {


                        JSONArray jsonArray = null;

                        try {
                            jsonArray = new JSONArray(ResultHolder);

                            JSONObject jsonObject;

                            subjects subjects;

                            subjectsList = new ArrayList<subjects>();

                            for(int i=0; i<jsonArray.length(); i++)
                            {
                                // subjects = new subjects();

                                jsonObject = jsonArray.getJSONObject(position);
                                eleman=jsonObject.getString("link");

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(getApplicationContext(),eleman, Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(getApplicationContext(),goruntuleme.class);

                        intent.putExtra("anahtar", eleman);
                        startActivity(intent);

                    }
                });



            }
        }
    }

}