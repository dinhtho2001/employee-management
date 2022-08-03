CREATE TABLE test (
  id bigint NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  password varchar(200) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_username (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;