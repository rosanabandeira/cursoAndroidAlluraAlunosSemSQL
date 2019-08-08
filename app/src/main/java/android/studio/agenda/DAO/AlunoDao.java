package android.studio.agenda.DAO;

import android.studio.agenda.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDao {

    private final static List<Aluno> alunos = new ArrayList<>();

    public void salva(Aluno aluno) {
        alunos.add(aluno);

    }

    public List<Aluno> todos() {
        return new ArrayList<>(alunos);
    }
}
