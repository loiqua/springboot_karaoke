CREATE DATABASE karaoke;

\c karaoke;

CREATE TABLE songs (
  id SERIAL PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  artist VARCHAR(100) NOT NULL,
  genre_id INT NOT NULL,
  year INT NOT NULL,
  lyrics TEXT NOT NULL
);

CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL
);
CREATE TABLE choose (
  user_id INT REFERENCES users(id),
  song_id INT REFERENCES songs(id),
  PRIMARY KEY (user_id, song_id)
);
