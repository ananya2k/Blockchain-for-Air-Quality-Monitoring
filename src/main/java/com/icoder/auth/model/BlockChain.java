package com.icoder.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "block_chain")
public class BlockChain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long bc_index;
	
    private Long time_stamp;
	private String hash;
	private String previous_hash;
	public Long getIndex() {
		return bc_index;
	}
	public void setIndex(Long index) {
		this.bc_index = index;
	}
	public Long getTime_stamp() {
		return time_stamp;
	}
	public void setTime_stamp(Long time_stamp) {
		this.time_stamp = time_stamp;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getPrevious_hash() {
		return previous_hash;
	}
	public void setPrevious_hash(String previous_hash) {
		this.previous_hash = previous_hash;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "DB :: - index :"+this.getIndex()+" timeStamp :"+this.getTime_stamp()+" hash :"+this.getHash()+" previousHash :"+this.getPrevious_hash();
	}
    
}
