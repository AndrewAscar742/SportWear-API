CREATE TABLE produtos(
	id int(6) primary key auto_increment,
	title varchar(50) not null,
	img varchar(200) not null,
	price decimal(9,2) not null,
	category varchar(12) not null

);