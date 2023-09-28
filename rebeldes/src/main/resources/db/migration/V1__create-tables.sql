CREATE TABLE purchasing_basis (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    price NUMERIC NOT NULL
);
CREATE TABLE rebel(
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    age INTEGER NOT NULL,
    gender VARCHAR(20) NOT NULL,
    status BOOLEAN NOT NULL DEFAULT FALSE,
    location VARCHAR(250) NOT NULL
);
CREATE TABLE inventory(
    id SERIAL PRIMARY KEY,
    fk_rebel INTEGER,
    FOREIGN KEY (fk_rebel) REFERENCES rebel(id)
);

CREATE TABLE vote_traitors(
     id SERIAL PRIMARY KEY,
     fk_rebel INTEGER,
     FOREIGN KEY(fk_rebel) REFERENCES rebel(id),
     votes INTEGER DEFAULT 0
);
CREATE TABLE purchasing_inventory(
    id SERIAL PRIMARY KEY,
    fk_inventory INTEGER,
    fk_purchasing_basis INTEGER,
    FOREIGN KEY(fk_purchasing_basis) REFERENCES purchasing_basis(id),
    FOREIGN KEY(fk_inventory) REFERENCES inventory(id)
);