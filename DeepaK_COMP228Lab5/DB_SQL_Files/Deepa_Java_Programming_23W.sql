CREATE TABLE Game (
  game_id NUMBER(10) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  game_title VARCHAR2(40)
);

CREATE TABLE Player (
  player_id NUMBER(10) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  first_name VARCHAR2(20),
  last_name VARCHAR2(20),
  address VARCHAR2(50),
  postal_code VARCHAR2(10),
  province VARCHAR2(20),
  Phone_Number VARCHAR2(20)
);

CREATE TABLE PlayerAndGame (
  player_game_id NUMBER(10) GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  game_id NUMBER(10),
  player_id NUMBER(10),
  playing_date DATE,
  score NUMBER(10,2),
  FOREIGN KEY (game_id) REFERENCES Game(game_id),
  FOREIGN KEY (player_id) REFERENCES Player(player_id)
);


SELECT game.game_id, game.game_title, player.player_id, PlayerAndGame.playing_date, PlayerAndGame.score, Player.first_name, Player.last_name, Player.address, Player.postal_code, Player.province, Player.phone_number
FROM Game
INNER JOIN PlayerAndGame ON Game.game_id = PlayerAndGame.game_id
INNER JOIN Player ON PlayerAndGame.player_id = Player.player_id;