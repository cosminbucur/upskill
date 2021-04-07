INSERT INTO `spring_security_jdbc`.`users` (`username`, `email`, `password`, `role`)
VALUES ('admin', 'admin@gmail.com', '{bcrypt}$2y$12$92ZkDrGVS3W5ZJI.beRlEuyRCPrIRlkEHz6T.7MVmH38l4/VAHhyi', 'ADMIN');
INSERT INTO `spring_security_jdbc`.`users` (`username`, `email`, `password`, `role`)
VALUES ('user', 'user@gmail.com', '{bcrypt}$2y$12$92ZkDrGVS3W5ZJI.beRlEuyRCPrIRlkEHz6T.7MVmH38l4/VAHhyi', 'USER');