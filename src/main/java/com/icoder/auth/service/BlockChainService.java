package com.icoder.auth.service;

import java.util.List;

import com.icoder.auth.model.BlockChain;
import com.icoder.common.block.Block;

public interface BlockChainService {

	List<BlockChain> findAll();
	Block ValidateBlockChain();
	BlockChain save(BlockChain blockChain);
	void deleteAll();
	
}
