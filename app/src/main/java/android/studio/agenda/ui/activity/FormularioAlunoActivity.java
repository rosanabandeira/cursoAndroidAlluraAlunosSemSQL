package android.studio.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.studio.agenda.DAO.AlunoDao;
import android.studio.agenda.R;
import android.studio.agenda.model.Aluno;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class FormularioAlunoActivity extends AppCompatActivity {

    AlunoDao dao = new AlunoDao();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        Toolbar toolbar = findViewById(R.id.formulario_toolbar);
        toolbar.setTitle("Novo Aluno");
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.toolbar_menu) {

            Aluno alunoCriado = new Aluno();
            dao.salva(alunoCriado);


            Toast.makeText(FormularioAlunoActivity.this, "Aluno salvo " + alunoCriado.getNome()
                    + " - " + alunoCriado.getTelefone()
                    + " - " + alunoCriado.getEmail()
                    + " - " + alunoCriado.getNota(), Toast.LENGTH_LONG).show();

            startActivity(new Intent(FormularioAlunoActivity.this, ListaAlunosActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }


}