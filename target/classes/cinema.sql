CREATE TABLE accounts
(
    id serial NOT NULL,
    value character varying(2000),
    CONSTRAINT accounts_pkey PRIMARY KEY (id)
);

CREATE TABLE halls
(
    id serial NOT NULL,
    rows character varying(2000),
    columns character varying(2000),
    account_id int references accounts(id),
    CONSTRAINT halls_pkey PRIMARY KEY (id)
);

CREATE TABLE users
(
  id serial NOT NULL,
  username character varying(2000),
  phone character varying(2000),
  CONSTRAINT users_pkey PRIMARY KEY (id)
);