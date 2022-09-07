USE capstone_db;

INSERT INTO users(city, email, password, enabled, user_type, state, username, profile_img)
VALUES('San Antonio','testing@email.com','$2a$10$uwZkt4sTwKzFp.gnm8UJbe1Z3BeMWdfJ3ZXIbBFRjLdFumuJM4hJi',true,'venue','texas','pleasefindme', 'https://cdn.filestackcontent.com/RUeUf2m3SiCYjVoIVXIm'),
      ('Austin','nottest@gmail.com','$2a$10$uwZkt4sTwKzFp.gnm8UJbe1Z3BeMWdfJ3ZXIbBFRjLdFumuJM4hJi',true,'band','Texas','hiddenojutsu', 'https://cdn.filestackcontent.com/RUeUf2m3SiCYjVoIVXIm'),
      ('Chicago','deftest@gmail.com','$2a$10$uwZkt4sTwKzFp.gnm8UJbe1Z3BeMWdfJ3ZXIbBFRjLdFumuJM4hJi',true,'musician','Illinois','chicagoisbest', 'https://cdn.filestackcontent.com/RUeUf2m3SiCYjVoIVXIm'),
      ('Denver','denver@gmail.com','$2a$10$uwZkt4sTwKzFp.gnm8UJbe1Z3BeMWdfJ3ZXIbBFRjLdFumuJM4hJi',true,'band','Colorado','moutain', 'https://cdn.filestackcontent.com/RUeUf2m3SiCYjVoIVXIm'),
      ('Portland','port@gmail,com','$2a$10$uwZkt4sTwKzFp.gnm8UJbe1Z3BeMWdfJ3ZXIbBFRjLdFumuJM4hJi',true,'venue','Oregon','hip', 'https://cdn.filestackcontent.com/RUeUf2m3SiCYjVoIVXIm'),
      ('Seattle','rain@gmail.com','$2a$10$uwZkt4sTwKzFp.gnm8UJbe1Z3BeMWdfJ3ZXIbBFRjLdFumuJM4hJi',true,'musician','Washington','wash', 'https://cdn.filestackcontent.com/RUeUf2m3SiCYjVoIVXIm');

#     INSERT INTO users(city, description, email, social_media, password, profile_img, state, username, first_name, last_name) VALUE ('test','this is a test','test@gmail.com','test','$2a$10$5odcJCeatSzjX7w3GoCSH.HpL..wEKLYyD47gd7pS42fL2.gwa1nq','test','test','testuse','test','test')