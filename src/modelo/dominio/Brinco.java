package modelo.dominio;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_brincos")
public class Brinco {
	
	
	  
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_BRINCO")
	@SequenceGenerator(name = "ID_BRINCO", sequenceName = "SEQ_BRINCO", allocationSize = 1)
	
	private Integer codigo;
	private String tipo;
	private Float precovenda;
	private String cor;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_fk_vendedor")
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Float getPrecovenda() {
		return precovenda;
	}
	public void setPrecovenda(Float precovenda) {
		this.precovenda = precovenda;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	@Override
	public String toString() {
		return "Brinco [codigo=" + codigo + ", tipo=" + tipo + ", precovenda=" + precovenda + ", cor=" + cor + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brinco other = (Brinco) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	

}
