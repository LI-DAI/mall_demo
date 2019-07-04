DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `nickname` varchar(36) NOT NULL COMMENT '用户昵称',
  `username` varchar(36) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `salt` varchar(36) NOT NULL COMMENT '加密盐',
  `avatar` varchar(200) DEFAULT NULL COMMENT '头像路径',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone_number` varchar(11) DEFAULT NULL COMMENT '电话号码',
  `gender` VARCHAR(10) DEFAULT 'MALE' COMMENT '性别,可以为MALE和FEMALE',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '0:正常 ，1:被锁定',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注标签',
  `create_time` timestamp COMMENT '创建时间',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp COMMENT '修改时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;