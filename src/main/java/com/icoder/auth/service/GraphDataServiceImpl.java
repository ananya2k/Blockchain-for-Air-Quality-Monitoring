package com.icoder.auth.service;

import java.util.List;

import com.icoder.auth.model.GraphData;
import com.icoder.auth.model.GraphData.KeyValue;

public class GraphDataServiceImpl implements GraphDataService{

	@Override
	public List<KeyValue> getPieChartData() {
		return GraphData.getPiechartData();
	}

}
