CREATE TABLE movie
(
	id  INTEGER IDENTITY PRIMARY KEY,
	name_russian VARCHAR(400),
	name_native VARCHAR(400),
	year_of_release INTEGER ,
	description varchar(4000),
	rating double precision default 0,
	price double precision default 0,
	picture_path varchar(4000)
)
;

CREATE TABLE movie_random
(
	id  INTEGER IDENTITY PRIMARY KEY,
	name_russian VARCHAR(400),
	name_native VARCHAR(400),
	year_of_release INTEGER ,
	description VARCHAR2(4000),
	rating double precision default 0,
	price double precision default 0,
	picture_path varchar(4000)
)
;

CREATE TABLE movie_by_genre
(
  id  INTEGER IDENTITY PRIMARY KEY,
  name_russian VARCHAR(400),
  name_native VARCHAR(400),
  year_of_release INTEGER ,
	description varchar(4000),
  rating double precision default 0,
  price double precision default 0,
  picture_path varchar(4000)
)
;

CREATE TABLE genre
(
	id   INTEGER IDENTITY PRIMARY KEY,
	name VARCHAR(100)
)
;

CREATE TABLE movie_genre
(
  movie_id INTEGER,
  genre_id INTEGER
)
;