-- ✅ Tabla de usuarios
CREATE TABLE IF NOT EXISTS user (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    email VARCHAR(255) NOT NULL UNIQUE,
                                    password VARCHAR(255) NOT NULL
);

-- ✅ Tabla de roles (uno a muchos)
CREATE TABLE IF NOT EXISTS user_roles (
                                          user_id BIGINT NOT NULL,
                                          role VARCHAR(255) NOT NULL,
                                          FOREIGN KEY (user_id) REFERENCES user(id)
);

-- ✅ Tabla de categorías
CREATE TABLE IF NOT EXISTS category (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL
);

-- ✅ Tabla de productos
CREATE TABLE IF NOT EXISTS product (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
                                       description TEXT,
                                       price DOUBLE,
                                       category_id BIGINT,
                                       FOREIGN KEY (category_id) REFERENCES category(id)
);

-- ✅ Insertar admin con contraseña encriptada (bcrypt de "admin123")
INSERT INTO user (email, password) VALUES
    ('admin@example.com', '$2a$10$Rk0OpjUXPeCxoLVA9r0UMeqtd0CUIlYQqTtrR62yM75y6PYVR85Q2');

-- ✅ Asignar rol ADMIN al admin
INSERT INTO user_roles (user_id, role) VALUES
    (1, 'ADMIN');

-- (opcional) Insertar categorías de ejemplo
INSERT INTO category (name) VALUES ('Electronics'), ('Books');

-- (opcional) Insertar productos de ejemplo
INSERT INTO product (name, description, price, category_id) VALUES
                                                                ('Smartphone', 'A super smart phone', 699.99, 1),
                                                                ('Novel', 'Bestseller book', 14.95, 2);