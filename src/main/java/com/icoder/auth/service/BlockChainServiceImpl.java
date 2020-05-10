/**
 * 
 */
package com.icoder.auth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.icoder.auth.model.BlockChain;
import com.icoder.auth.repository.BlockChainRepository;
import com.icoder.common.block.Block;

@Service
public class BlockChainServiceImpl implements BlockChainService {

	@Autowired
    private BlockChainRepository blockChainRepository;
	
	@Override
	public List<BlockChain> findAll() {
		List<BlockChain> blockChainList=blockChainRepository.findAll();
		return blockChainList;
	}

	@Override
	public Block ValidateBlockChain() {
		Block block=null;
		com.icoder.common.block.BlockChain blockChain=new com.icoder.common.block.BlockChain();
		List<BlockChain> dbBlockChainList=blockChainRepository.findAll();
		for (BlockChain blockChain2 : dbBlockChainList) {
			System.out.println(blockChain2.getIndex());
			block=blockChain.getChainByIndex(blockChain2.getIndex().intValue());
			
			System.out.println(block.toString());
			System.out.println(blockChain2.toString());
			
			if(!(block.getTimeStamp()==blockChain2.getTime_stamp() && block.getHash().equals(blockChain2.getHash()) && block.getPreviousHash().equals(blockChain2.getPrevious_hash()))){
				System.out.println("Testing : "+block.toString());
				break;
			}else{
				System.out.println(block.toString());
			}
		}
		return block;
	}

	@Override
	public BlockChain save(BlockChain blockChain) {
		BlockChain blockChainP=blockChainRepository.save(blockChain);
		return blockChainP;
	}
	
	public void deleteAll() {
		blockChainRepository.deleteAll();	
	}

}
