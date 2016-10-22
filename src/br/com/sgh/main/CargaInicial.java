package br.com.sgh.main;

import java.util.Calendar;

import org.hibernate.Session;

import br.com.sgh.dao.EspecialidadeDao;
import br.com.sgh.dao.MedicamentoDao;
import br.com.sgh.dao.PessoaDao;
import br.com.sgh.dao.TipoExameDao;
import br.com.sgh.factory.HibernateFactory;
import br.com.sgh.model.Especialidade;
import br.com.sgh.model.Medicamento;
import br.com.sgh.model.Medico;
import br.com.sgh.model.Paciente;
import br.com.sgh.model.TipoExame;

public class CargaInicial {

	public static void main(String[] args) throws Exception {

		Session session = HibernateFactory.getHibernateSession();
		session.beginTransaction();

		PessoaDao pessoaDao = new PessoaDao();
		
		/* MEDICOS TESTE */
		System.out.println("#########  INSERINDO MEDICOS #########");
		Medico medico1 = new Medico();
		medico1.setNome("João");
		Calendar dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1983);
		dt.set(Calendar.MONTH, Calendar.AUGUST);
		dt.set(Calendar.DAY_OF_MONTH, 11);
		medico1.setDataNascimento(dt.getTime());
		medico1.setCpf("39292792903");
		medico1.setCrm("12345");
		medico1.setEstaAtivo(true);
		pessoaDao.salvar(medico1);
		
		Medico medico2 = new Medico();
		medico2.setNome("Pedro");
		dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1992);
		dt.set(Calendar.MONTH, Calendar.JANUARY);
		dt.set(Calendar.DAY_OF_MONTH, 3);
		medico2.setDataNascimento(dt.getTime());
		medico2.setCpf("34410044265");
		medico2.setCrm("11111");
		medico2.setEstaAtivo(true);
		pessoaDao.salvar(medico2);
		
		Medico medico3 = new Medico();
		medico3.setNome("Lucas");
		dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1972);
		dt.set(Calendar.MONTH, Calendar.JANUARY);
		dt.set(Calendar.DAY_OF_MONTH, 3);
		medico3.setDataNascimento(dt.getTime());
		medico3.setCpf("23204741532");
		medico3.setCrm("78945");
		medico3.setEstaAtivo(true);
		pessoaDao.salvar(medico3);		

		Medico medico4 = new Medico();
		medico4.setNome("José");
		dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1975);
		dt.set(Calendar.MONTH, Calendar.JANUARY);
		dt.set(Calendar.DAY_OF_MONTH, 7);
		medico4.setDataNascimento(dt.getTime());
		medico4.setCpf("57967086600");
		medico4.setCrm("45612");
		medico4.setEstaAtivo(true);
		pessoaDao.salvar(medico4);
		
		
		/* PACIENTE TESTE */
		System.out.println("#########  INSERINDO PACIENTES #########");
		Paciente paciente1 = new Paciente();
		paciente1.setNome("Carlos");
		dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1977);
		dt.set(Calendar.MONTH, Calendar.JANUARY);
		dt.set(Calendar.DAY_OF_MONTH, 9);
		paciente1.setDataNascimento(dt.getTime());
		paciente1.setCpf("38911321664");
		paciente1.setMatricula("11111");;
		paciente1.setEstaAtivo(true);
		pessoaDao.salvar(paciente1);
		
		Paciente paciente2 = new Paciente();
		paciente2.setNome("Maria");
		dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1957);
		dt.set(Calendar.MONTH, Calendar.FEBRUARY);
		dt.set(Calendar.DAY_OF_MONTH, 9);
		paciente2.setDataNascimento(dt.getTime());
		paciente2.setCpf("55555802749");
		paciente2.setMatricula("22222");;
		paciente2.setEstaAtivo(true);
		pessoaDao.salvar(paciente2);
		
		Paciente paciente3 = new Paciente();
		paciente3.setNome("Paula");
		dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1961);
		dt.set(Calendar.MONTH, Calendar.MARCH);
		dt.set(Calendar.DAY_OF_MONTH, 9);
		paciente3.setDataNascimento(dt.getTime());
		paciente3.setCpf("05885490880");
		paciente3.setMatricula("33333");;
		paciente3.setEstaAtivo(true);
		pessoaDao.salvar(paciente3);
		
		Paciente paciente4 = new Paciente();
		paciente4.setNome("Tiago");
		dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1990);
		dt.set(Calendar.MONTH, Calendar.JULY);
		dt.set(Calendar.DAY_OF_MONTH, 10);
		paciente4.setDataNascimento(dt.getTime());
		paciente4.setCpf("38911321664");
		paciente4.setMatricula("44444");;
		paciente4.setEstaAtivo(true);
		pessoaDao.salvar(paciente4);
		
		Paciente paciente5 = new Paciente();
		paciente5.setNome("Teresa");
		dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1981);
		dt.set(Calendar.MONTH, Calendar.JANUARY);
		dt.set(Calendar.DAY_OF_MONTH, 25);
		paciente5.setDataNascimento(dt.getTime());
		paciente5.setCpf("26911192463");
		paciente5.setMatricula("55555");;
		paciente5.setEstaAtivo(true);
		pessoaDao.salvar(paciente5);

		EspecialidadeDao especialidadeDao = new EspecialidadeDao();
		/* ESPECIALIDADE TESTE */
		System.out.println("#########  INSERINDO ESPECIALIDADES #########");
		for(int i=1;i<=200;i++){
			Especialidade esp = new Especialidade();
			esp.setNome("Especialidade " + i);
			esp.setEstaAtivo(true);
			especialidadeDao.salvar(esp);
		}

		TipoExameDao tipoExameDao = new TipoExameDao();
		/* TIPO EXAME TESTE */
		for(int i=1;i<=250;i++){
			TipoExame te = new TipoExame();
			te.setNome("Exame Tipo " + i);
			te.setEstaAtivo(true);
			tipoExameDao.salvar(te);
		}

		MedicamentoDao medicamentoDao = new MedicamentoDao();
		/* MEDICAMENTO TESTE */
		System.out.println("#########  INSERINDO MEDICAMENTOS #########");
		for(int i=1;i<=2500;i++){
			Medicamento medicamento = new Medicamento();
			medicamento.setNome("Medicamento " + i);
			medicamento.setMarca("Marca " + ((i%20)+1));
			medicamento.setEstaAtivo(true);
			medicamentoDao.salvar(medicamento);
		}

		System.out.println("######### COMMIT #########");
		session.getTransaction().commit();
	}
}
