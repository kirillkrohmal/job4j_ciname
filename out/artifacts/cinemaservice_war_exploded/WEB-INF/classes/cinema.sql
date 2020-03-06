CREATE TABLE accounts
(
    id serial NOT NULL,
    username character varying(2000),
    phone character varying(2000),
    CONSTRAINT accounts_pkey PRIMARY KEY (id)
);

CREATE TABLE halls
(
    id serial NOT NULL,
    rows character varying(2000),
    place character varying(2000),
    CONSTRAINT halls_pkey PRIMARY KEY (id)
);