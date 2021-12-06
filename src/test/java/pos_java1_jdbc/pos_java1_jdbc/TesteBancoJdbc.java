package pos_java1_jdbc.pos_java1_jdbc;

import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();

		userposjava.setNome("Paulo");
		userposjava.setEmail("paulo@gmail.com");

		userPosDAO.salvar(userposjava);

	}

	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();

			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initBuscar() {

		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava userposjava = dao.buscar(5L);

			System.out.println(userposjava);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void initAtualizar() {
		try {

			UserPosDAO dao = new UserPosDAO();

			Userposjava objetoBanco = dao.buscar(6L);

			objetoBanco.setNome("Nome mudado com metodo atualizar");

			dao.atualizar(objetoBanco);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void initDeletar() {

		try {

			UserPosDAO dao = new UserPosDAO();
			dao.deletar(1L);
		} catch (Exception e) {

		}
	}

	@Test
	public void testeInsertTelefone() {

		Telefone telefone = new Telefone();
		telefone.setNumero("(41)9988-5646");
		telefone.setTipo("AP");
		telefone.setUsuario(9L);

		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);

	}

	@Test
	public void testeCarregarFonesUser() {

		UserPosDAO dao = new UserPosDAO();

		List<BeanUserFone> beanUserFones = dao.listaUserFone(9L);

		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("---------------------------------");
		}

	}

	@Test
	public void testeDeleteUSerFone() {

		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(9L);

	}

}
