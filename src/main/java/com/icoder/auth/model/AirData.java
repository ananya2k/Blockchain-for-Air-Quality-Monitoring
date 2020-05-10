package com.icoder.auth.model;

import javax.persistence.*;

@Entity
@Table(name = "air_data")
public class AirData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String station_id;
    private String Pollutant;
    private String date;
    
    private Double h01;
    private Double h02;
    private Double h03;
    private Double h04;
    private Double h05;
    private Double h06;
    private Double h07;
    private Double h08;
    private Double h09;
    private Double h10;
    private Double h11;
    private Double h12;
    private Double h13;
    private Double h14;
    private Double h15;
    private Double h16;
    private Double h17;
    private Double h18;
    private Double h19;
    private Double h20;
    private Double h21;
    private Double h22;
    private Double h23;
    private Double h24;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStation_id() {
		return station_id;
	}
	public void setStation_id(String station_id) {
		this.station_id = station_id;
	}
	public String getPollutant() {
		return Pollutant;
	}
	public void setPollutant(String pollutant) {
		Pollutant = pollutant;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getH01() {
		return h01;
	}
	public void setH01(Double h01) {
		this.h01 = h01;
	}
	public Double getH02() {
		return h02;
	}
	public void setH02(Double h02) {
		this.h02 = h02;
	}
	public Double getH03() {
		return h03;
	}
	public void setH03(Double h03) {
		this.h03 = h03;
	}
	public Double getH04() {
		return h04;
	}
	public void setH04(Double h04) {
		this.h04 = h04;
	}
	public Double getH05() {
		return h05;
	}
	public void setH05(Double h05) {
		this.h05 = h05;
	}
	public Double getH06() {
		return h06;
	}
	public void setH06(Double h06) {
		this.h06 = h06;
	}
	public Double getH07() {
		return h07;
	}
	public void setH07(Double h07) {
		this.h07 = h07;
	}
	public Double getH08() {
		return h08;
	}
	public void setH08(Double h08) {
		this.h08 = h08;
	}
	public Double getH09() {
		return h09;
	}
	public void setH09(Double h09) {
		this.h09 = h09;
	}
	public Double getH10() {
		return h10;
	}
	public void setH10(Double h10) {
		this.h10 = h10;
	}
	public Double getH11() {
		return h11;
	}
	public void setH11(Double h11) {
		this.h11 = h11;
	}
	public Double getH12() {
		return h12;
	}
	public void setH12(Double h12) {
		this.h12 = h12;
	}
	public Double getH13() {
		return h13;
	}
	public void setH13(Double h13) {
		this.h13 = h13;
	}
	public Double getH14() {
		return h14;
	}
	public void setH14(Double h14) {
		this.h14 = h14;
	}
	public Double getH15() {
		return h15;
	}
	public void setH15(Double h15) {
		this.h15 = h15;
	}
	public Double getH16() {
		return h16;
	}
	public void setH16(Double h16) {
		this.h16 = h16;
	}
	public Double getH17() {
		return h17;
	}
	public void setH17(Double h17) {
		this.h17 = h17;
	}
	public Double getH18() {
		return h18;
	}
	public void setH18(Double h18) {
		this.h18 = h18;
	}
	public Double getH19() {
		return h19;
	}
	public void setH19(Double h19) {
		this.h19 = h19;
	}
	public Double getH20() {
		return h20;
	}
	public void setH20(Double h20) {
		this.h20 = h20;
	}
	public Double getH21() {
		return h21;
	}
	public void setH21(Double h21) {
		this.h21 = h21;
	}
	public Double getH22() {
		return h22;
	}
	public void setH22(Double h22) {
		this.h22 = h22;
	}
	public Double getH23() {
		return h23;
	}
	public void setH23(Double h23) {
		this.h23 = h23;
	}
	public Double getH24() {
		return h24;
	}
	public void setH24(Double h24) {
		this.h24 = h24;
	}

}
