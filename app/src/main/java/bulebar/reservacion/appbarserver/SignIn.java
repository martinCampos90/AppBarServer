package bulebar.reservacion.appbarserver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import bulebar.reservacion.appbarserver.Common.Common;
import bulebar.reservacion.appbarserver.model.User;

public class SignIn extends AppCompatActivity {

    EditText edtPhone,edtPassword;
    Button btnSignIn;

    FirebaseDatabase db;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPhone = (MaterialEditText)findViewById(R.id.edtPhone);
        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        //Init Firebase
        db = FirebaseDatabase.getInstance();
        users = db.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                signInUser(edtPhone.getText().toString(),edtPassword.getText().toString());
            }

        });

    }

    private void signInUser (final String phone, String password){
        final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
        mDialog.setMessage("Por favor espere...");
        mDialog.show();

        final String localPhone = phone;
        final String localPassword = password;

        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(localPhone).exists()){
                    mDialog.dismiss();
                    User user = dataSnapshot.child(localPhone).getValue(User.class);
                    user.setPhone(localPhone);
                    if(Boolean.parseBoolean((user.getIsStaff())))//If isStaff==true
                    {
                        if(user.getPassword().equals(localPassword)){
                            //Login ok
                            Intent login = new Intent(SignIn.this,Home.class);
                            Common.currentUser = user;
                            startActivity(login);
                            finish();
                        }else
                            Toast.makeText(SignIn.this,"Contraseña incorrecta",Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(SignIn.this,"Por favor ingrese con una cuenta de administrador",Toast.LENGTH_SHORT).show();
                }else{
                    mDialog.dismiss();
                    Toast.makeText(SignIn.this,"El usuario no existe en la base de datos",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
