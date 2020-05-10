package com.icoder.common.block;
import com.icoder.auth.model.AirData;
import com.icoder.common.helpers.SHA256;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {

    static ArrayList<Block> chain = new ArrayList<Block>();

    public void addBlock (AirData airData){
        String previousHash;

        if (chain.size() ==0){
            previousHash= SHA256.generateHash("genesis");
        }else{
            previousHash = chain.get(chain.size()-1).getHash();
        }
        Block b = new Block(chain.size()+1,airData,previousHash);
        chain.add(b);

    }
    
    public static boolean verifyBlockChain(){

        for (int i = chain.size() - 1; i > 0; i--) {

            if (chain.get(i-1).getHash().equals(chain.get(i).getPreviousHash())) {
                continue;
            } else {
                return false;
            }


        }
        return true;
    }
    
    public static Block trueVerifyBlockChain(){

        for (int i = chain.size() - 1; i > 0; i--) {

            if (chain.get(i-1).getHash().equals(chain.get(i).getPreviousHash())) {
                continue;
            } else {
                return chain.get(i);
            }


        }
        return null;
    }
    
    public static boolean dbVerifyBlockChain(){

        for (int i = chain.size() - 1; i > 0; i--) {

            if (chain.get(i-1).getHash().equals(chain.get(i).getPreviousHash())) {
                continue;
            } else {
                return false;
            }


        }
        return true;
    }

    public List<AirData> getDataFromChain(){

        List<AirData> data = new ArrayList<>();
        for (Block block:chain) {

            data.add(block.getAirData());
        }
        return data;

    }
    
    public Block getChainByIndex(int index){
    		return getChain().get(index-1);
    }

	public List<Block> getChain() {
		return chain;
	}
    
}
