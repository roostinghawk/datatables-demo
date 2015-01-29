DROP TABLE IF EXISTS test.`user`;

CREATE TABLE test.`user`
	(
	id             INT NOT NULL auto_increment,
	uid            VARCHAR (45),
	username       VARCHAR (45),
	gender         INT DEFAULT 0,
	mobile         VARCHAR (11),
	email          VARCHAR (30),
	disabled       INT DEFAULT 0,
	createDatetime DATETIME,
	PRIMARY KEY (id)
	);

