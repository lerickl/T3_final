package com.example.finalandroid;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalandroid.clases.Pokem;
import com.example.finalandroid.clases.entrenador;
import com.example.finalandroid.clases.pokemon;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class addPokemon extends AppCompatActivity {

    private EditText imagen;
    private EditText Nombre;
    private EditText Tipo;
    private EditText latitud;
    private EditText longitud;
    private TextView Byte64Imag;
    private String StrImaage;
    private Button idAgregarP;
    private static String url= "https://upn.lumenes.tk/pokemons/{n00033222}/crear";
    static final int REQUEST_IMAGE_SUBIR = 10;
    static final int REQUEST_IMAGE_CATURA = 20;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_pokemon);
        Nombre=findViewById(R.id.idNombreP);
        Tipo=findViewById(R.id.idTipoP);
        imagen=findViewById(R.id.urlAdd);
        latitud=findViewById(R.id.idlatitud);
        longitud=findViewById(R.id.idlongitud);
        idAgregarP=findViewById(R.id.idAgregarP);
        checkCameraPermission();
       // ImagenClic();
        OnclicAgregar();

    }
    public void ImagenClic(){

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CapSubImagen();
                Log.e("Clic","Imagen");
            }
        });

    }
    public void CapSubImagen(){
        final CharSequence[] opciones ={"Tomar Foto","Cargar Imagen","Cancelar"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(addPokemon.this);

        alertOpciones.setTitle("Cambiar Foto");

        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("Tomar Foto")){

                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_IMAGE_CATURA);


                }else {
                    if (opciones[i].equals("Cargar Imagen")){
                        //ACTION_GET_CONTENT o PICK
                        Intent intent = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media                                                                                   .EXTERNAL_CONTENT_URI);
                        intent.setType("image/");

                        startActivityForResult(intent.createChooser(intent,"Selecciones la                                                                          Aplicacion"),REQUEST_IMAGE_SUBIR);
                    }else {
                        dialogInterface.dismiss();
                    }
                }
            }

        });
        alertOpciones.show();
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            try{
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                ByteArrayOutputStream stream= new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100, stream);
                byte[] bytes =stream.toByteArray();
                StrImaage= Base64.encodeToString(bytes, Base64.DEFAULT);
                Byte64Imag.setText(StrImaage);
            }catch (IOException e){}
        }
    }
    public void sendData(){

        Pokem data = addPokemon();
        String jsonString = new Gson().toJson(data);
        Log.e("Formato",jsonString);

        RequestQueue queue = Volley.newRequestQueue(this);

        try {
            JSONObject objJSon = new JSONObject(jsonString);

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, objJSon, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    Log.e("Envio","Correctamente");
                    Toast.makeText(getApplicationContext(),"Entrenador Guardado",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error","Al enviar data");
                    Toast.makeText(getApplicationContext(),"Ocurrio un Error",Toast.LENGTH_SHORT).show();
                }
            });
            queue.add(request);
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void OnclicAgregar(){

        idAgregarP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //OtenerDataGetCrud();
                Log.i("Pueblo", "asdasdas");


                sendData();
            }
        });
    }
    public Pokem addPokemon(){
        String  Bstr= "";
        Pokem test=new Pokem();
        test.nombre=Nombre.getText().toString();
        test.tipo=Tipo.getText().toString();
        test.latitude= Float.parseFloat(latitud.toString());
        test.longitude=Float.parseFloat(longitud.toString());
        test.url_imagen=imagen.getText().toString();
        return test;
    }
    private void checkCameraPermission(){
        int permisoCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.CAMERA);
        if (permisoCheck != PackageManager.PERMISSION_GRANTED){
            Log.i("Mensaje","No hay permiso para la camara!.");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},255);
        }else {
            Log.i("Mensaje","P");
        }
    }
}
