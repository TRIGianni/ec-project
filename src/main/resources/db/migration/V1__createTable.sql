CREATE TABLE IF NOT EXISTS products  (
         id SERIAL,
         product_name varchar(15),
         description varchar(15),
         unit_price decimal,
         image_url varchar(15)
);