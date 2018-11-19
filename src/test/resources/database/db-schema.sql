CREATE TABLE movie
(
	id  INTEGER IDENTITY PRIMARY KEY,
	name_russian VARCHAR(400),
	name_native VARCHAR(400),
	year_of_release INTEGER ,
	rating double precision default 0,
	price double precision default 0,
	picture_path varchar(4000)
)
;