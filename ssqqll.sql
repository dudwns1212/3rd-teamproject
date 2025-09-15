DROP SCHEMA IF EXISTS gymproject;
CREATE SCHEMA gymproject COLLATE = utf8_general_ci;
use gymproject;

create table users(
   user_id int auto_increment primary key,
    user_email varchar(50) unique,
    user_password varchar(50),
    user_name varchar(30),
    user_tel varchar(30),
    user_birth varchar(30),
    user_gender varchar(10)
);

CREATE TABLE post (
  post_id int auto_increment,
  post_name varchar(10) NOT NULL,
  post_content text DEFAULT NULL,
  post_user_id int Default NULL,
  post_tag char(10) Default NULL,
  post_img varchar(100) DEFAULT NULL,
  post_like int DEFAULT NULL,
  post_view int DEFAULT NULL,
  post_dislike int DEFAULT NULL,
  post_board_code int DEFAULT NULL,
  PRIMARY KEY (post_id),
  foreign key (post_user_id) references users(user_id)
  
);
insert into users(user_email, user_password, user_name, user_tel, user_birth, user_gender) values ('2@1.com','1','1','1','1','1');
insert into post(post_id, post_name, post_content, post_user_id, post_tag, post_img, post_like, post_view, post_dislike, post_board_code)
values(1, "성장했구나", "당신이 이걸 봤다는게 성장했다는 증거임", 1, null, null, null, null, null, null);



CREATE TABLE gym_machine (
    machine_id INT AUTO_INCREMENT PRIMARY KEY,     -- 기구 고유 번호 (PK)
    machine_name VARCHAR(100) NOT NULL,            -- 기구 이름
    machine_purchase_date DATE,                    -- 구입 일자
    machine_price DECIMAL(12,2),                   -- 가격 (소수점 2자리까지)
    machine_service_contact VARCHAR(20),           -- AS 연락처
    machine_img VARCHAR(255),                      -- 기구 사진 경로
    machine_video VARCHAR(255)                     -- 기구 사용 영상 경로 (유튜브 링크 등)
);
INSERT INTO gym_machine
(machine_name, machine_purchase_date, machine_price, machine_service_contact, machine_img, machine_video)
VALUES
('멀티 코너렉 HP-1001', '2024-03-15', 4300000.00, '010-1234-5678', 'images/멀티 코너렉HP-1001.jpg', 'https://youtu.be/abcd1234'),
('크로스 오버 NSA-018', '2025-03-15', 325000.00, '010-1234-5678', 'images/NSA-018 크로스 오버.jpg', 'https://youtu.be/abcd1234'),
('랫풀다운 PRT-303', '2030-03-15', 2300000.00, '010-1234-5678', 'images/랫풀다운PRT-303.jpg', 'https://youtu.be/abcd1234');




CREATE TABLE appointment (
id int auto_increment,
userName varchar(15) NOT NULL,
email varchar(50) DEFAULT NULL,
phone varchar(20) DEFAULT NULL,
address varchar(100) DEFAULT NULL,
appointmentId varchar(30) DEFAULT NULL,
serviceType varchar(30) DEFAULT NULL,
appointmentDate varchar(20) DEFAULT NULL,
appointmentDuration varchar(20) DEFAULT NULL,
status1 varchar(20) DEFAULT NUll,

PRIMARY KEY (id)
);


select * from gym_machine;
select * from users;
select * from appointment;
select * from post;

select * from post_comment;