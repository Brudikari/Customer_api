DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
                           id INT AUTO_INCREMENT  PRIMARY KEY,
                           first_name VARCHAR(250) NOT NULL,
                           last_name VARCHAR(250) NOT NULL,
                           user_name VARCHAR(250) NOT NULL,
                           mail VARCHAR(250) NOT NULL,
                           address VARCHAR(250) NOT NULL,
                           company VARCHAR(250) NOT NULL
);

INSERT INTO customers (first_name, last_name, user_name, mail, address, company) VALUES
                                                                    ('Laurent', 'GINA', 'laurentgina', 'laurentgina@mail.com', '23 Rue du Louvre, Paris, France', 'Gina Consulting'),
                                                                    ('Sophie', 'FONCEK', 'sophiefoncek', 'sophiefoncek@mail.com', '45 Boulevard Haussmann, Paris, France', 'Foncek Innovations'),
                                                                    ('Agathe', 'FEELING', 'agathefeeling', 'agathefeeling@mail.com', '67 Avenue de la Grande Armée, Paris, France', 'Feeling Design'),
                                                                    ('Alice', 'Dupont', 'alice.dupont', 'alice.dupont@example.com', '123 Rue de Rivoli, Paris, France', 'Dupont Technologies'),
                                                                    ('Bruno', 'Martin', 'bruno.martin', 'bruno.martin@example.com', '456 Avenue des Champs-Élysées, Paris, France', 'Martin Corp'),
                                                                    ('Carla', 'Bernard', 'carla.bernard', 'carla.bernard@example.com', '789 Boulevard Saint-Germain, Paris, France', 'Bernard Solutions'),
                                                                    ('David', 'Durand', 'david.durand', 'david.durand@example.com', '101 Rue de la Paix, Paris, France', 'Durand Industries'),
                                                                    ('Eva', 'Moreau', 'eva.moreau', 'eva.moreau@example.com', '202 Avenue Montaigne, Paris, France', 'Moreau Enterprises');