package controle.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.dao.BrincoDAO;
import modelo.dominio.Brinco;

@ManagedBean(name = "brincoMB")
@RequestScoped
public class BrincoMB {
	private String filtroTipo = null;
	private Brinco b = new Brinco();
	private BrincoDAO brincodao = new BrincoDAO();
	private List<Brinco> brincos = null;

	public List<Brinco> getBrincos() {

		if (this.brincos == null)
			this.brincos = this.brincodao.lerTodos();

		return brincos;
	}
	
	

	public String getFiltroTipo() {
		return filtroTipo;
	}

	public void setFiltroTipo(String filtroTipo) {
		this.filtroTipo = filtroTipo;
	}

	public void setBrincos(List<Brinco> brincos) {
		this.brincos = brincos;
	}

	public Brinco getB() {
		return b;
	}

	public void setB(Brinco b) {
		this.b = b;
	}

	public BrincoDAO getBrincodao() {
		return brincodao;
	}

	public void setBrincodao(BrincoDAO brincodao) {
		this.brincodao = brincodao;
	}

	public String SalvarBrinco() {
		this.brincodao.salvar(b);

		return "listarBrinco";
	}

	public String AlterarBrinco(Integer codigo) {

		this.b = brincodao.lerPorId(codigo);

		return "criarBrinco.jsf";
	}

	public String ExcluirBrinco(Integer codigo) {

		// ler objeto do banco
		this.b = brincodao.lerPorId(codigo);

		this.brincodao.excluir(this.b);

		return "listarBrinco.jsf";
	}
	
	public String filtrarBrinco() {

		this.brincos = this.brincodao.filtrarBrincos(filtroTipo);

		return "listarBrinco.jsf";
	}

	public String irBrinco() {

		return "criarBrinco";
	}
	
	public String irBrincolist() {

		return "listarBrinco.jsf";
	}
	

}
