CREATE TABLE accounts
(
    id serial NOT NULL,
    value character varying(2000),
    username character varying(2000),
    phone integer,
    CONSTRAINT accounts_pkey PRIMARY KEY (id)
);

CREATE TABLE halls
(
  id serial NOT NULL,
  rows character varying(2000),
  columns character varying(2000),
  account_id integer REFERENCES accounts (id)б
  CONSTRAINT halls_pkey PRIMARY KEY (id)
);