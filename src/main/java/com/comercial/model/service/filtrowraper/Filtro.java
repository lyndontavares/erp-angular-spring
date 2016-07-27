package com.comercial.model.service.filtrowraper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filtro {

	private String parametro;

	private Object valor;

	private Operador operador;

	private String join;

	private AndOr andOuOr;

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public Object getValor() {
		return valor;
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public AndOr getAndOuOr() {
		return andOuOr;
	}

	public void setAndOuOr(AndOr andOuOr) {
		this.andOuOr = andOuOr;
	}

	public Filtro() {
		this.andOuOr = AndOr.and;
	}

	public Filtro(String parametro, Object valor, Operador operador, String join) {
		super();
		this.parametro = parametro;
		this.valor = valor;
		this.operador = operador;
		this.join = join;
		this.andOuOr = AndOr.and;
	}

	public Filtro(String parametro, Object valor, Operador operador, String join, AndOr andOuOr) {
		super();
		this.parametro = parametro;
		this.valor = valor;
		this.operador = operador;
		this.join = join;
		this.andOuOr = andOuOr;
	}

	public static final class ExpressaoLogicaHelper {

		public static boolean maiorQueZero(Long numero) {
			return numero > 0;
		}

		public static boolean maiorQueZero(BigDecimal numero) {
			return (numero != null) && (numero.doubleValue() > 0);
		}

		public static boolean maiorQueVazio(String string) {
			return (string != null) && (!string.trim().equals(""));
		}

		public static boolean maiorOuIgualQueHoje(Date data) {
			return (data != null) && (data.compareTo(new Date()) >= 0);
		}

		public static boolean maiorQueHoje(Date data) {
			return (data != null) && (data.compareTo(new Date()) > 0);
		}

		public static boolean igualAHoje(Date data) {
			return (data != null) && (data.compareTo(new Date()) == 0);
		}

	}

	public static Builder getBuilder() {
		return new Builder();
	}

	public static final class Builder {

		private List<Filtro> parametros;

		Builder() {
			parametros = new ArrayList<>();
		}

		public Builder adicionarParametro(String nomeParametro, Object valorParametro, Operador operador, String join) {
			parametros.add(new Filtro(nomeParametro, valorParametro, operador, join));
			return this;
		}

		public Builder adicionarParametro(String nomeParametro, Object valorParametro, Operador operador, String join,
				AndOr andOuOr) {
			parametros.add(new Filtro(nomeParametro, valorParametro, operador, join, andOuOr));
			return this;
		}

		/**
		 * <h1>AdicionarSe</h1> Adiciona parâmetro ao filtro
		 * 
		 * @param condicaoParaAdicionarFiltro
		 *            expressão lógina. o prâmetro só é aadicioinado se
		 *            expressão verdadeira.
		 * @param nomeParametro
		 *            nome atributo da entidade. Se atributo objeto, use sintaxe
		 *            de ponto acessar seus atributos.
		 * @param valorParametro
		 *            valor de busca do filtro igual a tipagem do atributo a ser
		 *            pesquisado.
		 * @param operador
		 *            tipo enumerado.
		 * @param join
		 *            entidade relacionada. Se utilizar atributo de entidade
		 *            relacionada parâmetro obrigatório. Informe nome da
		 *            entidade relacionada em minúculas.
		 * @return retorna instância do builder.
		 */
		public Builder adicionarSe(boolean condicaoParaAdicionarFiltro, String nomeParametro, Object valorParametro,
				Operador operador, String join) {
			if (valorParametro != null) {
				if (condicaoParaAdicionarFiltro) {
					parametros.add(new Filtro(nomeParametro, valorParametro, operador, join));
				}
			}
			return this;
		}

		/**
		 * <h1>AdicionarSe</h1> Adiciona parâmetro ao filtro da mesma entidade
		 * sem JOIN. Se precisar de JOIN use : adicionarSe(boolean
		 * condicaoParaAdicionarFiltro, String nomeParametro, Object
		 * valorParametro, Operador operador, String join)
		 * 
		 * @param condicaoParaAdicionarFiltro
		 *            expressão lógina. o prâmetro só é aadicioinado se
		 *            expressão verdadeira.
		 * @param nomeParametro
		 *            nome atributo da entidade. Se atributo objeto, use sintaxe
		 *            de ponto acessar seus atributos.
		 * @param valorParametro
		 *            valor de busca do filtro igual a tipagem do atributo a ser
		 *            pesquisado.
		 * @param operador
		 *            tipo enumerado.
		 * @return retorna istância do builder.
		 */
		public Builder adicionarSe(boolean condicaoParaAdicionarFiltro, String nomeParametro, Object valorParametro,
				Operador operador) {
			if (valorParametro != null) {
				if (condicaoParaAdicionarFiltro) {
					parametros.add(new Filtro(nomeParametro, valorParametro, operador, null));
				}
			}
			return this;
		}

		public Builder adicionarSe(boolean condicaoParaAdicionarFiltro, String nomeParametro, Object valorParametro,
				Operador operador, String join, AndOr andOuOr) {
			if (valorParametro != null) {
				if (condicaoParaAdicionarFiltro) {
					parametros.add(new Filtro(nomeParametro, valorParametro, operador, join, andOuOr));
				}
			}
			return this;
		}

		public Builder ordenarAscendentePor(String nomeParametro) {
			parametros.add(new Filtro(nomeParametro, null, Operador.orderAsc, null));
			return this;
		}

		public Builder ordenarDescendentePor(String nomeParametro) {
			parametros.add(new Filtro(nomeParametro, null, Operador.orderDesc, null));
			return this;
		}

		public List<Filtro> build() {
			return parametros;
		}

	}

	@Override
	public String toString() {
		return "Filtro [parametro=" + parametro + ", valor=" + valor + ", operador=" + operador + " join=" + join + "]";
	}

	public String getJoin() {
		return join;
	}

	public void setJoin(String join) {
		this.join = join;
	}

}
