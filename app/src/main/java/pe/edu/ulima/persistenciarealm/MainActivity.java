package pe.edu.ulima.persistenciarealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guardar(View view){
        final Alumno alumno = new Alumno();
        alumno.setId(new Date().getTime());
        alumno.setCodigo("20161212");
        alumno.setNombre("Pepito");
        alumno.setNumeroSesiones(20);

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //Codigo de la transaccion
                realm.copyToRealm(alumno);
            }
        }, new Realm.Transaction.OnSuccess(){
            @Override
            public void onSuccess() {
                Log.i("MainActivity","Success");
            }
        }, new Realm.Transaction.OnError(){
            @Override
            public void onError(Throwable error) {
                Log.i("MainActivity","Error: " + error.getMessage());
            }
        });
        Log.i("MainActivity","Se ejecuto");
        RealmQuery query = realm.where(Alumno.class);
        RealmResults<Alumno> results = query.findAll();

        for (Alumno alu : results){
            Log.i("Alumno", String.valueOf(alu.getId()));
        }
    }
}
