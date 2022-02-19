CREATE TABLE IF NOT EXISTS public.auto (
    id SERIAL not null primary key,
    marca TEXT not null,
    anos TEXT not null,
    capacidad INT not null,
    precio INT not null
);