package com.icoder.auth.model;

import java.util.ArrayList;
import java.util.List;

import com.icoder.auth.model.AirData;
import com.icoder.common.block.BlockChain;

public class GraphData {
	
	private static List<KeyValue> piechartData;

	public static List<KeyValue> getPiechartData() {
		return piechartData;
	}

	public static void PieData(String date) {
		BlockChain blockChain=new BlockChain();
    	List<AirData> blockChainAirData=blockChain.getDataFromChain();
    	System.out.println(blockChainAirData);
    	List<KeyValue> blockChainGraphData=new ArrayList<>();
    	blockChainAirData.stream().filter(val->
    		val.getDate().equals(date)).forEach(val1->{
    			double hour=(val1.getH01()+val1.getH02()+val1.getH03()+val1.getH04()+val1.getH05()+val1.getH06()+
    					val1.getH07()+val1.getH08()+val1.getH09()+val1.getH10()+val1.getH11()+val1.getH12()+
    					val1.getH13()+val1.getH14()+val1.getH15()+val1.getH16()+val1.getH17()+val1.getH18()+
    					val1.getH19()+val1.getH20()+val1.getH21()+val1.getH22()+val1.getH23()+val1.getH24()
    					)/24;
    			blockChainGraphData.add(new KeyValue(val1.getPollutant(), String.valueOf(hour)));
    		});
    	GraphData.piechartData=blockChainGraphData;
	}
	
	public static class KeyValue{
		private String key;
		private String value;

		public KeyValue(String key,String value) {
			this.key=key;
			this.value=value;
		}
		public String getKey() {
			return key;
			}

			public String getValue() {
			return value;
			}
	}


}
