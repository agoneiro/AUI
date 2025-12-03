CREATE TABLE parishes (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE priests (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INTEGER,

    parish_id UUID REFERENCES parishes(id) 
);