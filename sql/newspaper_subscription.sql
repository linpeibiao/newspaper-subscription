
DROP TABLE IF EXISTS `t_newspaper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_newspaper` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) DEFAULT NULL COMMENT '报刊名称',
  `newspaper_number` varchar(32) DEFAULT NULL COMMENT '报刊号',
  `cover` varchar(512) DEFAULT NULL COMMENT '封面图片',
  `type` varchar(16) DEFAULT NULL COMMENT '类别',
  `brief` varchar(512) DEFAULT NULL COMMENT '简介',
  `publisher` varchar(32) DEFAULT NULL COMMENT '出版社',
  `publish_time` datetime DEFAULT NULL COMMENT '出版时间',
  `price` decimal(10,2) DEFAULT NULL COMMENT '订阅周期单价',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `backup1` varchar(255) DEFAULT NULL COMMENT '备用字段1',
  `backup2` varchar(255) DEFAULT NULL COMMENT '备用字段2',
  `is_deleted` tinyint(1) DEFAULT NULL COMMENT '逻辑删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_newspaper_type_name` (`type`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=102661 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_newspaper_type`
--

DROP TABLE IF EXISTS `t_newspaper_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_newspaper_type` (
  `id` bigint NOT NULL COMMENT '主键id',
  `type` varchar(16) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_order` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `order_number` varchar(64) DEFAULT NULL COMMENT '订单号',
  `user_id` bigint DEFAULT NULL COMMENT '用户id',
  `newspaper_id` bigint DEFAULT NULL COMMENT '报刊id',
  `period` int DEFAULT NULL COMMENT '订阅周期',
  `subscript_unit` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订阅周期单位',
  `count` int DEFAULT NULL COMMENT '订阅份数',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '总价格',
  `expiry_time` datetime DEFAULT NULL COMMENT '到期时间',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名称',
  `newspaper_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '报刊名称',
  `is_deleted` tinyint(1) DEFAULT NULL COMMENT '逻辑删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nackname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `real_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
  `department` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属单位',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `postcode` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮政编码',
  `state` tinyint(1) DEFAULT NULL COMMENT '用户状态 0-正常，1-禁用',
  `role` tinyint(1) DEFAULT NULL COMMENT '用户角色',
  `backup1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备用字段1',
  `backup2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备用字段2',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `is_deleted` tinyint(1) DEFAULT NULL COMMENT '逻辑删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
