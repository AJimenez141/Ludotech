-- Suppression des données dans l'ordre des dépendances

DELETE FROM location_exemplaire;
DELETE FROM location;
DELETE FROM exemplaire_jeu;
DELETE FROM modele_jeu_genres;
DELETE FROM utilisateur;
DELETE FROM modele_jeu;
DELETE FROM genre;
DELETE FROM address;

-- Réinitialisation des séquences
ALTER TABLE address ALTER COLUMN id RESTART WITH 1;

-- Insertion des données

-- Insérer des données dans la table address
INSERT INTO address (numero, code_postal, rue, ville) VALUES
('10', '75001', 'Rue de Rivoli', 'Paris'),
('20', '69002', 'Rue de la République', 'Lyon'),
('30', '13001', 'Rue Saint-Ferréol', 'Marseille');

-- Insérer des données dans la table genre
INSERT INTO genre (id, libelle) VALUES
(1, 'Action'),
(2, 'Aventure'),
(3, 'Puzzle');

-- Insérer des données dans la table modele_jeu
INSERT INTO modele_jeu (id, prix_location, nom) VALUES
(1, 10.0, 'Monopoly'),
(2, 15.0, 'Catan'),
(3, 20.0, 'Carcassonne');

-- Insérer des données dans la table modele_jeu_genres
INSERT INTO modele_jeu_genres (genres_id, modele_jeu_id) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Insérer des données dans la table utilisateur
INSERT INTO utilisateur (id, adresse_id, telephone, utilisateur_type, first_name, last_name, email, password) VALUES
(1, 1, '0102030405', 'client', 'Jean', 'Dupont', 'jean.dupont@example.com', 'password123'),
(2, 2, '0607080910', 'client', 'Marie', 'Curie', 'marie.curie@example.com', 'password456'),
(3, 3, '1112131415', 'admin', 'Albert', 'Einstein', 'albert.einstein@example.com', 'password789');

-- Insérer des données dans la table exemplaire_jeu
INSERT INTO exemplaire_jeu (est_louable, id, modele_jeu_id, reservation_client_id, date_reservation, code_barre) VALUES
(1, 1, 1, NULL, NULL, '1234567890123'),
(1, 2, 2, NULL, NULL, '2345678901234'),
(1, 3, 3, NULL, NULL, '3456789012345');

-- Insérer des données dans la table location
INSERT INTO location (client_id, est_paye, id, date_loc) VALUES
(1, 1, 1, CURRENT_TIMESTAMP),
(2, 0, 2, CURRENT_TIMESTAMP);

-- Insérer des données dans la table location_exemplaire
INSERT INTO location_exemplaire (id, id_exemplaire, location_id, prix_final, date_fin) VALUES
(1, 1, 1, 10.0, DATEADD('DAY', 7, CURRENT_TIMESTAMP)),
(2, 2, 2, 15.0, DATEADD('DAY', 7, CURRENT_TIMESTAMP));
