USE capstone_db;

INSERT INTO users(city, email, password,enabled,user_type, state, username)
VALUES('San Antonio','testing@email.com','password',true,'venue','texas','pleasefindme'),
      ('Austin','nottest@gmail.com','password',true,'band','Texas','hiddenojutsu'),
      ('Chicago','deftest@gmail.com','password',true,'musician','Illinois','chicagoisbest'),
      ('Denver','denver@gmail.com','password',true,'band','Colorado','moutain'),
      ('Portland','port@gmail,com','password',true,'venue','Oregon','hip'),
      ('Seattle','rain@gmail.com','password',true,'musician','Washington','wash');

#     INSERT INTO users(city, description, email, social_media, password, profile_img, state, username, first_name, last_name) VALUE ('test','this is a test','test@gmail.com','test','$2a$10$5odcJCeatSzjX7w3GoCSH.HpL..wEKLYyD47gd7pS42fL2.gwa1nq','test','test','testuse','test','test')