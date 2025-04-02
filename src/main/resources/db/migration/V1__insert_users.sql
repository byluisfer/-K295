-- Insert 'admin' user if not exists
INSERT INTO users (username, password)
SELECT 'admin', '$2a$10$abc123HashedPasswordHere'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'admin'
);

-- Insert 'user' user if not exists
INSERT INTO users (username, password)
SELECT 'user', '$2a$10$xyz456HashedPasswordHere'
WHERE NOT EXISTS (
    SELECT 1 FROM users WHERE username = 'user'
);

-- Insert 'ADMIN' role for 'admin'
INSERT INTO users_roles (users_id, roles)
SELECT u.id, 'ADMIN'
FROM users u
WHERE u.username = 'admin'
  AND NOT EXISTS (
    SELECT 1 FROM users_roles r WHERE r.users_id = u.id AND r.roles = 'ADMIN'
);

-- Insert 'USER' role for 'user'
INSERT INTO users_roles (users_id, roles)
SELECT u.id, 'USER'
FROM users u
WHERE u.username = 'user'
  AND NOT EXISTS (
    SELECT 1 FROM users_roles r WHERE r.users_id = u.id AND r.roles = 'USER'
);