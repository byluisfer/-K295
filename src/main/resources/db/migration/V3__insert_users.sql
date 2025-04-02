-- Insert initial users
INSERT INTO users (id, username, password) VALUES
                                               (1, 'adminUser', '$2a$10$yH4j2M7cFMc0S1IBGzduheCzQVu3WvhGH3F.9YcMRX.PEubtVYicG'), -- password123
                                               (2, 'normalUser', '$2a$10$gL3J6AxN4XY/5hK8BbZNOOuUAZF85eCVK2DIL6j7Em84dpxsLPErW'); -- admin123

-- Insert their roles
INSERT INTO users_roles (users_id, roles) VALUES
                                              (1, 'ADMIN'),
                                              (2, 'USER');