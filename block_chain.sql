CREATE TABLE `block_chain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time_stamp` bigint(100) NOT NULL COMMENT 'block_chain table',
  `hash` varchar(300) NOT NULL,
  `previous_hash` varchar(300) NOT NULL,
  `bc_index` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;
