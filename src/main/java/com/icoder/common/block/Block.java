package com.icoder.common.block;
import com.icoder.auth.model.AirData;
import com.icoder.common.helpers.SHA256;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Block {


    public long timeStamp;
    private int index;
    private AirData airData;
    private String hash;
    private String previousHash;
    private static String merkleRoot;
    private String nonce = "0000";



    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public AirData getAirData() {
        return airData;
    }

    public void setAirData(AirData airData) {
        this.airData = airData;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public static String getMerkleRoot() {
        return merkleRoot;
    }

    public void setMerkleRoot(String merkleRoot) {
        this.merkleRoot = merkleRoot;
    }



    public Block(int index, AirData airData, String previousHash) {
        this.index = index;
        this.airData = airData;
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        computeMerkleRoot();
        computeHash();
    }

    public void computeMerkleRoot() {
        List<String> treeList = merkleTree();
        setMerkleRoot(treeList.get(treeList.size()-1));
    }


    public List<String> merkleTree() {
        ArrayList<String> tree = new ArrayList<>();
        ObjectMapper oMapper = new ObjectMapper();
        
        @SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>)oMapper.convertValue(airData, Map.class);
        for (String s : map.keySet()) {
            tree.add(SHA256.generateHash(String.valueOf(map.get(s))));
        }
        int levelOffset = 0;
        for (int levelSize = map.size(); levelSize > 1; levelSize = (levelSize + 1) / 2) {
            for (int left = 0; left < levelSize; left += 2) {
                int right = Math.min(left + 1, levelSize - 1);
                String tleft = tree.get(levelOffset + left);
                String tright = tree.get(levelOffset + right);
                tree.add(SHA256.generateHash(tleft + tright));
            }
            levelOffset += levelSize;
        }
        return tree;
    }

    public void computeHash() {
        setHash(SHA256.generateHash(String.valueOf(timeStamp) + String.valueOf(index) + merkleRoot + nonce + previousHash));
    }

	@Override
	public String toString() {
		return "index :"+this.getIndex()+" timeStamp :"+this.getTimeStamp()+" hash :"+this.getHash()+" previousHash :"+this.getPreviousHash()+" merkleRoot :"+this.merkleRoot;
	}



}
