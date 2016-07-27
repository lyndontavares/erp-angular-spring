package com.comercial.model.grafico;

import java.util.List;

public class GraficoJson {

	
	private List<String> labels;
	
	private List<String> series;
	
	private List<Object> data;

	public List<String> getLabels() {
		return labels;
	}

	public void setLabels(List<String> labels) {
		this.labels = labels;
	}

	public List<String> getSeries() {
		return series;
	}

	public void setSeries(List<String> series) {
		this.series = series;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "GraficoJson [labels=" + labels + ", series=" + series + ", data=" + data + "]";
	}
	
	
	
	
}