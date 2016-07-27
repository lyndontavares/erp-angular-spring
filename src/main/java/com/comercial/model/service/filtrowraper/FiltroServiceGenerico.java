package com.comercial.model.service.filtrowraper;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.uaihebert.uaicriteria.UaiCriteria;
import com.uaihebert.uaicriteria.UaiCriteriaFactory;

public class FiltroServiceGenerico<T> implements FiltroGenercio<T> {

	@Autowired
	private EntityManager em;

	private Class<T> entityClass;

	public FiltroServiceGenerico() {

	}

	public FiltroServiceGenerico(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> consultar(List<Filtro> filtros) {

		UaiCriteria<T> easyCriteria = UaiCriteriaFactory.createQueryCriteria(em, entityClass);

		try {

			for (Filtro filtro : filtros) {
				switch (filtro.getOperador()) {
				case igual: {
					if (filtro.getAndOuOr().equals(AndOr.and)) {
						easyCriteria.andEquals(filtro.getParametro(), filtro.getValor());
					} else {
						easyCriteria.orEquals(filtro.getParametro(), filtro.getValor());
					}
					break;
				}

				case diferente: {
					if (filtro.getAndOuOr().equals(AndOr.and)) {
						easyCriteria.andNotEquals(filtro.getParametro(), filtro.getValor());
					} else {
						easyCriteria.orNotEquals(filtro.getParametro(), filtro.getValor());
					}
					break;
				}

				case maior: {
					easyCriteria.andGreaterThan(filtro.getParametro(), filtro.getValor());
					break;
				}

				case maiorIgual: {
					easyCriteria.andGreaterOrEqualTo(filtro.getParametro(), filtro.getValor());
					break;
				}

				case menor: {
					easyCriteria.andLessThan(filtro.getParametro(), filtro.getValor());
					break;
				}

				case menorIgual: {
					easyCriteria.andLessOrEqualTo(filtro.getParametro(), filtro.getValor());
					break;
				}

				case like: {
					if (filtro.getAndOuOr().equals(AndOr.and)) {
						easyCriteria.andStringLike(filtro.getParametro(), (String) filtro.getValor());
					} else {
						easyCriteria.orStringLike(filtro.getParametro(), (String) filtro.getValor());
					}
					break;
				}
				case nulo: {
					if (filtro.getAndOuOr().equals(AndOr.and)) {
						easyCriteria.andIsNull(filtro.getParametro());
					} else {
						easyCriteria.orIsNull(filtro.getParametro());
					}
					break;
				}
				case naoNulo: {
					if (filtro.getAndOuOr().equals(AndOr.and)) {
						easyCriteria.andIsNotNull(filtro.getParametro());
					} else {
						easyCriteria.orIsNotNull(filtro.getParametro());
					}
					break;
				}
				case between: {
					easyCriteria.andBetween(filtro.getParametro(), ((List<Object>) filtro.getValor()).get(0),
							((List<Object>) filtro.getValor()).get(1));
					break;
				}
				case innerJoin: {
					easyCriteria.innerJoin(filtro.getJoin()).andEquals(filtro.getParametro(),
							(Object) filtro.getValor());
					break;
				}

				case leftJoin: {
					easyCriteria.leftJoin(filtro.getJoin()).andEquals(filtro.getParametro(),
							(Object) filtro.getValor());
					break;
				}
				case maximoResultado: {
					easyCriteria.setMaxResults(Integer.parseInt(filtro.getValor().toString()));
					break;
				}

				case innerJoinFetch: {
					easyCriteria.innerJoinFetch(filtro.getJoin()).andEquals(filtro.getParametro(),
							(Object) filtro.getValor());
					break;
				}

				case innerJoinBetween: {
					easyCriteria.innerJoin(filtro.getJoin()).andBetween(filtro.getParametro(),
							((List<Object>) filtro.getValor()).get(0), ((List<Object>) filtro.getValor()).get(1));
					break;
				}
				case orderAsc: {
					easyCriteria.orderByAsc(filtro.getParametro());

					break;
				}
				case orderDesc: {
					easyCriteria.orderByDesc(filtro.getParametro());
					break;
				}
				default: {
					break;
				}

				}

			}
		} catch (Exception e) {
			System.out.println(">>>ERRO parâmetros filtro<<<");
			return null;
		}

		return easyCriteria.getResultList();
	}

}
