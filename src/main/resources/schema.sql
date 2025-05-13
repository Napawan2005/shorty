CREATE TABLE IF NOT EXISTS url_mapping (
                                           id          BIGSERIAL PRIMARY KEY,
                                           original_url TEXT NOT NULL,
                                           short_code   VARCHAR(10) NOT NULL UNIQUE,
    created_at   TIMESTAMP  NOT NULL DEFAULT NOW()
    );
