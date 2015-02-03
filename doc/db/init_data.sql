delete from user;
-- 10 male
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_1',0,'100001','user_1@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_2',0,'100002','user_2@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_3',0,'100003','user_3@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_4',0,'100004','user_4@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_5',0,'100005','user_5@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_6',0,'100006','user_6@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_7',0,'100007','user_7@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_8',0,'100008','user_8@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_9',0,'100009','user_9@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_10',0,'100010','user_10@test.com',0,now());

-- 10 female
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_11',1,'100020','user_11@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_12',1,'100019','user_12@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_13',1,'100018','user_13@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_14',1,'100017','user_14@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_15',1,'100016','user_15@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_16',1,'100015','user_16@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_17',1,'100014','user_17@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_18',1,'100013','user_18@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_19',1,'100012','user_19@test.com',0,now());
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_20',1,'100011','user_20@test.com',0,now());

-- 1 disabled
insert into user(uid,username,gender,mobile,email,disabled,createDatetime) values(uuid(),'user_21',0,'100021','user_21@test.com',1,now());