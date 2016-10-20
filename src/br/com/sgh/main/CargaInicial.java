package br.com.sgh.main;

import java.util.Calendar;

import org.hibernate.Session;

import br.com.sgh.dao.PessoaDao;
import br.com.sgh.factory.HibernateFactory;
import br.com.sgh.model.Especialidade;
import br.com.sgh.model.Medicamento;
import br.com.sgh.model.Medico;
import br.com.sgh.model.TipoExame;

public class CargaInicial {

	public static void main(String[] args) throws Exception {

		Session session = HibernateFactory.getHibernateSession();
		session.beginTransaction();

		PessoaDao genericDao = new PessoaDao();

		Medico medico1 = new Medico();
		medico1.setNome("João");

		Calendar dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1983);
		dt.set(Calendar.MONTH, Calendar.AUGUST);
		dt.set(Calendar.DAY_OF_MONTH, 11);

		medico1.setDataNascimento(dt.getTime());
		medico1.setCpf("123456");
		medico1.setCrm("12345");

		genericDao.salvar(medico1);
		
		Medico medico2 = new Medico();
		medico2.setNome("Pedro");

		dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1992);
		dt.set(Calendar.MONTH, Calendar.JANUARY);
		dt.set(Calendar.DAY_OF_MONTH, 3);

		medico2.setDataNascimento(dt.getTime());
		medico2.setCrm("11111");
		medico2.setCpf("1234");

		genericDao.salvar(medico2);
		
		Medico medico3 = new Medico();
		medico3.setNome("Lucas");

		dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1972);
		dt.set(Calendar.MONTH, Calendar.JANUARY);
		dt.set(Calendar.DAY_OF_MONTH, 3);

		medico3.setDataNascimento(dt.getTime());
		medico3.setCrm("78945");
		medico3.setCpf("232313");

		genericDao.salvar(medico3);		

		Medico medico4 = new Medico();
		medico4.setNome("José");
		
		dt = Calendar.getInstance();
		dt.set(Calendar.YEAR, 1975);
		dt.set(Calendar.MONTH, Calendar.JANUARY);
		dt.set(Calendar.DAY_OF_MONTH, 7);

		medico4.setDataNascimento(dt.getTime());
		medico4.setCrm("45612");
		medico4.setCpf("798745");

		genericDao.salvar(medico4);
		
		for(int i=1;i<=200;i++){
			Especialidade esp = new Especialidade();
			esp.setEstaAtivo(true);
			esp.setNome("Especialidade " + i);
			genericDao.salvar(esp);
		}

		for(int i=1;i<=250;i++){
			TipoExame te = new TipoExame();
			te.setNome("Exame Tipo " + i);
			te.setEstaAtivo(true);
			genericDao.salvar(te);
		}

		for(int i=1;i<=2500;i++){
			Medicamento medicamento = new Medicamento();
			medicamento.setNome("Medicamento " + i);
			medicamento.setMarca("Marca " + ((i%20)+1));
			medicamento.setEstaAtivo(true);
			genericDao.salvar(medicamento);
		}

		session.getTransaction().commit();
	}
}
